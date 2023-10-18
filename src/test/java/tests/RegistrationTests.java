package tests;

import manager.ProviderData;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


    public class RegistrationTests extends TestBase{
            @BeforeMethod(alwaysRun = true)
            public void precondition(){
                    app.getHelperUser().refresh();
                    if(app.getHelperUser().isLogged()) app.getHelperUser().logout();
            }
//        // тут удалили все вспомогательные методы, которые ушли в testBase
        @Test(groups = {"positive"})
        public void registrationPositiveTest(){
                int i = (int)(System.currentTimeMillis()/1000)%3600;
                User user = new User(
                        "polya" + i + "@mail.com",
                        "Pch1562735$");
//            // open login/registration form
        app.getHelperUser().openLoginRegistrationForm();
//            wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//            // fill login/registration form

       // app.getHelperUser().fillLoginRegistrationForm("poly" + i + "@mail.com", "Pch1562738$");
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
        app.getHelperUser().fillRegistrationForm1(user);
//            // click on button registration
        app.getHelperUser().submitReg();
        logger.info("Registration Positive Test starts with: " + user.getEmail() + " & " + user.getPassword());
//            wd.findElement(By.xpath("//button[2]")).click();
//            //assert
        app.getHelperUser().pause(10000);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
//            pause(6000);
//            Assert.assertTrue(wd.findElements(By.tagName("button")).size() > 0);
        }
        @Test(groups = {"negative"})
        public void registrationNegativeWrongEmailHW(){
                int i = (int)(System.currentTimeMillis()/1000)%3600;
                User user = new User(
                        "polya" + i + "mail.com",
                        "Pch1562735$");
//            // open login form
        app.getHelperUser().openLoginRegistrationForm();
//            wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//            // fill login form
//        int i = (int)(System.currentTimeMillis()/1000)%3600;
//        app.getHelperUser().fillLoginRegistrationForm("poly" + i + "mail.com", "Pch1562738$");
//            int i = (int)(System.currentTimeMillis()/1000)%3600;
//            WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//            emailInput.click();
//            emailInput.clear();
//            emailInput.sendKeys("pola" + i + "mail.com");

//            WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//            passInput.click();
//            passInput.clear();
//            passInput.sendKeys("Pch1562738$");
        app.getHelperUser().fillRegistrationForm1(user);
//            // click on button registration
        app.getHelperUser().submitReg();
//            wd.findElement(By.xpath("//button[2]")).click();
//            // assert
        app.getHelperUser().pause(10000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
//            //pause(3000);
//            Assert.assertTrue(isAlertPresent());
        }

        @Test(groups = {"positive"}, dataProvider = "registrationCSV", dataProviderClass = ProviderData.class)
        public void registrationPositiveTestCSV(User user){
            int i = (int)(System.currentTimeMillis()/1000)%3600;
            String email = user.getEmail();
            String password = user.getPassword();
            app.getHelperUser().openLoginRegistrationForm();
                 //   app.getHelperUser().fillRegistrationForm1(user);
            app.getHelperUser().fillRegistrationForm(email, password);
            app.getHelperUser().submitReg();
                 //   logger.info("Registration Positive Test starts with: " + user.getEmail() + " & " + user.getPassword());
            logger.info("Registration Positive Test starts with: " + email + " & " + password);
            app.getHelperUser().pause(1000);
            Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
        }
    }
