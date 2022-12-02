package com.solera.forum.selenium.form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumHomeTest {

	@Test
	public void f() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Carlos.Fuentes\\Downloads\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		WebElement cookie = driver.findElement(By.xpath("//*[@id=\"W0wltc\"]/div"));
		cookie.click();

		driver.findElement(By.xpath("//a[@aria-label='Aplicaciones de Google']//*[name()='svg']")).click();
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[role='presentation']")));
		driver.findElement(By.cssSelector("a[href*='play.google.com']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.navigate().back();
	}
}
