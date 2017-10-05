import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import org.junit.*;
public class RentACatTest{
    
    RentACat renter;
    Cat testCat;
    ArrayList<Cat> testList = new ArrayList<Cat>();
    
    //initialize a mock cat object for testing
    @Before
    public void setup(){
        testCat = mock(Cat.class);
        renter = new RentACat();
    }

    //Testing that the returnCat method returns true when the cat has been rented
    @Test
    public void testReturnCat(){
        when(testCat.getRented()).thenReturn(true);
        assertEquals(true,renter.returnCat(testCat));
    }

    //testing that the rentCat method returns true if the cat is not currently rented
    @Test
    public void testRentCat(){
        when(testCat.getRented()).thenReturn(false);
        assertEquals(true,renter.rentCat(testCat));
    }

    // Testing that the listCats method returns an empty string if all the cats are rented
    @Test
    public void testListCatEmpty(){
    	when(testCat.getRented()).thenReturn(true);
    	assertEquals("",renter.listCats(testList));
    }

    // Testing that the listCats method returns a string if the cats are not rented
    @Test
    public void testListCatFull(){
    	when(testCat.getRented()).thenReturn(false);
    	when(testCat.toString()).thenReturn("CAT");
        testList.add(testCat);
    	String s = renter.listCats(testList);
    	assertTrue(s.length() > 0);
    }

    //testing that catExists() returns false when the cat doesn't exist in the list
    @Test
    public void testCatNotExist(){
        when(testCat.getId()).thenReturn(1);
        testList.add(testCat);
        assertEquals(false,renter.catExists(0,testList));
    }

    //testing that catExists() returns true when the cat exists in the list
    @Test
    public void testCatExists(){
        when(testCat.getId()).thenReturn(1);
        testList.add(testCat);
        assertEquals(true, renter.catExists(1, testList));
    }
}