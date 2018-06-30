package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.model.Events.Event;

public class ReconnectionMsgEvent implements Event {

    private static final long serialVersionUID = 234567L;
    private int ID;
    private String name;

    public ReconnectionMsgEvent(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }
}
