package Day09_221223_JSEScroll_Cookies_Files;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C07_fileExist {
    //FileExist, dosyanin olup olmadigini kontrol eder.
    /*
    System.getProperty("user.dir"); Icinde bulunulan klasörün yolunu (path ) verir.
    System.getProperty ("user.home"); Bilgisayarımızda bulunan user klasörünü verir.
    Files.exists (Paths.get (filePath));

Bilgisayarınızda dosyanın olup olmadığını kontrol eder.
     */
    public static void main(String[] args) {

        String projectRoot=System.getProperty("user.dir");//user.dir = Projenin root'unun--en bastaki isim--(CWJunitSelenium) yolunu bize saglar.

        System.out.println(System.getProperty("user.dir"));//C:\Users\sevba\IdeaProjects\CWJunitSelenium

        String filePath="\\src\\test\\java\\Resources\\fileExist.jpg";

        filePath=projectRoot + filePath;//Almis oldugumuz 2 yolu birlestirip absolute path elde ettik

        Files.exists(Paths.get(filePath));//Bu komut, String olan yolu path komutundan olan formata donusturur
    //..... gibi bir dosya var mı yok mu sorgusu yaptirilir. If else yapisinda kullanilabilir

        System.out.println(Files.exists(Paths.get(filePath)));//true

        if (Files.exists(Paths.get(filePath))){
            System.out.println("Dosya bulundu");//Dosya bulundu
        }else System.out.println("Dosya bulunamadi");
    }
}