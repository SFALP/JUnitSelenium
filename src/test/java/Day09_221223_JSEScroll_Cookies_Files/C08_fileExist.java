package Day09_221223_JSEScroll_Cookies_Files;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class C08_fileExist {
//NOT:: Bu class, masaustunde olan bir png formatindaki gorsel icin gercekletirilmistir.
// Herhangi bir zamanda calistirilmasi durumunda duzgun calismayabilir.

    @Test
    public void fileExists() {
//Uzerinde calisilan gorselin masaustu uzantisi:
//C:\Users\sevba\OneDrive\Desktop\fileExist.png

//user.home islevi ise;
        System.out.println(System.getProperty("user.home"));//C:\Users\sevba

        String homePath = System.getProperty("user.home");//home yolu hoPath isminde String olarak atandi.

        String filePath = "\\OneDrive\\Desktop\\fileExist.png";//Dosyanin kalan komutunu atadik

        String fullPath = homePath + filePath;//Home ve Dosyanin komutunu birlestirip full path elde ettik.
        System.out.println("fullPath = " + fullPath);//fullPath = C:\Users\sevba\OneDrive\Desktop\fileExist.png

        File image = new File(fullPath);//Bu komut dosyanin bulunmasi saglanir.

        //Bulunan File uzerinden dosyanin olup olmadigi kontrol edilebilmektedir
        Assert.assertTrue(image.exists());//Dosyanin varligi kontrol edildi.
    }
}