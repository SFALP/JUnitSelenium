package Day01_221214_SeleniumMaven;

import org.junit.Assert;
import org.junit.Test;

public class C99_Ornek {
    int a = 50;
    int b = 60;
    int c = 70;
    int d = 50;
    String s1 = "Leyla";
    String s2 = "mecnun";

    @Test
    public void test1(){
        Assert.assertTrue(a>b);//-
    }

    @Test
    public void test2(){
        Assert.assertEquals(a,d);//++
    }


    @Test
    public void test3(){
        Assert.assertEquals(s1,s2);//--
    }

    @Test
    public void test4(){
        Assert.assertSame(s1,s2);//--
    }

    @Test
    public void test5(){
        Assert.assertFalse(d<b);//--
    }
}
