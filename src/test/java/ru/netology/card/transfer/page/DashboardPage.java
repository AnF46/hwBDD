package ru.netology.card.transfer.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import ru.netology.card.transfer.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
        // к сожалению, разработчики не дали нам удобного селектора, поэтому так
        private ElementsCollection cards = $$(".list__item div");
        private final String balanceStart = "баланс: ";
        private final String balanceFinish = " р.";
        private final SelenideElement header = $("[data-test-id=dashboard]");
        private final SelenideElement reloadButton = $("[data-test-id=action-reload]");

        public DashboardPage() {
            header.shouldBe(visible);
        }

        public int getCardBalance(String maskedCardNumber) {
            var text = cards.findBy(Condition.text(maskedCardNumber)).getText();
            return extractBalance(text);
        }

        public TransferPage selectCardToTransfer(DataHelper.CardInfo cardInfo) {
            cards.findBy(Condition.attribute("data-test-id", cardInfo.getTestId())).$("[data-test-id=action-deposit]").click();
            return new TransferPage();
        }

        public void reloadDashboardPage() {
            reloadButton.click();
            header.shouldBe(visible);
        }
        public int getFirstCardBalance() {
            val text = cards.first().text();
            return extractBalance(text);
        }

        private int extractBalance(String text) {
            val start = text.indexOf(balanceStart);
            val finish = text.indexOf(balanceFinish);
            val value = text.substring(start + balanceStart.length(), finish);
            return Integer.parseInt(value);
        }

}
