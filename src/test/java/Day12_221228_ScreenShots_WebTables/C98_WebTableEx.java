package Day12_221228_ScreenShots_WebTables;

import Utilities.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
Go to URL: https://the-internet.herokuapp.com/tables
Print the entire table
Print All Rows
Print Last row data only
Print column 5 data in the table body
Write a method that accepts 2 parameters
parameter 1 = row number
parameter 2 = column number
printData(3,4); => prints
parameter 3 = table id
printData(3,4,"table1") => prints data in 3rd row 4th Column with table id
 */
public class C98_WebTableEx extends BaseTest {
    @Override
    public void tearDown() {
        super.tearDown();
    }

    @Test
    public void test01() {
//Go to URL: https://the-internet.herokuapp.com/tables
        driver.get("https://the-internet.herokuapp.com/tables");

        WebElement table1 = driver.findElement(By.id("table1"));

//Print the entire table
        System.out.println("table1.getText() = " + table1.getText());
/*
table.getText() = Last Name First Name Email Due Web Site Action
Smith John jsmith@gmail.com $50.00 http://www.jsmith.com edit delete
Bach Frank fbach@yahoo.com $51.00 http://www.frank.com edit delete
Doe Jason jdoe@hotmail.com $100.00 http://www.jdoe.com edit delete
Conway Tim tconway@earthlink.net $50.00 http://www.timconway.com edit delete

 */

//Print All Rows
        int rowTotals = table1.findElements(By.xpath(".//tr")).size();
        System.out.println("rowTotals = " + rowTotals);//rowTotals = 5

        for (int i = 1; i < rowTotals; i++) {
            System.out.println("" + i + ".satır: " + table1.findElement(By.xpath(".//tr[" + i + "]")).getText());
/*
1.satır: Last Name First Name Email Due Web Site Action
2.satır: Bach Frank fbach@yahoo.com $51.00 http://www.frank.com edit delete
3.satır: Doe Jason jdoe@hotmail.com $100.00 http://www.jdoe.com edit delete
4.satır: Conway Tim tconway@earthlink.net $50.00 http://www.timconway.com edit delete
 */
        }

//Print Last row data only
        WebElement lastRow = table1.findElement(By.xpath(".//tr[" + (rowTotals - 1) + "]"));
        System.out.println("lastRow = " + lastRow.getText());//lastRow = Conway Tim tconway@earthlink.net $50.00 http://www.timconway.com edit delete

//Print column 5 data in the table body
        for (int i = 1; i < rowTotals; i++) {
            System.out.println("" + i + ".satır-5.sütun: " + table1.findElement(By.xpath(".//tr[" + i + "]//td[5]")).getText());
/*
1.satır-5.sütun: http://www.jsmith.com
2.satır-5.sütun: http://www.frank.com
3.satır-5.sütun: http://www.jdoe.com
4.satır-5.sütun: http://www.timconway.com
 */
        }
        printData(3, 4, table1);
    }
//Write a method that accepts 2 parameters

    //parameter 1 = row number
    //parameter 2 = column number
    //printData(3,4); => prints
    //parameter 3 = table id
    //printData(3,4,"table1") => prints data in 3rd row 4th Column with table id

    public void printData(int rowNum, int columnNum, WebElement table1) {
        String data = table1.findElement(By.xpath(".//tr[" + rowNum + "]//td[" + columnNum + "]")).getText();
        System.out.println("" + rowNum + ".satır " + columnNum + ".sütundaki data: " + data);
//3.satır 4.sütundaki data: $100.00

    }

}