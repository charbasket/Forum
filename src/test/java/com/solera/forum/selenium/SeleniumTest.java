package com.solera.forum.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumTest {

	@Test
	public void homePageRepeatedPost() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Carlos.Fuentes\\Downloads\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:3000");

		driver.findElement(By.xpath("//select[@class='w-25 align-self-center m-2']")).click();
		WebElement e = driver.findElement(By.xpath("//select[@class='w-25 align-self-center m-2']"));
		Select select = new Select(e);
		select.selectByVisibleText("Cars");

		WebElement f = driver.findElement(By.xpath("//input[@id='threadName']"));
		f.sendKeys("Ferrari");

		driver.findElement(By.xpath("//button[@id='sendThreat']")).click();

		WebElement result = driver.findElement(By.xpath("//h4[normalize-space()='Ya Existe']"));
		Assert.assertEquals(result.getText(), "Ya Existe");
	}

	@Test
	public void homePageWorks() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Carlos.Fuentes\\Downloads\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:3000");

		driver.findElement(By.xpath("//select[@class='w-25 align-self-center m-2']")).click();
		WebElement e = driver.findElement(By.xpath("//select[@class='w-25 align-self-center m-2']"));
		Select select = new Select(e);
		select.selectByVisibleText("Cars");

		WebElement f = driver.findElement(By.xpath("//input[@id='threadName']"));
		f.sendKeys("Motor");

		driver.findElement(By.xpath("//button[@id='sendThreat']")).click();
	}

	@Test
	public void sendPostWorks() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Carlos.Fuentes\\Downloads\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:3000");

		driver.findElement(By.xpath("//select[@class='w-25 align-self-center m-2']")).click();
		WebElement e = driver.findElement(By.xpath("//select[@class='w-25 align-self-center m-2']"));
		Select select = new Select(e);
		select.selectByVisibleText("Cars");

		WebElement f = driver.findElement(By.xpath("//input[@id='threadName']"));
		f.sendKeys("Motor");

		driver.findElement(By.xpath("//button[@id='sendThreat']")).click();

		driver.findElement(By.xpath("//div[1]//div[2]//select[1]")).click();
		WebElement a = driver.findElement(By.xpath("//div[1]//div[2]//select[1]"));
		select = new Select(a);
		select.selectByVisibleText("Doubt");

		WebElement body = driver.findElement(By.xpath("//textarea[@id='textAreaPost']"));
		body.sendKeys("Estmos en selenium");

		driver.findElement(By.xpath("//button[normalize-space()='Check and Send']")).click();

	}

}
