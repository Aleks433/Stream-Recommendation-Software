public class CommandAddStream implements Command{
    Stream toAdd;

    CommandAddStream(int streamerId, int streamType, int id, int streamGenre, long length, String name) {
        toAdd = new Stream(streamType, id, streamGenre, 0, streamerId, length, 1673560800, name);
    }

    @Override
    public void execute() {
        Database.getDatabase().addStream(toAdd);
    }
}
