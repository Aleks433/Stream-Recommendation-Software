public class CommandDeleteStream implements Command{
    private int streamId;
    private int streamerId;

    CommandDeleteStream(int streamerId, int streamId) {
        this.streamerId = streamerId;
        this.streamId = streamId;
    }

    @Override
    public void execute() {
        Database db = Database.getDatabase();
        db.deleteStream(db.getStreamById(streamId));
    }
}
