import java.io.Serializable;

/**
 * The class Section has a LinkedList of paragraphs and has methods to manipulate this list.
 *
 * @author  Valerie Foster
 * @version 2/13/2018
 */
public class Section implements Serializable {
    
    // instance variable
    private LinkedList<Paragraph> paraList;

    /**
     * Constructor for objects of class Section
     */
    public Section() {
        paraList = new LinkedList<Paragraph>();
    }

    /**
     * This method returns the size of the paraList
     *
     * @return      the size of the list
     */
    public int getParaCount() {
        return paraList.size();
    }
    
    /**
     * This method returns a paragraph at the given index
     *
     * @param   ind     the index of the paragraph to return
     * @return          the Paragraph at the given index
     */
    public Paragraph getParagraph(int ind) {
        return paraList.getElement(ind);
    }
    
    /**
     * This method adds the given paragraph at the end of the list
     *
     * @param   para    the Paragraph to add
     */
    public void addParagraph(Paragraph para) {
        paraList.addAtEnd(para);
    }
    
    /**
     * This method adds the given paragraph at the given index
     *
     * @param   ind     the index of where to add the paragraph
     * @param   para    the Paragraph to add
     */
    public void addAtPos(int ind, Paragraph para) {
        paraList.addAtPos(ind, para);
    }
    
    /**
     * This method removes a paragraph at the given index from the list
     *
     * @param   ind     the index of the paragraph the remove
     */
    public void removeParagraph(int ind) {
        paraList.remove(ind);
    }
    
    /**
     * This method takes a Paragraph as a parameter and if it finds it in the list it returns true and moves it up,
     * otherwise it returns false and does nothing
     *
     * @param   para    a Paragraph to move up in the list
     * @return          a boolean variable that expresses whether the given paragraph was moved up or not
     */
    public boolean moveUp(Paragraph para) {
        return paraList.moveUp(para);
    }
    
    /**
     * This method takes a Paragraph as a parameter and if it finds it in the list it returns true and moves it down,
     * otherwise it returns false and does nothing
     *
     * @param   para    a Paragraph to move down in the list
     * @return          a boolean variable that expresses whether the given paragraph was moved down or not
     */
    public boolean moveDown(Paragraph para) {
        return paraList.moveDown(para);
    }
    
    /** 
     * Creates and returns a string representation of this Section
     * 
     * @return  a String showing basic information about the section
     */
    @Override
    public String toString() {
        return paraList.toString();
    }
    
}
