package tests.utils;

import lombok.extern.log4j.Log4j2;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.util.concurrent.TimeUnit;

@Log4j2
public class TestListener implements ITestListener {

    public void onTestStart(ITestResult iTestResult) {
        log.info((String.format("================== STARTING TEST %s ==================", iTestResult.getName())));
    }

    public void onTestSuccess(ITestResult iTestResult) {
        log.info(String.format("================== FINISHED TEST %s Duration: %ss ==================", iTestResult.getName(),
                getExecutionTime(iTestResult)));
    }

    public void onTestFailure(ITestResult iTestResult) {
        log.info(String.format("================== FAILED TEST %s Duration: %ss ==================", iTestResult.getName(),
                getExecutionTime(iTestResult)));
        AllureAttachment.addAttachments();
    }

    public void onTestSkipped(ITestResult iTestResult) {
        log.info(String.format("================== SKIPPING TEST %s ==================", iTestResult.getName()));
        AllureAttachment.addAttachments();
    }

    /*@Attachment(value = "Last screen state", type = "image/jpg/png")
    private byte[] takeScreenshot(ITestResult iTestResult) {
        ITestContext context = iTestResult.getTestContext();
        try {
            WebDriver driver = (WebDriver) context.getAttribute("driver");
            if(driver != null) {
                return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            } else {
                return new byte[] {};
            }
        } catch (NoSuchSessionException | IllegalStateException ex) {
            return new byte[] {};
        }
    }*/

    private long getExecutionTime(ITestResult iTestResult) {
        return TimeUnit.MILLISECONDS.toSeconds(iTestResult.getEndMillis() - iTestResult.getStartMillis());
    }
}
