package manager;

import models.Contact;
import models.User;
import org.testng.annotations.DataProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProviderData {
    @DataProvider
    public Iterator<Object[]> userDTO(){    //Data Transfer Object
        List<Object[]> list = new ArrayList<>();//список, состоящий из массива объектов
        list.add(new Object[]{
                User.builder()
                        .email("rita@mail.com")
                        .password("Rr12345$")
                        .build()
        });
        list.add(new Object[]{
                User.builder()
                        .email("linkas@mail.com")
                        .password("Opd136476$")
                        .build()
        });
        list.add(new Object[]{
                User.builder()
                        .email("april@mail.com")
                        .password("Oj76543$")
                        .build()
        });
        list.add(new Object[]{
                User.builder()
                        .email("dan@mail.com")
                        .password("Ft12376$")
                        .build()
        });
        return list.iterator(); //метод возвращает объект итератора
    }
    @DataProvider
    public Iterator<Object[]> AddContactDTO(){
        List<Object[]> list = new ArrayList<>();//список, состоящий из массива объектов
        list.add(new Object[]{
                Contact.builder()
                    .name("John")
                    .lastName("White")
                    .phone("12357689298")
                    .email("jb123_@mail.com")
                    .address("Haifa")
                    .description("friend")
                    .build()
        });
        list.add(new Object[]{
                Contact.builder()
                        .name("Sara")
                        .lastName("White")
                        .phone("12364792298")
                        .email("Sw948_@mail.com")
                        .address("Ashdod")
                        .description("friend")
                        .build()
        });
        list.add(new Object[]{
                Contact.builder()
                        .name("Lisa")
                        .lastName("Miller")
                        .phone("38472920484")
                        .email("lm1364_@mail.com")
                        .address("Tel Aviv")
                        .description("sister")
                        .build()
        });
        list.add(new Object[]{
                Contact.builder()
                        .name("Alex")
                        .lastName("Fisher")
                        .phone("28374653097")
                        .email("af123_@mail.com")
                        .address("Gedera")
                        .description("Doctor")
                        .build()
        });
        return list.iterator(); //метод возвращает объект итератора
    }
}
