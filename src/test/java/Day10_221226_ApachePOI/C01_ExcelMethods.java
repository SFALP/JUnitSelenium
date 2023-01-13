package Day10_221226_ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ExcelMethods {
    public static void main(String[] args) throws IOException {
//Excel dosyamizin path'ini aldik.
        String excelPath="src\\test\\java\\Resources\\excelfile.xlsx";

//Excel dosyasina erisim icin asagidaki yontem/kod yapisi kullanilmaktadir.
        FileInputStream fileInputStream=new FileInputStream(excelPath);

// Acilan dosyayi excel workbook'una cevirdik
        Workbook workbook= WorkbookFactory.create(fileInputStream);

//Excelde erisim sirasi: Kitap(Workbook) ismi --> Sayfa indexi(sheet) --> Satir verisi --> Sutun verisi

        Sheet sheet1=workbook.getSheetAt(0);//1.sayfanin index degeri 0 oldugundan burada sheet bilgisi tanimlanmistir.

//Satir verisini asagidaki sekilde aliyoruz:
        Row row1=sheet1.getRow(0);//ilk satir isaretlendi. Index'i 0'dir.

//Ilgili satirda yer alan bir hucre de index no uzerinden secilir.
        Cell cell1=row1.getCell(0);//Bu kod, row1'de yer alan 0.indexte yer alan cell'de(hucrede) yer alan bilgi isaretlenmis olur.

        System.out.println("Cell1 = " + cell1);//OUTPUT: cell1 = COUNTRY

// Hucrelerimizde string operasyonlarini gerceklestirmek istersek toString() methodunu kullanarak hucreyi string'e cevirebiliriz
        System.out.println("Cell1 = " + cell1.toString().toLowerCase());//OUTPUT: Cell1 = country
    }
}