import java.util.Comparator;

public class ComparatorRecommendedStreams implements Comparator<Stream> {
    @Override
    public int compare(Stream o1, Stream o2) {
        return (int) (o2.getNoOfStreams() - o1.getNoOfStreams());
    }
}
