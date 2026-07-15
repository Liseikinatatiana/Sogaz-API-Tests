package utils;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "loginData")
    public static Object[][] loginData() {
        return new Object[][]{
                {"user@mail.com", "Qwerty123!", "success", "Добро пожаловать"},
                {"user@mail.com", "WrongPass", "fail", "Неверный пароль"},
                {"", "Qwerty123!", "fail", "Введите email"},
                {"user@mail.com", "", "fail", "Введите пароль"}
        };
    }

    @DataProvider(name = "validLoginData")
    public static Object[][] validLoginData() {
        return new Object[][]{
                {"user@mail.com", "Qwerty123!"},
                {"user2@mail.com", "Pass123!"}
        };
    }
}
