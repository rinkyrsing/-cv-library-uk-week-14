package uk.co.library.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import uk.co.library.utility.Utility;

import javax.swing.plaf.PanelUI;
import java.time.Duration;

public class HomePage extends Utility {
    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='keywords']")
    WebElement jobTitleField ;
    @FindBy(xpath = "//input[@id='location']")
    WebElement locationField ;
    @FindBy(xpath = "//select[@id='distance']")
    WebElement distanceDropDown;
    @FindBy(xpath = "//button[@id='toggle-hp-search']")
    WebElement moreSearchOptionsLink;
    @FindBy(xpath = "//input[@id='salarymin']")
    WebElement salaryMin;
    @FindBy (xpath = "//input[@id='salarymax']")
    WebElement salaryMax;
    @FindBy (xpath = "//select[@id='salarytype']")
    WebElement salaryTypeDropDown;
    @FindBy(xpath = "//select[@id='tempperm']")
    WebElement jobTypeDropDown;
    @FindBy (xpath = "//input[@id='hp-search-btn']")
    WebElement findJobsBtn;
    @FindBy (css ="#hp-search-btn")
    WebElement acceptPrivacy;
    WebElement ele = driver.findElement(By.xpath("//input[@id='hp-search-btn']"));
    @FindBy(xpath = "//iframe[@id='gdpr-consent-notice']")
    WebElement acceptIFrame;

    @FindBy(xpath = "//button[@id='save']")
    WebElement acceptCookiesButton;
    public void acceptCookies(){
       /* Reporter.log("Accept all message "  + acceptCookiesButton.toString()+"<br>");*/
        driver.switchTo().frame(acceptIFrame);
        clickOnElement(acceptCookiesButton);}
    public void clickOnFindJobsButton(){
        Reporter.log("Click on FindJob button"  + findJobsBtn.toString()+"<br>");
        clickOnElement(findJobsBtn);
    }
    public void enterJobTitle(String jobTitle){
        Reporter.log("Enter jobtitle " + jobTitle + " to jobtitle field " + jobTitleField.toString()+"<br>");
        sendTextToElement(jobTitleField,jobTitle);
    }
    public void enterLocation(String location){
        Reporter.log("Enter location " + location + " to location field " + locationField.toString()+"<br>");
        sendTextToElement(locationField,location);
    }
    public void selectDistance(String distance){
        Reporter.log("Select distance " + distance + " from distsance dropdown " + distanceDropDown.toString()+"<br>");
        selectByVisibleTextFromDropDown(distanceDropDown,distance);
    }
    public void clickOnMoreSearchOptionLink(){
        Reporter.log("Click on more search option "  + moreSearchOptionsLink.toString()+"<br>");
        clickOnElement(moreSearchOptionsLink);
    }
    public void enterMinSalary(String minSalary){
        Reporter.log("Enter min Salary " + minSalary + " to minimum salary field " + salaryMin.toString()+"<br>");
        sendTextToElement(salaryMin,minSalary);
    }
    public void enterMaxSalary(String maxSalary){
        Reporter.log("Enter max Salary " + maxSalary + " to maximum salary field " + salaryMax.toString()+"<br>");
        sendTextToElement(salaryMax,maxSalary);
    }
    public void selectSalaryType(String salaryType){
        Reporter.log("Select Salary Type " + salaryType + " from salary type dropdown " + salaryTypeDropDown.toString()+"<br>");
        selectByVisibleTextFromDropDown(salaryTypeDropDown,salaryType);
    }
    public void selectJobType(String jobType){
        Reporter.log("Select Job Type " + jobType + " from job type dropdown " + jobTypeDropDown.toString()+"<br>");
        selectByVisibleTextFromDropDown(jobTypeDropDown,jobType);
    }



}
