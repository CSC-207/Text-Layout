import static org.junit.Assert.*;   // shorten calls to assert functions
import org.junit.Before;            // shorten future calls to Before
import org.junit.Test;              // shorten future calls to Test

/**
 * Test each of the procedures we implemented, ensuring we test edge
 * cases as well.
 * 
 * @author Albert-Kenneth Okine
 */
public class TextBlockTests {
    // Define objects to reference later on in our tests
    TextBlock testLine, testBox, testEmpty;

    /** Run before each test to setup the testing environment */
    @Before
    public void setUp() {
        // Make an empty TextLine (width = 0, height = 1)
        testEmpty = new TextLine("");
        // Make a TextLine (width = 5, height = 1)
        testLine = new TextLine("Hello");
        // Make a BoxedBlock (width = 7, height = 3)
        testBox = new BoxedBlock(testLine);
    } // setUp()
    
    /** Test the TBUtils.equal procedure */
    @Test
    public void equalTest() {
        try { // Handle any exceptions in the equal function
            // Test that the procedure works as intended
            assert(TBUtils.equal(testEmpty, testEmpty));
            assert(TBUtils.equal(testLine, testLine));
            assert(TBUtils.equal(testBox, testBox));
            // Test that the prcedure works with new objects
            assert(TBUtils.equal(testLine, new TextLine("Hello")));
            assert(TBUtils.equal(testBox, new BoxedBlock(testLine)));
            // Test that the procedure fails as intended
            assertFalse(TBUtils.equal(testEmpty, testLine));
            assertFalse(TBUtils.equal(testLine, testBox));
            assertFalse(TBUtils.equal(testBox, testEmpty));

        } catch (Exception e) {
            assert(false) : "Exception in equalTest";
        } // try...catch
    } // equalTest()

    /** Test the TBUtils.eqv prcocedure */
    @Test
    public void eqvTest() {
        try { // Handle any exceptions in the eqv function
            // Test that the procedure works as intended
            assert(TBUtils.eqv(testEmpty, testEmpty));
            assert(TBUtils.eqv(testLine, testLine));
            assert(TBUtils.eqv(testBox, testBox));
            // Test that the prcedure works with new objects
            assert(TBUtils.eqv(testBox, new BoxedBlock(testEmpty)));
            assert(TBUtils.eqv(testBox, new BoxedBlock(testLine)));
            // Test that the procedure fails as intended
            assertFalse(TBUtils.eqv(testLine, testBox));
            assertFalse(TBUtils.eqv(testBox, testEmpty));

        } catch (Exception e) {
            assert(false) : "Exception in eqvTest";
        } // try...catch
    } // eqvTest()

    /** Test the TBUtils.eq procedure */
    @Test
    public void eqTest() {
        try { // Hanfle any exception in the eq funcition
            // Test that the procedure works as intended
            assert(TBUtils.eq(testEmpty, testEmpty));
            assert(TBUtils.eq(testLine, testLine));
            assert(TBUtils.eq(testBox, testBox));
            // Test that the procedure fails as intended
            assertFalse(TBUtils.eq(testEmpty, testLine));
            assertFalse(TBUtils.eq(testLine, testBox));
            assertFalse(TBUtils.eq(testBox, testEmpty));
            // Test that the prcedure fails with new objects
            assertFalse(TBUtils.eq(testLine, new TextLine("Hello")));
            assertFalse(TBUtils.eq(testBox, new BoxedBlock(testLine)));
        } catch (Exception e) {
            assert(false) : "Exception in eqTest";
        }
    } // eqTest()

    /** Test the Truncated class */
    @Test
    public void truncateTest() {
        try { // Handle any exceptions in the equal function 
             // Define Truncated objects
            TextBlock testEmptyT = new Truncated(testEmpty, 0);
            TextBlock testBoxT = new Truncated(testBox, 7);
            
            // Test that the procedure works as intended
            assert(TBUtils.equal(testEmpty, testEmptyT));
            assert(TBUtils.equal(testBox, testBoxT));
            assert(TBUtils.equal(testLine, new Truncated(testLine, 5)));
            // Test that the procedure fails as intended
            assertFalse(TBUtils.equal(testLine, new Truncated(testLine, 4)));
            assertFalse(TBUtils.equal(testLine, new Truncated(testLine, 6)));

        } catch (Exception e) {
            assert(false) : "Exception in truncateTest"; 
        } // try...catch
    } // truncateTest()

    /** Test the Centered class */
    @Test
    public void centerTest() {
        try { // Handle any exceptions in the equal function 
            // Define Centered objects
            TextBlock testEmptyC = new Centered(testEmpty, 0);
            TextBlock testBoxC = new Centered(testBox, 7);
            
            // Test that the procedure works as intended
            assert(TBUtils.equal(testEmpty, testEmptyC));
            assert(TBUtils.equal(testBox, testBoxC));
            assert(TBUtils.equal(testLine, new Centered(testLine, 5)));
            // Test that the procedure fails as intended
            assertFalse(TBUtils.equal(testLine, new Centered(testLine, 4)));
            assertFalse(TBUtils.equal(testLine, new Centered(testLine, 6)));
        
        } catch (Exception e) {
            assert(false) : "Exception in centerTest";
        } // try...catch
    } // centerTest()

    /** Test the RightJustified class */
    @Test
    public void rightJustifyTest() {
        try { // Handle any exceptions in the equal function 
            // Define RightJustified objects
            TextBlock testEmptyR = new RightJustified(testEmpty, 0);
            TextBlock testBoxR = new RightJustified(testBox, 7);
            
            // Test that the procedure works as intended
            assert(TBUtils.equal(testEmpty, testEmptyR));
            assert(TBUtils.equal(testBox, testBoxR));
            assert(TBUtils.equal(testLine, new RightJustified(testLine, 5)));
            // Test that the procedure fails as intended
            assertFalse(TBUtils.equal(testLine, new RightJustified(testLine, 4)));
            assertFalse(TBUtils.equal(testLine, new RightJustified(testLine, 6)));
        
        } catch (Exception e) {
            assert(false) : "Exception in rightJustifyTest";
        } // try...catch
    } // rightJustifyTest()

    /** Test the HorizonatllyFlipped class */
    @Test
    public void horizontallyFlipTest() {
        try { // Handle any exceptions in the equal function 
            // Define HorizontllyFlipped objects
            TextBlock testEmptyH = new HorizontallyFlipped(testEmpty);
            TextBlock testLineH = new HorizontallyFlipped(testLine);
            TextBlock testBoxH = new HorizontallyFlipped(testBox);
            
            // Test that the procedure works as intended
            assert(TBUtils.equal(new TextLine("olleH"), testLineH));
            assert(TBUtils.equal(testEmpty, testEmptyH));
            // Test that the procedure fails as intended
            assertFalse(TBUtils.equal(testLine, testLineH));
            assertFalse(TBUtils.equal(testBox, testBoxH));

        } catch (Exception e) {
            assert(false) : "Exception in horizontallyFlipTest";
        } // try...catch
    } // horizontallyFlipTest()

    /** Test the VerticallyFlipped class */
    @Test
    public void verticallyFlipTest() {
        try { // Handle any exceptions in the equal function 
            // Define VerticallyFlipped objects
            TextBlock testEmptyV = new VerticallyFlipped(testEmpty);
            TextBlock testLineV = new VerticallyFlipped(testLine);
            TextBlock testBoxV = new VerticallyFlipped(testBox);
            
            // Test that the procedure works as intended
            assert(TBUtils.equal(testEmpty, testEmptyV));
            assert(TBUtils.equal(testLine, testLineV));
            // Test that the procedure fails as intended
            assert(TBUtils.equal(testBox, testBoxV));
            assert(TBUtils.equal(testBox, testBoxV));
        
        } catch (Exception e) {
            assert(false) : "Exception in verticallyFlipTest";
        } // try...catch
    } // verticallyFlipTest()
} // TextBlockTests