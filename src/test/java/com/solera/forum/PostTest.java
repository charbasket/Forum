package com.solera.forum;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PostTest {

	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = "http://localhost:8080/posts";
	}

	@Test
	public void getAllPost() {
		given().when().get().then().assertThat().statusCode(200).extract().response().asString();
	}

	@Test
	public void getPostByThreadAndNameAndThreadAndNameExist() {
		String thread = "cars";
		String title = "ferrari";
		int size = 0;

		String response = given().when().get(thread + "/" + title).then().assertThat().statusCode(200).extract()
				.response().asString();
		Assert.assertEquals(response, "true");
	}

	@Test
	public void getPostByThreadAndNameAndThreadAndNameDoesNotExist() {
		String thread = "cars";
		String title = "ferrarii";
		int size = 0;

		String response = given().when().get(thread + "/" + title).then().assertThat().statusCode(200).extract()
				.response().asString();
		Assert.assertEquals(response, "false");
	}

}
