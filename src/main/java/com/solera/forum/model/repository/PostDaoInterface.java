package com.solera.forum.model.repository;

import java.util.List;

import com.solera.forum.model.entity.Post;

public interface PostDaoInterface {
	List<Post> findAllPost();

	List<Post> findPostByThread(String thread);

	List<String> findAllThreads();

	boolean addPost(Post post);

	Post setPostImage(Post post);

	boolean bodyContainsBannedWords(String body);

	boolean checkPostByTitleAndThread(String thread, String title);

}
