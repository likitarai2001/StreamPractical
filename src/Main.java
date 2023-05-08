import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;

public class Main {
    public void displayFlights(ArrayList<Airport> arr) {
        System.out.println("Flight information");
        for (Airport airportObj : arr) {
            System.out.println("Name: " + airportObj.name + " | Journey: " + airportObj.journey + " | Arrival: " + airportObj.arrTime + " | Departure: "
                    + airportObj.deptTime + " | Price: " + airportObj.price);
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Main mainObj = new Main();

        ArrayList<Airport> arr = new ArrayList<Airport>();
        arr.add(new Airport("IndiGo", "AMD to BLR", 12, 13, 3700));
        arr.add(new Airport("Akasa Air", "BOM to COK", 14, 15, 4800));
        arr.add(new Airport("Vistara", "BLR to HYD", 16, 19, 6800));
        arr.add(new Airport("Air India", "DEL to BOM", 21, 23, 6800));

        System.out.println("Flights with sorted (ascending) arrival time");
        List<Airport> sortedList = arr.stream()
                .sorted((x, y) -> x.arrTime - y.arrTime)
                .collect(Collectors.toList());
        mainObj.displayFlights((ArrayList<Airport>) sortedList);

        System.out.println("Flights with price greater than 5000");
        Map<String, String> airportMap = arr.stream()
                .filter(x -> x.price > 5000)
                .collect(Collectors.toMap(Airport::getName, Airport::getJourney));
        for (Map.Entry entry : airportMap.entrySet()) {
            System.out.println(entry.getKey() + " :: " + entry.getValue());
        }

        Integer sumPrice = arr.stream()
                .map(Airport::getPrice)
                .reduce(0, Integer::sum);
        System.out.println("\nSum of price of all flights " + sumPrice);

        String allFlights = arr.stream()
                .map(Airport::getName)
                .collect(Collectors.joining(", "))
                .toString();
        System.out.println("All flights: " + allFlights);
    }
}