package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

    public class RegistrationTests extends TestBase{
//        // тут удалили все вспомогательные методы, которые ушли в testBase
        @Test
        public void registrationPositiveTest(){
//            // open login form
        app.getHelperUser().openLoginRegistrationForm();
//            wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//            // fill login form
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        app.getHelperUser().fillLoginRegistrationForm("poly" + i + "@mail.com", "Pch1562738$");
//            int i = (int)(System.currentTimeMillis()/1000)%3600; // переменная i, которая будет зависеть от
//            // компьютерного времени (кол-во милисекунд, которое прошло с 1 января 1970г, всегда меняется и
//            // переменная i ,будет всегда разная и у нас всегда будет уникальный imail
//            WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//            emailInput.click();
//            emailInput.clear();
//            emailInput.sendKeys("pola" + i + "@mail.com"); // надо чтобы каждый раз был новый пользователь
//            WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//            passInput.click();
//            passInput.clear();
//            passInput.sendKeys("Pch1562738$");
//
//            // click on button registration
        app.getHelperUser().submitReg();
//            wd.findElement(By.xpath("//button[2]")).click();
//            //assert
        app.getHelperUser().pause(10000);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
//            pause(6000);
//            Assert.assertTrue(wd.findElements(By.tagName("button")).size() > 0);
        }
        @Test
        public void registrationNegativeWrongEmailHW(){
//            // open login form
        app.getHelperUser().openLoginRegistrationForm();
//            wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//            // fill login form
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        app.getHelperUser().fillLoginRegistrationForm("poly" + i + "mail.com", "Pch1562738$");
//            int i = (int)(System.currentTimeMillis()/1000)%3600;
//            WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//            emailInput.click();
//            emailInput.clear();
//            emailInput.sendKeys("pola" + i + "mail.com");

//            WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//            passInput.click();
//            passInput.clear();
//            passInput.sendKeys("Pch1562738$");
//
//            // click on button registration
        app.getHelperUser().submitReg();
//            wd.findElement(By.xpath("//button[2]")).click();
//            // assert
        app.getHelperUser().pause(10000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
//            //pause(3000);
//            Assert.assertTrue(isAlertPresent());
        }
    }
