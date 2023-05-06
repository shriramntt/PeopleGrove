package com.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PeopleGrovePage {

	public PeopleGrovePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
}
