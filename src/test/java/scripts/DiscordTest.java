package scripts;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.Discord;
import utilities.*;

import static helpers.Runners.runAccessibilityCopy;
import static helpers.Runners.runAllureReport;
import static utilities.FrontEndOperation.waitSeconds;

@ExtendWith(TestErrorHandler.class)
public class DiscordTest {

  Discord controller;

  @BeforeAll
  public static void clean_reports_logs() {
    JSExecutor.runCommand(
        LocalEnviroment.isWindows()
            ? Constants.ALLURE_CLEAN_COMMAND_WIN
            : Constants.ALLURE_CLEAN_COMMAND_MAC);
    AllureReport.fillReportInfo();
  }

  @BeforeEach
  public void iAmOnAmazonWebpage() {
    controller = new Discord();
  }

  @Test
  public void logIn() {
    controller.clickIniciarSesion();
    controller.rellenarEmail();
    controller.rellenarPassword();
    controller.clickBotonIniciarSesion();
  }

  @AfterEach
  public void closeDriver() {
    Accessibility.checkAccessibility();
    NetworkLogs.getNetworkLogs();
    AllureReport.fillReportInfo();
  }

  @AfterAll
  public static void runReports() {
    runAllureReport();
    runAccessibilityCopy();
  }
}
