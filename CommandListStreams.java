import java.util.List;

public class CommandListStreams implements Command {

    private int userId;

    CommandListStreams(int userId) {
        this.userId = userId;
    }

    @Override
    public void execute() {
        Database db = Database.getDatabase();
        User userSearch;
        Streamer streamerSearch;
        userSearch = db.getUserById(userId);
        String output = "[";
        if (userSearch == null) {
            streamerSearch = db.getStreamerById(userId);
            List<Stream> streams = db.getStreamByArtist(streamerSearch.getId());
            for (int i = 0; i < streams.size(); i++) {
                output += streams.get(i) + ",";
            }
        }
        else if(userSearch!=null){
            for (int i = 0; i < userSearch.getStreams().size(); i++) {
                int streamId = userSearch.getStreams().get(i);
                output += db.getStreamById(streamId) + ",";
            }
        }
        System.out.println(output.substring(0,output.length()-1) + "]");
    }
}