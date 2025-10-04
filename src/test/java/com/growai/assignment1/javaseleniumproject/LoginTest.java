package com.growai.assignment1.javaseleniumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;

    @BeforeClass
    public  void setUpBrowser()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("Browser launched");
    }

    @BeforeMethod
    public void navigateToApp(){
        driver.get("https://the-internet.herokuapp.com/login");
        System.out.println("Navigated to The internet!");
    }

    @Test(priority = 1)
    public void  Testcase1_Valid_Login_Test() {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement text = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='flash success']")));

        String successtext = text.getText();
        Assert.assertTrue(successtext.contains("You logged into a secure area!"), "Login success message not displayed.");
        System.out.println(successtext);
    }

    @Test(priority = 2)
    public void  Testcase2_Invalid_Login_Test() {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmithas");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("SuperSecretPasswo");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Invalidtext = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='flash']")));

        String invalid_text = Invalidtext.getText();
        Assert.assertTrue(invalid_text.contains("Your username is invalid!"));
        System.out.println(invalid_text);
    }

    @Test(priority = 3)
    public void  Testcase3_Empty_Login_Test() {

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Invalidtext = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='flash']")));

        String invalid_text = Invalidtext.getText();
        Assert.assertTrue(invalid_text.contains("Your username is invalid!"));
        System.out.println(invalid_text);
    }
    @AfterClass
    public void closeBrowser(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.quit();
        System.out.println("Browser Closed");
    }

}
