import com.revature.daos.ChildDAO;
import com.revature.services.ChildService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ChildTest {
    ChildDAO mockChDAO;
    ChildService chServ;

    @BeforeAll
    public void setup() {
        mockChDAO = mock(ChildDAO.class);
        chServ = new ChildService(mockChDAO);
    }


    @Test
    public void getChildByZeroId() {
        assertNull(chServ.getChildById(0));
    }

    @Test
    public void getChildByNegativeId() {
        assertNull(chServ.getChildById(-1));
    }


    @Test
    public void deleteChildZeroId() {
        assertEquals(0, chServ.deleteChild(0));
//        verify(mockChDAO, times(0)).deleteChild(0);
    }

    @Test
    public void deleteChildNegativeId() {
        assertEquals(0, chServ.deleteChild(-1));
//        verify(mockChDAO, times(0)).deleteChild(-1);
    }
}
