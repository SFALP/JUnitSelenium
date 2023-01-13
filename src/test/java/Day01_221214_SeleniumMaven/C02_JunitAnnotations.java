package Day01_221214_SeleniumMaven;

import org.junit.*;

public class C02_JunitAnnotations {

    /*
    1.Test:
    2.Test:
    3.Test:
    4.Test: (gelistirme asamasinda bu yuzden trapora dahil olmasin)

    Her testimizden once ve sonra calismasi gereken kod bloklarimiz(methodlarimiz) mevcut.
    Tum testlerin oncesi ve sonrasinda calismasi gereken kodlarimiz mevcut

              1. @Test -> Marks a method as a TEST CASE.
              2. @Before : Runs before EACH @Test annotation.
              3. @After : Runs after EACH @Test annotation.
              4. @BeforeClass : Runs before each class only once.
              5. @AfterClass : Runs after each class only once.
              6. @Ignore : Skipping a test case.
     */
    @Test
    public void test01() {
        System.out.println("1.Test yapiliyor...");
    }

    @Test
    public void test02() {
        System.out.println("2.Test yapiliyor...");
    }

    @Test
    public void test03() {
        System.out.println("3.Test yapiliyor...");
    }

    @Ignore
    @Test
    public void test04() {
        System.out.println("4.Test gelistirme asamasinda...");
    }

    @Before
    public void beforeEach() {
        System.out.println("\nMethod oncesi code blogu calisti");
    }

    @After
    public void afterEach() {
        System.out.println("Method sonrasi code blogu calisti\n");
    }

    @BeforeClass
    public static void beforeAll() {
        System.out.println("Tum Methodlarin oncesindeki code blogu calisti");
    }

    @AfterClass
    public static void afterAll() {
        System.out.println(" Tum Methodlarin sonrasindaki code blogu calisti");
    }

}
