package Graph;

import org.junit.Test;

public class FriendShipTest {
    @Test
    public void test() {
        String[] neighborsInput = {
                "1,John",
                "2,Frank",
                "3,Nolan",
                "4,Monica",
                "6,Vera"
        };

        String[] friendshipsInput = {
                "1,3",
                "1,2",
                "1,2",
                "2,1",
                "2,4"
        };
        FriendShip fs = new FriendShip();
        fs.findFriends(neighborsInput, friendshipsInput);
    }
}
