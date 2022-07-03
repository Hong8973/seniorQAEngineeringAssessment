package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"}
        ,monochrome = true
        ,features = "src/test/resources"
        ,glue = "stepdefinitions"
)
public class RunCukesTest {

}
