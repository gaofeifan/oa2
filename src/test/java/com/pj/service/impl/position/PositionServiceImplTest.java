package com.pj.service.impl.position;

import java.util.List;
import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pj.system.pojo.Position;
import com.pj.system.service.PositionService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-config.xml"})
public class PositionServiceImplTest {

	@Resource
	private PositionService positionService;
	
	@Test
	public void testSavePosition() {
		Position position = new Position();
		position.setName("员工");
		position.setNumber("ZJ111");
		position.setDescription("大家都是员工");
		this.positionService.insertSelective(position );

		Position position2 = new Position();
		position2.setName("经理");
		position2.setNumber("ZJ222");
		position2.setDescription("领导");
		this.positionService.insertSelective(position2 );
	}

	@Test
	public void testFindPositionById() {
		Position position = this.positionService.selectByPostId(1);
		System.out.println(position);
	}

	@Test
	public void testUpdatePositionById() {
		Position position = new Position();
		position.setId(2);
		position.setDescription("老大们");
		this.positionService.updateByPrimaryKeySelective(position );
	}

	@Test
	public void testFindPositioAll() {
		List<Position> list = this.positionService.selectNotDeleteALL();
		for (Position position : list) {
			System.out.println(position);
		}
	}

	@Test
	public void testDeletePositionById() {
		double d = 25d;
		if(d < 25){
			System.out.println("3天内");
		}else{
			System.out.println("3天外");
		}
	}

}
