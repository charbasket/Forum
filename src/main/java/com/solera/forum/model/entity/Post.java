package com.solera.forum.model.entity;

import java.io.Serializable;

public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	private String title;
	private String thread;
	private String category;
	private String body;
	private String image;
	private boolean publicPost;

	public Post() {
	}

	public Post(String title, String thread, String category, String body, boolean publicPost) {
		this.title = title;
		this.thread = thread;
		this.category = category;
		this.body = body;
		this.publicPost = publicPost;
	}

	public Post(String title, String thread, String category, String body, boolean publicPost, String image) {
		this.title = title;
		this.thread = thread;
		this.category = category;
		this.body = body;
		this.publicPost = publicPost;
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThread() {
		return thread;
	}

	public void setThread(String thread) {
		this.thread = thread;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isPublicPost() {
		return publicPost;
	}

	public void setPublicPost(boolean publicPost) {
		this.publicPost = publicPost;
	}

	@Override
	public String toString() {
		return "Post [title=" + title + ", thread=" + thread + ", category=" + category + ", body=" + body + ", image="
				+ image + ", publicPost=" + publicPost + "]";
	}

}
