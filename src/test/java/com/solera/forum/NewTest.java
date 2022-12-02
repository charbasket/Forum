package com.solera.forum;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class NewTest {

	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = "http://localhost:8080/posts";
	}

	@Test
	public void getAllPost() {
		given().when().get().then().assertThat().statusCode(200).extract().response().asString();
	}

	@Test
	public void getPostByThreadAndThreadExists() {
		String thread = "cars";
		int size = 0;

		String response = given().when().get(thread).then().assertThat().statusCode(200).extract().response()
				.asString();
		JsonPath js = new JsonPath(response);
		size = js.getInt("size()");

		Assert.assertNotEquals(size, 0);

		String responseThreads;
		for (int i = 0; i < size; i++) {
			responseThreads = js.get("[" + i + "].thread");
			Assert.assertEquals(responseThreads.toLowerCase(), thread);
		}
	}

	@Test
	public void getPostByThreadAndThreadDoesNotExist() {
		String thread = "asdf";
		int size = 0;

		String response = given().when().get(thread).then().assertThat().statusCode(200).extract().response()
				.asString();
		System.err.println(response);
		JsonPath js = new JsonPath(response);
		size = js.getInt("size()");

		Assert.assertEquals(size, 0);
	}

}
