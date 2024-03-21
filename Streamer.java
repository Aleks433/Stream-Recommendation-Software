public class Streamer {
    private int streamerType;
    private int id;
    private String name;

    Streamer(int streamerType, int id, String name) {
        this.id = id;
        this. streamerType = streamerType;
        this.name = name;
    }

    public static Streamer getStreamers(String[] args) {
        return new Streamer(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2]);
    }

    public int getId() {
        return this.id;
    }

    public int getStreamerType() {
        return this.streamerType;
    }

    public String getName() {
        return this.name;
    }
}
