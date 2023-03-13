package utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.BasePage;

public class Environment {

    private static ThreadLocal<AndroidDriver<MobileElement>> androidDriver = new ThreadLocal<>();
    public static Properties prop = new Properties();

    public static void initialization() {

        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability("deviceName", prop.getProperty("deviceName"));
            capabilities.setCapability("platformName", prop.getProperty("platformName"));
            capabilities.setCapability("platformVersion", prop.getProperty("platformVersion"));
            capabilities.setCapability("appPackage", prop.getProperty("appPackage"));
            capabilities.setCapability("appActivity", prop.getProperty("appActivity"));
            capabilities.setCapability("automationName", prop.getProperty("automationName"));
            capabilities.setCapability("app", System.getProperty("user.dir")
            + prop.getProperty("applicationpath." + Environment.prop.getProperty("environment")));

            androidDriver.set(new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723"), capabilities));

            if (getDriver().findElement(By.id("com.android.permissioncontroller:id/continue_button")).isDisplayed()) {

                BasePage.explicitWait(getDriver(), getDriver().findElement(By.id("com.android.permissioncontroller:id/continue_button")));
                getDriver().findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();

                BasePage.explicitWait(getDriver());
                getDriver().switchTo().alert().accept();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static AndroidDriver<MobileElement> getDriver() {
        return androidDriver.get();
    }

    static {
        loadEnvironmentProperties();
    }

    private static void loadEnvironmentProperties() {
        setEnvironment();
        prop.putAll(getProperties("config/common.properties"));
        prop.putAll(getProperties("config/" + prop.getProperty("environment") + ".properties"));
        overrideSystemProperties();
    }

    public static String getEnv() {
        return prop.getProperty("environment");
    }

    private static void setEnvironment() {
        String env = System.getProperty("environment") != null ? System.getProperty (
            "environment") : getEnv() != null ? getEnv() : "qa";
        prop.put("environment", env);
    }

    private static void overrideSystemProperties() {
        Set<Object> sysPropKeys = System.getProperties().keySet();
        Set<Object> localPropKeys = prop.keySet();
        for (Object localKey : localPropKeys) {
            sysPropKeys.forEach((sysKey) -> {
                if (localKey.equals(sysKey)) {
                    prop.put(localKey, System.getProperty(sysKey.toString()));
                }
            });
        }
    }

    /*
     * helper method to read properties from a file.
     * Params: filename - name of the file to be read.
     * Returns: properties.
     */
    public static Properties getProperties(String filename) {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Properties p = new Properties();
        try (InputStream resourceStream = loader.getResourceAsStream(filename)) {
            p.load(resourceStream);
        } catch (Exception e) {
            System.out.println("Unable to open [" + filename + "]");
        }
        return p;
    }
}
