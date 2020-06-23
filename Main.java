
/**
 * The Main class gives examples of output of the other classes in this project.
 *
 * @author  Valerie Foster
 * @version 2/13/2018
 */
public class Main {
    
    public static void main(String args[]) {
        Document testDoc = Document.getInstance();
        testDoc.newDoc("Cats vs. Dogs");
        
        Paragraph para1 = new Paragraph("Cats vs. Dogs: Which Pet Is Better?", Paragraph.ParaStyle.HEADING_1);
        
        Paragraph para2 = new Paragraph("Rate the Competitors", Paragraph.ParaStyle.HEADING_2);
        Paragraph para3 = new Paragraph("To determine which is the \"better\" pet, let's see how cats and dogs stack up in five categories: vision, smell, speed, endurance and intelligence.", Paragraph.ParaStyle.LEFT);
        
        Paragraph para4 = new Paragraph("Vision", Paragraph.ParaStyle.HEADING_4);
        Paragraph para5 = new Paragraph("Cats win this one. Both animals are predators, which means their visual acumen stresses movement over detail. Neither cats nor dogs are going to read the type on road signs, and their color vision isn’t as strong as ours, but a quick movement will get noticed even if it’s minor. But give the gold to the cats for their ability to see in far less light. When the mousies come out to play at dusk, the cats are ready for them. A twitch of a whisker or a tiny movement in the leaves can be seen in near-darkness.", Paragraph.ParaStyle.LEFT);
        
        Paragraph para6 = new Paragraph("Smell", Paragraph.ParaStyle.HEADING_4);
        Paragraph para7 = new Paragraph("Dogs even the score with their sense of smell. There’s a reason why you don’t see drug-sniffing cats, and it’s not just because cats aren’t exactly amenable to clocking in for a 9-to-5 shift at the police station. While cats have a better sense of smell than humans do — really, we’re pretty worthless in the nose department — the canine sense of smell is nothing short of astonishing. Most dogs have a face that’s really nothing but nose, and their ability to detect and distinguish odors is in the range of four times better than a cat’s.", Paragraph.ParaStyle.LEFT);
        
        Paragraph para8 = new Paragraph("Speed", Paragraph.ParaStyle.HEADING_4);
        Paragraph para9 = new Paragraph("Cats are natural sprinters, coiling and uncoiling their spines to blast off after prey or away from predators. For about the length of a suburban backyard, a cat can outrun and out jump a dog and can get over the fence before a dog can catch him. But that dash is going to take everything the cat has — he needs to rest after. Dogs such as Greyhounds can maintain speeds of 40 mph for a pretty good distance and can catch up to and pass a cat pretty quickly. Have to give this one to the dogs, by a nose.", Paragraph.ParaStyle.LEFT);
        
        Paragraph para10 = new Paragraph("Endurance", Paragraph.ParaStyle.HEADING_4);
        Paragraph para11 = new Paragraph("Dogs are natural marathoners, and a fit dog such as a working sled dog can cover ground at a trot for hours. The only endurance sport a cat would win is napping, since the overwhelming majority of the feline day planner is filled with a single notation: “Zzzzzzzzzz.” That’s not a dig on cats, though: When they need to hunt for food they don’t waste any time. They find, they kill, they eat … and they nap.", Paragraph.ParaStyle.LEFT);
        
        Paragraph para12 = new Paragraph("Intelligence", Paragraph.ParaStyle.HEADING_4);
        Paragraph para13 = new Paragraph("Cat lovers can argue very effectively that cats are smart enough to get people to feed and care for them with little more than purring in return. Measured that way, it’s hard to argue that dogs are smarter. But then you start listing all the jobs dogs have been trained to do, from smelling malignant tumors to taking down criminals, from finding and fetching birds to running an intricate agility course at top speed. And then there’s the matter of language recognition: Many dogs know more than 100 words, and a few know almost twice that many. Cats? If they know more than the words you use to call them for dinner, they’re not saying. Winner: dogs.", Paragraph.ParaStyle.LEFT);
        
        Section sec1 = new Section();
        sec1.addParagraph(para1);
        Section sec2 = new Section();
        sec2.addParagraph(para2);
        sec2.addParagraph(para3);
        Section sec3 = new Section();
        sec3.addParagraph(para4);
        sec3.addParagraph(para5);
        Section sec4 = new Section();
        sec4.addParagraph(para6);
        sec4.addParagraph(para7);
        Section sec5 = new Section();
        sec5.addParagraph(para8);
        sec5.addParagraph(para9);
        Section sec6 = new Section();
        sec6.addParagraph(para10);
        sec6.addParagraph(para11);
        Section sec7 = new Section();
        sec7.addParagraph(para12);
        sec7.addParagraph(para13);
        
        testDoc.addSection(sec1);
        testDoc.addSection(sec2);
        testDoc.addSection(sec3);
        testDoc.addSection(sec4);
        testDoc.addSection(sec5);
        testDoc.addSection(sec6);
        testDoc.addSection(sec7);
        
        testDoc.saveToHTML();
        
        System.out.println(testDoc);
    }
    
}
