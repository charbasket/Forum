package com.solera.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solera.forum.model.entity.Post;
import com.solera.forum.model.repository.PostDaoInterface;

@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostDaoInterface iPost;

	@GetMapping
	public List<Post> getAllPosts() {
		return iPost.findAllPost();
	}

	@GetMapping("/threads")
	public List<String> getAllThreads() {
		return iPost.findAllThreads();
	}

	@GetMapping("/{thread}/{title}")
	public boolean checkThreadAndTitle(@PathVariable String thread, @PathVariable String title) {
		return iPost.checkPostByTitleAndThread(thread, title);
	}

	@PostMapping("/checkBody")
	public boolean checkBodyContainsBannedWords(@RequestBody String body) {
		return iPost.bodyContainsBannedWords(body);
	}

	@PostMapping("/add")
	public boolean addPost(@RequestBody Post post) {
		return iPost.addPost(post);
	}

}
