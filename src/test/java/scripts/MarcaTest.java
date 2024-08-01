package scripts;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.Marca;
import utilities.*;

import static helpers.Runners.runAccessibilityCopy;
import static helpers.Runners.runAllureReport;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utilities.FrontEndOperation.compareTexts;
import static utilities.FrontEndOperation.waitSeconds;

@ExtendWith(TestErrorHandler.class)
public class MarcaTest {

  private static Marca controller;

  @BeforeAll
  public static void clean_reports_logs() {
    JSExecutor.runCommand(
        LocalEnviroment.isWindows()
            ? Constants.ALLURE_CLEAN_COMMAND_WIN
            : Constants.ALLURE_CLEAN_COMMAND_MAC);
    AllureReport.fillReportInfo();
  }

  @BeforeEach
  public void iAmOnTheMarcaWebsite() {
    controller = new Marca();
  }

  @Test
  public void checkNewsArticleImage() {
    controller.acceptCookies();
    controller.clickLeganes();
    controller.clickPlantilla();
    controller.checkNamePlayer();
    controller.changeTab();
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
