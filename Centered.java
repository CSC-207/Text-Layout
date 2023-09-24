/**
 * Given a text block and a width, builds a new block that
 * centers the block within that width.
 * 
 * @author Albert-Kenneth Okine
 */
public class Centered implements TextBlock {
    // +--------+---------------------------------------------------------
    // | Fields |
    // +--------+---------------------------------------------------------

    /** The stuff in the box */
    TextBlock contents;
    /** The width of the box */
    int w;

    // +--------------+---------------------------------------------------
    // | Constructors |
    // +--------------+---------------------------------------------------

    /** Build a new block with contents _contents and width `w` */
    public Centered(TextBlock _contents, int _w) {
        this.contents = _contents;
        this.w = _w;
    } // Centered(TextBlock, int)

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
        if ((i >= 0) && (i < this.contents.height())) {
            if (this.contents.width() >= this.w) {
                // Extract an appropriate length substring of the row
                return this.contents.row(i).substring(0, this.w);
            } // if (contents' width is greater than this.w)
            else {
                // Determine the number of spaces to pad the row
                int n = (this.w - this.contents.width()) / 2;
                // Pad the row and return the centered string
                return ((this.w - this.contents.width()) % 2 == 1)
                    ? TBUtils.spaces(n+1) + this.contents.row(i) + TBUtils.spaces(n)
                    : TBUtils.spaces(n) + this.contents.row(i) + TBUtils.spaces(n);
            } // else
        } // if (valid row)
        // Otherwise, throw an exception describing the error
        else throw new Exception("Invalid row " + i);
    } // row(int)

    /** Determine how many rows are in the block. */
    public int height() {
        return this.contents.height();
    } // height()

    /** Determine how many columns are in this block. */
    public int width() {
        return this.w;
    } // width()
} // class Centered