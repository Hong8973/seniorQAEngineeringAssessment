package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.MinisterialMediaReleases;
import pages.Common;


public class SearchStepDefinitions {
    Common common = new Common();
    MinisterialMediaReleases ministerialMediaReleases = new MinisterialMediaReleases();

    @Given("I open {string}")
    public void openURL(String url){
        common.openURL(url);
    }

    @Given("I want to search for Media Releases for {string}")
    public void setMinister(String minister){
        ministerialMediaReleases.setMinister(minister);
    }

    @And("I expand the accordion for {string}")
    public void expandAccordion(String accordionName){
        ministerialMediaReleases.expandAccordion(accordionName);
    }

    @And("I select the checkbox for the given minister")
    public void selectCheckboxForMinister(){
        ministerialMediaReleases.selectCheckboxForMinister();
    }

    @When("I run the search")
    public void runSearch(){
        ministerialMediaReleases.runSearch();
    }

    @Then("Verify that the results on all pages only contain media releases for the given minister")
    public void verifySearchResultsForMinister(){
        ministerialMediaReleases.verifySearchResultsForMinister();
    }


}