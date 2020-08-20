package util;


import com.testinium.BaseTest;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AllMethods extends BaseTest {
    public void getTextControl(MobileElement element, String key) {
        Assert.assertEquals("Text içeriği bulunmamaktadır.", getTextElement(element), key);
        System.out.println("Elementte ki değer ile Gelen değer uyuşmaktadır.");
    }

    public String getTextElement(MobileElement element) {
        String elemaninTexti = "";
        elemaninTexti = element.getText();
        System.out.println("Elemanın Text değeri: " + elemaninTexti);
        return elemaninTexti;
    }

    public MobileElement findElement(String key) {
        try {
            MobileElement element = (MobileElement) (new WebDriverWait(driver, 5, 300))
                    .until(ExpectedConditions.elementToBeClickable(By.cssSelector(key)));
            return element;

        } catch (Exception ex) {
            Assert.fail("" + key + "'li element 10 saniye boyunca arandı fakat bulunamadı..!!!");
            return null;
        }
    }

    public void clickToElement(WebElement element) {
        element.click();
    }

}
