package textblock;
/** 
 * Rearrange the text blocks vertically.
 * 
 * @author Albert-Kenneth Okine
 */
public class VerticallyFlipped implements TextBlock {
    // +--------+----------------------------------------------------
    // | Fields |
    // +--------+----------------------------------------------------

    /** The stuff in the box */
    TextBlock contents;
    
    // +--------------+----------------------------------------------
    // | Constructors |
    // +--------------+----------------------------------------------

    /** Build a new line with contents _contents */
    public VerticallyFlipped(TextBlock _contents) {
        this.contents = _contents;
    } // VerticallyFlipped(TextBlock)

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
            // Return the vertically flipped row
            return this.contents.row(this.contents.height() - i - 1);
        } // if (valid row index)
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
} // class VerticallyFlipped