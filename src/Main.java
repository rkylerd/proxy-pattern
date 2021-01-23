import ArrayLazyLoaderProxy.My2DArrayProxy;
import ScheduleBasedProxy.ProxyReminder;

public class Main {
    public static void main(String[] args) {
//        Test the Schedule Based Proxy
        ProxyReminder pr = new ProxyReminder();
        try {
            //Will throw exception if outside of MWF 8am to 5pm
            //Otherwise the true schedule based class will print out the arbitrary reminder
            pr.beginReminder("Go to church next Sunday");
            System.out.println("It must be Monday, Wednesday, or Friday between 8am and 5pm.\n");
        } catch (Exception e) {
            e.printStackTrace();
        }


//        Test the lazy loader proxy

        //test1.txt has a 3 by 3 array
        My2DArrayProxy lazyLoader = new My2DArrayProxy("test1");
        try {
            // By calling lazyLoader.toString() the array in test1 will be loaded
            System.out.println(lazyLoader.toString());
            lazyLoader.setCoordinateVal(0, 2, "gotcha");
            System.out.println(lazyLoader.toString());

        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
