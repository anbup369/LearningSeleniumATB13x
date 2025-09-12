package com.test.selenium.Task;
//https://awesomeqa.com/practice.html

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Task3rd_Sept_awesome_qa_practice {

    @Test
    public void task() {

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://awesomeqa.com/practice.html");

        //To Enter First name
        driver.findElement(By.xpath("//input[@name=\"firstname\"]")).sendKeys("testFirstName");

        //To Enter Last name
        driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("testLastName");

        //To select Gender  Male
        driver.findElement(By.xpath("//input[@id=\"sex-0\"]")).click();

        //To select exp 7 year
        driver.findElement(By.xpath("//input[@id=\"exp-6\"]")).click();

        //To select Date(entered date)
        driver.findElement(By.xpath("//input[@id=\"datepicker\"]")).sendKeys("03/09/2025");

        //To select Profession: Automation Tester
        driver.findElement(By.xpath("//input[@id=\"profession-1\"]")).click();

        //To select Automation Tools: Webdriver
        driver.findElement(By.xpath("//input[@id=\"tool-2\"]")).click();

        //to select Continent :Europe  //    //Can use Select class to automate classic dropdown with tag <select>
        driver.findElement(By.xpath("//select[@id=\"continents\"]")).click();
        driver.findElement(By.xpath("//select[@id=\"continents\"]")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath("//select[@id=\"continents\"]")).click();

        //Can use Select class to automate classic dropdown with tag <select>


        //To select selenium_commands: wait commands //    //Can use Select class to automate classic dropdown with tag <select>
        driver.findElement(By.xpath("//select[@id=\"selenium_commands\"]")).click();
        driver.findElement(By.xpath("//select[@id=\"selenium_commands\"]")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath("//select[@id=\"selenium_commands\"]")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath("//select[@id=\"selenium_commands\"]")).sendKeys(Keys.ARROW_DOWN);


        //Upload Image
        //Download File Click here to Download File

        //To click submit button
        driver.findElement(By.xpath("//button[@id=\"submit\"]")).click();
    }

}
