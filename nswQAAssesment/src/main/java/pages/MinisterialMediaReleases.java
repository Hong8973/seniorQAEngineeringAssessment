package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class MinisterialMediaReleases {
    Common common = new Common();
    WebDriver driver = common.getDriver();


    private static String minister;

    // PAGE OBJECTS

    public WebElement accordion(String name){
        return common.waitForElement("//button[@class='search-filter__toggle' and contains(text(),'"+name+"')]", 60);
    }

    public WebElement checkbox(String name){
        return driver.findElement(By.xpath("//label[contains(@class,'nsw-form__checkbox') and contains(text(),'"+name+"')]"));
    }

    public WebElement buttonSearch(){
        return driver.findElement(By.xpath("//input[contains(@class,'button')and @value='Search']"));
    }

    public List<WebElement> cardTagList(){
        return driver.findElements(By.xpath("//div[@class='nsw-card__tag']"));
    }

    public WebElement buttonShowNextResults(){
        return driver.findElement(By.xpath("//a[@title='Show next results']"));
    }





    // METHODS


    // Set minister search criteria for use in later methods
    public void setMinister(String name){
        minister = name;
    }

    // Get minister value
    public String getMinister(){
        return minister;
    }

    // Click the accordion
    public void expandAccordion(String name){
        accordion(name).click();
    }

    // Select the checkbox for the given minister in the Filter by Minister accordion
    public void selectCheckboxForMinister(){
        checkbox(minister).click();
    }

    // click the Search button
    public void runSearch(){
        buttonSearch().click();
    }

    // Verify that the results on all pages only contain media releases for the given minister
    public void verifySearchResultsForMinister(){
        boolean isInAllTagsLists = true;
        int i = 0;

        // exit loop immediately if there are any fails
        while(isInAllTagsLists && i < cardTagList().size()){
            if(! cardTagList().get(i).getText().contains(minister)){
                isInAllTagsLists = false;
            }
            i++;
        }

        // Check all pages of search results unless already failed
        while(isInAllTagsLists && common.isElementPresent(buttonShowNextResults())){
            buttonShowNextResults().click();
            while(isInAllTagsLists && i < cardTagList().size()){
                if(! cardTagList().get(i).getText().contains(minister)){
                    isInAllTagsLists = false;
                }
                i++;
            }
        }
        Assert.assertTrue("Search results are for the given minister", isInAllTagsLists);
    }

}
