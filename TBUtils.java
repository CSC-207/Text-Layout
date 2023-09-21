import java.io.PrintWriter;

/**
 * Utilities for TextBlocks.
 * 
 * @author Samuel A. Rebelsky and Albert-Kenneth Okine
 * @version 2.0 of September 2023
 */
public class TBUtils {
    // +--------------+---------------------------------------------------
    // | Class Fields |
    // +--------------+

    /**
     * A really big sequence of dashes. This sequence may grow as the
     * program operates.
     */
    static String lotsOfDashes = "--";

    /**
     * A really big sequence of spaces. This sequence may grow as the
     * program operates.
     */
    static String lotsOfSpaces = "    ";

    // +----------------+-------------------------------------------------
    // | Static Methods |
    // +----------------+

    /**
     * Build a sequence of dashes of a specified length.
     */
    static String dashes(int len) {
        // Note: This strategy probably represents an overkill in
        // attempts at efficiency.
        // Make sure the collection of dashes is big enough
        while (lotsOfDashes.length() < len) {
            lotsOfDashes = lotsOfDashes.concat(lotsOfDashes);
        } // while
        // Extract an appropriate length substring
        return lotsOfDashes.substring(0, len);
    } // dashes(int)

    /**
     * Print a TextBlock to the specified destination.
     */
    public static void print(PrintWriter pen, TextBlock block) {
        for (int i = 0; i < block.height(); i++) {
            // Even though we only call block.row with a valid i,
            // we need to put the call in a try/catch block.
            try {
                pen.println(block.row(i));
            } catch (Exception e) {
                pen.println();
            } // catch (Exception)
        } // for
    } // print(PrintWriter, TextBlock)

    /**
     * Build a sequence of spaces of a specified length.
     */
    static String spaces(int len) {
        // As with dashes, this is probably overkill.
        // Make sure the collection of dashes is big enough
        while (lotsOfSpaces.length() < len) {
            lotsOfSpaces = lotsOfSpaces.concat(lotsOfSpaces);
        } // while
        // Extract an appropriate length substring
        return lotsOfSpaces.substring(0, len);
    } // spaces(int)

    /**
     * Check if the text blocks contain the same lines.
     */
    public static Boolean equal(TextBlock t1, TextBlock t2)
        throws Exception {
        // Check that both TextBlocks have the same height
        if (t1.height() != t2.height()) return false;
        // Loop through each row and check they are the same
        for (int index = 0; index < t1.height(); index ++) {
            if (!t1.row(index).equals(t2.row(index))) {
                return false;
            } // if (rows are not the same)
        } // for (each row in t1,t2)
        // Each row is the same, so t1 and t2 are equal
        return true;
    } // equal(TextBlock, TextBlock)

    /** 
     * Check if the text blocks were built the same way.
     */
    public static Boolean eqv(TextBlock t1, TextBlock t2) {
        // Compare the classes of the two objects
        return t1.getClass().equals(t2.getClass());
    } // eqv(TextBlock, TextBlock)

    /** 
     * Check if the text blocks have the same memory location.
     */
    public static Boolean eq(TextBlock t1, TextBlock t2) {
        // Compare the memory locations of the two objects
        return (t1 == t2);
    } // eq(TextBlock, TextBlock)
} // class TBUtils