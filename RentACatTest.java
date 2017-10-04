import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.*;

public class RentACatTest{
    @Test
    public void testReturnCat(){
        Cat testCat = mock(Cat.class);
        when(testCat.getRented()).thenReturn(true);
        RentACat renter = new RentACat();
        assertEquals(true,renter.returnCat(testCat));
    }
}