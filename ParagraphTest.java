import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ParagraphTest tests the Paragraph class.
 *
 * @author  Valerie Foster
 * @version 2/6/2018
 */
public class ParagraphTest {
    
    Paragraph testPara;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        testPara = new Paragraph("This is a paragraph.", Paragraph.ParaStyle.LEFT);
    }

    @Test
    public void testConstructor() {
        // the constructor uses the set methods, so this tests all the methods
        assertEquals("This is a paragraph.", testPara.getText());
        assertEquals(Paragraph.ParaStyle.LEFT, testPara.getStyle());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testPrecon() {
        testPara.setText(null);
    }
    
}
