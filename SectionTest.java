import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SectionTest tests the Section class.
 *
 * @author  Valerie Foster
 * @version 2/13/2018
 */
public class SectionTest {
    
    Section testSec;
    Paragraph para1;
    Paragraph para2;
    Paragraph para3;
    Paragraph para4;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        testSec = new Section();
        para1 = new Paragraph("This is a paragraph.", Paragraph.ParaStyle.LEFT);
        para2 = new Paragraph("This is a second paragraph.", Paragraph.ParaStyle.LEFT);
        para3 = new Paragraph("And here's another one.", Paragraph.ParaStyle.LEFT);
        para4 = new Paragraph("This is the last one.", Paragraph.ParaStyle.LEFT);
        testSec.addParagraph(para1);
        testSec.addParagraph(para2);
        testSec.addParagraph(para2);
        testSec.addParagraph(para4);
    }

    @Test
    public void testCount() {
        assertEquals(4, testSec.getParaCount());
    }
    
    @Test
    public void testAddAtPos() {
        Paragraph para = new Paragraph("This is an extra paragraph.", Paragraph.ParaStyle.LEFT);
        testSec.addAtPos(3, para);
        assertEquals(para, testSec.getParagraph(3));
    }
    
    @Test
    public void testRemove() {
        testSec.removeParagraph(1);
        assertEquals(3, testSec.getParaCount());
    }
    
}
