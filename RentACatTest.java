import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.*;
public class RentACatTest{
    
    RentACat renter;
    Cat testCat;
    
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
}