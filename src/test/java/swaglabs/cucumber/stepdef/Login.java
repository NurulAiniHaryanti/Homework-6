/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swaglabs.cucumber.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    
    @Given("user is on SwagLabs login page")
    public void user_is_on_SwagLabs_login_page() {
        WebDriverManager.chromedriver().setup();
//        ChromeOptions opt = new ChromeOptions();
        //opt.setHeadless(false);
        
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        
    }
    @When("user input (.*) as username$")
    public void user_input_standart_user_as_username(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
    }
    @And("user input (.*) as password$")
    public void user_input_secret_sauce_as_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }
    @And("user click login button")
    public void user_click_login_button() {
        driver.findElement(By.id("login-button")).click();
    }
    @Then("user verify (.*) login result$")
    public void user_is_on_dashboard(String status) {
       if (status.equals("success")) {
           WebElement element = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
           String text = element.getText();
           Assert.assertEquals("Products", text);
       } else {
           WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
           String textError = errorElement.getText();
           Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", textError);
        }
    
    }
    
    @And("user add cart sauce labs bike light")
    public void user_add_cart_sauce_labs_bike_light(){
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
    }
    
    @Then("cart is added")
    public void cart_is_added(){
        WebElement cartElement = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"));
        String cartText = cartElement.getText();
        Assert.assertEquals("1", cartText);
    }
    @And("user remove cart sauce labs bike light")
    public void user_remove_cart_sauce_labs_bike_light(){
        driver.findElement(By.id("remove-sauce-labs-bike-light")).click();
    
    }
    @Then("cart is blank")
    public void cart_is_blank(){
        WebElement cartElement = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
        String cartText = cartElement.getText();
        Assert.assertEquals("", cartText);
    }  
}