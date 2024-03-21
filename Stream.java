import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Stream {
    private int streamType;
    private int id;
    private int streamGenre;
    private long noOfStreams;
    private int streamerId;
    private Duration length;
    private Date dateAdded;
    private String name;

    Stream(int streamType, int id, int streamGenre, long noOfStreams, int streamerId,
           long length, long date, String name) {
        this.streamType = streamType;
        this.id = id;
        this.streamGenre = streamGenre;
        this.noOfStreams = noOfStreams;
        this.streamerId = streamerId;
        this.length = Duration.ofSeconds(length);
        this.dateAdded = new Date(date*1000L - 7200);
        this.name = name;
    }

    public static Stream getStreams(String[] args) {
        return new Stream(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]),
                Long.parseLong(args[3]), Integer.parseInt(args[4]), Long.parseLong(args[5]), Long.parseLong(args[6]),
                args[7]);
    }

    public int getStreamType() {
        return streamType;
    }

    public int getId() {
        return id;
    }

    public int getStreamGenre() {
        return streamGenre;
    }

    public long getNoOfStreams() {
        return noOfStreams;
    }

    public void setNoOfStreams(long noOfStreams) {
        this.noOfStreams = noOfStreams;
    }

    public int getStreamerId() {
        return streamerId;
    }

    public Duration getLength() {
        return length;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        String toRet = "{\"id\":\"" + getId() +
                "\",\"name\":\"" + getName() +
                "\",\"streamerName\":\"";
        Database db = Database.getDatabase();
        Streamer streamer = db.getStreamerById(getStreamerId());
        toRet += streamer.getName() + "\",";
        toRet += "\"noOfListenings\":\"" + getNoOfStreams() +
                "\",\"length\":\"";
        if(length.toHours()==0) {
            long minutes = length.toMinutes();
            long seconds = length.toSeconds()%60;
            String lengthStr = String.format("%02d:%02d", minutes, seconds);
            toRet += lengthStr;
        }
        else {
            long hours = length.toHours();
            long minutes = length.toMinutes()%60;
            long seconds = length.toSeconds()%60;
            String lenghtStr = String.format("%02d:%02d:%02d", hours, minutes, seconds);
            toRet += lenghtStr;
        }
        toRet+="\",\"dateAdded\":\"";
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-YYYY");
        toRet+=format.format(getDateAdded());
        toRet+="\"}";
        return toRet;
    }
}
