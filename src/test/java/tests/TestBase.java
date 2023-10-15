package tests;
import manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase{

    //  WebDriver wd; - ушел в ApplicationManager (для всего проекта объявляет переменную
    static ApplicationManager app = new ApplicationManager(      //(static - java-машина инициализирует его в первую очередь)
            System.getProperty("browser", BrowserType.CHROME));

    Logger logger = LoggerFactory.getLogger(TestBase.class);
    @BeforeMethod(alwaysRun = true)
    public void startTest(Method method){
        logger.info("Started test ---->" + method.getName());
    }
    @AfterMethod(alwaysRun = true)
    public void stopTest(Method method){
        logger.info("Finished test ---->" + method.getName());
        logger.info("=====================================================================");
    }
    @BeforeSuite(alwaysRun = true)
    //  public void init(){ //тоже ушел в ApplicationManager (чтобы к нему обратитьс надо создать объект класса ApplicationManager)
    //     wd = new ChromeDriver();
    //     wd.navigate().to("https://telranedu.web.app/home");
    //     wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);}

    public void setup() {
        app.init(); // через имя объекта обращаемся к ApplicationManager
    }

    @AfterSuite(alwaysRun = true)
 //   public void tearDown(){
 //   pause(5000);
 //   wd.quit();

    public void stop() {
        app.tearDown();
    }
}
//    public void pause(int millis){ // вспомогательный метод
//        try {
//            Thread.sleep(millis); // метод бросает эксепшн (try - catch)
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
       // вспомогательный метод
//    public boolean isAlertPresent() {                              // метод позволяет определять есть ли alert на экране (возвращает true или false),
//        Alert alert = new WebDriverWait(wd, 5)     // жди чего то в течение какого-то времени (5 секунд)
//                .until(ExpectedConditions.alertIsPresent());       // жди этого события - появления alert (возвращает или ссылку на объект
//                                                                   // alert, или null в зависимости от того есть ли alert или нет)
//        if (alert == null) return false;                           // если нет alert
//        wd.switchTo().alert();                                     // если есть, то переключаемся на поле alertа
//        System.out.println(alert.getText());                       // читаем сообщение (но его надо сохранить в переменную и сравнить потом с тектом по документации
//        alert.accept();                                            // нажимаем на конпочку OK
//        return true;
//    }
//    public void openLoginRegistrationForm(){
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//    }

//    public void fillLoginRegistrationForm(String email, String password){
//
//        type(By.xpath("//input[1]"), email);
//                //   WebElement emailInput = wd.findElement(By.xpath("//input[1]")); - нужен input[1]
//                //   emailInput.click(); - кликаем на этот элемент
//                //   emailInput.clear(); - очищаем содержимое (если там что то было)
//                //   emailInput.sendKeys(email); - заполняем корректными данными (email)
//
//        type(By.xpath("//input[2]"), password);
//                //   WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//                //   passInput.click();
//                //   passInput.clear();
//                //   passInput.sendKeys(password);- заполнили пароль
//    }

//    public void submitLogin(){
////        wd.findElement(By.xpath("//button[1]")).click();}
    // вспомогательный метод - нужны во всех тестах, поэтому в хелпербейз
//    public boolean isElementPresent(By locator){    //будем сюда передавать стратегию
//       return wd.findElements(locator).size()>0;
//    }
//    public void logout(){
//        click(By.xpath("//*[.=Sign Out]")); // элемент у которого функция(.) TEXT возвращает значение Sign Out
//    }
//    public void click(By locator){
//        wd.findElement(locator).click();
//    }
//    public void type(By locator, String text){                 // метод передает нужный текст нужному элементу
//        WebElement element = wd.findElement(locator);          // нужен input[1]
//        element.click();                                       // кликаем на этот элемент
//        element.clear();                                       // очищаем содержимое (если там что то было)
//        element.sendKeys(text);                                // писваиваем нужный текст
//    }

//    public boolean isLogged(){
//        return isElementPresent(By.xpath("//*[.=Sign Out]")); //проверка залогинились ли
//    }
//}


