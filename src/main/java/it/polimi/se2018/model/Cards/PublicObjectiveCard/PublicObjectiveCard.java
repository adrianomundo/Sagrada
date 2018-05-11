package it.polimi.se2018.model.Cards.PublicObjectiveCard;

import it.polimi.se2018.model.Cards.PatternCard;

public class PublicObjectiveCard {
    private int vicoryPoint;
    private PublicEffects effect;

    public PublicObjectiveCard(PublicEffects effect) {
        this.effect = effect;
    }

    public int executeEffect(PatternCard pattern){
            return effect.RunPoint(pattern);
        }
}
