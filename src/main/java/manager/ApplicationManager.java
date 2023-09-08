package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class ApplicationManager{ // связующее звено (singl tone), тут создаем объект, которые используют все классы
    WebDriver wd;
    HelperUser helperUser; // создаю поле типа HelperUser

    public void init(){
        wd = new ChromeDriver();
        wd.navigate().to("https://telranedu.web.app/home");
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //---------------------------------------------------------------------------------------------------------
        helperUser = new HelperUser(wd); // через кончтруктор HelperUser создали объект и положили его в helperUser
        // теперь мне доступны методы этого класса в ApplicationManager
    }

    public void tearDown(){
        wd.quit();
    }

    public HelperUser getHelperUser() { // даем доступ
        return helperUser;
    }
}
