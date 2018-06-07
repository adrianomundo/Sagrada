package it.polimi.se2018.server.model.Events.SinglePlayer;

import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Events.Event;

import java.util.List;

public class SinglePrivateEvent implements Event {

    private static final long serialVersionUID = 384934L;
    private List<PrivateObjectiveCard> privateList;

    public SinglePrivateEvent(List<PrivateObjectiveCard> privateList) {
        this.privateList = privateList;
    }

    public List<PrivateObjectiveCard> getPrivateList() {
        return privateList;
    }


}
