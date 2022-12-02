package com.solera.forum;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class NewTest {
	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = "http://localhost:8080/posts";
	}

	@Test
	public void f() {
		assertEquals(1, 1);

	}
}
