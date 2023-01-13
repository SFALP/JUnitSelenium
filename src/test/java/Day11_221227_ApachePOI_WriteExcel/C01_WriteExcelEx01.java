package Day11_221227_ApachePOI_WriteExcel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*TASK
Store the path of the file as string and open the file.
Open the workbook.
Open the first worksheet.
Go to the first row.
Create a cell on the 3rd column (2nd index) on the first row.
Write “POPULATION” on that cell.
Create a cell on the 2nd row 3rd cell(index2), and write data.
Create a cell on the 3rd row 3rd cell(index2), and write data.
Create a cell on the 4th row 3rd cell(index2), and write data.
Write and save the workbook.
Close the file.
Close the workbook.
 */
public class C01_WriteExcelEx01 {

    @Test
    public void test01() throws IOException {
        //Dosya path aldin
        String path = "src\\test\\java\\Resources\\excelfile.xlsx";

//Dosyamizi aciyoruz.
        FileInputStream fis = new FileInputStream(path);

//Dosyamizi bir workbook haline getiriyoruz.
        Workbook workbook = WorkbookFactory.create(fis);

//Sheet'e gecilir
        Sheet sheet2 = workbook.getSheetAt(1);//2.sheet'in indexi 1 oldugu icin bu sekilde yazilir.

//Satira gecis yapilir.
        Row row1 = sheet2.getRow(0);//1.satiri alabilmek icin index 0 olmalidir.

// Cell'e gecis yapilir.
//        Cell row1Cell3=row1.getCell(2);//NSA'da boyle yapilir. Varyasyon icin alttaki kodla da yapilir.
        Cell row1Cell3 = row1.createCell(2);//ilk satirin 3.hucresini olusturduk.

//Hucreye ifade yazdirilmasi asamasi:
        row1Cell3.setCellValue("POPULATION");//1satir, 3.sutuna POPULATION ifadesi yazdirildi

//Method chain'le data ekleme/degistirme methodu:
        sheet2.getRow(1).createCell(2).setCellValue("Rusyanin populasyonu");

        sheet2.getRow(2).createCell(2).setCellValue("Cin'in populasyonu");
        sheet2.getRow(3).createCell(2).setCellValue("ABD'nin populasyonu");

//Excel dosyamiza yazma islemini yapiyoruz.
        FileOutputStream fos = new FileOutputStream(path);

//Workbook'ta yazma islemi yapilması kodu olusturulur.
        workbook.write(fos);

//Dosyalarin kapatilmasi ise;
        fis.close();
        fos.close();

//Workbook'un kapatilmasi ise:
        workbook.close();
    }
}