package manager;

import models.Contact;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
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
        int i = (int)(System.currentTimeMillis()/1000%3600);
        list.add(new Object[]{
                Contact.builder()
                    .name("John"+i)
                    .lastName("White")
                    .phone("12357689" + i)
                    .email("jw" + i + "@mail.com")
                    .address("Haifa")
                    .description("friend")
                    .build()
        });
        list.add(new Object[]{
                Contact.builder()
                        .name("Lina"+i)
                        .lastName("Black")
                        .phone("12338289" + i)
                        .email("lb" + i + "@mail.com")
                        .address("Tel Aviv")
                        .description("sister")
                        .build()
        });
        list.add(new Object[]{
                Contact.builder()
                        .name("Sara"+i)
                        .lastName("Parker")
                        .phone("94757689" + i)
                        .email("sp" + i + "@mail.com")
                        .address("Ashdod")
                        .description("friend")
                        .build()
        });
        return list.iterator(); //метод возвращает объект итератора
    }
    @DataProvider
    public Iterator<Object[]> registrationCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(
                new FileReader(new File("src/test/resources/reg_dataset1.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{
                    User.builder()
                            .email(split[0])
                            .password(split[1])
                            .build()
            });
            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
       }
    }
