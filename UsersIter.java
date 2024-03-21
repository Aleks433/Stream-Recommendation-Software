import java.util.List;

public class UsersIter implements Iterator{
    private User[] usersList;
    private int index=0;

    UsersIter(List<User> users) {
        usersList = new User[users.size()] ;
        for(int i=0;i<users.size();i++) {
            usersList[i] = users.get(i);
        }
    }

    @Override
    public boolean hasNext() {
        if(index < usersList.length) {
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        return usersList[index++];
    }
}