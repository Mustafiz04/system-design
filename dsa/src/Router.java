import java.util.*;

class Router {
    String name;
    int x, y;
    Router(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Router other) {
        int dx = this.x - other.x;
        int dy = this.y = other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}

class Broadcast {
public boolean canBroadcast (List<Router> router, String ori, String desc, int range) {
    HashMap<String, Router> map = new HashMap<>();
    for(Router r: router) {
        map.put(r.name, r);
    }

    if(!map.containsKey(ori) || !map.containsKey(desc)) return false;

    HashSet<String> vis = new HashSet<>();
    Queue<String> q = new LinkedList<>();

    q.offer(ori);

    while(!q.isEmpty()) {
        String curr = q.poll();
        if(curr.equals(desc)) return true;

        vis.add(curr);
        Router current = map.get(curr);

        for(Router neighbor: router) {
            if( !vis.contains(neighbor.name) && !neighbor.name.equals(curr) && current.distanceTo(neighbor) <= range ) {
                q.offer(neighbor.name);
            }
        }
    }

    return false;
}
        }