import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
    public class LoginTests {

        WebDriver wd; // инициализируем веб драйвер

        @BeforeMethod
        public void init(){ // метод инициализации проекта
            wd = new ChromeDriver(); // вебдрайвер инициализируется конструктором Хромдрайвера
            wd.navigate().to("https://telranedu.web.app/home"); // доступны методы ChromeDriver
            wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); // какое кол-во времени подожди, прежде чем искать следующий элемент
        }


        @Test
        public void loginPositiveTest(){

            // open login form
            wd.findElement(By.xpath("//*[.='LOGIN']")).click();
            // fill login form (находим локаторы на элементы email и password)
            WebElement emailInput = wd.findElement(By.xpath("//input[1]")); // нужен input[1]
            emailInput.click();// кликаем на этот элемент
            emailInput.clear(); // очищаем содержимое (если там что то было)
            emailInput.sendKeys("rita@mail.com"); // заполняем корректными данными (email)

            WebElement passInput = wd.findElement(By.xpath("//input[2]"));
            passInput.click();
            passInput.clear();
            passInput.sendKeys("Rr12345$"); // заполнили пароль

            // click on button login
            wd.findElement(By.xpath("//button[1]")).click(); // нашли кнопку login (button[1])
            // assert - для того чтобы понять, что тест прйден успешно (появилась страница contacts, кнопка sign out и тд)
            pause(10000);//(для того чтобы страница подгрузилась)
            Assert.assertTrue(wd.findElements(By.tagName("button")).size()>0); // собираем все элементы button в коллекцию и ее размер должен быть>0
            // после теста надо вернуть приложение в исходное состояние
        }

        @Test
        public void loginNegativeTestWrongEmail(){
            // open login form
            wd.findElement(By.xpath("//*[.='LOGIN']")).click();
            // fill login form (находим локаторы на элементы email и password)
            WebElement emailInput = wd.findElement(By.xpath("//input[1]")); // нужен input[1]
            emailInput.click(); // кликаем на этот элемент
            emailInput.clear(); // очищаем содержимое (если там что то было)
            emailInput.sendKeys("ritamail.com"); // заполняем данными (email)

            WebElement passInput = wd.findElement(By.xpath("//input[2]"));// нужен input[2]
            passInput.click();
            passInput.clear();
            passInput.sendKeys("Rr12345$"); // заполнили пароль
            // click on button login
            wd.findElement(By.xpath("//button[1]")).click(); // нашли кнопку login (button[1])
            // assert
            pause(3000);
        }
        @Test
        public void loginNegativeTestWrongPasswordHW(){
            // open login form
            wd.findElement(By.xpath("//*[.='LOGIN']")).click();
            // fill login form
            WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
            emailInput.click();
            emailInput.clear();
            emailInput.sendKeys("rita@mail.com");

            WebElement passInput = wd.findElement(By.xpath("//input[2]"));
            passInput.click();
            passInput.clear();
            passInput.sendKeys("Ss123456");
            // click on button login
            wd.findElement(By.xpath("//button[1]")).click();
            // assert
            //pause(3000);
        }
        public void pause(int millis){
            try {
                Thread.sleep(millis); // метод бросает эксепшн (try - catch)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        @AfterMethod
        public void tearDown(){
            pause(5000);
            wd.quit();
        }
    }


