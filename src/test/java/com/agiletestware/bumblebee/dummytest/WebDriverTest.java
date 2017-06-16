package com.agiletestware.bumblebee.dummytest;

import java.io.File;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.agiletestware.bumblebee.annotations.BooleanValue;
import com.agiletestware.bumblebee.annotations.Bumblebee;

@Bumblebee(testplan = "Subject\\webdriver", testlab = "Root\\webdriver", testset = "overridden values")
public class WebDriverTest {

	private WebDriver driver;

	@BeforeClass
	public static void beforeClass() {
		System.setProperty("webdriver.chrome.driver", new File("chromedriver.exe").getAbsolutePath());
	}

	@Before
	public void setUp() {
		this.driver = new ChromeDriver();
	}

	@Test
	public void testOne() {
		driver.get("http:\\agiletestware.com");
		Assert.assertEquals("Agiletestware - Software for QA and Development Tools", driver.getTitle());
	}

	@Test
	public void testTwo() {
		driver.get("http:\\agiletestware.com");
		Assert.assertEquals("Something wrong", driver.getTitle());
	}

	@Ignore
	@Test
	public void ignoredTest() {
		driver.get("http:\\agiletestware.com");
	}

	@Bumblebee(testlab = "Root\\webdriver", testset = "overridden values", description = "description", almReqIds = { 1,
			4 }, almReqRecursive = BooleanValue.TRUE)
	@Test
	public void testThree() {
		throw new RuntimeException("You shall not pass!!!");
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
