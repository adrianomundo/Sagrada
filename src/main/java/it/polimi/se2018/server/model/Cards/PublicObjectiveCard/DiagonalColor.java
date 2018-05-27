package it.polimi.se2018.server.model.Cards.PublicObjectiveCard;

import it.polimi.se2018.server.model.Cards.PatternCard;

import java.util.Arrays;

/**
 * Class DiagonalColor: Public Objective Card
 * @author Salvatrore Fadda
 */
public class DiagonalColor implements PublicEffects {


   @Override
   public int RunPublic(PatternCard pattern) {
      int points = 0;
      boolean[] control = new boolean[20];
      Arrays.fill(control, Boolean.FALSE);
      for (int i = 0; i < 15; i = i + 5) {
         for (int j = 0; j < 4; j++) {
            if (!(pattern.getPattern().get(i + j).isBoxEmpty() || pattern.getPattern().get(i + j + 6).isBoxEmpty())) {
               if ((pattern.getPattern().get(i + j).getDice().getColor() == pattern.getPattern().get(i + j + 6).getDice().getColor())) {
                  control[i + j] = true;
                  control[i + j + 6] = true;
               }
            }

         }

      }
      for (int i = 1; i < 15; i = i + 5) {
         for (int j = 0; j < 4; j++) {
            if (!(pattern.getPattern().get(i + j).isBoxEmpty() || pattern.getPattern().get(i + j + 4).isBoxEmpty())) {
               if ((pattern.getPattern().get(i + j).getDice().getColor() == pattern.getPattern().get(i + j + 4).getDice().getColor())) {
                  control[i + j] = true;
                  control[i + j + 4] = true;
               }
            }
         }
      }
      for (int i = 0; i < 20; i++) {
         if (control[i]) {
            points++;
         }
      }

      return points;
   }
}



