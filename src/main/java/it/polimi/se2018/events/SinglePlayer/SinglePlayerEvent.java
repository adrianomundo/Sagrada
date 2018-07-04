package it.polimi.se2018.events.SinglePlayer;

import it.polimi.se2018.events.Event;

public class SinglePlayerEvent implements Event {

    private static final long serialVersionUID = 489348;
    private int id;
    private boolean singlePlayer;

    public SinglePlayerEvent(int id, boolean singlePlayer) {
        this.id = id;
        this.singlePlayer = singlePlayer;
    }

    public boolean isSinglePlayer() {
        return singlePlayer;
    }

    public int getId() {
        return id;
    }
}