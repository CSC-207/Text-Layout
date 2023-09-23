import java.io.PrintWriter;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.3 of September 2019
 */
public class TBExpt {
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) throws Exception {
    // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);

    // Create a block to use
    TextBlock line1 = new TextLine("Hello");
    TextBlock line2 = new TextLine("Goodbye");
    
    TextBlock block1 = new BoxedBlock(line1);
    TextBlock block2 = new BoxedBlock(line2);
    
    TextBlock comp1 = new HComposition(block1, line2);

    TextBlock comp2 = new HComposition(block1, line2);
    
    TextBlock comp3 = new HComposition(block1, block2);

    TextBlock compBox = new BoxedBlock(comp1);

    
    // Print out the block
    TBUtils.print(pen, block1);
    TBUtils.print(pen, block2);
    
    
    TBUtils.print(pen, comp1);
    TBUtils.print(pen, comp2);

    TBUtils.print(pen, comp3);


    TBUtils.print(pen, compBox);

    TBUtils.print(pen, new Truncated(compBox, 50));
    TBUtils.print(pen, new Centered(compBox, 20));
    TBUtils.print(pen, new RightJustified(compBox, 20));

    TBUtils.print(pen, new VerticallyFlipped(compBox));
    TBUtils.print(pen, new HorizontallyFlipped(compBox));

    pen.println(TBUtils.equal(compBox, compBox));

    pen.println(TBUtils.equal(block1, new Truncated(block1, 8)));

    pen.println(TBUtils.eqv(block1, block2));

    pen.println(TBUtils.eqv(comp3, comp2));


    TBUtils.print(pen, new Centered(line1, 5));
    TBUtils.print(pen, new Centered(line1, 10));

    
    pen.println(line1.width());


    // Clean up after ourselves.
    pen.close();
  } // main(String[])

} // class TBExpt