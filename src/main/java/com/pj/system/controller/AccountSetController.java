package com.pj.system.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.system.pojo.User;
import com.pj.system.service.AccountService;
import com.pj.system.service.SessionProvider;
import com.pj.utils.RequestUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/** 
* @author 作者 E-mail: gx
* @version 创建时间：2016年8月17日 下午6:29:51 
* 	账号设置
*/
@Api(value="accountSet-api",description="账号设置",position = 1)
@Controller
@RequestMapping("/accountSet")
public class AccountSetController {

	@Autowired
	private AccountService accountService;	
	@Autowired
	private SessionProvider sessionProvider;
	Map<String, Object> map = new HashMap<String, Object>();
	//显示账号信息
	@ApiOperation(value="显示账号信息",httpMethod="GET")
	@RequestMapping(value="/info",method=RequestMethod.GET,produces = "application/json;charset=utf-8")
	@ResponseBody
	public MappingJacksonValue list(String callback,HttpServletRequest req, HttpServletResponse res){
		Map<String, String> map = new HashMap<String, String>();
		String email = this.sessionProvider.getAttibute(RequestUtils.getCSESSIONID(req, res));
		
		User user = accountService.findByName(email);
		map.put("phone", user.getPhone());
		map.put("email", user.getEmail());
		map.put("id", user.getId().toString());
		MappingJacksonValue mjv = new MappingJacksonValue(map);
		mjv.setJsonpFunction(callback);
		return mjv;
	}
	//账号设置-修改手机号
	@ApiOperation(value = "修改手机",httpMethod="POST")
	@RequestMapping(value = "/phone" ,method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public ResponseEntity<T> editPhone(@RequestParam(required =false) @ApiParam(value="用户email") String email, @RequestParam(required =false) @ApiParam(value ="手机号") String phone,
			@RequestParam(required =false) @ApiParam(value ="新手机号") String newphone
			){
		Map<String, String> map = new HashMap<String, String>();
		if(phone !=null){
			if(phone.equals(newphone)){
				map.put("error", "原手机号与新手机号相同,请重新输入!");
			}{
		//根据前台id查到用户所有信息
		User u = accountService.findByName(email);
		u.setPhone(newphone);
		accountService.updatephone(u);
		return ResponseEntity.status(HttpStatus.OK).body(null);
			}
		}else{
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}
	}

}
	
