package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Setup implements ITestListener {
    private static ExtentReports extentsReports;
    public static ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<ExtentTest>();
    public void onStart(ITestContext context){
    String fileName = ExtentReportUtils.getReportNameWithTimeStamp();
    String fullReportPath  =  System.getProperty("user.dir")+"\\reports\\"+fileName;
    extentsReports = ExtentReportUtils.createInstance(fullReportPath,"Test API Automation Report","Test Execution Report");

    }
    public void onFinish(ITestContext context){
    if (extentsReports != null)
        extentsReports.flush();
    }
    public void onTestStart(ITestResult result){
        ExtentTest test = extentsReports.createTest(result.getMethod().getMethodName());
        extentTestThreadLocal.set(test);
    }





}
