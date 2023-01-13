package Day11_221227_ApachePOI_WriteExcel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.*;

/*TASK
Create an object of File class to open xlsx file.
Create an object of FileInputStream class to read excel file.
Create an object of FileInputStream class to read excel file.
Creating workbook instance that refers to .xlsx file.
Creating a Sheet object.
Get all rows in the sheet.
Create a row object to retrieve row at index 3.
Create a cell object to enter value in it using cell Index.
Write the data in excel using output stream.
 */
public class C02_WriteExcelEx02 {
    @Test
    public void changeExcelData() throws IOException {
//Dosya path adresini aldik.
        String filePath = "src/test/java/Resources/excelData.xlsx";

//Path'imizden file olusturduk
        File file = new File(filePath);

//File'mizi actik.
        FileInputStream fis = new FileInputStream(file);

//Workbook'umuzu olusturduk
        Workbook wB = WorkbookFactory.create(fis);

//Sheet erisimi yapildi
        Sheet informationData = wB.getSheet("informationData");

// total row sayisini bulduk ve yazdirdik
        int totalRowsUsed = informationData.getLastRowNum() - informationData.getFirstRowNum();
        System.out.println("Total Rows = " + totalRowsUsed);//Total Rows = 13

// Yeni bir row olusturup row icerisindeki celleri de olusturarak degerlerini atadik
        Row row5 = informationData.getRow(4);

        row5.createCell(0).setCellValue("Ahmet");
        row5.createCell(1).setCellValue("Cakar");
        row5.createCell(2).setCellValue("ahmet.cakar@beyazfutbol.com");
        row5.createCell(3).setCellValue("Male");
        row5.createCell(4).setCellValue("0123456789");
        row5.createCell(5).setCellValue("Address");

// Dosyamiza yazma islemini gerceklestirdik
        FileOutputStream fos = new FileOutputStream(file);
        wB.write(fos);

// Oblejelerimizi kapattik
        fis.close();
        fos.close();
        wB.close();
    }
}