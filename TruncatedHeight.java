/**
 * Given a text block and a maximum height, builds a new block that
 * truncates the input block to that height.
 * 
 * @author Albert-Kenneth Okine
 */
public class TruncatedHeight implements TextBlock {
    // +--------+---------------------------------------------------------
    // | Fields |
    // +--------+---------------------------------------------------------

    /** The stuff in the box */
    TextBlock t1;
    TextBlock t2;

    /** The stuff in the box */
    TextBlock contents;
    /** the height of a cell */
    int h;

    // +--------------+---------------------------------------------------
    // | Constructors |
    // +--------------+---------------------------------------------------

    /** Build a new block with contents _contents and height _h */
    public TruncatedHeight(TextBlock _contents, int _h) {
        this.contents = _contents;
        this.h = _h;
    } // TruncatedHeight(TextBlock, int)

    // +---------+--------------------------------------------------------
    // | Methods |
    // +---------+--------------------------------------------------------

    /**
     * Get one row from the block.
     * 
     * @pre 0 <= i < this.height()
     * @exception Exception if the precondition is not met
     */
    public String row(int i) throws Exception {
        // Check if index i is in the valid range
        if ((i >= 0) && (i < this.height())) {
            if (i >= this.contents.height()) {
                // Return an appropriate length row of spaces
                return TBUtils.spaces(this.contents.width());
            } // if (row(i) is not in contents)
            else {
                // Return the row from contents
                return this.contents.row(i);
            } // else (row(i) is in contents)
        } // if (valid row)
        // Otherwise, throw an exceptino describing the error
        else throw new Exception("Invalid row " + i);
    } // row(int)

    /** Determine how many rows are in the block. */
    public int height() {
        return this.h;
    } // height()

    /** Determine how many columns are in the block. */
    public int width() {
        return this.contents.width();
    } // width() 
} // class TruncatedHeight