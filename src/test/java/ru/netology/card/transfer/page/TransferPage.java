package ru.netology.card.transfer.page;
import com.codeborne.selenide.SelenideElement;
import ru.netology.card.transfer.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {

    private final SelenideElement header = $(".heading_size_xl").shouldHave(text("Пополнение карты"));
    private final SelenideElement amountField = $("[data-test-id=amount] input");
    private final SelenideElement fromField = $("[data-test-id=from] input");
    private final SelenideElement transferButton = $("[data-test-id=action-transfer]");
    private final SelenideElement errorMsg = $("[data-test-id=error-notification] .notification__content");


    public TransferPage() {
        header.shouldBe(visible);
    }

    public DashboardPage makeValidTransfer(String amountToTransfer, DataHelper.CardInfo cardInfo) {
        makeTransfer(amountToTransfer, cardInfo);
        return new DashboardPage();
    }

    public void makeTransfer(String amountToTransfer, DataHelper.CardInfo cardInfo){
        amountField.setValue(amountToTransfer);
        fromField.setValue(cardInfo.getCardNumber());
        transferButton.click();
    }

    public void showError(String expectedText) {
        errorMsg.shouldHave(text(expectedText), Duration.ofSeconds(15)).shouldBe(visible);
    }




}
