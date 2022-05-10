package uk.co.library.testsuite;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;
import uk.co.library.pages.HomePage;
import uk.co.library.pages.ResultPage;
import uk.co.library.testbase.TestBase;
import uk.co.library.utility.Utility;

public class JobSearchTest extends TestBase {
    HomePage homePage;
    ResultPage resultPage;
    @BeforeMethod(alwaysRun = true)
public void inIt(){
homePage =new HomePage();
resultPage =new ResultPage();
    }
@Test(groups = {"sanity","regression","smoke"},dataProvider = "dataForJob",dataProviderClass = TestData.class)
    public void verifyJobSearchResultUsingDifferentDataSet(String jobTitle, String location, String
        distance, String salaryMin, String salaryMax, String salaryType, String jobType,String expectedText) throws InterruptedException {
        homePage.acceptCookies();
        homePage.enterJobTitle(jobTitle);
        homePage.enterLocation(location);
        homePage.selectDistance(distance);
        homePage.clickOnMoreSearchOptionLink();
        homePage.enterMinSalary(salaryMin);
        homePage.enterMaxSalary(salaryMax);
        homePage.selectSalaryType(salaryType);
        homePage.selectJobType(jobType);
        homePage.clickOnFindJobsButton();
        String actual =resultPage.getText();
        String expected = expectedText;

    Assert.assertEquals(actual,expected);
}


}
