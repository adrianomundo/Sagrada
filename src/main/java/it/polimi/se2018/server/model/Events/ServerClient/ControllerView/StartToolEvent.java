package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.controller.ToolCard;
import it.polimi.se2018.server.model.Events.Event;

import java.util.List;

public class StartToolEvent implements Event {

    private static final long serialVersionUID = 390322L;
    private int id;
    private List<ToolCard> toolCardList;

    public StartToolEvent(int id, List<ToolCard> toolCardList) {
        this.id = id;
        this.toolCardList = toolCardList;
    }

    public int getId() {
        return id;
    }

    public List<ToolCard> getToolCardList() {
        return toolCardList;
    }
}