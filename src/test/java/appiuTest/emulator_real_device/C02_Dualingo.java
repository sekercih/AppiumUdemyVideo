package appiuTest.emulator_real_device;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class C02_Dualingo {
    @Test
    public void dualingoCreate() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        //todo adb shell getprop ro.build.version.release
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"7.0");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        //todo emulator -list-avds
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel2");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\Mehmet\\Desktop\\com.AppiumStart\\src\\test\\app\\Duolingo.apk");

        AndroidDriver<AndroidElement> driver=new
                AndroidDriver<>(new URL("http:127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        WebElement getstart=driver.findElement(By.id("com.duolingo:id/introFlowNewUserButton"));
        getstart.click();

        WebElement english=driver.findElement(By.xpath("//*[@text=\"English\"]"));
        english.click();

    }
}
