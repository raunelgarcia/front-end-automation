package scripts;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.Marca;
import utilities.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static utilities.FrontEndOperation.waitSeconds;

@ExtendWith(TestErrorHandler.class)
public class MarcaTest {

    private static Marca controller;

    @BeforeAll
    public static void clean_reports_logs() {
        JSExecutor.runCommand(LocalEnviroment.isWindows() ? Constants.ALLURE_CLEAN_COMMAND_WIN : Constants.ALLURE_CLEAN_COMMAND_MAC);
        JSExecutor.runCommand(LocalEnviroment.isWindows() ? Constants.NETWORK_LOG_CLEAN_COMMAND_WIN : Constants.NETWORK_LOG_CLEAN_COMMAND_MAC);
        NetworkLogs.clearLogs();
    }

    @BeforeEach
    public void iAmOnTheMarcaWebsite() {
        controller = new Marca();
    }

    @Test
    public void checkNewsArticleImage() {
        controller.acceptCookies();
    }

    @Test
    public void checkIfNewExists() {
        controller.acceptCookies();
        controller.goToNotice();
        assertTrue(true, "La imagen no se muestra en pantalla");
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
