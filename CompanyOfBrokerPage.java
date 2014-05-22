package test.pages;


import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.Support.ReadData;

import java.util.List;

public class CompanyOfBrokerPage extends FluentWebDriverPage {
    ReadData ReadData = new ReadData();
    public CompanyOfBrokerPage(WebDriverProvider driverProvider){
        super(driverProvider);
    }

    public void verifySubRoleOfBroker(){
        Assert.assertTrue(WaitUtil.isElementPresent(By.xpath("//div[@id='searchFilters']/div[1]/span[contains(text(),'Subrole: ')]/strong[contains(text(),'Residential Broker')]"),getDriverProvider().get()));
    }

    public void verifyStrategy(){
        Assert.assertTrue(WaitUtil.isElementPresent(By.xpath("//div[@id='searchFilters']/div[1]/span[contains(text(),'Strategy:')]/strong[contains(text(),'Acquisitions')]"),getDriverProvider().get()));
    }

    public void clickOnBrokerCompanyName(int RowIndex){
        try{
            String strBrokerCompany = ReadData.readDataExcel("RealEstateDetails", RowIndex, "BrokerCompanyName");
            findElement(By.xpath("//tbody[@id='searchResults']/tr/td/a/strong[contains(text(),'"+strBrokerCompany+"')]")).click();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void clickOnServiceOfBroker(int RowIndex){
        try{
            String strBrokerService = ReadData.readDataExcel("RealEstateDetails", RowIndex, "VerifyProject");
            findElement(By.xpath("//tbody[@id='searchResults']/tr/td/a/strong[contains(text(),'"+strBrokerService+"')]")).click();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void verifyBrokerCompany(int RowIndex){
        //wait until page gets loaded
        WaitUtil.simpleSleep(500);
        try{
            String strBrokerCompanyName = ReadData.readDataExcel("RealEstateDetails", RowIndex, "BrokerCompanyName");
            Assert.assertTrue(WaitUtil.isElementPresent(By.xpath("//tbody[@id='searchResults']/tr/td/a/strong/span[contains(text(),'"+strBrokerCompanyName+"')]"), getDriverProvider().get()));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void selectSolarOption(){
        //wait until asset experience drop down appears
        WaitUtil.simpleSleep(500);
        findElement(By.id("AssettypeId_checkbox_16")).click();
        findElement(By.xpath("//div[@id='searchFilters']/div/div/label[contains(text(),'Asset Experience:')]/following-sibling::div/div/div/span[@class='arrow glyphicon glyphicon-chevron-down']")).click();
    }

    public void selectInDdOption() {
        //wait until page gets loaded
        WaitUtil.simpleSleep(500);
        findElement(By.id("DealstageId_checkbox_10")).click();
        findElement(By.xpath("//div[@id='searchFilters']/div/div/label[contains(text(),'Deal Stage:')]/following-sibling::div/div/div/span[@class='arrow glyphicon glyphicon-chevron-down']")).click();
    }

}
