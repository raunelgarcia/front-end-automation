package scripts;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.Actividad2;
import utilities.*;

import static utilities.FrontEndOperation.waitSeconds;

@ExtendWith(TestErrorHandler.class)
public class Actividad2Test {

    private static Actividad2 controller;

    @BeforeEach
    public void phone() {
        controller = new Actividad2();
    }

    @Test
    public void clickContactos() {
        controller.clickContactos();
    }

    @AfterEach
    public void closeDriver() {
        AllureReport.fillReportInfo();
        NetworkLogs.getNetworkLogs();
        waitSeconds(Constants.LOW_TIMEOUT);
    }

    public static void runAllureReport() {
        if (LocalEnviroment.isWindows()) {
            JSExecutor.runCommand(Constants.ALLURE_COMMAND_WIN);
        } else {
            JSExecutor.runCommand(Constants.ALLURE_COMMAND_MAC);
        }
    }

    public static void runAccessibilityCopy() {
        if (LocalEnviroment.getAccessibility() && LocalEnviroment.isWeb()) {
            Accessibility.moveHtmlReportToAccessibilityDirectory(Constants.ACCESSIBILITY_REPORT_PATH);
        }
    }
}
