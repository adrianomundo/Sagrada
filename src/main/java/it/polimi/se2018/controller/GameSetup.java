package it.polimi.se2018.controller;


import it.polimi.se2018.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.model.Cards.PublicObjectiveCard.*;
import it.polimi.se2018.model.Components.DiceColor;

import java.util.ArrayList;

public class GameSetup {
    private Game game;

    private GameSetup(Game game){
        this.game = game;
    }

    protected void setupPlayer(int ID){
//setta i player della partita con i rispettivi dati e li aggiunge nel vettore dei player presente in model
    }

    protected void numberOfPlayers(){
        int n;
        n = game.getModel().getPlayerList().size();
        game.getModel().setNumberPlayer(n);

    }

    protected ArrayList<PrivateObjectiveCard> loadPrivate(){
        ArrayList<PrivateObjectiveCard> list = new ArrayList<>();
        list.add(new PrivateObjectiveCard(DiceColor.BLUE));
        list.add(new PrivateObjectiveCard(DiceColor.RED));
        list.add(new PrivateObjectiveCard(DiceColor.GREEN));
        list.add(new PrivateObjectiveCard(DiceColor.PURPLE));
        list.add(new PrivateObjectiveCard(DiceColor.YELLOW));
        return list;

    }

    protected ArrayList<PublicObjectiveCard> loadPublic(){
        ArrayList<PublicObjectiveCard> list = new ArrayList<>();
        list.add(new PublicObjectiveCard(new DarkShade()));
        list.add(new PublicObjectiveCard(new DiagonalColor()));
        list.add(new PublicObjectiveCard(new DifferentColorColumn()));
        list.add(new PublicObjectiveCard(new DifferentColorRow()));
        list.add(new PublicObjectiveCard(new DifferentShade()));
        list.add(new PublicObjectiveCard(new DifferentShadeRow()));
        list.add(new PublicObjectiveCard(new DifferentShadeColumn()));
        list.add(new PublicObjectiveCard(new LightShade()));
        list.add(new PublicObjectiveCard(new MediumShade()));
        list.add(new PublicObjectiveCard(new VarietyColor()));
        return list;
    }

    protected void setPatternCard(){
        //chiama al suo interno drow pattern e aspetta le risposte per settare le pattern al singolo player
    }







}
