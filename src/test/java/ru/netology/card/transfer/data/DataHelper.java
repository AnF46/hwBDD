package ru.netology.card.transfer.data;
import lombok.Value;

import java.util.Random;

public class DataHelper {
    private DataHelper() {
    }

   /* public static String VerificationCode() {
        return "12345";
    }*/

    public static AuthenInfo getAuthenInfo() {
        return new AuthenInfo("vasya", "qwerty123");
    }

    public static CardInfo getFirstCardInfo() {
        return new CardInfo ( "5559 0000 0000 0001", "test-id");
    }

    public static CardInfo getSecondCardInfo() {
        return new CardInfo ( "5559 0000 0000 0002", "test-id");
    }

    public static String getMaskedNumber (String cardNumber) {
        return "***** " + cardNumber.substring(15);
    }

    public static int generateRightAmount(int balance) {
        return new Random().nextInt(Math.abs(balance)) + 1;
    }

    public static int generateWrongAmount(int balance) {
        return new Random().nextInt(5000) + Math.abs(balance) + 1;
    }

    public static VerificationCode getVerificationCodeFor(AuthenInfo authInfo) {
        return new VerificationCode("12345");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }


    @Value
    public static class CardInfo {
        String cardNumber;
        String testId;
    }

    @Value
    public static class AuthenInfo {
        String login;
        String password;
    }

}
