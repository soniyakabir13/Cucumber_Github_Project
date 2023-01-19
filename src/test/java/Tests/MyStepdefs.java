package Tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;

public class MyStepdefs {
    WebDriver driver;
    @Given("Iam on the home page")
    public void iamOnTheHomePage() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/");
    }


    @When("I enter valid username and password")
    public void iEnterValidUsernameAndPassword() {

        driver.findElement(By.name("userName")).sendKeys("abc@gmail.com");
        driver.findElement(By.name("password")).sendKeys("1234");
        driver.findElement(By.name("submit")).click();
    }

    @Then("I should logged in")
    public void iShouldLoggedIn() {
    String expectedResult= "Login Successfully";
    String actualResult = driver.findElement
            (By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3")).getText();
    Assert.assertEquals(actualResult,expectedResult);

    }

    @When("I enter {string} username and {string} password")
    public void iEnterUsernameAndPassword(String userName, String passWord) {
        driver.findElement(By.name("userName")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(passWord);
        driver.findElement(By.name("submit")).click();

    }

    @Then("I should not be logged in")
    public void iShouldNotBeLoggedIn() {
       boolean userName =  driver.findElement(By.name("userName")).isDisplayed();
       Assert.assertTrue(userName);
    }


    @Given("I am on the google home page")
    public void iAmOnTheGoogleHomePage() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://www.google.com/");


    }

    @When("I enter {string} keywords")
    public void iEnterKeywords(String keyWord) {
        driver.findElement(By.name("q")).sendKeys(keyWord);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);


    }

    @Then("I should see a result")
    public void iShouldSeeAResult() {
     String results = driver.findElement(By.id("result-stats")).getText();
     System.out.println(results);
     //to remove all the white space
     String[] onlyNumbers = results.split(" ");
     //using index value to get the number only and using replace method to remove coma
     String number = onlyNumbers[1].replace(",","");
     System.out.println(number);
     //converting into double
     double resultNum = Double.parseDouble(number);
     Assert.assertTrue(resultNum > 10000000);


    }

    @Then("I should not see a result")
    public void iShouldNotSeeAResult() {
        String results = driver.findElement(By.id("result-stats")).getText();
        System.out.println(results);
        //to remove all the white space
        String[] onlyNumbers = results.split(" ");
        //using index value to get the number only and using replace method to remove coma
        String number = onlyNumbers[1].replace(",","");
        System.out.println(number);
        //converting into double
        double resultNum = Double.parseDouble(number);
        Assert.assertTrue(resultNum <= 0);












    }



}


