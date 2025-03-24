import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Room {
    int start;
    int end;
    List<Player> players = new ArrayList<>();

    Room(Player player) {
        players.add(player);
        start = player.level - 10;
        end = player.level + 10;
    }
}

class Player implements Comparable<Player> {
    int level;
    String name;

    Player(int level, String name) {
        this.level = level;
        this.name = name;
    }

    @Override
    public int compareTo(Player o) {
        return this.name.compareTo(o.name);
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            Player player = new Player(Integer.parseInt(st.nextToken()), st.nextToken());
            boolean entered = false;
            for (int j = 0; j < rooms.size(); j++) {
                if (entered) break;
                if (rooms.get(j).players.size() == m) continue;
                if (rooms.get(j).start <= player.level && player.level <= rooms.get(j).end) {
                    rooms.get(j).players.add(player);
                    entered = true;
                }
            }

            if (!entered) {
                rooms.add(new Room(player));
            }
        }

        for (Room r : rooms) {
            if (r.players.size() == m) {
                sb.append("Started!").append("\n");
            } else {
                sb.append("Waiting!").append("\n");
            }

            Collections.sort(r.players);
            for (Player player : r.players) {
                sb.append(player.level).append(" ").append(player.name).append("\n");
            }
        }

        System.out.println(sb);
    }
}
