
//Priority is used the prioritize  the test methods in testNG
//It is usually denoted by @Test(priority=0)
//priority value can be an integer like -1,0,1,2
//When priority of same integer is passed then testNg follows the ascii value Rule[alphabetic order]

package DemoTestNGFeatures;

import org.testng.annotations.Test;

public class DemoPriority {

    @Test(priority = -1)
    public void test1() {
        System.out.println("test1");
    }

    @Test(priority = 1)
    public void step2() {
        System.out.println("test2");
    }

    @Test(priority = 2)
    public void third3() {
        System.out.println("test3");
    }
}
