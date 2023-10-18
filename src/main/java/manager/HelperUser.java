package manager;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{ // все что связано с тестирование регистарции и логина (с позиции юзер)

    public HelperUser(WebDriver wd){
        super(wd); // вызывем конструктор супер класса (HelperBase), для создания объекта helperuser я вызываю родительский конструктор
    }
    public void openLoginRegistrationForm(){
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
    }
    public void login(User user){
        openLoginRegistrationForm();
        fillRegistrationForm1(user);
        submitLogin();
    }

    public void login(String email, String password){
        openLoginRegistrationForm();
        fillRegistrationForm(email,password);
        submitLogin();
    }

    public void fillLoginRegistrationForm(String email, String password){
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password); // сломали специально
    }
    public void fillRegistrationForm1(User user) {
        type(By.xpath("//input[@placeholder='Email']"), user.getEmail());
        type(By.xpath("//input[@placeholder='Password']"), user.getPassword());
    }
    public void fillRegistrationForm(String email, String password) {
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);
    }
    public void submitLogin(){
        wd.findElement(By.xpath("//button[1]")).click();
    }
    public void submitReg(){
        wd.findElement(By.xpath("//button[2]")).click();
    }
    public void logout(){
        click(By.xpath("//button[.='Sign Out']")); // элемент у которого функция(.) TEXT возвращает значение Sign Out
    }
    public boolean isLogged(){
        return isElementPresent(By.xpath("//button[.='Sign Out']")); //проверка залогинились ли
    }
}

