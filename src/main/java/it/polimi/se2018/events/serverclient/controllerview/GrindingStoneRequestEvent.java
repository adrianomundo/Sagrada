package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.events.Event;

/**
 * Class GrindingStoneRequestEvent: controller view event for Grinding Stone tool card request
 */
public class GrindingStoneRequestEvent implements Event {

    private static final long serialVersionUID = 576837L;
    private int id;
    private int poolSize;

    /**
     * class constructor with the id of the player and the size of the pool
     * @param id id of the player
     * @param poolSize size of the pool
     */
    public GrindingStoneRequestEvent(int id, int poolSize) {
        this.id = id;
        this.poolSize = poolSize;
    }

    /**
     * method that provides the caller the id of the player
     * @return id of the player
     */
    public int getId() {
        return id;
    }

    /**
     * method that provides the caller the size of the pool
     * @return size of the pool
     */
    public int getPoolSize() {
        return poolSize;
    }
}
