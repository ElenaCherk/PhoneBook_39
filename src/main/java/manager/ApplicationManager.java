package manager;

import lombok.Getter;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager{ // связующее звено (singl tone), тут создаем объект, которые используют все классы
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class); // создали объект, который будет
                                                    // логироввть то что находится в ApplicationManager
 //   WebDriver wd;
    EventFiringWebDriver wd;
    // даем доступ к методам класса HelperUser
    HelperUser helperUser; // создаю поле типа HelperUser
    HelperContact helperContact;
    String browser;
    Properties properties;
    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }
    public void init() throws IOException {
      //  properties.load(new FileReader(new File("src/test/resources/prod.properties")));
     //   String link = "https://telranedu.web.app/home";

         String target = System.getProperty("target", "pre_prod");
         properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

         String link = properties.getProperty("web.baseURL");

     //   wd = new ChromeDriver();
        if(browser.equals(BrowserType.CHROME)) {
            wd = new EventFiringWebDriver(new ChromeDriver());
            logger.info("Test started on Chrome");
        } else if(browser.equals(BrowserType.FIREFOX)){
            wd = new EventFiringWebDriver(new FirefoxDriver());
            logger.info("Test started on Firefox");
        }
        wd.register(new WDListener());

        wd.navigate().to(link);
        logger.info("Navigated to the link --->" +link);
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //---------------------------------------------------------------------------------------------------------
        helperUser = new HelperUser(wd); // через кончтруктор HelperUser создали объект и положили его в helperUser
        // теперь мне доступны методы этого класса в ApplicationManager
        helperContact = new HelperContact(wd);
    }

    public void tearDown(){
        logger.info("Test completed");
        wd.quit();

    }
    public HelperUser getHelperUser() {
        return helperUser;
    }
    public HelperContact getHelperContact() { // геттер который можно заменить геттером из LomBock
        return helperContact;
    }
    public String getEmail(){
        return properties.getProperty("web.email");
    }
    public String getPassword(){
        return properties.getProperty("web.password");
    }
}
