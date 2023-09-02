import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

    public class RegistrationTests {

        WebDriver wd;

        @BeforeMethod
        public void init(){
            wd = new ChromeDriver();
            wd.navigate().to("https://telranedu.web.app/home");
            wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        }
        @Test
        public void registrationPositiveTest(){
            // open login form
            wd.findElement(By.xpath("//*[.='LOGIN']")).click();
            // fill login form
            int i = (int)(System.currentTimeMillis()/1000)%3600; // переменная i, которая будет зависеть от
            // компьютерного времени (кол-во милисекунд, которое прошло с 1 января 1970г, всегда меняется и
            // переменная i ,будет всегда разная и у нас всегда будет уникальный imail

            WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
            emailInput.click();
            emailInput.clear();
            emailInput.sendKeys("pola" + i + "@mail.com"); // надо чтобы каждый раз был новый пользователь

            WebElement passInput = wd.findElement(By.xpath("//input[2]"));
            passInput.click();
            passInput.clear();
            passInput.sendKeys("Pch1562738$");

            // click on button registration
            wd.findElement(By.xpath("//button[2]")).click();
            //assert
            pause(6000);
            Assert.assertTrue(wd.findElements(By.tagName("button")).size() > 0);
        }
        @Test
        public void registrationNegativeTestHW(){
            // open login form
            wd.findElement(By.xpath("//*[.='LOGIN']")).click();
            // fill login form
            int i = (int)(System.currentTimeMillis()/1000)%3600;

            WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
            emailInput.click();
            emailInput.clear();
            emailInput.sendKeys("pola" + i + "mail.com");

            WebElement passInput = wd.findElement(By.xpath("//input[2]"));
            passInput.click();
            passInput.clear();
            passInput.sendKeys("Pch1562738$");

            // click on button registration
            wd.findElement(By.xpath("//button[2]")).click();
            // assert
            //pause(3000);
        }

        @AfterMethod
        public void tearDown(){
            pause(3000);
            wd.quit();
        }

        public void pause(int millis){
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
