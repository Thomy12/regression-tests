import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;


public class testest extends resources {

    @Test (priority = 0)
    //Test that the site is loaded
    public void test1(){

        Assert.assertTrue(idIsDisplayed("header_logo"));

    }

    @Test (priority = 1)
    //Test that the user can register
    public void test2() throws InterruptedException {

        clickByClass("login");
        Thread.sleep(2000);
        inputById("email_create", email);
        clickById("SubmitCreate");
        Thread.sleep(5000);
        clickById("id_gender1");
        inputById("customer_firstname", fName);
        inputById("customer_lastname", lName);
        inputById("passwd", password);
        selectIndexById("days", day);
        selectIndexById("months", month);
        selectValueById("years", year);
        inputById("address1", address);
        inputById("city", city);
        selectIndexById("id_state", state);
        inputById("postcode", postCode);
        inputById("phone_mobile", phone);
        clickById("submitAccount");
        Assert.assertTrue(classIsDisplayed("logout"));

    }

    @Test (priority = 2)
    //Test that the user can log in
    public void test3() throws InterruptedException{

        clickByClass("login");
        Thread.sleep(2000);
        inputById("email", email);
        inputById("passwd", password);
        clickById("SubmitLogin");
        Thread.sleep(3000);
        Assert.assertTrue(classIsDisplayed("logout"));

    }

    @Test (priority = 3)
    //Test that the user can add a product to the cart
    public void test4() throws InterruptedException{

        clickByClass("login");
        Thread.sleep(2000);
        inputById("email", email);
        inputById("passwd", password);
        clickById("SubmitLogin");
        clickByXpath("//*[@id=\"block_top_menu\"]/ul/li[3]");
        clickByXpath("//*[@id=\"center_column\"]/ul/li[1]//a[@class=\"product_img_link\"]");
        Thread.sleep(8000);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
        clickByClass("exclusive");
        Thread.sleep(10000);
        Assert.assertTrue(getElementTextXpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2").contains("Product successfully added to your shopping cart"));

    }

    @Test (priority = 4)
    //Test that the user can checkout - E2E
    public void test5() throws InterruptedException{

        clickByClass("login");
        Thread.sleep(2000);
        inputById("email", email);
        inputById("passwd", password);
        clickById("SubmitLogin");
        clickByXpath("//*[@id=\"block_top_menu\"]/ul/li[3]");
        Thread.sleep(2000);
        clickByXpath("//*[@id=\"center_column\"]/ul/li[1]//a[@class=\"product_img_link\"]");
        Thread.sleep(2000);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
        clickByClass("exclusive");
        Thread.sleep(5000);
        clickByXpath("//*[@id=\"layer_cart\"]//div[4]/a/span");
        Thread.sleep(2000);
        clickByXpath("//*[@id=\"center_column\"]//p/a/span");
        Thread.sleep(2000);
        clickByXpath("//*[@id=\"center_column\"]/form//button");
        Thread.sleep(2000);
        clickById("cgv");
        clickByXpath("//*[@id=\"form\"]//button/span");
        Thread.sleep(2000);
        clickByClass("bankwire");
        Thread.sleep(2000);
        clickByXpath("//*[@id=\"cart_navigation\"]/button/span");
        Thread.sleep(2000);
        Assert.assertEquals(getElementTextXpath("//*[@class=\"cheque-indent\"]/*[@class=\"dark\"]"), "Your order on My Store is complete.");
    }
}
