package com.test.selenium.ex11_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/*
https://awesomeqa.com/webtable.html

XPath Summary for Static Web Table Automation
| Goal | XPath |
| Get the entire table | //table |
| Get the header row | //table//th |
| Get all rows (including header) | //table/tbody/tr |
| Get all data rows (excluding header) | //table/tbody/tr[position()>1] |
| Get all company names | //table/tbody/tr/td[1] |
| Get the country of "Island Trading" | //td[text()='Island Trading']/following-sibling::td[2] |
| Get a specific cell (row 3, column 2) | //table/tbody/tr[3]/td[2] |
| Find row with partial text "Island" | //table/tbody/tr[td[contains(text(),'Island')]] |

 */

public class StaticWebTableTests {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/webtable.html");
    }

    @Test
    public void Test_01verifyEntireTableIsDisplayed() {
        //| Get the entire table | //table |
        WebElement table = driver.findElement(By.xpath("//table"));
        Assert.assertTrue(table.isDisplayed(), "Table is not displayed");
        System.out.println("Printing Entire Table\n");
        System.out.println(table.getText());

    }

    @Test
    public void Test_02verifyHeaderRowContents() {
        //| Get the header row | //table//th |
        List<WebElement> headers = driver.findElements(By.xpath("//table//th"));
        Assert.assertFalse(headers.isEmpty(), "Header row is empty");
        System.out.println("Printing Header Row:");
        for (WebElement header : headers) {
            System.out.print(header.getText() + " | ");
        }

    }

    @Test
    public void Test_03verifyRowAndColumnCountAndPrintAllCells() {

        // Verify no of Rows
        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
        Assert.assertFalse(rows.isEmpty(), "No rows found");
        System.out.println("Total rows: " + rows.size());


        // Verify no of Columns
        List<WebElement> Columns = driver.findElements(By.xpath("//table/tbody/tr[2]/td"));
        Assert.assertFalse(Columns.isEmpty(), "No columns found");
        System.out.println("Total columns: " + Columns.size());


        // Iterate through all cell
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell2 : cells) {
                System.out.print(cell2.getText() + " | ");
            }
            System.out.println();
        }
    }

    @Test
    public void Test_04verifyAllDataRowsArePresent() {
        //| Get all rows (excluding header) | //table/tbody/tr[position()>1] |
        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr[position()>1]"));
        Assert.assertFalse(rows.isEmpty(), "No data rows found");

        System.out.println("printing all rows:\n");
        for (WebElement row : rows) {
            System.out.println(row.getText());
        }
    }

    @Test
    public void Test_05verifyCompanyNamesAreListed() {
        //| Get all Company names | //table/tbody/tr/td[1] |
        List<WebElement> companies = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
        Assert.assertFalse(companies.isEmpty(), "No company names found");

        System.out.println("Printing Company names:\n");
        for (WebElement company : companies) {
            System.out.println(company.getText());
        }
        System.out.println();
    }

    @Test
    public void Test_06verifyCountryOfIslandTrading() {
        //| Get the country of "Island Trading" |//td[text()='Island Trading']/following-sibling::td[2]|
        WebElement country = driver.findElement(By.xpath("//td[text()='Island Trading']/following-sibling::td[2]"));
        Assert.assertEquals(country.getText(), "UK", "Country of 'Island Trading' is not UK");

        System.out.println("\nCountry of Island Trading : " + country.getText());
    }

    @Test
    public void Test_07verifySpecificCellValueByIndex() {
        //Get cell value by row and column index ,i.e. Access Cell value at row 3, column 2
        WebElement cell = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
        Assert.assertNotNull(cell.getText(), "Cell value is null");
        System.out.println("Cell value at row 3, column 2: " + cell.getText());
    }

    @Test
    public void Test_08verifyRowWithPartialTextMatch() {
        //Find row based on partial text match
      WebElement row = driver.findElement(By.xpath("//table/tbody/tr[td[contains(text(),'Island')]]"));//for getting entire row of matched text
        Assert.assertTrue(row.getText().contains("Island"), "Row does not contain partial text 'Island'");
        System.out.println("Row with partial match 'Island': " + row.getText());
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
