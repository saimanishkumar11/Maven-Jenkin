package GaadiBazar;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SearchByBudget {

    static String driverPath = "D:\\Softwares\\geckodriver-v0.28.0-win64\\geckodriver.exe";
    WebDriver driver;
    
    @Test
    public void searchGaadiBybudget() throws InterruptedException
    {
        
        System.setProperty("webdriver.gecko.driver",driverPath);            
        driver = new FirefoxDriver();
        driver.get("https://www.gaadibazaar.in/");
            
        WebElement radioByBudget = driver.findElement(By.id("by-budget-label"));
        radioByBudget.click();
        driver.findElement(By.name("select-budget-btn")).click();
        
        WebElement dropDownBudget = driver.findElement(By.id("home-dropmenu-ul"));
        List<WebElement> optionsBudget = dropDownBudget.findElements(By.tagName("li"));
        for (WebElement option : optionsBudget)
        {
            if (option.getText().equals("5 - 10 Lakhs "))
            {
                option.click(); // click the desired option
                break;
            }
        }
        //dropDown.findElement(By.id("home-dropmenu-ul-list1")).click();
        
        driver.findElement(By.name("select-bodytype-btn")).click();
        
        WebElement dropDownBody = driver.findElement(By.id("home-dropmenu-ul02"));
        List<WebElement> optionsBody = dropDownBody.findElements(By.tagName("li"));
        for (WebElement option : optionsBody)
        {
            if (option.getText().equals("Hatch Back "))
            {
                option.click(); // click the desired option
                break;
            }
        }
        
        driver.findElement(By.name("select-card-budget-btn")).click();
        
        Thread.sleep(3000);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
                
        driver.close();
        
    }

 

}
