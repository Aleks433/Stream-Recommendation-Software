import java.util.Collections;
import java.util.List;

public class CommandSurprise implements Command{
    private int userId;
    private int typeOfStream;

    CommandSurprise(int userId, String typeOfStream) {
        this.userId = userId;
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
        List<Stream> streams = db.getSurpriseStreams(typeOfStream, userId);
        Collections.sort(streams, new ComparatorSurpriseStreams());
        int toAdd=3;
        int i=0;
        String surpiseStreams="";
        System.out.print("[");
        while(i<streams.size() && toAdd!=0) {
            Stream stream = streams.get(i);
            surpiseStreams += stream + ",";
            toAdd--;
            i++;
        }
        System.out.print(surpiseStreams.substring(0,surpiseStreams.length()-1));
        System.out.println("]");
    }
}
