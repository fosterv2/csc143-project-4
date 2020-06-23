import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.io.Serializable;

/**
 * The class Document has a name and a LinkedList od Sections. It has methods to maipulate the LinkedList, and also methods to open, close,
 * save, and save to HTML Documents with the condition that only one Document can be open at a time.
 *
 * @author  Valerie Foster
 * @version 2/13/2018
 */
public class Document implements Serializable{

    private static Document instance = null;

    // instance variables
    private String name;
    private LinkedList<Section> secList;

    /**
     * Private constructor for class Section desigened to defeat instantiation
     */
    private Document() {
        
    }

    /**
     * This method returns the size of the secList
     *
     * @return      the size of the list
     */
    public int getSecCount() {
        return secList.size();
    }

    /**
     * This method returns a section at the given index
     *
     * @param   ind     the index of the section to return
     * @return          the Section at the given index
     */
    public Section getSection(int ind) {
        return secList.getElement(ind);
    }

    /**
     * This method adds the given secton at the end of the list
     *
     * @param   para    the Section to add
     */
    public void addSection(Section sec) {
        secList.addAtEnd(sec);
    }

    /**
     * This method adds the given section at the given index
     *
     * @param   ind     the index of where to add the section
     * @param   para    the Section to add
     */
    public void addAtPos(int ind, Section sec) {
        secList.addAtPos(ind, sec);
    }

    /**
     * This method removes a section at the given index from the list
     *
     * @param   ind     the index of the section the remove
     */
    public void removeSection(int ind) {
        secList.remove(ind);
    }

    /**
     * This method takes a Section as a parameter and if it finds it in the list it returns true and moves it up,
     * otherwise it returns false and does nothing
     *
     * @param   para    a Section to move up in the list
     * @return          a boolean variable that expresses whether the given section was moved up or not
     */
    public boolean moveUp(Section sec) {
        return secList.moveUp(sec);
    }

    /**
     * This method takes a Secton as a parameter and if it finds it in the list it returns true and moves it down,
     * otherwise it returns false and does nothing
     *
     * @param   para    a Section to move down in the list
     * @return          a boolean variable that expresses whether the given section was moved down or not
     */
    public boolean moveDown(Section sec) {
        return secList.moveDown(sec);
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static Document getInstance() {
        if (instance == null) {
            instance = new Document();
        }
        return instance;
    }
    
    /**
     * This method determines if there is a Document open or not
     *
     * @return      true if there is an open document or false if there is not
     */
    public boolean isOpen() {
        return name != null;
    }

    /**
     * This method creates a new document with the given name
     *
     * @param   name    a String name for the Document
     * @throws          IllegalStateException if there is already a Document open
     * @throws          IllegalArgumentException if the name is null or empty
     */
    public void newDoc(String name) {
        if (isOpen()) {
            throw new IllegalStateException("A new document cannot be opened when there is another one open.");
        }
        if (name == null || name == "") {
            throw new IllegalArgumentException("The name cannot be null or empty.");
        }
        this.name = name;
        secList = new LinkedList<Section>();
    }

    /**
     * This method saves the currently open document via serialization
     *
     * @throws  IllegalStateException if there is not an open document
     * @throws  FileNotFoundException, IOException if something goes wrong with the serialization
     */
    public void saveDoc() {
        if (!isOpen()) {
            throw new IllegalStateException("There is no document open, so there is nothing to save.");
        }
        try {
            FileOutputStream docFile = new FileOutputStream(name + ".wpd");
            ObjectOutputStream out = new ObjectOutputStream(docFile);
            out.writeObject(getSecCount());
            for (int ind = 1; ind <= getSecCount(); ind++) {
                out.writeObject(getSection(ind));
            }
            out.close();
            docFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("problem 1");
        } catch (IOException e) {
            System.out.println("problem 2");
        }
    }

    /**
     * This method saves the currently open document via serialization then clears the instance variable
     * 
     * @throws  IllegalStateException if there is not an open document
     */
    public void closeDoc() {
        if (!isOpen()) {
            throw new IllegalStateException("There is no document open, so there is nothing to save.");
        }
        name = null;
        secList = null;
        instance = null;
    }

    /**
     * This method opens a previously closed document with the given name via deserialization
     *
     * @param   name    a String name for the Document
     * @throws          IllegalStateException if there is already a Document open
     */
    public void openDoc(String name) {
        if (isOpen()) {
            throw new IllegalStateException("A different document cannot be opened when there is another one open.");
        }
        this.name = name;
        secList = new LinkedList<Section>();
        try {
            FileInputStream docFile = new FileInputStream(name + ".wpd");
            ObjectInputStream in = new ObjectInputStream(docFile);
            int secCount = (int)in.readObject();
            for (int ind = 1; ind <= secCount; ind++) {
                Section sec = (Section)in.readObject();
                addSection(sec);
            }
            in.close();
            docFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("problem 3");
        } catch (IOException e) {
            System.out.println("problem 4");
        } catch (ClassNotFoundException e) {
            System.out.println("problem 5");
        }
    }

    /**
     * This method writes the currently open document to a file with html tags so that the file will be a readable html file
     *
     * @throws  IllegalStateException if there is not an open document
     * @throws  FileNotFoundException if something goes wrong with writing to a file
     */
    public void saveToHTML() {
        if (!isOpen()) {
            throw new IllegalStateException("There is no document open, so there is nothing to save.");
        }
        try {
            PrintStream output = new PrintStream(new File(name + ".html"));
            output.println("<!DOCTYPE html>");
            output.println("<html>");
            output.println("<body>");
            for (int sec = 1; sec <= instance.getSecCount(); sec++) {
                Section section = instance.getSection(sec);
                for (int para = 1; para <= section.getParaCount(); para++) {
                    switch (section.getParagraph(para).getStyle()) {
                        case BULLET_LIST:
                        case NUMBER_LIST:
                        case LEFT:
                        output.println("<p style=\"text-align:left\">");
                        output.println(section.getParagraph(para).getText());
                        output.println("</p>");
                        break;
                        case CENTER:
                        output.println("<p style=\"text-align:center\">");
                        output.println(section.getParagraph(para).getText());
                        output.println("</p>");
                        break;
                        case RIGHT:
                        output.println("<p style=\"text-align:right\">");
                        output.println(section.getParagraph(para).getText());
                        output.println("</p>");
                        break;
                        case HEADING_1:
                        output.println("<h1>");
                        output.println(section.getParagraph(para).getText());
                        output.println("</h1>");
                        break;
                        case HEADING_2:
                        output.println("<h2>");
                        output.println(section.getParagraph(para).getText());
                        output.println("</h2>");
                        break;
                        case HEADING_3:
                        output.println("<h3>");
                        output.println(section.getParagraph(para).getText());
                        output.println("</h3>");
                        break;
                        case HEADING_4:
                        output.println("<h4>");
                        output.println(section.getParagraph(para).getText());
                        output.println("</h4>");
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
        }
    }

    /** 
     * Creates and returns a string representation of this Document
     * 
     * @return  a String showing basic information about the document
     */
    @Override
    public String toString() {
        String str = "";
        str += "Name: " + name + "\n";
        str += secList.toString();
        return str;
    }

}
