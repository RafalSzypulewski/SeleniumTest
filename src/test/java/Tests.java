import base.BaseGui;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.MainPage;


public class Tests extends BaseGui {

    private MainPage mainPage;

    @BeforeClass
    public void setup() {
        System.out.println("SETUP");
    }

    @Test
    public void firstTest() {
        System.out.println("FIRST TEST");
       // mainPage = new MainPage(driver);
    }

    @Test
    public void secondTest() {
        System.out.println("SECOND TEST");
        //mainPage = new MainPage(driver);
    }

}
