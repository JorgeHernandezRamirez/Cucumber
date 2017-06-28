package com.jorgehernandezramirez.bdd.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/feature"}, glue = {"com.jorgehernandezramirez.bdd.cucumber.steps"})
public class UserTest {
}
