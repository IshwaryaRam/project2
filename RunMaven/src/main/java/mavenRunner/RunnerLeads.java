package mavenRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

//create leads
@RunWith(Cucumber.class)
@CucumberOptions(features="C:/Selenium_TestLeaf/RunMaven/src/main/java/mavenFeature/createLeadUsingMaven.feature", 
glue= {"mavenRunner","mavenPages"}, monochrome=true)

//tags= {"@Sanity", "@Regression"},



public class RunnerLeads {

}
