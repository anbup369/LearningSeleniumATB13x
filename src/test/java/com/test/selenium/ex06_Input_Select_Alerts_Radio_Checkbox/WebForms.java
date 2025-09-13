package com.test.selenium.ex06_Input_Select_Alerts_Radio_Checkbox;

// Webform practice with multiple UI elements : https://www.selenium.dev/selenium/web/web-form.html
//.submit() and .isSelected() is used for webelements
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebForms {
    @Test
    public void webforms() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.get("https://www.selenium.dev/selenium/web/web-form.html");
//            driver.findElement(By.id("my-text-id")).sendKeys("testinput");
//            driver.findElement(By.name("my-password")).sendKeys("password");
//            driver.findElement(By.name("my-textarea")).sendKeys("this is text area");

            // InputBox disabled
//            WebElement disabledInput = driver.findElement(By.name("my-disabled"));
//            Assert.assertFalse(disabledInput.isEnabled(), "Input should be disabled");
//            System.out.println("Inputbox enabled(disabled): " + disabledInput.isEnabled());

            // Inputbox Readonly(enabled)
//            WebElement ReadonlyInput = driver.findElement(By.xpath("//input[@name='my-readonly']"));
//            Assert.assertTrue(ReadonlyInput.isEnabled(), "Input should be enabled");
//            System.out.println("Inputbox enabled(enabled): " + ReadonlyInput.isEnabled());

            // Checked checkbox
//            WebElement Checked_checkbox = driver.findElement(By.xpath("//input[@id=\"my-check-1\"]"));
//            Assert.assertTrue(Checked_checkbox.isSelected(), "Checkbox is selected");
//            System.out.println("Checkbox selected  : " + Checked_checkbox.isSelected());

            // Default checkbox
//            WebElement UnChecked_checkbox = driver.findElement(By.xpath("//input[@id=\"my-check-2\"]"));
//            Assert.assertFalse(UnChecked_checkbox.isSelected(), "Checkbox is unselected");
//            System.out.println("Default checkbox selected : " + UnChecked_checkbox.isSelected());

            // Checked radio button
//            WebElement Checked_radio = driver.findElement(By.xpath("//input[@id=\"my-radio-1\"]"));
//            Assert.assertTrue(Checked_radio.isSelected(), "Radio button is selected");
//            System.out.println("Radio button selected : " + Checked_radio.isSelected());

            // Default radio button
//            WebElement UnChecked_radio = driver.findElement(By.xpath("//input[@id=\"my-radio-2\"]"));
//            Assert.assertFalse(UnChecked_radio.isSelected(), "Radio button is unselected");
//            System.out.println("Default Radio button selected  : " + UnChecked_radio.isSelected());

            //Dropdown (select)
//            WebElement dropdown1 = driver.findElement(By.xpath("//select[@name='my-select']"));
//            Select select = new Select(dropdown1);
//            select.selectByValue("2");
//
//            WebElement selected = select.getFirstSelectedOption();
//
//            Assert.assertEquals(selected.getText(),"Two");
//            System.out.println(selected.getText());
//
//            Assert.assertEquals(selected.getAttribute("value"),"2");
//            System.out.println(selected.getAttribute("value"));

            //Dropdown (datalist)
            driver.findElement(By.xpath("//input[@name=\"my-datalist\"]")).click();



            // Clicking Submit button
//            driver.findElement(By.xpath("//button[@type='submit']")).submit();

        } catch (Exception e) {
            System.err.println("Test encountered an error: " + e.getMessage());
            e.printStackTrace();
        } finally {
//            driver.quit(); // Ensures browser closes even if test fails
        }
    }
}