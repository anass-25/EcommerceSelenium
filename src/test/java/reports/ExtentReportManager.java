package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static synchronized ExtentReports getReport() {

        if (extent == null) {

            File directory = new File("Reports");
            directory.mkdirs();
            ExtentSparkReporter spark = new ExtentSparkReporter("Reports/ExtentReport.html");
            spark.config().setDocumentTitle("TutorialsNinja Automation Report");
            spark.config().setReportName("Selenium Java Test Results");
            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Project", "TutorialsNinja");
            extent.setSystemInfo("Automation", "Selenium Java");
            extent.setSystemInfo("Framework", "TestNG");
        }

        return extent;
    }
}