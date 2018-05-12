package it.polimi.se2018.TestComponents;

import it.polimi.se2018.model.Components.Dice;
import it.polimi.se2018.model.Components.DiceBag;
import it.polimi.se2018.model.Components.DiceColor;
import it.polimi.se2018.model.Components.DraftPool;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestDraftPool {

    @Test
    public void testConstructor() {
        DiceBag diceBag = new DiceBag();

        DraftPool draftPool = new DraftPool(5, diceBag);

        assertEquals(11, draftPool.getNowNumber());
        assertEquals(79, diceBag.getListBag().size());

    }

    @Test
    public void testCleanListDice () {
        DiceBag diceBag = new DiceBag();

        DraftPool draftPool = new DraftPool(3, diceBag );
        ArrayList<Dice> listDice = draftPool.cleanListDice();

        assertEquals(0, draftPool.getDraftPool().size());
        assertEquals(7,listDice.size());
    }

    @Test
    public void testSetDice() {
        DiceBag diceBag = new DiceBag();
        DraftPool draftPool = new DraftPool(4, diceBag);
        Dice dice = new Dice(4, DiceColor.YELLOW);

        draftPool.setDice(dice);
        assertEquals(10, draftPool.getNowNumber());
    }

    @Test
    public void testConstructorDefault() {
        DraftPool draftPool = new DraftPool();

        assertEquals(null, draftPool.getDraftPool());
    }

}