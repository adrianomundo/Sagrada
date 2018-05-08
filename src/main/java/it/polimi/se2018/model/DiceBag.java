package it.polimi.se2018.model;




import java.util.Collections;
import java.util.Random;
import java.util.ArrayList;

public class DiceBag {
    private final int TOP = 0;
    private final int MAX_VALUE = 6;
    private final int NUMBER = 90;
    private Dice dice;
    private ArrayList<Dice> listDice;
    private int value;
    private DiceColour colour;
//gestione eccezioni da dichiarare e controlli da fare


    public DiceBag() {
        this.listDice = new ArrayList<Dice>();

        //creazione dadi casuali, 18 per ogni colore
        Random random = new Random();
        for (int i = 0; i < (NUMBER / 5); i++) {

            this.listDice.add(dice = new Dice(value = random.nextInt(MAX_VALUE) + 1, colour = DiceColour.YELLOW));
            this.listDice.add(dice = new Dice(value = random.nextInt(MAX_VALUE) + 1, colour = DiceColour.PURPLE));
            this.listDice.add(dice = new Dice(value = random.nextInt(MAX_VALUE) + 1, colour = DiceColour.RED));
            this.listDice.add(dice = new Dice(value = random.nextInt(MAX_VALUE) + 1, colour = DiceColour.GREEN));
            this.listDice.add(dice = new Dice(value = random.nextInt(MAX_VALUE) + 1, colour = DiceColour.BLUE));
        }

        /*controllo numero elementi
        if (listDice.size() == NUMBER)
        ....... */

        //mischio la Bag
        Collections.shuffle(this.listDice);


    }

    //ritorna l'arraylist associatio alla Bag

    public ArrayList<Dice> getListBag() {

        return listDice;
    }

    //restituisce e rimuove un dado dalla dicebag
    public Dice getDice() {
        dice = listDice.remove(TOP);
        return dice;
    }

    //aggiunge un dado alla dicebag e la mischia
    public void setDice(Dice dice) {
        listDice.add(dice);
        Collections.shuffle(listDice);
    }

}
