package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./features/PeopleGrove.feature",
				glue = "com\\stepdefinition",
					dryRun = true,tags = "@two")
public class TestRunner {

}
