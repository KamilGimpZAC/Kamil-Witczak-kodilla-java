package exception.test;

public class FlightRunner {
    public static void main(String[] args) {
        Flight flight = new Flight("airport1", "airport2");
        FlightLogic flightLogic = new FlightLogic();
        try{
            flightLogic.findFlight(flight);
        } catch (RouteNotFoundException e) {
            e.printStackTrace();
        }
    }
}

