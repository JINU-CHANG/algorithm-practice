import java.util.*;

class Node {
    Position position;
    int time;

    public Node(Position position, int time) {
        this.position = position;
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;
        return position.equals(node.position) && time == node.time;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, time);
    }
}

class Position {
    int y;
    int x;

    Position(int y, int x) {
        this.y = y;
        this.x = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;
        return y == position.y && x == position.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, x);
    }
}

class Route {
    List<Node> routes;

    Route (List<Node> routes) {
        this.routes = routes;
    }

    public int getTime() {
        return routes.size();
    }

    public void add(Node node) {
        routes.add(node);
    }
}

class Solution {
    public int solution(int[][] points, int[][] routes) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            map.put(i + 1, points[i]);
        }

        List<Route> results = new ArrayList<>();
        for (int i = 0; i < routes.length; i++) {
            int[] route = routes[i];

            Position start = new Position(map.get(route[0])[0], map.get(route[0])[1]);
            Position end = new Position(0, 0);
            Route list = new Route(new ArrayList<>());
            for (int j = 1; j < route.length; j++) {
                if (!start.equals(end)) {
                    list.add(new Node(start, list.getTime()));
                }
                end = new Position(map.get(route[j])[0], map.get(route[j])[1]);
                findRoute(start, end, list);

                start = end;
            }

            results.add(list);
        }

        return findCollision(results);
    }

    private void findRoute(Position start, Position end, Route route) {
        int y = start.y;
        int x = start.x;

        while (y != end.y) {
            int time = route.getTime();
            if (y < end.y) y += 1;
            else y  -= 1;

            Position nPosition = new Position(y, x);
            Node node = new Node(nPosition, time);
            route.add(node);
            if (nPosition.equals(start)) return;
        }

        while (x != end.x) {
            int time = route.getTime();
            if (x < end.x) x += 1;
            else x -= 1;
            
            Position nPosition = new Position(y, x);
            Node node = new Node(nPosition, time);
            route.add(node);
            if (nPosition.equals(start)) return;
        }
    }

    private int findCollision(List<Route> results) {
        Set<Node> nodes = new HashSet<>();
        Set<Node> sameNodes = new HashSet<>();
        for (Route result : results) {
            List<Node> routes = result.routes;
            for (int i = 0; i < routes.size(); i++) {
                Node node = routes.get(i);
                if (nodes.contains(node)) {
                    sameNodes.add(node);
                } else nodes.add(node);
            }
        }

        return sameNodes.size();
    }
}