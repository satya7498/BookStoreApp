package com.books.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin= {"pretty", "html:target/cucumber_report.html","junit:target/cucumber.xml"},features="src/main/resources/features",glue= {"com.books.stepDefinition"})

public class Runner {

}
