import java.util.Collections;
import java.util.List;

public class CommandRecommend implements Command{
    private int userId;
    private int typeOfStream;

    CommandRecommend(int id, String typeOfStream) {
        this.userId = id;
        switch (typeOfStream) {
            case "SONG" : {
                this.typeOfStream = 1;
                break;
            }
            case "PODCAST" : {
                this.typeOfStream = 2;
                break;
            }
            case "AUDIOBOOK" : {
                this.typeOfStream = 3;
                break;
            }
        }
    }

    @Override
    public void execute() {
        Database db = Database.getDatabase();
        User user = db.getUserById(userId);
        List<Stream> streams = db.getRecommendedStreams(typeOfStream, userId);
        Collections.sort(streams, new ComparatorRecommendedStreams());
        int i = 0, toAdd = 5;
        System.out.print("[");
        String recommendedStreams="";
        while(i < streams.size() && toAdd != 0) {
            Stream stream = streams.get(i);
            boolean listening = false;
            for(int j = 0;j<user.getStreams().size();j++) {
                int streamId = user.getStreams().get(j);
                if(streamId == stream.getId()) {
                    listening = true;
                    break;
                }
            }
            if(!listening) {
                recommendedStreams += stream + ",";
                toAdd--;
            }
            i++;
        }
        System.out.print(recommendedStreams.substring(0,recommendedStreams.length()-1));
        System.out.println("]");
    }
}
