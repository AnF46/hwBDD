package ru.netology.card.transfer.data;

import lombok.Value;

import java.util.Random;

public class DataHelper {
    private DataHelper() {
    }

    public static AuthenInfo getAuthenInfo() {
        return new AuthenInfo("vasya", "qwerty123");
    }

    public static CardInfo getFirstCardInfo() {
        return new CardInfo("5559 0000 0000 0001", "92df3f1c-a033-48e6-8390-206f6b1f56c0");
    }

    public static CardInfo getSecondCardInfo() {
        return new CardInfo("5559 0000 0000 0002", "0f3f5c2a-249e-4c3d-8287-09f7a039391d");
    }

    public static String getMaskedNumber(String cardNumber) {
        return "**** **** **** " + cardNumber.substring(15);
    }

    public static int generateRightAmount(int balance) {
        return new Random().nextInt(Math.abs(balance)) + 1;
    }

    public static int generateWrongAmount(int balance) {

        return Math.abs(balance) + new Random().nextInt(5000)  + 1;
    }


        public static String getVerificationCode() {
            return "12345";
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
