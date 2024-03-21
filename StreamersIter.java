import java.util.List;

public class StreamersIter implements Iterator{

    private Streamer[] streamerList;
    private int index=0;

    StreamersIter(Streamer[] streamers) {
        streamerList = streamers;
    }

    StreamersIter(List<Streamer> streamers) {
        streamerList = new Streamer[streamers.size()] ;
        for(int i=0;i<streamers.size();i++) {
            streamerList[i] = streamers.get(i);
        }
    }

    @Override
    public boolean hasNext() {
        if(index < streamerList.length)  {
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        return streamerList[index++];
    }
}
