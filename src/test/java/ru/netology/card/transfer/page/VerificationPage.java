package ru.netology.card.transfer.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.card.transfer.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

    public class VerificationPage {
        private SelenideElement codeField = $("[data-test-id=code] input");
        private SelenideElement verifyButton = $("[data-test-id=action-verify]");

        public VerificationPage() {
            codeField.shouldBe(visible);
        }

        public DashboardPage validVerify() {
            codeField.setValue(DataHelper.getVerificationCode());
            verifyButton.click();
            return new DashboardPage();
        }
    }
