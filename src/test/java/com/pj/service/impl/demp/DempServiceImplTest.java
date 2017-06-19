package com.pj.service.impl.demp;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pj.system.pojo.Demp;
import com.pj.system.service.DempService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-config.xml"})
public class DempServiceImplTest {

	@Resource
	private DempService dempService;
	
	@Test
	public void testSaveDemo() {
		Demp demp = new Demp();
		demp.setName("研发部2");
		demp.setNumber("YF222");
		Integer demo = this.dempService.insertSelective(demp);
		System.out.println(demo);
	}

	@Test
	public void testFindDempById() {
		Demp demp = this.dempService.selectByPrimaryKey(2);
		System.out.println(demp);
	}

	@Test
	public void testUpdateDemp() {
		Demp demp = new Demp();
		demp.setId(2);
		demp.setName("研发部二部");
		demp.setCompanyid(1);
		this.dempService.updateByPrimaryKeySelective(demp );
	}

	@Test
	public void testFindDempList() {
		List<Demp> findDempList = this.dempService.selectNotDeleteALL();
		for (Demp demp : findDempList) {
			System.out.println(demp);
		}
	}
	
	@Test
	public void testIsDelete() {
		this.dempService.deleteByPrimaryKey(1);	
	}
}
