package Runner;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@Cucumber.Options(strict = false, features = "Features", glue={"Functions"}, format = { "pretty",
		"html:target/site/cucumber-pretty",
		"json:target/cucumber.json" }, tags = { "~@ignore" })
// strict = false (will fail execution if there are undefined or pending steps)
// features="Features" (the path to the features)
// glue={"Functions"} (where to look for glue code "Step Definition")
public class TestRunner {

}