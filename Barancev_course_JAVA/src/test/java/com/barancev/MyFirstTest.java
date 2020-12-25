package com.barancev;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void myFirstTest(){
        login("admin", "admin");
        String title = driver.getTitle();
        wait.until(titleIs(title));
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

    public void login (String login, String password){
        driver.navigate().to("http://localhost/litecart/admin");
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).sendKeys(login);
        WebElement element2 = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(password);
        WebElement element3 = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("login")));
        driver.findElement(By.name("login")).click();
    }
}
