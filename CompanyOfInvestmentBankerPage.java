package test.pages;


import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import test.Support.ReadData;

import java.util.List;

public class CompanyOfInvestmentBankerPage extends FluentWebDriverPage {
    ReadData ReadData = new ReadData();
    public CompanyOfInvestmentBankerPage(WebDriverProvider driverProvider){
        super(driverProvider);
    }

    public void verifySubRoleOfBanker(){
        Assert.assertTrue(WaitUtil.isElementPresent(By.xpath("//div[@id='searchFilters']/div/span[contains(text(),'Subrole:')]/strong[contains(text(),'Investment Banker')]"),getDriverProvider().get()));
    }

    public void verifyStrategyOfBanker(){
        Assert.assertTrue(WaitUtil.isElementPresent(By.xpath("//div[@id='searchFilters']/div/span[contains(text(),'Strategy:')]/strong[contains(text(),'Capital Raising')]"),getDriverProvider().get()));
    }

    public void clickOnCompanyName(int RowIndex){
        try{
            String strCompany = ReadData.readDataExcel("RealEstateDetails", RowIndex, "InvestmentBankerCompanyName");
            findElement(By.xpath("//tbody[@id='searchResults']/tr/td/a/strong[contains(text(),'"+strCompany+"')]")).click();
        }catch (Exception e) {
            System.out.println(e);
        }

    }

    public void clickOnProject(int RowIndex){
        try{
            String strProject = ReadData.readDataExcel("RealEstateDetails", RowIndex, "VerifyProject");
            findElement(By.xpath("//tbody[@id='searchResults']/tr/td/a/strong[contains(text(),'"+strProject+"')]")).click();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void setSlider(){
        WebElement sliderLeft = findElement(By.xpath("//div[@id='searchFilters']/div[2]/div[2]/div/div[2]/a[1]"));
        for(int i=0;i<10;i++){
            sliderLeft.sendKeys(Keys.ARROW_UP);
        }
        WebElement sliderRight = findElement(By.xpath("//div[@id='searchFilters']/div[2]/div[2]/div/div[2]/a[2]"));
        for(int i=0;i<60;i++){
            sliderRight.sendKeys(Keys.ARROW_DOWN);
        }
        //wait until page gets loaded
        WaitUtil.simpleSleep(5000);
    }

    public void verifyInvestmentBankerCompany(int RowIndex){
        //wait until page gets loaded
        WaitUtil.simpleSleep(500);
        try{
            String strInvestmentBankerCompanyName = ReadData.readDataExcel("RealEstateDetails", RowIndex, "InvestmentBankerCompanyName");
            Assert.assertTrue(WaitUtil.isElementPresent(By.xpath("//tbody[@id='searchResults']/tr/td/a/strong/span[contains(text(),'"+strInvestmentBankerCompanyName+"')]"), getDriverProvider().get()));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void clearSlider(){
        WebElement sliderLeft = findElement(By.xpath("//div[@id='searchFilters']/div[2]/div[2]/div/div[2]/a[1]"));
        for(int i=0;i<10;i++){
            sliderLeft.sendKeys(Keys.ARROW_LEFT);
        }
        WebElement sliderRight = findElement(By.xpath("//div[@id='searchFilters']/div[2]/div[2]/div/div[2]/a[2]"));
        for(int i=40;i<=100;i++){
            sliderRight.sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public void selectHealthCareOption(){
        //wait until page gets loaded
        WaitUtil.simpleSleep(500);
        findElement(By.id("AssettypeId_checkbox_13")).click();
        findElement(By.xpath("//div[@id='searchFilters']/div/div/label[contains(text(),'Asset Experience:')]/following-sibling::div/div/div/span[@class='arrow glyphicon glyphicon-chevron-down']")).click();
    }

    public void selectPermittedOption(){
        //wait until page gets loaded
        WaitUtil.simpleSleep(500);
        findElement(By.id("DealstageId_checkbox_5")).click();
        findElement(By.xpath("//div[@id='searchFilters']/div/div/label[contains(text(),'Deal Stage:')]/following-sibling::div/div/div/span[@class='arrow glyphicon glyphicon-chevron-down']")).click();
    }

    public void clickProfileAndExperienceField(){
        //wait until profile field appears
        WaitUtil.simpleSleep(500);
        findElement(By.id("ui-accordion-1-header-0")).click();
    }

    public void selectNoOfOfficeField(){
        WebElement sliderLeft = findElement(By.xpath("//div[@id='ui-accordion-1-panel-0']/div[1]/div/div[2]/a[1]"));
        for(int i=0;i<55;i++){
            sliderLeft.sendKeys(Keys.ARROW_UP);
        }
    }

    public void clearNoOfOfficeField(){
        WebElement sliderLeft = findElement(By.xpath("//div[@id='ui-accordion-1-panel-0']/div[1]/div/div[2]/a[1]"));
        for(int i=0;i<55;i++){
            sliderLeft.sendKeys(Keys.ARROW_LEFT);
        }
    }

    public void selectNoOfProfessionals(){
        WebElement sliderLeft = findElement(By.xpath("//div[@id='ui-accordion-1-panel-0']/div[2]/div/div[2]/a[1]"));
        for(int i=0;i<60;i++){
            sliderLeft.sendKeys(Keys.ARROW_UP);
        }
    }

    public void clearNoOfProfessionals(){
        WebElement sliderLeft = findElement(By.xpath("//div[@id='ui-accordion-1-panel-0']/div[2]/div/div[2]/a[1]"));
        for(int i=0;i<60;i++){
            sliderLeft.sendKeys(Keys.ARROW_LEFT);
        }
    }

    public void selectValueOfTransactionCompleted(){
        WebElement sliderLeft = findElement(By.xpath("//div[@id='ui-accordion-1-panel-0']/div[3]/div/div[2]/a[1]"));
        for(int i=0;i<40;i++){
            sliderLeft.sendKeys(Keys.ARROW_UP);
        }
    }

    public void clearValueOfTransactionCompleted(){
        WebElement sliderLeft = findElement(By.xpath("//div[@id='ui-accordion-1-panel-0']/div[3]/div/div[2]/a[1]"));
        for(int i=0;i<40;i++){
            sliderLeft.sendKeys(Keys.ARROW_LEFT);
        }
    }

    public void selectNumberOfTransactionCompleted(){
        WebElement sliderLeft = findElement(By.xpath("//div[@id='ui-accordion-1-panel-0']/div[4]/div/div[2]/a[1]"));
        for(int i=0;i<40;i++){
            sliderLeft.sendKeys(Keys.ARROW_UP);
        }
    }

    public void clearNumberOfTransactionCompleted(){
        WebElement sliderLeft = findElement(By.xpath("//div[@id='ui-accordion-1-panel-0']/div[4]/div/div[2]/a[1]"));
        for(int i=0;i<40;i++){
            sliderLeft.sendKeys(Keys.ARROW_LEFT);
        }
    }

}
