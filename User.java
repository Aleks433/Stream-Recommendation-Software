import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private List<Integer> streams;

    User(int id, String name, String streams) {
        this.id = id;
        this.name = name;
        String[] streamsList = streams.split(" ");
        this.streams = new ArrayList<>(streamsList.length);
        for(int i=0;i< streamsList.length;i++) {
            this.streams.add(Integer.parseInt(streamsList[i]));
        }
    }

    public static User getUsers(String[] args) {
        return new User(Integer.parseInt(args[0]), args[1], args[2]);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getStreams() {
        return streams;
    }
}
