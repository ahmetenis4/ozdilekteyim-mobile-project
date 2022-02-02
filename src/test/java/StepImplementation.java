import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class StepImplementation extends BaseTest {


    AndroidTouchAction action = new AndroidTouchAction(appiumDriver);

    @Step("<time> saniye bekle")
    public void waitTime(int time) throws InterruptedException {
        Thread.sleep(1000L*time);

        Log4j.log.info(time + "Saniye Kadar Bekletildi");
    }

    @Step("<Key> İd'li elemente tıkla")
    public void clickElementByid(String Key){
        appiumDriver.findElement(By.id(Key)).click();
        System.out.println(Key+" Elementine tiklandi");
        Log4j.log.info(Key+"Elementine tiklandi");

    }
    @Step("id <id> li elementi bul ve <text> değerini yaz")
    public void sendKeysId(String id,String text){
        appiumDriver.findElement(By.id(id)).sendKeys(text);
        Log4j.log.info( text+"değeri yazıldı");




    }
        @Step("xpath <xpath> li elementi bul ve <text> alanını kontrol et")
        public void textAreaControlByXpath(String xpath, String text){
            Assert.assertTrue("Element text değerini içermiyor"
                    , appiumDriver.findElement(By.xpath(xpath)).getText().contains(text));

    }


    @Step("<Key> xpath'li elemente tıkla")
    public void clickElementByxpath(String Key){
        appiumDriver.findElement(By.xpath(Key)).click();
        System.out.println(Key+" Elementine tiklandi");
        Log4j.log.info(Key + "Elemente tıklandı");
    }




    @Step("id <id> li elementi bul ve <text> alanını kontrol et")
    public void textAreaControlById(String id, String text) {
        Assert.assertTrue("Element text değerini içermiyor"
                , appiumDriver.findElement(By.id(id)).getText().contains(text));

    }

    @Step("Sayfayı scroll et")
    public void scrollButton() {

        final int ANIMATION_TIME = 500;
        final int PRESS_TIME = 200;
        PointOption pointOptionStart, pointOptionEnd;
        Dimension dims = appiumDriver.manage().window().getSize();
        pointOptionStart = PointOption.point(dims.width / 2, (int) (dims.height * 0.8));
        pointOptionEnd = PointOption.point(dims.width / 2, (int) (dims.height * 0.1));
        for (int i = 1; i <3 ; i++) {
            new TouchAction(appiumDriver)
                    .press(pointOptionStart)
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
            Log4j.log.info( "Scroll edildi");
        }
    }
                @Step("Element <xpath> ile random bir ürün seç ve tıkla")
                 public void clickRandom(String xpath) {
                 Random random = new Random();
                  List<MobileElement> products = appiumDriver.findElements(By.xpath(xpath));
                    int index = random.nextInt(products.size());
                     products.get(index).click();
                    Log4j.log.info( "Random ürüne tıklandı");


            }

    }