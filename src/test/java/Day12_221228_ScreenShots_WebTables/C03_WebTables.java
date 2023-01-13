package Day12_221228_ScreenShots_WebTables;

import Utilities.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*TASK
Go to URL: http://demo.guru99.com/test/web-table-element.php
To find third row of table
To get 3rd row's 2nd column data
Get all the values of a Dynamic Table
 */
public class C03_WebTables extends BaseTest {
    @Override
    public void tearDown() {
//        super.tearDown();
    }

    @Test
    public void webTableEx() {
        driver.get("http://demo.guru99.com/test/web-table-element.php");
//Tablomuzu locate ettik
        WebElement table = driver.findElement(By.xpath("//table[@class='dataTable']")).findElement(By.tagName("tbody"));

//3.satir locate edildi.
        WebElement row3 = table.findElement(By.xpath("(.//tr)[3]"));

//3.satir 3.sutun (hucre) locate edildi.
        WebElement row3Cell3 = row3.findElement(By.xpath(".//td[3]"));

        System.out.println("row3Cell3 = " + row3Cell3.getText());//BU VERI SUREKLI DEGISKENDIR.// row3Cell3 = 905.8

        int satirSayisi = table.findElements(By.xpath(".//tr")).size();
        System.out.println("satirSayisi = " + satirSayisi);//satirSayisi = 26

        int sutunSayisi = row3.findElements(By.xpath(".//td")).size();
        System.out.println("sutunSayisi = " + sutunSayisi);//sutunSayisi = 5

        for (int i = 1; i <= satirSayisi; i++) {
            //her bir satir

            for (int j = 1; j <= sutunSayisi; j++) {
                //her satirin sutunu
                By locator = By.xpath(".//tr[" + i + "]//td[" + j + "]");
                WebElement tableData = table.findElement(locator);

                System.out.print(tableData.getText() + " ");
            }
            System.out.println();
        }
        /* OUTPUT

Corporation Bank A 620.1 302.9 + 9.6
JaiprakashAssociates A 762.1 562.9 + 7.3
Central Bank A 608.5 43.4 + 4.4
DCB Bank A 678.1 683.4 + 5.5
Corporation Bank A 836.4 149.6 + 2
Power Finance Co A 147.4 668.6 + 5
Marico Ltd. A 466.9 400.4 + 8.4
Ajanta Pharma Lt A 747.8 488.6 + 4.4
GRUH Finance Li A 566.9 43 + 7.8
Hind. Petrol A 90.6 997.6 + 3.5
GRUH Finance Li A 179 802.8 + 9.2
LIC Housing Fi A 235.9 897.2 + 9.9
Bharat Petroleum A 355.5 718.7 + 8.2
Deepak Fertilisers A 485.2 515.6 + 8.4
Rashtriya Chemicals A 900.5 759.8 + 6.4
Dewan Housing A 286.8 445.3 + 6
Dewan Housing A 523.6 813.5 + 5.2
IDFC Bank A 357 671.8 + 4
JK Tyre & Industries A 24.5 513 + 2.9
LIC Housing Fi A 423 743 + 5.9
Hero MotoCorp A 70.1 865 + 9.6
Bharat Electroni A 950.2 817.7 + 6.1
Kirloskar Oil Engine A 440.3 166.1 + 9.5
Quess Corp A 238.2 425 + 2.2
Kirloskar Oil Engine A 615.1 848.9 + 6.5
Chennai Petro. A 934.8 472.6 + 7.5

         */
    }
}