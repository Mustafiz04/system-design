import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] arg) {
        // ContainedNumbersFinder
        List<Integer> stream = Arrays.asList(1, 1, 2, 2, 2, 3, 3, 3, 4, 5, 5, 6, 7, 7, 7, 8, 8, 8, 8);
        int k = 4;

        ContainedNumbersFinder finder = new ContainedNumbersFinder();
        List<List<Integer>> result = finder.findContainedNumbers(stream, k);

        for (int i = 0; i < result.size(); i++) {
            System.out.println("Chunk " + (i + 1) + " contained numbers: " + result.get(i));
        }

        // Broadcast
        Broadcast broadcast = new Broadcast();
        List<Router> router = Arrays.asList(
                new Router("A", 0, 0),
                new Router("B", 0, 8),
                new Router("C", 0, 17),
                new Router("D", 11, 0)
        );
        String source = "A";
        String destination = "D";
        int range = 10;
        System.out.println(broadcast.canBroadcast(router, source, destination, range));

        List<Router> routers1 = Arrays.asList(
                new Router("A", 0, 0),
                new Router("B", 0, 8),
                new Router("C", 0, 17),
                new Router("D", 11, 0)
        );

        System.out.println(broadcast.canBroadcast(routers1, "A", "C", 10)); // true
        System.out.println(broadcast.canBroadcast(routers1, "A", "D", 10)); // false
        System.out.println(broadcast.canBroadcast(routers1, "B", "D", 15)); // true via A

        List<Router> routers2 = Arrays.asList(
                new Router("X", 1, 1),
                new Router("Y", 2, 2),
                new Router("Z", 5, 5),
                new Router("W", 10, 10)
        );

        System.out.println(broadcast.canBroadcast(routers2, "X", "Z", 2)); // false
        System.out.println(broadcast.canBroadcast(routers2, "X", "Y", 2)); // true
        System.out.println(broadcast.canBroadcast(routers2, "X", "W", 10)); // false
    }
}