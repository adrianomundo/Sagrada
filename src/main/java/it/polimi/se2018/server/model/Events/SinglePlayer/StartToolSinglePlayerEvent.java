package it.polimi.se2018.server.model.Events.SinglePlayer;

import it.polimi.se2018.server.controller.ToolCard;
import it.polimi.se2018.server.model.Events.Event;

import java.util.List;

public class StartToolSinglePlayerEvent implements Event {

    private static final long serialVersionUID = 49304903L;
    private List<ToolCard> toolCardList;
    private int poolSize;


    public StartToolSinglePlayerEvent(List<ToolCard> toolCards, int poolSize) {
        this.toolCardList = toolCards;
        this.poolSize = poolSize;
    }

    public List<ToolCard> getToolCardList() {
        return toolCardList;
    }

    public int getPoolSize() {
        return poolSize;
    }
}
