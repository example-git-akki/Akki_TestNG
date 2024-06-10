package TestListenrs;

import org.testng.ITestListener;
import org.testng.ITestResult;

import static org.apache.commons.io.FileUtils.copyFile;

public class Listner implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Succeeded test are :" + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Failed test are :" + result.getName());
        Page.takeScreenShot(result);
    }


}
