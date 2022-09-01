package com.bit.test;

import org.junit.Test;

public class SmokeTest extends BaseTest{

	@Test
	public void test1() throws InterruptedException {

		Scenario scenario = new Scenario(driver);
		scenario.targetEndToEndScenario();
		System.out.println("test1");
	}
}
