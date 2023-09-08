package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
    public class LoginTests extends TestBase {
                        //  WebDriver wd; // инициализируем веб драйвер
                        /*  @BeforeMethod
                        public void init(){ // метод инициализации проекта
                        wd = new ChromeDriver(); // вебдрайвер инициализируется конструктором Хромдрайвера
                        wd.navigate().to("https://telranedu.web.app/home"); // доступны методы ChromeDriver
                        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); // какое кол-во времени подожди, прежде чем искать следующий элемент
                         }*/
        @Test
        public void loginPositiveTest(){
            // open login form

                         //   wd.findElement(By.xpath("//*[.='LOGIN']")).click();
            app.getHelperUser().openLoginRegistrationForm();
            //  openLoginRegistrationForm(); // замена строчки 16
            // fill login form (находим локаторы на элементы email и password)
                        // WebElement emailInput = wd.findElement(By.xpath("//input[1]")); // нужен input[1]//emailInput.click();// кликаем на этот элемент
                        //  emailInput.clear();                               // очищаем содержимое (если там что то было)
                        //  emailInput.sendKeys("rita@mail.com");             // заполняем корректными данными (email)
                        //  WebElement passInput = wd.findElement(By.xpath("//input[2]"));
                        //  passInput.click();
                        //  passInput.clear();
                        //  passInput.sendKeys("Rr12345$");                   // заполнили пароль
           // fillLoginRegistrationForm("rita@mail.com", "Rr12345$"); // замена 20-26
            app.getHelperUser().fillLoginRegistrationForm("rita@mail.com", "Rr12345$");
                        //  click on button login
                        //  wd.findElement(By.xpath("//button[1]")).click(); // нашли кнопку login (button[1])
             app.getHelperUser().submitLogin();

                         // assert - для того чтобы понять, что тест прйден успешно (появилась страница contacts, кнопка sign out и тд)
             app.getHelperUser().pause(10000);//(для того чтобы страница подгрузилась)
             Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
                         //  Assert.assertTrue(wd.findElements(By.tagName("button")).size()>0); // собираем все элементы button в коллекцию и ее размер должен быть>0
                         // после теста надо вернуть приложение в исходное состояние
        }
        @Test
        public void loginNegativeTestWrongEmail(){
//            // open login form
        app.getHelperUser().openLoginRegistrationForm();
//            wd.findElement(By.xpath("//*[.='LOGIN']")).click();

//            // fill login form (находим локаторы на элементы email и password)
        app.getHelperUser().fillLoginRegistrationForm("ritamail.com", "Rr12345$");
//            WebElement emailInput = wd.findElement(By.xpath("//input[1]")); // нужен input[1]
//            emailInput.click(); // кликаем на этот элемент
//            emailInput.clear(); // очищаем содержимое (если там что то было)
//            emailInput.sendKeys("ritamail.com"); // заполняем данными (email)
//
//            WebElement passInput = wd.findElement(By.xpath("//input[2]"));// нужен input[2]
//            passInput.click();
//            passInput.clear();
//            passInput.sendKeys("Rr12345$"); // заполнили пароль

//            // click on button login
        app.getHelperUser().submitLogin();
//            wd.findElement(By.xpath("//button[1]")).click(); // нашли кнопку login (button[1])
//            // assert
        app.getHelperUser().pause(10000);//(для того чтобы страница подгрузилась)
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
//            pause(3000);
//            Assert.assertTrue(isAlertPresent());
        }
         @Test
         public void loginNegativeTestWrongPasswordHW(){
//            // open login form
        app.getHelperUser().openLoginRegistrationForm();
//            wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//            // fill login form
        app.getHelperUser().fillLoginRegistrationForm("rita@mail.com", "Ss123456");
//            WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//            emailInput.click();
//            emailInput.clear();
//            emailInput.sendKeys("rita@mail.com");

//            WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//            passInput.click();
//            passInput.clear();
//            passInput.sendKeys("Ss123456");

//            // click on button login
        app.getHelperUser().submitLogin();
//            wd.findElement(By.xpath("//button[1]")).click();
//            // assert
        app.getHelperUser().pause(10000);//(для того чтобы страница подгрузилась)
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
//            //pause(3000);
//            Assert.assertTrue(isAlertPresent());
         }
//       /* public void pause(int millis){
//            try {
//                Thread.sleep(millis); // метод бросает эксепшн (try - catch)
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        @AfterMethod
//        public void tearDown(){
//            pause(5000);
//            wd.quit();
//        }
//        public boolean isAlertPresent() {                              // метод позволяет определять есть ли alert на экране (возвращает true или false),
//            Alert alert = new WebDriverWait(wd, 5)     // жди чего то в течение какого-то времени (5 секунд)
//                    .until(ExpectedConditions.alertIsPresent()); // жди этого события - появления alert (возвращает или ссылку на объект
//            // alert, или null в зависимости от того есть ли alert или нет)
//            if (alert == null) return false; // если нет alert
//            wd.switchTo().alert(); // если есть, то переключаемся на поле alertа
//            System.out.println(alert.getText()); // читаем сообщение (но его надо сохранить в переменную и сравнить потом с тектом по документации
//            alert.accept(); // нажимаем на конпочку OK
//            return true;
//        }*/
    }


