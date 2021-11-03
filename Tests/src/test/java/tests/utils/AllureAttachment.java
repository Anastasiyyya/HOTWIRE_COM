package tests.utils;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.selenide.LogType;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.logging.Level;

@Log4j2
public class AllureAttachment {

    public static Optional<byte[]> getScreenshot() {
        try {
            return WebDriverRunner.hasWebDriverStarted() ? Optional.of(((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES)) : Optional.empty();
        } catch (Exception ex) {
            log.error("Could not get page screenshot!\n" + ex.getMessage());
            return Optional.empty();
        }
    }

    public static Optional<byte[]> getBrowserLog() {
        try {
            return WebDriverRunner.hasWebDriverStarted() ? Optional.of(String.join("\n", Selenide.getWebDriverLogs(LogType.BROWSER.toString(), Level.ALL)).getBytes(StandardCharsets.UTF_8)) : Optional.empty();
        } catch (Exception ex) {
            log.error("Could not get browser console log!\n" + ex.getMessage());
            return Optional.empty();
        }
    }

    public static void addAttachments() {
        AllureLifecycle allure = Allure.getLifecycle();
        getScreenshot().ifPresent((bytes) -> allure.addAttachment("screenshot", "image/png", "png", bytes));
        getBrowserLog().ifPresent((bytes) -> allure.addAttachment("log", "application/json", "txt", bytes));
    }
}
