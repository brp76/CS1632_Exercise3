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
    }

    //Testing that the returnCat method returns true when the cat has been rented
    @Test
    public void testReturnCat(){
        when(testCat.getRented()).thenReturn(true);
        renter = new RentACat();
        assertEquals(true,renter.returnCat(testCat));
    }

    //testing that the rentCat method returns true if the cat is not currently rented
    @Test
    public void testRentCat(){
        when(testCat.getRented()).thenReturn(false);
        renter = new RentACat();
        assertEquals(true,renter.rentCat(testCat));
    }

    // Testing that the listCats method returns an empty string if all the cats are rented
    @Test
    public void testListCatEmpty(){
    	when(testCat.getRented()).thenReturn(true);
    	renter = new RentACat();
    	assertEquals("",renter.listCats(testList));
    }

    // Testing that the listCats method returns a string if the cats are not rented
    @Test
    public void testListCatFull(){
    	when(testCat.getRented()).thenReturn(false);
    	when(testCat.toString()).thenReturn("CAT");
    	renter = new RentACat();
    	String s = renter.listCats(testList);
    	System.out.println(s);
    	assertTrue(s.length() > 0);
    }

    //testing that listCats() returns null when the cat doesn't exist in the list
    @Test
    public void testCatNotExist(){
        when(testCat.getId()).thenReturn(1);
        renter = new RentACat();
        testList.add(testCat);
        assertEquals(false,renter.catExists(0,testList));
    }
}