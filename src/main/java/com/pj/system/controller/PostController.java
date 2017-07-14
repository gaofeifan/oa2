package com.pj.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.config.base.tool.NumberTool;
import com.pj.config.web.controller.SystemManageController;
import com.pj.system.pojo.Post;
import com.pj.system.service.PositionService;
import com.pj.system.service.PostService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 	岗位
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/post")
@Api(value="post", description="岗位", position=12)
public class PostController extends SystemManageController {
	//	日志对象
	private static final Logger logger = LoggerFactory.getLogger(PostController.class); 
	@Resource
	private PostService postService;

	@Resource
	private NumberTool numberUtils;
	
	@Resource
	private PositionService positionService;
	/**
	 * 	获取岗位number
	 */
	@ApiOperation(value = "获取岗位number", httpMethod = "GET", response=Map.class, notes ="获取岗位number")
	@RequestMapping("/getPostNumber.do")
	@ResponseBody
	public Map<String , Object> getPostNumber(){
		Map<String, Object> map;
		try {
	
			String number = this.numberUtils.getSingleNumber(postService,four);
			map = this.success(number);
		} catch (Exception e) {
			logger.error("获取岗位单号异常" + e.getMessage());
			throw new RuntimeException("操作资源异常");		
		}
		return map;
	}
	
	/**
	 *	添加岗位
	 */
	@ResponseBody
	@ApiOperation(value = "添加岗位", httpMethod = "POST", response=String.class, notes ="添加岗位")
	@RequestMapping(value="/save.do", method =RequestMethod.POST)
	public Map<String, Object> savePost(@ModelAttribute("post")Post post){
		try {
			this.postService.insertSelective(post);
			
		} catch (Exception e) {
			logger.error("添加岗位异常" + e.getMessage());
			throw new RuntimeException("操作资源异常");		
		}
		return this.success(null);
	}
	
	/**
	 * 	回现岗位信息
	 */
	@ResponseBody
	@ApiOperation(value = "回现岗位信息", httpMethod = "GET", response=String.class, notes ="回现岗位信息")
	@RequestMapping(value={"/find.do"}, method =RequestMethod.GET )
	public Map<String, Object> findPostById(@ApiParam("id") @RequestParam("id")Integer id , Model model){
		Map<String, Object> map;
		try {
			Post post = this.postService.selectByPrimaryKey(id);
			map = this.success(post);
		} catch (Exception e) {
			 logger.error("回现岗位信息异常" + e.getMessage());
			 throw new RuntimeException("操作资源异常");		
		}
    	return map;
	}
	
	/**
	 * 	修改岗位信息
	 */
	@ApiOperation(value = "修改岗位信息", httpMethod = "POST", response=String.class, notes ="修改岗位信息")
	@RequestMapping(value="/edit.do", method =RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updatePost(@ModelAttribute("post") Post post){
		try {
			post.setIsdelete(0);
			this.postService.updateByPrimaryKey(post);
		} catch (Exception e) {
			logger.error("修改岗位信息异常" + e.getMessage());
			throw new RuntimeException("操作资源异常");		
		}
		return this.success(null);
	}
	
	/**
	 * 	查询所有的岗位信息
	 */
	@ResponseBody
	@ApiOperation(value = "查询所有的岗位信息", httpMethod = "GET", response=String.class, notes ="查询所有的岗位信息")
	@RequestMapping(value="/list.do", method =RequestMethod.GET)
	public Map<String, Object> findAllPost(@ModelAttribute("post")Post post){
		Map<String, Object> map;
		try {
			Map<String, Object> hashMap = new HashMap<>();
			List<Post> posts = this.postService.selectALL(post);
			hashMap.put("posts", posts);
			map = this.success(hashMap);
		} catch (Exception e) {
			logger.error("查询所有的岗位信息异常" + e.getMessage());
			throw new RuntimeException("操作资源异常");		
		}
    	return map;
	}
	
	/**
	 * 	根据id删除岗位
	 */
	@ApiOperation(value = "根据id删除岗位", httpMethod = "GET", response=String.class, notes ="根据id删除岗位")
	@RequestMapping(value="/delete.do", method =RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> deletePostById(@ApiParam("id") @RequestParam("id")Integer id){
		try {
			this.postService.deleteByPrimaryKeyToLogic(id);
		} catch (Exception e) {
			logger.error("删除岗位信息异常" + e.getMessage());
			throw new RuntimeException("操作资源异常");		
		}
		return this.success(null);
	}
	
	/**
	 * 	查询是否可以删除
	 */
	@ApiOperation(value = "查询是否可以删除", httpMethod = "GET", response=Map.class, notes ="查询是否可以删除")
	@RequestMapping(value="/isDelete.do" , method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> isDeletePost(@ApiParam("id") @RequestParam("id")Integer id){
		Boolean flag = this.postService.isDeleteDemp(id);
		Map<String, Object> map = this.success(flag);
		return map;
		
	}
	
	@ApiOperation(value = "查询公司  根据人事权限查询", httpMethod = "GET", response=Map.class, notes ="查询公司  根据人事权限查询")
	@RequestMapping(value="/selectPostByUserid.do" , method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> selectPostByUserid(@ApiParam("userid") @RequestParam("userid")Integer userid,@ApiParam("menuid") @RequestParam("menuid")Integer menuid,@ApiParam("dempid") @RequestParam("dempid")Integer dempid){
		try {
			List<Post> post = this.postService.SelectByUserid(userid, menuid,dempid);
			return this.success(post);
		} catch (Exception e) {
			e.printStackTrace();
			return this.error("查询异常"+e.getMessage());
		}
	}
	
}
