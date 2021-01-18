package exception.test;

public class RouteNotFoundException extends Exception {
    public RouteNotFoundException() {
        System.out.println("Airport unavailable");
    }
}
