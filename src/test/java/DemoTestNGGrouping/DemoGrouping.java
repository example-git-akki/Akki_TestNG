//Grouping is an feature in testNg to add group to ur test methods to execute it in a small-time
//it is annotated by @Test(groups={"String1","String1"})
//it is declared at suite level and test level
//it is followed by suite-test->groups->run->include or exclude
//meta groups are nothing but the group of groups
//partial grouping is done by declare @Test(group="all") above the class declared
//Regular expression like windows.*  its like having comman names


package DemoTestNGGrouping;

import org.testng.annotations.Test;

public class DemoGrouping {

    @Test(groups = {"smoke", "regression"})
    public void test1() {
        System.out.println("test1");
    }

    @Test(groups = {"smoke", "sanity"})
    public void test2() {
        System.out.println("test2");
    }

    @Test(groups = {"retesting", "functional"})
    public void test3() {
        System.out.println("test3");
    }
}
