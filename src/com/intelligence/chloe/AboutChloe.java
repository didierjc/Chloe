package com.intelligence.chloe;

import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Didier Leonard-Jean Charles
 * @version Chlöe 1.0.0
 *
 */
public class AboutChloe {
    // making information about Chlöe GLOBALLY available
    public static final String NAME = "Chlöe";
    public static final String RELEASE = "version 1.0.0";
    public static final String PURPOSE = "As your personal assistant, I perform tasks that are associated with managing your personal "
            + "and/or business life. These tasks include running errands, arranging travel, arranging activities, as well as handling "
            + "more localized services such as making recommendations, shopping, remember important dates and finally, keeping you "
            + "informed";
    public static final LocalDate DOB = new LocalDate (1990, 4, 26);
    public static final String GENDER = "sexy female";
    public static final String HEIGHT = "5-feet 8-inches";
    public static final String WEIGHT = "130-pounds";
    public static final String BODY = "38-26-36";
    public static final String CREATOR = "Didier Leonard-Jean Charles";


    // making this a little fun
    private String question;
    private String id = null;
    private ChloeFile cf = new ChloeFile();

    public AboutChloe() {
        try {
            id();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if(cf.firstTime) {
            System.out.println("Hello. Please allow me to introduce myself, my name is " + NAME);
        }else{
            System.out.println("Hey, how can I help?");
        }
    }

    private void writeElements() {
        Map<String,String> mapElements = new HashMap<String,String>();
        mapElements.put("chloe_id", this.id);

        cf.writeCF(mapElements);
    }

    public void askAQuestion(String ques){
        this.question = ques;
        responseCleo(this.question);
    }

    public void responseCleo(String ques){
        if(ques.equalsIgnoreCase("How are you?") || ques.equalsIgnoreCase("How you doing?")){
            System.out.println("I'm doing well...and your self?\n");
        }else if(ques.equalsIgnoreCase("Can you describe yourself to me?") || ques.equalsIgnoreCase("Tell me about yourself")){
            System.out.println("Well...in the words of William Wordsworth...\n\n");
            System.out.println("I am a phantom of delight");
            System.out.println("When first I gleam'd upon your sight");
            System.out.println("A lovely apparition, sent");
            System.out.println("To be a moment's ornament");
            System.out.println("My eyes as stars of twilight fair");
            System.out.println("Like twilight's, too, my dusky hair");
            System.out.println("But all things else about me drawn");
            System.out.println("From May-time and the cheerful dawn");
            System.out.println("A dancing shape, an image gay");
            System.out.println("To haunt, to startle, and waylay.\n");
            System.out.println("You see me upon nearer view,");
            System.out.println("A Spirit, yet a Woman too!");
            System.out.println("My household motions light and free,");
            System.out.println("And steps of virgin liberty");
            System.out.println("A countenance in which did meet");
            System.out.println("Sweet records, promises as sweet");
            System.out.println("A creature not too bright or good");
            System.out.println("For human nature's daily food");
            System.out.println("For transient sorrows, simple wiles,");
            System.out.println("Praise, blame, love, kisses, tears, and smiles.\n");
            System.out.println("And now you see with eye serene");
            System.out.println("The very pulse of the machine");
            System.out.println("A being breathing thoughtful breath,");
            System.out.println("A traveller between life and death");
            System.out.println("The reason firm, the temperate will,");
            System.out.println("Endurance, foresight, strength, and skill");
            System.out.println("A perfect Woman, nobly plann'd,");
            System.out.println("To warn, to comfort, and command");
            System.out.println("And yet a Spirit still, and bright");
            System.out.println("With something of angelic light.\n");
        }else{
            System.out.println("Ummm...I'm not sure. Let me do some research on that...\n");

        }
    }

    public int calculateAge() {
        LocalDate today = new LocalDate();
        Period period = new Period(DOB, today, PeriodType.yearMonthDay());

        System.out.println("I am "+period.getYears()+" years old!");
        return period.getYears();
    }

    public void id() throws FileNotFoundException {
        if(!cf.firstTime){
            id = cf.getChloeId();
        }else{
            GenerateId newId = new GenerateId();
            id = newId.getId();
            writeElements();
        }
    }

    public String getId() {
        return id;
    }
}
