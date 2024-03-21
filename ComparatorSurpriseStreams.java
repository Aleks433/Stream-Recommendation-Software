import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Comparator;

public class ComparatorSurpriseStreams implements Comparator<Stream> {
    @Override
    public int compare(Stream o1, Stream o2) {
        LocalDate dayOfFirstStream = o1.getDateAdded().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        LocalDate dayOfSecondStream = o2.getDateAdded().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        if(dayOfFirstStream.equals(dayOfSecondStream)) {
            return (int)(o2.getNoOfStreams() - o1.getNoOfStreams());
        }
        if(o2.getDateAdded().before(o1.getDateAdded())) {
            return -1;
        }
        else {
            return 1;
        }
    }
}
