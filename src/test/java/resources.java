import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class resources {

    WebDriver driver;
    String email = "loxike1781@awinceo.com", password = "passtest123";
    String fName = "test", lName = "testington", address = "test street 12", city = "test city", postCode = "55555", phone = "0755555555", year = "1990";
    int day = 2, month = 6, state = 9;

    @BeforeSuite
    public void setup0(){
        System.setProperty("webdriver.chrome.driver", "D:\\work stuff\\Chromedriver\\chromedriver.exe");
    }

    @BeforeMethod
    public void setup1(){
        this.driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }

    @AfterMethod
    //Close
    public void setdown(){
        driver.close();
    }

    public void findById(String id){
        driver.findElement(By.id(id));
    }

    public void findByClass(String className){
        driver.findElement(By.className(className));
    }

    public void findByXpath(String xpath){
        driver.findElement(By.xpath(xpath));
    }

    public void clickById(String identifier){
        driver.findElement(By.id(identifier)).click();
    }

    public void clickByClass(String identifier){
        driver.findElement(By.className(identifier)).click();
    }

    public void clickByXpath(String identifier){
        driver.findElement(By.xpath(identifier)).click();
    }

    public void inputById(String identifier, String input){
        driver.findElement(By.id(identifier)).sendKeys(input);
    }

    public void inputByClass(String identifier, String input){
        driver.findElement(By.className(identifier)).sendKeys(input);
    }

    public void inputByXpath(String identifier, String input){
        driver.findElement(By.xpath(identifier)).sendKeys(input);
    }

    public boolean idIsDisplayed(String identifier){
        return driver.findElement(By.id(identifier)).isDisplayed();
    }

    public boolean classIsDisplayed(String identifier){
        return driver.findElement(By.className(identifier)).isDisplayed();
    }

    public boolean xpathIsDisplayed(String identifier){
        return driver.findElement(By.xpath(identifier)).isDisplayed();
    }

    public void selectIndexById(String identifier, int index){
        WebElement x = driver.findElement(By.id(identifier));
        Select select = new Select(x);
        select.selectByIndex(index);

    }

    public void selectValueById(String identifier, String value){
        WebElement y = driver.findElement(By.id(identifier));
        Select select = new Select(y);
        select.selectByValue(value);
    }

    public String getElementTextXpath(String identifier){
        return driver.findElement(By.xpath(identifier)).getText();

    }

    public String getElementTextClass(String identifier){
        return driver.findElement(By.className(identifier)).getText();

    }

}
