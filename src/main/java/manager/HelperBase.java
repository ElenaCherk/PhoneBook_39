package manager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase { // все вспомогтаельные методы
    WebDriver wd; // объявляем поле, потому что без него не будут работат методы этого класса
    // нужно получить доступ к объектам хромдрайвера

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void click(By locator){

        wd.findElement(locator).click();
    }
    public void type(By locator, String text){                 // метод передает нужный текст нужному элементу
        WebElement element = wd.findElement(locator);          // нужен input[1]
        element.click();                                       // кликаем на этот элемент
        element.clear();                                       // очищаем содержимое (если там что то было)
        element.sendKeys(text);                                // писваиваем нужный текст
    }

    public boolean isElementPresent(By locator){    //будем сюда передавать стратегию
        return wd.findElements(locator).size()>0;
    }

    public boolean isAlertPresent() {                              // метод позволяет определять есть ли alert на экране (возвращает true или false),
        Alert alert = new WebDriverWait(wd, 5)     // жди чего то в течение какого-то времени (5 секунд)
                .until(ExpectedConditions.alertIsPresent());       // жди этого события - появления alert (возвращает или ссылку на объект
        // alert, или null в зависимости от того есть ли alert или нет)
        if (alert == null) return false;                           // если нет alert
        wd.switchTo().alert();                                     // если есть, то переключаемся на поле alertа
        System.out.println(alert.getText());                       // читаем сообщение (но его надо сохранить в переменную и сравнить потом с тектом по документации
        alert.accept();                                            // нажимаем на конпочку OK
        return true;
    }

    public void pause(int millis){ // вспомогательный метод
        try {
            Thread.sleep(millis); // метод бросает эксепшн (try - catch)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
