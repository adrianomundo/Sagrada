package it.polimi.se2018.server.model.Cards.PublicObjectiveCard;

import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Components.GlassBox;
import static java.lang.Math.min;

import java.io.Serializable;
import java.util.Iterator;

/**
 * class used to count the number of points
 * @author Dario Miceli
 */
public class MediumShade implements PublicEffects, Serializable {

    private static final int VPOINTS = 2;
    private static final String NAME = "Medium Shades";

    @Override
    public int runPublic(PatternCard pattern){
        int points;
        int setOf3= 0;
        int setOf4 = 0;
        GlassBox box;

        Iterator<GlassBox> it = pattern.getPattern().iterator();
        while (it.hasNext()) {
            box = it.next();
            if(!box.isBoxEmpty()) {
                if (box.getDice().getValue() == 3) {
                    setOf3++;
                }
                if (box.getDice().getValue() == 4) {
                    setOf4++;
                }
            }
        }
        points = min(setOf3, setOf4);
        points = points * VPOINTS;

        return points;
    }

    @Override
    public String toString(){
        return NAME + "\n"
                + "Sets of 3 & 4 values anywhere" + "\n"
                + "VP : " + VPOINTS;
    }

    public static String getNAME() {
        return NAME;
    }

}

