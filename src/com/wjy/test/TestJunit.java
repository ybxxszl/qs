package com.wjy.test;

import org.junit.*;

import com.wjy.test.database.DatabaseTest;

public class TestJunit extends DatabaseTest {

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
