package scripts;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.Ikea;
import utilities.*;

import static scripts.MarcaTest.runAllureReport;
import static utilities.FrontEndOperation.waitSeconds;

@ExtendWith(TestErrorHandler.class)
public class IkeaTest {

    Ikea controller;

    @BeforeAll
    public static void clean_reports_logs() {
        JSExecutor.runCommand(LocalEnviroment.isWindows() ? Constants.ALLURE_CLEAN_COMMAND_WIN : Constants.ALLURE_CLEAN_COMMAND_MAC);
        JSExecutor.runCommand(LocalEnviroment.isWindows() ? Constants.NETWORK_LOG_CLEAN_COMMAND_WIN : Constants.NETWORK_LOG_CLEAN_COMMAND_MAC);
        NetworkLogs.clearLogs();
    }
    @BeforeEach
    public void iAmOnAmazonWebpage() {
        controller = new Ikea();
        controller.acceptCookies();
    }
    @Test
    public void lookForSofas() {
        controller.clickMuebles();
        controller.addToCart();
    }
    @AfterEach
    public void closeDriver() {
        AllureReport.fillReportInfo();
        NetworkLogs.getNetworkLogs();
        waitSeconds(Constants.LOW_TIMEOUT);
    }
    @AfterAll
    public static void runReports() {
        runAllureReport();
    }
}
