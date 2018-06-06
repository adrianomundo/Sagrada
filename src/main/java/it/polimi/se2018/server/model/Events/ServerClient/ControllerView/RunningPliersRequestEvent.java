package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.model.Events.Event;

public class RunningPliersRequestEvent implements Event {

    private static final long serialVersionUID = 777888L;
    private int id;
    private int poolSize;

    public RunningPliersRequestEvent(int id, int poolSize) {
        this.id = id;
        this.poolSize = poolSize;
    }

    public int getId() {
        return id;
    }

    public int getPoolSize() {
        return poolSize;
    }
}

