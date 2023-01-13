package Day10_221226_ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
Add the excel file on the resources folder.
Open the file.
Open the workbook using file input stream.
Open the first worksheet.
Go to first row.
Go to first cell on that first row and print.
Go to second cell on that first row and print.
Go to 2nd row first cell and assert if the data equal to Russia.
Go to 3rd row 2nd cell-chain the row and cell.
Find the number of used row.
Print country, area key value pairs as map object.
 */
public class C02_ApachePoiTask {

    @Test
    public void apacheTask() throws IOException {
//Excel dosyamizin path'ini aldik.//Add the excel file on the resources folder.
        String excelPath = "src\\test\\java\\Resources\\excelfile.xlsx";

//Excel dosyasinaki verilere erisim icin asagidaki yontem/kod yapisi kullanilmaktadir.//Open the file.
        FileInputStream fileInputStream = new FileInputStream(excelPath);

// Acilan dosyayi excel workbook'una cevirdik. //Open the workbook using file input stream.
        Workbook workbook = WorkbookFactory.create(fileInputStream);

//Open the first worksheet.
        Sheet sheet1 = workbook.getSheetAt(0);

//Go to first row.
        Row row1 = sheet1.getRow(0);

//Go to first cell on that first row and print.
        Cell row1cell1 = row1.getCell(0);
        System.out.println("Row1 - Cell1 = " + row1cell1);//Row1 - Cell1 = COUNTRY

//Go to 2. cell on that first row and print.
        Cell row1cell2 = row1.getCell(1);
        System.out.println("Row1 - Cell2 = " + row1cell2);//Row1 - Cell2 = AREA

//Go to 2nd row first cell and assert if the data equal to Russia.
        Row row2 = sheet1.getRow(1);
        Cell row2Cell1 = row2.getCell(0);
        System.out.println("Row2 - Cell1 = " + row2Cell1);//Row2 - Cell1 = Rusya
        Assert.assertEquals("Rusya", row2Cell1.toString());

//Go to 3rd row 2nd cell-chain the row and cell.
        Row row3 = sheet1.getRow(2);
        Cell row3Cell2 = row3.getCell(1);
        System.out.println("Row3 - Cell2 = " + row3Cell2);//Row3 - Cell2 = 9569901.0

//Find the number of used row.
        sheet1.getPhysicalNumberOfRows();//Satirin sayisini verir.
        System.out.println(sheet1.getPhysicalNumberOfRows());//OUTPUT16

        sheet1.getLastRowNum();//son satirin index degerini verir. (Sonuc index cinsinden)
        System.out.println(sheet1.getLastRowNum());//15
        System.out.println();
        int totalRows = sheet1.getPhysicalNumberOfRows();
//Print country, area key value pairs as map object.
        Map<String, String> countryAreas = new HashMap<>();//hashMap olusturduk. For dongusunde konteyner'a ihtiyacimiz var. Bu amacla olusturulmaktadir.
        for (int row = 1; row < totalRows; row++) {
            String country = sheet1.getRow(row).getCell(0).toString();

            //Her satirda ulkeyi yazdiriyoruz
            System.out.println((row + 1) + ". satir " + country);

            String area = sheet1.getRow(row).getCell(1).toString();
            System.out.println("Country = " + country + " - Area= " + area);
            // Her bir satirdaki ulke ve yuzolcumu degerlerini mapimizin icerisine yerlestirdik
            countryAreas.put(country, area);
        }
/*
2. satir Rusya
Country = Rusya - Area= 1.6377742E7
3. satir Çin
Country = Çin - Area= 9569901.0
4. satir ABD
Country = ABD - Area= 9158960.0
5. satir Canada
Country = Canada - Area= 9093507.0
6. satir Brezilya
Country = Brezilya - Area= 8460415.0
7. satir Avustralya
Country = Avustralya - Area= 7682300.0
8. satir Hindistan
Country = Hindistan - Area= 2973193.0
9. satir Arjantin
Country = Arjantin - Area= 2736690.0
10. satir Kazakistan
Country = Kazakistan - Area= 2699700.0
11. satir Cezayir
Country = Cezayir - Area= 2381741.0
12. satir Suudi Arabistan
Country = Suudi Arabistan - Area= 2381741.0
13. satir Meksika
Country = Meksika - Area= 1943945.0
14. satir Endonezya
Country = Endonezya - Area= 1811569.0
15. satir Sudan
Country = Sudan - Area= 1765050.0
16. satir Türkiye
Country = Türkiye - Area= 769632.0
 */
        System.out.println(countryAreas);
        //{Suudi Arabistan=2381741.0, Rusya=1.6377742E7, ABD=9158960.0, Brezilya=8460415.0,
        // Sudan=1765050.0, Avustralya=7682300.0, Hindistan=2973193.0, Arjantin=2736690.0,
        // Meksika=1943945.0, Çin=9569901.0, Canada=9093507.0, Cezayir=2381741.0, Kazakistan=2699700.0,
        // Endonezya=1811569.0, Türkiye=769632.0}
    }
}
