import java.util.List;

public class StreamsIter implements Iterator{
    private Stream[] streamList;
    private int index=0;

    StreamsIter(List<Stream> streams) {
        streamList = new Stream[streams.size()];
        for(int i=0;i<streams.size();i++) {
            streamList[i] = streams.get(i);
        }
    }

    @Override
    public boolean hasNext() {
        if(index < streamList.length) {
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        return streamList[index++];
    }
}
