package it.polimi.se2018.TestController;

import it.polimi.se2018.exceptions.InvalidMoveException;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.DarkShade;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.DiagonalColor;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.PublicObjectiveCard;
import it.polimi.se2018.server.model.Components.Dice;
import it.polimi.se2018.server.model.Components.DiceColor;
import it.polimi.se2018.server.model.Components.Player;
import it.polimi.se2018.server.controller.RoundManager;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class testRoundManager {

    @Test
    public void testCalculatePrivate() throws FileNotFoundException, InvalidMoveException {
        Player player = new Player();
        Player player1 = new Player();
        PrivateObjectiveCard privateObjectiveCard = new PrivateObjectiveCard(DiceColor.YELLOW);
        PrivateObjectiveCard privateObjectiveCard1 = new PrivateObjectiveCard(DiceColor.GREEN);
        player.setPrivate(privateObjectiveCard);
        player1.setPrivate(privateObjectiveCard1);
        PatternCard patternCard = new PatternCard();
        PatternCard patternCard1;
        PatternCard patternCard2;
        ArrayList<PatternCard> patternCardArrayList = patternCard.loadPatternList();
        patternCard1 = patternCardArrayList.get(0);
        patternCard2 = patternCardArrayList.get(1);
        Dice dice = new Dice(3, DiceColor.YELLOW);
        Dice dice1 = new Dice(4, DiceColor.GREEN);
        Dice dice2 = new Dice(5, DiceColor.BLUE);


        patternCard1.putDiceOnPattern(dice, 0, patternCard1);
        patternCard1.putDiceOnPattern(dice2, 1, patternCard1);
        patternCard1.putDiceOnPattern(dice1, 5, patternCard1);
        patternCard2.putDiceOnPattern(dice1, 4, patternCard2);
        patternCard2.putDiceOnPattern(dice1, 8, patternCard2);
        patternCard2.putDiceOnPattern(dice1, 12, patternCard2);

        player.setPattern(patternCard1);
        player1.setPattern(patternCard2);

        ArrayList<Player> players = new ArrayList<>();
        players.add(player);
        players.add(player1);

        ArrayList<Integer> result;
        RoundManager roundManager = new RoundManager();
        result = roundManager.calculatePrivate(players);

        assertEquals(3, player.getPrivatePoints());
        assertEquals(3, result.get(0).intValue());
        assertEquals(12, player1.getPrivatePoints());
        assertEquals(12, result.get(1).intValue());


    }

    @Test
    public void testCalculateTokens() {
        Player player = new Player();
        Player player1 = new Player();

        player.setTokensNumber(3);
        player1.setTokensNumber(1);

        ArrayList<Player> players = new ArrayList<>();
        players.add(player);
        players.add(player1);

        RoundManager roundManager = new RoundManager();
        ArrayList<Integer> result;
        result = roundManager.calculateTokens(players);

        assertEquals(3, result.get(0).intValue());
        assertEquals(1, result.get(1).intValue());
    }

    @Test
    public void testCalculatePublic() throws FileNotFoundException, InvalidMoveException {
        Player player = new Player();
        Player player1 = new Player();
        PrivateObjectiveCard privateObjectiveCard = new PrivateObjectiveCard(DiceColor.YELLOW);
        PrivateObjectiveCard privateObjectiveCard1 = new PrivateObjectiveCard(DiceColor.GREEN);
        player.setPrivate(privateObjectiveCard);
        player1.setPrivate(privateObjectiveCard1);
        PatternCard patternCard = new PatternCard();
        PatternCard patternCard1;
        PatternCard patternCard2;
        ArrayList<PatternCard> patternCardArrayList = patternCard.loadPatternList();
        patternCard1 = patternCardArrayList.get(0);
        patternCard2 = patternCardArrayList.get(1);
        Dice dice = new Dice(3, DiceColor.YELLOW);
        Dice dice1 = new Dice(4, DiceColor.GREEN);
        Dice dice2 = new Dice(5, DiceColor.BLUE);


        patternCard1.putDiceOnPattern(dice, 0, patternCard1);
        patternCard1.putDiceOnPattern(dice2, 1, patternCard1);
        patternCard1.putDiceOnPattern(dice1, 5, patternCard1);
        patternCard2.putDiceOnPattern(dice1, 4, patternCard2);
        patternCard2.putDiceOnPattern(dice1, 8, patternCard2);
        patternCard2.putDiceOnPattern(dice1, 12, patternCard2);

        player.setPattern(patternCard1);
        player1.setPattern(patternCard2);

        ArrayList<Player> players = new ArrayList<>();
        players.add(player);
        players.add(player1);

        ArrayList<PublicObjectiveCard> publicObjectiveCards = new ArrayList<>();
        PublicObjectiveCard publicObjectiveCard = new PublicObjectiveCard(new DiagonalColor());
        PublicObjectiveCard publicObjectiveCard1 = new PublicObjectiveCard(new DarkShade());

        publicObjectiveCards.add(publicObjectiveCard);
        publicObjectiveCards.add(publicObjectiveCard1);

        ArrayList<Integer> result;
        RoundManager roundManager = new RoundManager();
        result = roundManager.calculatePublic(players, publicObjectiveCards);

        assertEquals(0, result.get(0).intValue());
        assertEquals(3, result.get(1).intValue());


    }

    @Test
    public void testCalculateEmptyBox() throws FileNotFoundException, InvalidMoveException {
        Player player = new Player();
        Player player1 = new Player();

        PatternCard patternCard = new PatternCard();
        PatternCard patternCard1;
        PatternCard patternCard2;
        ArrayList<PatternCard> patternCardArrayList = patternCard.loadPatternList();
        patternCard1 = patternCardArrayList.get(0);
        patternCard2 = patternCardArrayList.get(1);
        Dice dice = new Dice(3, DiceColor.YELLOW);
        Dice dice1 = new Dice(4, DiceColor.GREEN);
        Dice dice2 = new Dice(5, DiceColor.BLUE);


        patternCard1.putDiceOnPattern(dice, 0, patternCard1);
        patternCard1.putDiceOnPattern(dice2, 1, patternCard1);
        //patternCard1.putDiceOnPattern(dice1, 5, patternCard1);
        patternCard2.putDiceOnPattern(dice1, 4, patternCard2);
        patternCard2.putDiceOnPattern(dice1, 8, patternCard2);
        patternCard2.putDiceOnPattern(dice1, 12, patternCard2);

        player.setPattern(patternCard1);
        player1.setPattern(patternCard2);

        ArrayList<Player> players = new ArrayList<>();
        players.add(player);
        players.add(player1);

        ArrayList<Integer> result;
        RoundManager roundManager = new RoundManager();
        result = roundManager.calculateEmptyBox(players);

        assertEquals(18, result.get(0).intValue());
        assertEquals(17, result.get(1).intValue());


    }
    @Test
    public void testCalculatePoints() throws FileNotFoundException, InvalidMoveException {
        Player player = new Player();
        Player player1 = new Player();
        PrivateObjectiveCard privateObjectiveCard = new PrivateObjectiveCard(DiceColor.YELLOW);
        PrivateObjectiveCard privateObjectiveCard1 = new PrivateObjectiveCard(DiceColor.GREEN);
        player.setPrivate(privateObjectiveCard);
        player1.setPrivate(privateObjectiveCard1);
        PatternCard patternCard = new PatternCard();
        PatternCard patternCard1;
        PatternCard patternCard2;
        ArrayList<PatternCard> patternCardArrayList = patternCard.loadPatternList();
        patternCard1 = patternCardArrayList.get(0);
        patternCard2 = patternCardArrayList.get(1);
        Dice dice = new Dice(3, DiceColor.YELLOW);
        Dice dice1 = new Dice(4, DiceColor.GREEN);
        Dice dice2 = new Dice(5, DiceColor.BLUE);


        patternCard1.putDiceOnPattern(dice, 0, patternCard1);
        patternCard1.putDiceOnPattern(dice2, 1, patternCard1);
        //patternCard1.putDiceOnPattern(dice1, 5, patternCard1);
        patternCard2.putDiceOnPattern(dice1, 4, patternCard2);
        patternCard2.putDiceOnPattern(dice1, 8, patternCard2);
        patternCard2.putDiceOnPattern(dice1, 12, patternCard2);

        player.setPattern(patternCard1);
        player1.setPattern(patternCard2);

        ArrayList<Player> players = new ArrayList<>();
        players.add(player);
        players.add(player1);

        ArrayList<PublicObjectiveCard> publicObjectiveCards = new ArrayList<>();
        PublicObjectiveCard publicObjectiveCard = new PublicObjectiveCard(new DiagonalColor());
        PublicObjectiveCard publicObjectiveCard1 = new PublicObjectiveCard(new DarkShade());

        publicObjectiveCards.add(publicObjectiveCard);
        publicObjectiveCards.add(publicObjectiveCard1);

        player.setTokensNumber(20);
        player1.setTokensNumber(20);

        RoundManager roundManager = new RoundManager();
        players = roundManager.calculatePoints(players, publicObjectiveCards);

        assertEquals(5, players.get(0).getFinalPoints());
        assertEquals(18, players.get(1).getFinalPoints());


    }

    @Test
    public void testCheckPoints() {
        Player player = new Player();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();

        player.setFinalPoints(100);
        player1.setFinalPoints(100);
        player2.setFinalPoints(100);
        player3.setFinalPoints(25);

        player.setPrivatePoints(25);
        player1.setPrivatePoints(30);
        player2.setPrivatePoints(35);
        player3.setPrivatePoints(35);

        player.setTokensNumber(2);
        player1.setTokensNumber(3);
        player2.setTokensNumber(4);
        player3.setTokensNumber(5);

        ArrayList<Player> playerArrayList = new ArrayList<Player>();
        playerArrayList.add(player);
        playerArrayList.add(player1);
        playerArrayList.add(player2);
        playerArrayList.add(player3);

        RoundManager roundManager = new RoundManager();
        playerArrayList = roundManager.checkPoints(playerArrayList);

        assertEquals(3, playerArrayList.get(1).getTokensNumber());
        assertEquals(4, playerArrayList.get(0).getTokensNumber());
        assertEquals(2, playerArrayList.get(2).getTokensNumber());
        assertEquals(5, playerArrayList.get(3).getTokensNumber());
    }

    @Test
    public void testCalculateWinner() throws InvalidMoveException, FileNotFoundException {
        Player player = new Player();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();

        PrivateObjectiveCard privateObjectiveCard = new PrivateObjectiveCard(DiceColor.YELLOW);
        PrivateObjectiveCard privateObjectiveCard1 = new PrivateObjectiveCard(DiceColor.GREEN);
        player.setPrivate(privateObjectiveCard);
        player1.setPrivate(privateObjectiveCard1);
        player2.setPrivate(privateObjectiveCard);
        player3.setPrivate(privateObjectiveCard1);
        PatternCard patternCard = new PatternCard();
        PatternCard patternCard1;
        PatternCard patternCard2;
        ArrayList<PatternCard> patternCardArrayList = patternCard.loadPatternList();
        patternCard1 = patternCardArrayList.get(0);
        patternCard2 = patternCardArrayList.get(1);
        Dice dice = new Dice(3, DiceColor.YELLOW);
        Dice dice1 = new Dice(4, DiceColor.GREEN);
        Dice dice2 = new Dice(5, DiceColor.BLUE);


        patternCard1.putDiceOnPattern(dice, 0, patternCard1);
        patternCard1.putDiceOnPattern(dice2, 1, patternCard1);
        //patternCard1.putDiceOnPattern(dice1, 5, patternCard1);
        patternCard2.putDiceOnPattern(dice1, 4, patternCard2);
        patternCard2.putDiceOnPattern(dice1, 8, patternCard2);
        patternCard2.putDiceOnPattern(dice1, 12, patternCard2);

        player.setPattern(patternCard1);
        player1.setPattern(patternCard2);
        player2.setPattern(patternCard1);
        player3.setPattern(patternCard2);

        ArrayList<Player> players = new ArrayList<>();
        players.add(player);
        players.add(player1);
        players.add(player2);
        players.add(player3);

        ArrayList<PublicObjectiveCard> publicObjectiveCards = new ArrayList<>();
        PublicObjectiveCard publicObjectiveCard = new PublicObjectiveCard(new DiagonalColor());
        PublicObjectiveCard publicObjectiveCard1 = new PublicObjectiveCard(new DarkShade());

        publicObjectiveCards.add(publicObjectiveCard);
        publicObjectiveCards.add(publicObjectiveCard1);

        player.setTokensNumber(20);
        player1.setTokensNumber(21);
        player2.setTokensNumber(22);
        player3.setTokensNumber(23);

        RoundManager roundManager = new RoundManager();
        players = roundManager.calculateWinner(players, publicObjectiveCards);

        assertEquals(23, players.get(0).getTokensNumber());
        assertEquals(21, players.get(1).getTokensNumber());
        assertEquals(22, players.get(2).getTokensNumber());
        assertEquals(20, players.get(3).getTokensNumber());

    }
}