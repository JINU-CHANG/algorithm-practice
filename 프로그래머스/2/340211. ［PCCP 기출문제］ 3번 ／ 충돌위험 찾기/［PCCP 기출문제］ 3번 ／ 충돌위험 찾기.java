import java.util.*;

class Point {
    int y;
    int x;
    int time;

    public Point(int y, int x, int time) {
        this.y = y;
        this.x = x;
        this.time = time;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Point point = (Point) object;
        return y == point.y && x == point.x && time == point.time;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, x, time);
    }
}

class Route {
    List<Point> routes;

    Route (List<Point> routes) {
        this.routes = routes;
    }

    public void add(Point point) {
        routes.add(point);
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

            int startY = map.get(route[0])[0];
            int startX = map.get(route[0])[1];
            int endY = 0;
            int endX = 0;
            int time = 0;
            Route list = new Route(new ArrayList<>());
            for (int j = 1; j < route.length; j++) {
                if (startY != endY && startX != endX) {
                    list.add(new Point(startY, startX, time));
                }
                endY = map.get(route[j])[0];
                endX = map.get(route[j])[1];
                time = findRoute(startY, startX, endY, endX, list, time);

                startY = endY;
                startX = endX;
            }

            results.add(list);
        }

        // for (int i = 0; i < routes.length; i++) {
        //     for(int[] arr : results.get(i).routes) {
        //         System.out.println(Arrays.toString(arr));
        //     }
        // }

        return findCollision(results);
    }

    private int findRoute(int startY, int startX, int endY, int endX, Route route, int time) {
        int x = 1;
        if (startY > endY) x = -1;
        else x = 1;

        while (startY != endY) {
            time++;
            startY = startY + x;
            Point point = new Point(startY, startX, time);
            route.add(point);
            if (startY == endY && startX == endX) return time;
        }

        if (startX > endX) x = -1;
        else x = 1;

        while (startX != endX) {
            time++;
            startX = startX + x;
            Point point = new Point(startY, startX, time);
            route.add(point);
            if (startX == endX) return time;
        }
        return time;
    }

    private int findCollision(List<Route> results) {
        Set<Point> points = new HashSet<>();
        Set<Point> samePoints = new HashSet<>();
        for (Route result : results) {
            List<Point> routes = result.routes;
            for (int i = 0; i < routes.size(); i++) {
                Point point = routes.get(i);
                if (points.contains(point)) {
                    samePoints.add(point);
                } else points.add(point);
            }
        }

        return samePoints.size();
    }
}