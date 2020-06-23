import java.io.Serializable;

/**
 * The class Paragraph keeps information about a paragraph, a String of text and a style from the embedded class Parastyle.
 * It has the basic accessor and mutator methods.
 *
 * @author  Valerie Foster
 * @version 2/13/2018
 */
public class Paragraph implements Serializable {
    
    // instance variables
    private String text;
    private ParaStyle style;

    /**
     * Constructor for objects of class Paragraph
     * 
     * @param   text    a String of text for the paragraph
     * @param   style   a ParaStyle for the style of the paragraph
     */
    public Paragraph(String text, ParaStyle style) {
        this.setText(text);
        this.setStyle(style);
    }
    
    /**
     * A mutator method - sets the text of the Paragraph to the given text
     *
     * @param   text    a String of text for the paragraph
     * @trows   IllegalArgumentException if the given text is null
     */
    public void setText(String text) {
        if (text == null) {
            throw new IllegalArgumentException("The text cannot be null.");
        }
        this.text = text;
    }

    /**
     * A mutator method - sets the style of the Paragraph to the given ParaStyle
     *
     * @param   style   a ParaStyle for the style of the paragraph
     */
    public void setStyle(ParaStyle style) {
        this.style = style;
    }
    
    /**
     * An accessor method - returns the text of this paragraph
     *
     * @return    a String of text
     */
    public String getText() {
        return this.text;
    }
    
    /**
     * An accessor method - returns the style of this paragraph
     *
     * @return    a ParaStyle for the style
     */
    public ParaStyle getStyle() {
        return this.style;
    }
    
    /** 
     * Creates and returns a string representation of this Paragraph
     * 
     * @return  a String showing basic information about the paragraph
     */
    @Override
    public String toString() {
        String str = "";
        str += "Text: " + text + "\n";
        str += "Style: " + style + "\n";
        return str;
    }
    
    public enum ParaStyle implements Serializable {
        LEFT, CENTER, RIGHT, BULLET_LIST, NUMBER_LIST, HEADING_1, HEADING_2, HEADING_3, HEADING_4
    }
    
}
