package it.polimi.se2018.events;

public class InvalidMoveEvent implements Event {

    private static final long serialVersionUID = 329239320L;
    private String errorMsg;
    private int id;

    public InvalidMoveEvent(String errorMsg,int id) {
        this.errorMsg = errorMsg;
        this.id = id;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public int getId() {
        return id;
    }
}