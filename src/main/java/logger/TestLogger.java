package logger;

import io.qameta.allure.Step;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestLogger {
    public static final Logger LOGGER = LoggerFactory.getLogger(TestLogger.class);

    @Step("{0}")
    public static void logAction(String stepMessage, Object ... parameters){
        String message = String.format(stepMessage, parameters);
        LOGGER.info("\u001B[32m" + message + "\u001B[0m");
//        LOGGER.info("LOG: {}", message);
    }

    @Step("{0}")
    public static void logError(String stepMessage, Object ... parameters){
        String message = String.format(stepMessage, parameters);
        LOGGER.error("ERROR: {}", message);
    }

    @Step("{0}")
    public static void logAllureStepWithScreenshot(String stepMessage, Object ... parameters){
        String message = String.format(stepMessage, parameters);
//        Allure.addAttachment(message + " : ",
//                new ByteArrayInputStream((TakeScreenshort) WebDriverRunner.getWebDriver().getScreenshotAs(OutputType.BYTES)));
    }

    public void logDebug(String logging) {
        LOGGER.debug("\u001B[34m" + logging + "\u001B[0m");
    }
    public void logInfo(String logging) {
        LOGGER.info("\u001B[32m" + logging + "\u001B[0m");
    }

    public static void logError(String logging) {
        LOGGER.error("\u001B[31m" + logging + "\u001B[0m");
    }
}
