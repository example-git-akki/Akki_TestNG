package DemoTestNGDependsOnGroup;

import org.testng.annotations.Test;

public class DemoDependsOnGroup {
    static String trackingNumber = null;


    @Test
    public void createShipment() {
        System.out.println(5 / 0);
        System.out.println("createShipment");
        trackingNumber = "abc123";
    }

    @Test(dependsOnMethods = "createShipment")
    public void trackShipment() throws Exception {
        if (trackingNumber != null) {
            System.out.println("trackShipment");
        } else {
            throw new Exception();
        }
    }

    @Test(dependsOnMethods = {"createShipment", "trackShipment"})
    public void cancelShipment() throws Exception {
        if (trackingNumber != null) {
            System.out.println("cancelShipment");
        } else {
            throw new Exception();
        }
    }

}

