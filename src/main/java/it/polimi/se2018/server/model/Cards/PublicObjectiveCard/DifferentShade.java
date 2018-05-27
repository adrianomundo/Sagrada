package it.polimi.se2018.server.model.Cards.PublicObjectiveCard;

import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Components.GlassBox;
import java.util.Iterator;
import static java.lang.Math.min;

/**
 * class used to count the number of points
 * @author Dario Miceli
 */

public class DifferentShade implements PublicEffects {

    /**
     *
     * @param pattern scheme card of a player
     * @return number of sets of one of each value multiplied by value of victory point
     */
    @Override
    public int RunPublic(PatternCard pattern){
        int points;
        int setOf1= 0;
        int setOf2 = 0;
        int setOf3 = 0;
        int setOf4 = 0;
        int setOf5 = 0;
        int setOf6 = 0;
        int temp1;
        int temp2;
        int temp3;
        int temp4;

        GlassBox box;

        Iterator<GlassBox> it = pattern.getPattern().iterator();
        while (it.hasNext()) {
            box = it.next();
            if (!box.isBoxEmpty()){
            if (box.getDice().getValue() == 1 ) {
                setOf1++;
            }
            if (box.getDice().getValue() == 2){
                setOf2++;
            }
            if (box.getDice().getValue() == 3 ) {
                setOf3++;
            }
            if (box.getDice().getValue() == 4){
                setOf4++;
            }
            if (box.getDice().getValue() == 5 ) {
                setOf5++;
            }
            if (box.getDice().getValue() == 6){
                setOf6++;
            }
            }
        }

        temp1 = min(setOf1, setOf2);
        temp2 = min(setOf3, setOf4);
        temp3 = min(setOf5, setOf6);
        temp4 = min(temp1, temp2 );
        points = min(temp3, temp4) * 5;

        return points;
    }

}