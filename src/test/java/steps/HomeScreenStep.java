package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.HomeScreenPage;
import utils.Environment;

public class HomeScreenStep {

    HomeScreenPage homeScreenPage = new HomeScreenPage(Environment.getDriver());

    @Given("verify the {string}")
    public void verify_the_title(String title) {
        homeScreenPage.getHomeScreenTitle(title);
    }

    @Then("verify the elements on the screen")
    public void verify_the_elements_on_the_screen() {
        Assert.assertTrue(homeScreenPage.helloText().isDisplayed());
        Assert.assertTrue(homeScreenPage.localizationText().isDisplayed());
        Assert.assertTrue(homeScreenPage.enButton().isDisplayed());
        Assert.assertTrue(homeScreenPage.chromeButton().isDisplayed());
        Assert.assertTrue(homeScreenPage.fileButton().isDisplayed());
        Assert.assertTrue(homeScreenPage.editText().isDisplayed());
        Assert.assertTrue(homeScreenPage.showProgressBarButton().isDisplayed());
        Assert.assertTrue(homeScreenPage.acceptCheckBox().isDisplayed());
        Assert.assertTrue(homeScreenPage.displayTextViewButton().isDisplayed());
        Assert.assertTrue(homeScreenPage.displayToastButton().isDisplayed());
        Assert.assertTrue(homeScreenPage.displayPopUpWindowButton().isDisplayed());
        Assert.assertTrue(homeScreenPage.unHandledExceptiponButton().isDisplayed());
        Assert.assertTrue(homeScreenPage.unHandledExceptiponEditText().isDisplayed());
        Assert.assertTrue(homeScreenPage.encodedText().isDisplayed());
        Assert.assertTrue(homeScreenPage.layoutButton().isDisplayed());
    }
}
