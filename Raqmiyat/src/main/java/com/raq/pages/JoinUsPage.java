package com.raq.pages;

import java.io.IOException;

import com.raq.testbase.TestBase;

public class JoinUsPage extends TestBase{

	public JoinUsPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}



public String checkTitle() {
	String title = driver.getTitle();	
	return title;
}



	
}

