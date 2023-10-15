package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder // конструктор (строитель объектов)

public class User {
        String email;
        String password;

        public void setEmail(String email) {
            this.email = email;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public models.User withEmail(String email) {
            this.email = email;
            return this;
        }

        public models.User withPassword(String password) {
            this.password = password;
            return this;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public User(String email, String password) {

            this.email = email;
            this.password = password;
        }
        public User(){} // создаем дефолтный констурктор
    }

