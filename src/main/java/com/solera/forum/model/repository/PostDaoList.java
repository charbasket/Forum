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
	public List<String> findAllThreads() {
		List<String> listOfThreads = new ArrayList<String>();
		System.err.println(listOfPosts.size());
		for (int i = 0; i < listOfPosts.size(); i++) {
			if (!listOfThreads.contains(listOfPosts.get(i).getThread())) {
				listOfThreads.add(listOfPosts.get(i).getThread());
			}
		}
		return listOfThreads;
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
	public boolean bodyContainsBannedWords(String body) {
		boolean containsBannedWords = true;
		for (int i = 0; i < bannedWords.size(); i++) {
			if (body.contains(bannedWords.get(i))) {
				return containsBannedWords;
			}
		}
		return !containsBannedWords;
	}

	@Override
	public boolean addPost(Post post) {
		boolean add = false;
		setPostImage(post);
		if (bodyContainsBannedWords(post.getBody())) {
			return add;
		}
		try {
			listOfPosts.add(post);
			add = true;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return add;
	}

	@Override
	public boolean checkPostByTitleAndThread(String thread, String title) {
		boolean postAlreadyExists = true;
		List<Post> postByThread = findPostByThread(thread);
		for (int i = 0; i < postByThread.size(); i++) {
			if (postByThread.get(i).getTitle().toLowerCase().equals(title.toLowerCase())) {
				return postAlreadyExists;
			}
		}
		return !postAlreadyExists;
	}

}
