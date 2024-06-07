//Ignore is generally used to ignore a test,method ,package in an testNG
//at test level it is done by adding @Ignore above @Test annotation
//at class level it is done by adding @Ignore above the class name declared
//at package level it is done by creating package-info.java class

package DemoTestNGIgnore;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Ignore
public class DemoIgnore {
//    @Ignore
    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    @Test
    public void test3() {
        System.out.println("test3");
    }
}
