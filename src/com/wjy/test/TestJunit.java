package com.wjy.test;

import org.junit.*;

public class TestJunit {

	@Before
	public void test1() {
		System.out.println("Before");
	}

	@Test
	public void test2() {
		System.out.println("Test");
	}

	@After
	public void test3() {
		System.out.println("After");
	}

}
