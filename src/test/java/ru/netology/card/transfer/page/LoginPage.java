package ru.netology.card.transfer.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.card.transfer.data.DataHelper;

public class LoginPage {
    private final SelenideElement loginField = $("[data-test-id= XXXX] input");
    private final SelenideElement passwordField = $("[data-test-id= XXXX] input");
    private final SelenideElement loginButton = $("[data-test-id= XXXX] input");


    public VerificationPage validLogin(DataHelper.AuthenInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        return new VerificationPage();
    }
}
