package it.polimi.se2018.client.network.socket;

import it.polimi.se2018.client.ClientInterface;
import it.polimi.se2018.client.view.View;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Events.ClientServer.*;
import it.polimi.se2018.server.model.Events.Event;
import it.polimi.se2018.server.model.Events.ServerClient.ControllerView.*;
import it.polimi.se2018.server.model.Events.ServerClient.ModelView.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.rmi.RemoteException;

// this class must do:
// create the new socket connection and get the input/output stream
// method run, waiting to read the object from the server and
// call the readEvent, depending on the runtime types, that it's responsible to set it to the Client View
// method sendEvent, it's responsible of sending the object using socket across the network
// override of the methods of the clientInterface, that could be callable from the Client (aka socketClientImpl)

public class SocketHandler implements ClientInterface, Runnable {

    private Socket clientConnection;
    private ObjectInputStream socketIn;
    private ObjectOutputStream socketOut;
    private View view;

    public SocketHandler(String host, int port, View view) {

        try {
            this.clientConnection = new Socket(host, port);
            //this.socketIn = new ObjectInputStream(clientConnection.getInputStream());
            //socketOut = new ObjectOutputStream(clientConnection.getOutputStream());
            this.view = view;

            //new Thread(this).start();

        }
        catch (IOException e) {
            System.out.println("Connection error socket");
            e.printStackTrace();
        }

    }

    /**
     * The method run represent the Socket Handler Input mode, this is a thread that generate a loop waiting
     * for new object input to read, then call the method responsible for the proper behaviour, catch IOException
     * and ClassNotFoundException if something goes wrong.
     * @author adrianomundo
     */

    @Override
    public void run() {

        System.out.println("Listen the event from the server");
        boolean loop = true;

        while (loop) {

            try {

                socketIn = new ObjectInputStream(clientConnection.getInputStream());
                Object object = socketIn.readObject();

                if (object instanceof Event) {
                    readEvent((Event) object);
                }
                else {
                    System.out.println("Not received an object");
                }

            }
            catch (IOException e) {
                System.out.println("Error in I/O socket");
                e.printStackTrace();
            }
            catch (ClassNotFoundException e) {
                System.out.println("Error loading class socket");
                e.printStackTrace();
            }
        }

    }

    // metodo per leggere evento chiamato dal socket INPUT e in base all'evento fare la cosa giusta
    public void readEvent(Event event) {

        if (event instanceof PlayerIDEvent) {
            view.setPlayerID(((PlayerIDEvent) event).getPlayerID());
            System.out.println("Player id set " + view.getPlayerID());

        }
        else if (event instanceof PlayerNameUpdateEvent) {

            if ((view.getPlayerID()) == (((PlayerNameUpdateEvent) event).getID())) {
               view.setNameView(((PlayerNameUpdateEvent) event).getName());
               System.out.println("Name set" + view.getPlayerName());
            }
            else {
                System.out.println("Other name" + ((PlayerNameUpdateEvent) event).getName());
            }
        }

        else if (event instanceof GameStartedEvent) {
            view.setStarted(((GameStartedEvent) event).isStarted());
            System.out.println("Game started: " + view.isStarted());
            view.showNameChoose();
        }

        else if (event instanceof PlayerPrivateUpdateEvent) {

            if((view.getPlayerID()) == ((PlayerPrivateUpdateEvent) event).getID()) {
                view.showPrivateCard(((PlayerPrivateUpdateEvent) event).getCard());
            }
        }

        else if (event instanceof StartPatternEvent) {

            if((view.getPlayerID()) == ((StartPatternEvent) event).getID()) {
                view.showPatternList(((StartPatternEvent) event).getPatternListEvent());
            }

        }

        else if (event instanceof PublicDrawEvent) {

            view.showPublicCard(((PublicDrawEvent) event).getCard());
        }

        else if (event instanceof PlayerPatternUpdateEvent) {

            if((view.getPlayerID()) == ((PlayerPatternUpdateEvent) event).getID()) {
                view.showPattern(((PlayerPatternUpdateEvent) event).getCard());
            }
        }

        else if (event instanceof PlayerTokensUpdateEvent) {

            if ((view.getPlayerID()) == ((PlayerTokensUpdateEvent) event).getID()) {
                view.showTokens(((PlayerTokensUpdateEvent) event).getTokensNumber());
            }
        }

        else if (event instanceof StartRoundEvent) {

            view.showCurrentRound(((StartRoundEvent) event).getRound());
        }

        else if (event instanceof StartTurnEvent) {

            if ((view.getPlayerID()) == ((StartTurnEvent) event).getID()) {
                view.showCurrentTurn();
            }

            else {
                view.showOtherCurrentTurn(((StartTurnEvent) event).getName());
            }
        }

        else if (event instanceof RollDraftPoolEvent) {

            if ((view.getPlayerID()) == ((RollDraftPoolEvent) event).getId()) {
                view.showRollCommand();
            }
        }

        else if (event instanceof PlayerDraftPoolUpdateEvent) {

            view.showDraftPool(((PlayerDraftPoolUpdateEvent) event).getDraftPool());
        }

        else if (event instanceof StartMoveEvent) {

            if ((view.getPlayerID()) == ((StartMoveEvent) event).getID()) {
                view.showMoveCommand();
            }
        }

        else if (event instanceof PatternUpdateEvent) {

            if((view.getPlayerID()) == ((PatternUpdateEvent) event).getID()) {
                view.showPatternUpdate(((PatternUpdateEvent) event).getPatternCard());
            }
            else {
                view.showOtherPattern(((PatternUpdateEvent) event).getPatternCard(), ((PatternUpdateEvent) event).getName());
            }

        }

        else if (event instanceof RoundTrackerUpdateEvent) {

            view.showRoundTracker(((RoundTrackerUpdateEvent) event).getRoundTracker());
        }

        else if (event instanceof TurnPatternEvent) {

            if((view.getPlayerID()) == ((TurnPatternEvent) event).getID()) {
                view.showPatternUpdate(((TurnPatternEvent) event).getPatternCard());
            }
        }

        else if (event instanceof StartToolEvent) {

            if((view.getPlayerID()) == ((StartToolEvent) event).getId()) {
                view.showToolCommand();
            }

        }

        else if (event instanceof PlayerPointsUpdateEvent) {

            view.showFinalRank(((PlayerPointsUpdateEvent) event).getPlayerList());
        }

        else if (event instanceof WinnerEvent) {

            if ((view.getPlayerID()) == ((WinnerEvent) event).getID()) {
                view.showWinner();
            } else {
                view.showLosers();
            }
        }

        else {
            System.out.println("Not understood the message");
        }
    }


    /**
     * sendEvent represent the Socket Handler Output mode, it is used to send the event invoked by the client
     * across the network, catch IOException if something goes wrong
     * @param event
     * @author adrianomundo
     *
     */
    public synchronized void sendEvent(Event event) {

        try {
            socketOut = new ObjectOutputStream(clientConnection.getOutputStream());
            socketOut.writeObject(event);
            socketOut.flush();
        }
        catch (IOException e) {
            System.out.println("Error in writing object in socket");
            e.printStackTrace();
        }
    }







    // ----socket client impl----------------override methods callable by the client------------------------------


    @Override
    public void setPlayerNameToServer(String name, int id) {
        sendEvent(new PlayerNameEvent(name, id));
        //System.out.println("sto chiedendo di impostare" + name + "come id" + id);
    }

    @Override
    public void setPatternCardToServer(PatternCard patternCard, int id) {
        sendEvent(new PlayerPatternEvent(id, patternCard));

    }

    @Override
    public void setDraftPoolToServer() {
        sendEvent(new PlayerDraftPoolEvent());
    }

    @Override
    public void setMoveToServer(int indexPool, int indexPattern) {
        sendEvent(new PlayerMoveEvent(indexPool, indexPattern));
    }

    @Override
    public void setStartToolToServer() {
        sendEvent(new PlayerStartToolEvent());
    }

    @Override
    public void setNextTurnToServer() {
        sendEvent(new PlayerNextTurnEvent());
    }
}
