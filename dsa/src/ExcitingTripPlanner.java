import java.util.*;

public class ExcitingTripPlanner {
    static HashMap<String, List<String>> graph = new HashMap<>();
    static HashMap<String, Integer> excitementMap = new HashMap<>();
    static List<String> bestPath = new ArrayList<>();
    static int maxExcitement = 0;

    static void addCity(String name, int excitement) {
        excitementMap.put(name, excitement);
        graph.putIfAbsent(name, new ArrayList<>());
    }

    static void addFlight(String city1, String city2) {
        graph.get(city1).add(city2);
        graph.get(city2).add(city1);
    }

    static void dfs(String current, List<String> path, HashSet<String> visited, int excitement) {
        path.add(current);
        visited.add(current);
        excitement += excitementMap.get(current);

        if(path.size() == 4) {
            if( excitement > maxExcitement ) {
                maxExcitement = excitement;
                bestPath = new ArrayList<>(path);
            }
        } else {
            for(String city: graph.get(current)) {
                if( !visited.contains(city) ) {
                    dfs(city, path, visited, excitement);
                }
            }
        }

        path.remove(path.size() - 1);
        visited.remove(current);
    }

    public static void main(String[] args) {
        // Add cities
        addCity("New York", 10000);
        addCity("San Francisco", 1000);
        addCity("Texas", 500);
        addCity("LA", 20000);
        addCity("Chicago", 3000);
        addCity("San Jose", 900);

        // Add flights (bidirectional)
        addFlight("New York", "San Francisco");
        addFlight("New York", "LA");
        addFlight("Chicago", "LA");
        addFlight("San Jose", "San Francisco");

        for(String city: excitementMap.keySet()) {
            dfs(city, new ArrayList<>(), new HashSet<>(), 0);
        }

        System.out.println(bestPath.toString());
        System.out.println(maxExcitement);
    }
}
