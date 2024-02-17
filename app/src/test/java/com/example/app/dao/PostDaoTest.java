package com.example.app.dao;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.AppApplication;
import com.example.app.model.Post;

@SpringBootTest(classes = AppApplication.class)
@Transactional
public class PostDaoTest {
	
	@Autowired
	private PostDao dao;
	
	private static List<Post> expectedPosts = Arrays.asList(
			new Post("a", "this is a"),
			new Post("testt", "i am testt")
	);
	
	@Test
	void testGetPost() {
		List<Post> actualPosts = dao.getPosts();
		assertEquals(expectedPosts.get(0).getName(), actualPosts.get(0).getName());
		assertEquals(expectedPosts.get(0).getMessage(), actualPosts.get(0).getMessage());
	}
}
