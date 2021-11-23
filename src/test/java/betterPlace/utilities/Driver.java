package betterPlace.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class Driver {
    private Driver() {
    }
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();
    public static WebDriver get(){
        if (driverPool.get() == null) {
            String browser = System.getProperty("browser") != null ? browser = System.getProperty("browser") : ConfigurationReader.get("browser");
            //Burasi webDriver de automation yaparken telefon modunda calistiriyor.
//            Map<String, Object> deviceMetrics = new HashMap<>();
//            deviceMetrics.put("width", 400);
////            deviceMetrics.put("height", 750);
//            deviceMetrics.put("pixelRatio", 3.0);
//            Map<String, Object> mobileEmulation = new HashMap<>();
//            mobileEmulation.put("deviceMetrics", deviceMetrics);
//            mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 8.0.0;" +
//                    "Pixel 2 XL Build/OPD1.170816.004) AppleWebKit/537.36 (KHTML, like Gecko) " + "Chrome/67.0.3396.99 Mobile Safari/537.36");

            switch (browser) {
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--disable-web-security");
//                    options.setExperimentalOption("mobileEmulation", mobileEmulation);
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver(options));
                    break;
            }
        }

        return driverPool.get();
    }
    public static void closeDriver() {
        driverPool.get().quit();
        driverPool.remove();
    }
}
