import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuestTest {
    Guest guest;

    @Before
    public void before() {
        guest = new Guest("James Smith");
    }

    @Test
    public void hasName() {
        assertEquals("James Smith", guest.getName());
    }
}
