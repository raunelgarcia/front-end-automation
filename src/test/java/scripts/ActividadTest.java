package scripts;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.Actividad;
import utilities.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static utilities.FrontEndOperation.compareTexts;
import static utilities.FrontEndOperation.waitSeconds;

@ExtendWith(TestErrorHandler.class)
public class ActividadTest {

    private static Actividad controller;

    @BeforeEach
    public void iAmOnTheMarcaWebsite() {
        controller = new Actividad();
    }

    @Test
    public void acceptCookies() {
        controller.acceptCookies();
    }

    @AfterEach
    public void closeDriver() {
        Accessibility.checkAccessibility();
        AllureReport.fillReportInfo();
        NetworkLogs.getNetworkLogs();
        waitSeconds(Constants.LOW_TIMEOUT);
    }

    @AfterAll
    public static void runReports() {
        runAllureReport();
        runAccessibilityCopy();
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
