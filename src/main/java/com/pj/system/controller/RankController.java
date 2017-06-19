package com.pj.system.controller;

import java.util.ArrayList;
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
import com.pj.system.pojo.Rank;
import com.pj.system.service.RankService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;
/**
 * 职级
 * @author Administrator
 *
 */
@RequestMapping("/rank")
@Controller
@Api(value="rank", description=" 职级", position=13)
public class RankController extends SystemManageController{
	//	日志对象
	private static final Logger logger = LoggerFactory.getLogger(RankController.class); 
	@Resource
	private RankService rankService;
	
	@Resource
	private NumberTool numberUtils;
	/**
	 * 	去往添加页面
	 */
	@ApiIgnore
	@RequestMapping("/add.do")
	public String add(){
		return "rank/add";
	}
	
	/**
	 * 	获取职位number
	 */
	@ApiOperation(value = "获取职位number", httpMethod = "GET", response=Map.class, notes ="获取职位number")
	@RequestMapping("/getRankNumber.do")
	@ResponseBody
	public Map<String , Object> getRankNumber(){
		Map<String, Object> map;
		try {
			String number = this.numberUtils.getSingleNumber(rankService, four);
			map = this.success(number);
		} catch (Exception e) {
			logger.error("获取职级单号" + e.getMessage());
			throw new RuntimeException("操作资源异常");		
		}
		return map;
	}
	/**
	 * 	添加职级
	 */
	@ApiOperation(value = "添加职级", httpMethod = "POST", response=String.class, notes ="添加职级")
	@RequestMapping(value="/save.do" , method=RequestMethod.POST)
	@ResponseBody
	public Map<String , Object> saveRank(@ModelAttribute("rank")Rank rank){
		try {
			this.rankService.insertSelective(rank);
		} catch (Exception e) {
			logger.error("添加职位异常" + e.getMessage());
			throw new RuntimeException("添加职位异常");
		}
		return this.success(null);
	}
	
	/**
	 * 	回现数据
	 */
	@ResponseBody
	@ApiOperation(value = "根据id回现数据", httpMethod = "GET", response=String.class, notes ="根据id回现数据")
	@RequestMapping(value="/find.do", method =RequestMethod.GET)
	public Map<String, Object> selectRankById(@ApiParam("id") @RequestParam("id")Integer id , Model model){
		Map<String, Object> map;
		try {
			Rank rank = this.rankService.selectByPrimaryKey(id);
			map = this.success(rank);
		} catch (Exception e) {
			logger.error("回现职位信息异常" + e.getMessage());
			throw new RuntimeException("操作资源异常");		
		}
    	return map;
	}
	
	/**
	 * 	更新职级数据
	 */
	@ApiOperation(value = "更新职级数据", httpMethod = "POST", response=String.class, notes ="更新职级数据")
	@RequestMapping(value="/edit.do", method =RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateRank(@ModelAttribute("rank")Rank rank){
		try {
			this.rankService.updateByPrimaryKeySelective(rank);
		} catch (Exception e) {
			logger.error("更新职级数据异常" + e.getMessage() );
			throw new RuntimeException("更新职位异常");
		}
		return this.success(null);
	}
	
	/**
	 * 	查询所有的职级信息
	 */
	@ResponseBody
	@ApiOperation(value = "查询所有的职级信息", httpMethod = "GET", response=String.class, notes ="查询所有的职级信息")
	@RequestMapping(value="/list.do", method =RequestMethod.GET)
	public Map<String, Object> findRankAll(Model model){
		Map<String, Object> map;
		try {
			List<Rank> ranks = this.rankService.selectNotDeleteALL();
			List<List<Rank>> lists = new ArrayList<List<Rank>>();
			lists.add(ranks);
			map = this.success(lists);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询所有的职级信息异常" + e.getMessage());
			throw new RuntimeException("操作资源异常");		
		}
    	return map;
	}
	
	/**
	 * 	删除职级
	 */
	@ApiOperation(value = "删除职级", httpMethod = "GET", response=String.class, notes ="删除职级")
	@RequestMapping(value="delete.do" , method =RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> deleteRankById(@ApiParam("id") @RequestParam("id")Integer id){
		try {
			this.rankService.deleteByPrimaryKeyToLogic(id);
		} catch (Exception e) {
			logger.error("删除职级异常" + e.getMessage());
			throw new RuntimeException("操作资源异常");		
		}
		return this.success(null);
	}
}

