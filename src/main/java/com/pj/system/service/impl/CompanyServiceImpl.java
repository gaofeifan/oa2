package com.pj.system.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.auth.mapper.AuthUserMapper;
import com.pj.config.base.mapper.MyMapper;
import com.pj.config.base.service.AbstractBaseServiceImpl;
import com.pj.system.mapper.CompanyMapper;
import com.pj.system.mapper.DempMapper;
import com.pj.system.mapper.PostMapper;
import com.pj.system.pojo.Company;
import com.pj.system.pojo.Demp;
import com.pj.system.pojo.Organization;
import com.pj.system.pojo.Post;
import com.pj.system.service.CompanyService;
import com.pj.system.service.DempService;
import com.pj.utils.redis.RedisUtil;

import tk.mybatis.mapper.entity.Example;

@Transactional
@Service
public class CompanyServiceImpl extends AbstractBaseServiceImpl<Company, Integer> implements CompanyService {

	@Resource
	private CompanyMapper companyMapper;

	@Resource
	private DempMapper dempMapper;

	@Resource
	private AuthUserMapper authUserMapper;

	@Resource
	private PostMapper postMapper;

	@Resource
	private DempService dempService;

	@Resource
	private RedisTemplate<String, String> redisTemplate;

	@Override
	public MyMapper<Company> getMapper() {
		return companyMapper;
	}

	/**
	 * 根据名称查询
	 */
	@Override
	public Integer selectByName(String companyName) {
		Example example = new Example(Company.class);
		example.createCriteria().andCondition(" name LIKE ", "%" + companyName + "%").andCondition(" isdelete = 0");
		List<Company> list = this.companyMapper.selectByExample(example);
		return list.size() != 0 ? list.get(0).getId() : null;
	}

	/**
	 * 查询是否可以删除
	 */
	@Override
	public Boolean isDeleteCompany(Integer companyId) {
		Boolean flag = true;
		Example example = new Example(Company.class);
		example.createCriteria().andCondition(" pId = " + companyId).andCondition(" isdelete = 0 ");
		List<Company> companys = this.companyMapper.selectByExample(example);
		Demp record = new Demp();
		record.setCompanyid(companyId);
		record.setIsdelete(0);
		List<Demp> demps = this.dempMapper.select(record);
		if (companys.size() > 0 || demps.size() > 0) {
			flag = false;
		}
		return flag;
	}

	/**
	 * 根据用户权限查询所负责公司信息
	 */
	@Override
	public List<Company> getByAuthUser(Integer userId) {
		return companyMapper.getByAuthUser(userId);
	}

	/**
	 * 根据id获取父节节点
	 */
	@Override
	public Company selectParentCompanyById(int id) {
		return this.companyMapper.selectParentCompanyById(id);
	}

	/**
	 * 查询公司跟人事权限
	 * 
	 * @author GFF
	 * @date 2017年7月5日下午7:30:58
	 * @return
	 */
	@Override
	public List<Company> selectCompanyByPersonnelAuthority() {
		List<Company> companys = this.selectNotDeleteALL();
		List<Company> deleteCompanys = new ArrayList<>();
		for (Company company : companys) {
			List<Demp> dempList = this.dempService.selectDempByPersonnelAuthority(company.getId());
			if (dempList.size() == 0) {
				deleteCompanys.add(company);
			}
		}
		for (Company company : deleteCompanys) {
			companys.remove(company);
		}
		return companys;
	}

	@Override
	public List<Company> selectByUserid(Integer userId, Integer menuid) {
		return this.companyMapper.selectByUserid(userId, menuid);
	}

	@Override
	public List<Organization> selectOransNotDeleteALL() {
		return companyMapper.selectOransNotDeleteALL();
	}

	// 展示所有，不包含没有岗位的（暂时没用到）
	public List<Organization> getDempsAndPosts(Organization company, String type) {
		List<Organization> organizations = new ArrayList<Organization>();
		List<Organization> allPosts = new ArrayList<Organization>();
		// 根据menuId和postid，userid查权限表，如果已经被useridling其他用户
		// for(Organization company : companys){
		// List<Organization> childPosts = new ArrayList<Organization>();
		Integer companyId = company.getId();
		// 所有子公司，包含本级
		List<Organization> childCompanysList = companyMapper.selectChildsById(companyId);
		for (Organization childCompany : childCompanysList) {
			Integer childCompanyId = childCompany.getId();
			// 各子公司的直接岗位
			List<Organization> posts = postMapper.selectLinealsByCompanyId(childCompanyId);
			allPosts.addAll(posts);
			List<Organization> childDemps = dempMapper.selectOrgsByCompanyId(childCompanyId);
			// 各子公司的所有部门
			List<Organization> demps = new ArrayList<Organization>();
			for (Organization childDemp : childDemps) {
				demps.addAll(dempMapper.selectOrgChildListById(childDemp.getId()));
			}
			// 循环各公司所有部门得到直接岗位
			for (Organization demp : demps) {
				List<Organization> dempPosts = postMapper.selectLinealsByDempId(demp.getId());

				if ((dempPosts != null && dempPosts.size() > 0)) {
					allPosts.addAll(dempPosts);
					if (!"post".equals(type)) {
						organizations.add(demp);
					}
				}

			}
			if ((allPosts == null || allPosts.size() == 0)) {
				childCompanysList.remove(childCompany);
			}
		}
		organizations.addAll(allPosts);
		organizations.addAll(childCompanysList);

		// }
		return organizations;

	}

	@Override
	public List<Integer> getAllPosts(List<Organization> companys) {

		List<Integer> organizations = new ArrayList<Integer>();
		for (Organization company : companys) {

			Integer companyId = company.getId();
			List<Organization> innerDempList = dempMapper.selectOrgsByCompanyId(companyId);
			List<Integer> innerPostList = postMapper.selectLinealIdsByCompanyId(companyId);

			organizations.addAll(innerPostList);

			// 查找子部门下的子部门或岗位
			// organizations.addAll(getDepts(innerDempList, type));
			for (Organization organization : innerDempList) {
				Integer dempId = organization.getId();
				List<Organization> childAllDempList = dempMapper.selectOrgChildListById(dempId);

				for (Organization demp : childAllDempList) {
					List<Integer> postList = postMapper.selectLinealIdsByDempId(demp.getId());
					organizations.addAll(postList);
				}
			}

		}
		return organizations;
	}

	/**
	 * @descript:递归部门得到岗位number
	 * @param dempList
	 * @return
	 */
	public List<String> getDeptNums(List<String> deptVosList, List<Organization> dempList) {
		// List<String> deptVosList=new ArrayList<String>();
		if (dempList != null && dempList.size() > 0) {
			for (Organization organization : dempList) {

				Integer dempId = organization.getId();
				List<Organization> innerDempList = dempMapper.selectOrgsByPId(dempId);
				List<String> postList = postMapper.selectLinealNumsByDempId(dempId);
				deptVosList.addAll(postList);
				if (innerDempList != null && innerDempList.size() > 0) {
					deptVosList = getDeptNums(deptVosList, innerDempList);
				}
			}
		}
		return deptVosList;
	}

	@Override
	public List<String> getPostNumByCompanys(List<Organization> companys) {
		List<String> organizations = new ArrayList<String>();
		for (Organization company : companys) {
			Integer companyId = company.getId();
			List<Organization> innerDempList = dempMapper.selectOrgsByCompanyId(companyId);
			List<String> innerPostList = postMapper.selectLinealNumsByCompanyId(companyId);

			organizations.addAll(innerPostList);

			// 查找子部门下的子部门或岗位
			// organizations.addAll(getDepts(innerDempList, type));
			organizations = getDeptNums(organizations, innerDempList);
			// for(Organization organization : innerDempList){
			// Integer dempId = organization.getId();
			// List<Organization> dempList = dempMapper.selectOrgsByPId(dempId);
			// List<String> postList =
			// postMapper.selectLinealNumsByDempId(dempId);
			//
			// organizations.addAll(postList);
			// organizations = getDeptNums(organizations, dempList);
			// }

		}
		return organizations;
	}

	public void name(List<Organization> companys, String type) {
		List<Organization> organizations = new ArrayList<Organization>();
		for (Organization company : companys) {
			List<Organization> allPosts = new ArrayList<Organization>();
			Integer companyId = company.getId();
			// 所有子公司，包含本级
			List<Organization> childCompanysList = companyMapper.selectChildsById(companyId);
			for (Organization childCompany : childCompanysList) {
				Integer childCompanyId = childCompany.getId();
				// 各子公司的直接岗位
				List<Organization> posts = postMapper.selectLinealsByCompanyId(childCompanyId);
				allPosts.addAll(posts);
				List<Organization> childDemps = dempMapper.selectOrgsByCompanyId(childCompanyId);
				// 各子公司的所有部门
				List<Organization> demps = new ArrayList<Organization>();
				for (Organization childDemp : childDemps) {
					demps.addAll(dempMapper.selectOrgChildListById(childDemp.getId()));
				}
				// 循环各公司所有部门得到直接岗位
				for (Organization demp : demps) {
					List<Organization> dempPosts = postMapper.selectLinealsByDempId(demp.getId());

					if ((dempPosts != null && dempPosts.size() > 0)) {
						allPosts.addAll(dempPosts);
						if (!"post".equals(type)) {
							organizations.add(demp);
						}
					}

				}
			}
			if ((allPosts == null || allPosts.size() == 0)) {
				companys.removeAll(childCompanysList);
			} else {
				organizations.addAll(allPosts);
			}

		}

	}

	@Override
	public List<Organization> selectByPId(Integer pId) {
		return companyMapper.selectByPId(pId);
	}

	// 记录公司num
	private Map<String, Object> getCompanyNum(List<String> organNums, String companysStr) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Organization> companys = new ArrayList<Organization>();
		String dempPNum = companysStr;// 部门的父num
		if (companysStr.contains("-")) {
			String[] companyArr = companysStr.split("-");

			// 部门的父num
			dempPNum = companyArr[companyArr.length - 1];

			for (int i = 0; i < companyArr.length; i++) {
				String comNum = companyArr[i];

				if (!organNums.contains(comNum)) {
					organNums.add(comNum);
					Organization organization = new Organization();
					String name = companyMapper.selectByNumber(comNum).getName();
					organization.setNumber(comNum);
					organization.setName(name);
					if (i != 0) {
						organization.setpNum(companyArr[i - 1]);
					}
					organization.setHasChilds("yes");
					companys.add(organization);
					RedisUtil.set("organ-" + comNum, organization);

					// organizationMapper.insertSelective(organization);

				}
			}

		} else {
			if (!organNums.contains(companysStr)) {
				organNums.add(companysStr);
				// Organization company =
				// organizationMapper.seleByNumber(companysStr);
				Organization company = (Organization) RedisUtil.get("organ-" + companysStr);
				if (company == null) {
					company = new Organization();
					String name = companyMapper.selectByNumber(companysStr).getName();
					company.setNumber(companysStr);
					company.setName(name);
					company.setHasChilds("yes");
					companys.add(company);
					RedisUtil.set("organ-" + companysStr, company);

					// organizationMapper.insertSelective(company);
				}
			}
		}
		
		map.put("dempPNum", dempPNum);
		map.put("companys", companys);
		return map;
	}

	@Override
	public List<Organization> getDempsAndPosts(Integer userid, Integer menuid, Organization company) {

		redisTemplate.delete(redisTemplate.keys("organ-*"));
		
		// 根据menuId和userid查权限表，如果已经被userid另外的其他用户赋予权限，则不展示
		// 已经占用的postid
		List<Integer> otherAuthPosts = authUserMapper.selectByNotUserMenuPost(userid, menuid);

		// 所有的postid
		List<Integer> allPosts = postMapper.selectAllPostId(0);
		// 除去已经占用的，得到要展示的postid
		allPosts.removeAll(otherAuthPosts);

		// 记录number是否已存在
		List<String> organNums = new ArrayList<String>();
		
		//公司list
		List<Organization> companys = new ArrayList<Organization>();
		//部门list
		List<Organization> demps = new ArrayList<Organization>();
		//岗位list
		List<Organization> posts = new ArrayList<Organization>();
		
		// 循环得到sign_num,分解得到公司部门信息保存
		for (Integer postid : allPosts) {
			Post post = postMapper.selectByPrimaryKey(postid);
			Organization postOrg = new Organization();
			postOrg.setNumber(post.getNumber());
			postOrg.setName(post.getName());
			postOrg.setHasChilds("no");

			String signNum = post.getSignNum();
			if (StringUtils.isNotBlank(signNum)) {

				// 判断字符串中是否有部门，有则记录位置
				int dempStartInx = signNum.indexOf("DEMP");
				int postStartInx = signNum.indexOf("ST");
				// 公司字符串
				String companysStr = "";
				String dempsStr = "";
				String postPNum = "";// 岗位父num
				
				if (dempStartInx != -1) {
					// 有部门
					companysStr = signNum.substring(0, dempStartInx - 1);
					Map<String, Object> comMap = getCompanyNum(organNums, companysStr);
					String dempPNum = (String) comMap.get("dempPNum");
					companys.addAll((List<Organization>)comMap.get("companys"));
					
					// 部门
					dempsStr = signNum.substring(dempStartInx, postStartInx - 1);
					postPNum = dempsStr;
					if (dempsStr.contains("-")) {
						String[] dempArr = dempsStr.split("-");
						postPNum = dempArr[dempArr.length - 1];
						for (int i = 0; i < dempArr.length; i++) {
							String dempNum = dempArr[i];

							if (!organNums.contains(dempNum)) {
								organNums.add(dempNum);
								Organization organization = new Organization();
								String name = dempMapper.selectOrgByNumber(dempNum).getName();
								organization.setNumber(dempNum);
								organization.setName(name);
								if (i == 0) {
									organization.setpNum(dempPNum);
								} else {
									organization.setpNum(dempArr[i - 1]);
								}
								organization.setHasChilds("yes");
								demps.add(organization);
								RedisUtil.set("organ-" + dempNum, organization);
								// organizationMapper.insertSelective(organization);
							}
						}
					} else {
						if (!organNums.contains(dempsStr)) {
							organNums.add(dempsStr);
							// Organization demp =
							// organizationMapper.seleByNumber(dempsStr);
							Organization demp = (Organization) RedisUtil.get("organ-" + dempsStr);
							if (demp == null) {
								demp = new Organization();
								String name = dempMapper.selectOrgByNumber(dempsStr).getName();
								demp.setNumber(dempsStr);
								demp.setName(name);
								demp.setpNum(dempPNum);
								demp.setHasChilds("yes");
								demps.add(demp);
								RedisUtil.set("organ-" + dempsStr, demp);

								// organizationMapper.insertSelective(demp);
							}
						}
					}

				} else {

					// 无部门
					companysStr = signNum.substring(0, postStartInx - 1);
					Map<String, Object> map = getCompanyNum(organNums, companysStr);
					postPNum = (String) map.get("dempPNum");
					companys.addAll((List<Organization>)map.get("companys"));
				}
				postOrg.setpNum(postPNum);
				posts.add(postOrg);
				RedisUtil.set("organ-" + post.getNumber(), postOrg);
				// organizationMapper.insertSelective(postOrg);
			}
		}

		List<Organization> organizations = new ArrayList<Organization>();
//		Set<String> keys = redisTemplate.keys("organ-*");
//		for (String key : keys) {
//			organizations.add((Organization) RedisUtil.get(key));
//		}
		organizations.addAll(companys);
		organizations.addAll(demps);
		organizations.addAll(posts);
		// List<Organization> organizations = organizationMapper.selectAll();
		return organizations;

	}

}
