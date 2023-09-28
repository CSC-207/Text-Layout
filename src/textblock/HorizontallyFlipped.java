package textblock;
/** 
 * Rearrange the text blocks horizontally.
 * 
 * @author Albert-Kenneth Okine
 */
public class HorizontallyFlipped implements TextBlock {
    // +--------+----------------------------------------------------
    // | Fields |
    // +--------+----------------------------------------------------

    /** The stuff in the box */
    TextBlock contents;
    
    // +--------------+----------------------------------------------
    // | Constructors |
    // +--------------+----------------------------------------------

    /** Build a new line with contents _contents */
    public HorizontallyFlipped(TextBlock _contents) {
        this.contents = _contents;
    } // HorizontallyFlipped(TextBlock)

    // +---------+---------------------------------------------------
    // | Methods |
    // +---------+---------------------------------------------------

    /**
     * Get one row from the block.
     * 
     * @pre 0 <= i < this.height()
     * @exception Exception if the precondition is not met
     */
    public String row(int i) throws Exception {
        // Check if index i is in the valid range
        if ((i >= 0) && (i < this.contents.height())) {
            // Use the StringBuilder class to make reversing easier
            StringBuilder str = new StringBuilder(this.contents.row(i));
            // Return the row, horizontally flipped
            return str.reverse().toString();
        } // if (valid row number)
        // Otherwise, throw an exception describing the error
        else throw new Exception("Invalid row " + i);
    } // row(int)

    /** Determine how many rows are in the block. */
    public int height() {
        return this.contents.height();
    } // height()

    /** Determine how many columns are in this block. */
    public int width() {
        return this.contents.width();
    } // width()
} // class HorizontallyFlipped