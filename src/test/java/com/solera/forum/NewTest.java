package com.solera.forum;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class NewTest {
	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = "http://localhost:8080/posts";
	}

	@Test
	public void getAllPost() {
		String response = given().when().get().then().assertThat().statusCode(200).extract().response().asString();
	}

}
