public class CommandListenStream implements Command{
    private int userId;
    private int streamId;
    CommandListenStream(int userId, int streamId) {
        this.userId = userId;
        this.streamId = streamId;
    }
    @Override
    public void execute() {
        Database db = Database.getDatabase();
        User user = db.getUserById(userId);
        if(user == null) {
            return;
        }
        user.getStreams().add(streamId);
        Stream stream = db.getStreamById(streamId);
        stream.setNoOfStreams(stream.getNoOfStreams()+1);
    }
}
