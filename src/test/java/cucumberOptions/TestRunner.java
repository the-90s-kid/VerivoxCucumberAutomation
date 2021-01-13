package cucumberOptions;

//Author Chinmaya Bhagwat mail : bhagwatchinmaya@gmail.com

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(  
	    features = "src/test/java/features",
	    glue="stepDefinations",
	    monochrome=true)
public class TestRunner extends AbstractTestNGCucumberTests{

}
