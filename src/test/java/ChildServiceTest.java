//import com.revature.daos.ChildDAO;
//import com.revature.models.Child;
//import com.revature.models.Classroom;
//import com.revature.services.ChildService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//
//public class ChildServiceTest {
//
//    ChildDAO mockCDao = Mockito.mock(ChildDAO.class);
//    ChildService cService = new ChildService();
//
//    @Test
//    public void getChildByIdZero() {
//        //should be null because the first id starts at 1
//        Assertions.assertNull(cService.getChildById(0));
//    }
//
//    @Test
//    public void getChildByIdNegativeInt() {
//        //should be null because the first id starts at 1
//        Assertions.assertNull(cService.getChildById(-3));
//    }
//
//    //Test for positive values
//    //Need to fake a call to the ChildDao and return it with a return value
//
//    @Test
//    public void getChildByIdPositiveInt() {
//        //Lets get a fake Child object we want to return from the DB
//        Child child = new Child(2, "Johnathan", "Dooley", "2022-04-27", new Classroom(6, "Babies", "babies room"));
//        Mockito.when(mockCDao.getChildById(6)).thenReturn(child);
//        Assertions.assertEquals(child, cService.getChildById(6));
//    }
//}
