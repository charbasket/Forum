package com.solera.forum.model.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.solera.forum.model.entity.Post;

@Repository
public class PostDaoList implements PostDaoInterface {

	private List<Post> listOfPosts;
	private List<String> bannedWords;

	public PostDaoList() {
		listOfPosts = new ArrayList<Post>();
		bannedWords = new ArrayList<String>();
		loadPosts();
		loadBannedWords();
	}

	private void loadPosts() {
		listOfPosts.add(new Post("Java 18", "Computer Science", "QA", "I want to create an api", true));
		listOfPosts.add(new Post("Ferrari", "Cars", "News", "New Ferrari", false));
	}

	private void loadBannedWords() {
		bannedWords.add("hola");
		bannedWords.add("adios");
	}

	@Override
	public List<Post> findAllPost() {
		return listOfPosts;
	}

	@Override
	public List<Post> findPostByThread(String thread) {
		List<Post> postByThread = new ArrayList<Post>();
		for (int i = 0; i < listOfPosts.size(); i++) {
			if (listOfPosts.get(i).getThread().toLowerCase().equals(thread.toLowerCase())) {
				postByThread.add(listOfPosts.get(i));
			}
		}
		return postByThread;
	}

	@Override
	public Post setPostImage(Post post) {

		if (post.getCategory().toLowerCase().equals("doubt")) {
			post.setImage("questionMark");
		} else if (post.getCategory().toLowerCase().equals("suggestion")) {
			post.setImage("loudSpeaker");
		} else if (post.getCategory().toLowerCase().equals("clarification")) {
			post.setImage("pencil");
		}
		return post;
	}

	@Override
	public boolean bodyContainsBannedWords(Post post) {
		boolean containsBannedWords = true;
		for (int i = 0; i < bannedWords.size(); i++) {
			if (post.getBody().contains(bannedWords.get(i))) {
				return containsBannedWords;
			}
		}
		return !containsBannedWords;
	}

	@Override
	public String addPost(Post post) {
		// Status = -1 -> fail to add the post
		// Status = 1 -> post added
		// Status = 0 -> post contains banned words
		String status;
		setPostImage(post);
		if (bodyContainsBannedWords(post)) {
			status = "Post contains banned workds";
			return status;
		}
		try {
			listOfPosts.add(post);
			status = "Post added";
		} catch (Exception e) {
			e.printStackTrace();
			status = "Something went wrong";
		}
		return status;
	}

	@Override
	public boolean checkPostByTitleAndThread(String thread, String title) {
		boolean postAlreadyExists = true;
		findPostByThread(thread);
		for (int i = 0; i < postByThread.size(); i++) {
			if (postByThread.get(i).getTitle().toLowerCase().equals(title)) {
				return postAlreadyExists;
			}
		}
		return !postAlreadyExists;
	}

}
