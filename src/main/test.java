import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

class GameTest {

    @Test
    public void testgetdate() {
        String actual = Game.getDate();

        Assert.assertEquals("2021-10-13", actual);
    }

}