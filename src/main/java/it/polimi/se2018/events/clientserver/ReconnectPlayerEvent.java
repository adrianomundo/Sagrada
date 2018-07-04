package it.polimi.se2018.events.clientserver;

import it.polimi.se2018.events.Event;

public class ReconnectPlayerEvent implements Event {

    private static final long serialVersionUID = 39899084L;
    private int playerID;

    public ReconnectPlayerEvent(int playerID) {
        this.playerID = playerID;
    }

    public int getPlayerID() {
        return playerID;
    }
}