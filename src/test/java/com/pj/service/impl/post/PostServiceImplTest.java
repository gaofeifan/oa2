package com.pj.service.impl.post;

import java.util.List;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pj.system.pojo.Post;
import com.pj.system.service.PostService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-config.xml"})
public class PostServiceImplTest {

	@Resource
	private PostService postService;
	
	@Test
	public void testSavePost() {
		Post post = new Post();
		post.setName("UI");
		post.setDescription("美工");
		this.postService.insertSelective(post );
	}

	@Test
	public void testFindPostById() {
		Post post = this.postService.selectByPrimaryKey(1);
		System.out.println(post);
	}

	@Test
	public void testUpdatePostById() {
		Post post = new Post();
		post.setName("js");
		post.setId(2);
		post.setDescription("攻城狮");
		post.setNumber(null);
		this.postService.updateByPrimaryKeySelective(post );
	}

	@Test
	public void testFindPositioAll() {
		List<Post> list = this.postService.selectAll();
		for (Post post : list) {
			System.out.println(post);
		}
	}

	@Test
	public void testDeletePostById() {
		this.postService.deleteByPrimaryKey(2);
	}

}
