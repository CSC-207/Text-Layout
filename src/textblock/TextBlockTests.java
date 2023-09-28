package textblock;
import static org.junit.Assert.*;   // shorten calls to assert functions
import org.junit.Before;            // shorten future calls to BeforeClass
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