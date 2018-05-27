package it.polimi.se2018.client;

import it.polimi.se2018.client.network.rmi.RmiHandler;
import it.polimi.se2018.client.network.socket.SocketHandler;
import it.polimi.se2018.client.view.CliView;
import it.polimi.se2018.client.view.View;
import it.polimi.se2018.server.network.socket.SocketServerInterface;

import java.util.Scanner;

public class Client {

    private static final int SOCKETPORT = 8888;
    private  static final String host = "localhost";
    private static SocketHandler serverSocket;
    private static RmiHandler serverRmi;

    public static void main(String[] args) {

        System.out.println("Welcome to the game of SAGRADA");
        Scanner reader = new Scanner(System.in);

        System.out.println("Enter your username");
        String username = reader.nextLine();

        System.out.println("How do you prefer to play: GUI or CLI?");
        String textView = reader.nextLine();
        View view;

        if (textView.equalsIgnoreCase("Gui")) {

            // TODO correct this
            view = new CliView(reader, username);

        }

        else if (textView.equalsIgnoreCase("Cli")){

            view = new CliView(reader, username);

        }

        else {
            reader.close();
            // TODO correct this
            view = new CliView(reader, username); // sistemare in modo che viewReal sia inizializzata
        }

        System.out.println("Enter the IP address of the Server");

        System.out.println("Choose the connection type:Socket or RMI?");
        String connectionType = reader.nextLine();

        if (connectionType.equalsIgnoreCase("Socket")) {

            serverSocket = new SocketHandler(host, SOCKETPORT, view);

            // non so se necessario
            view.setConnection(serverSocket);

            //decidere se così o dentro sockethandler
            Thread socketThread = new Thread(serverSocket);
            socketThread.start();

            // start of the thread of the selected view
            Thread viewThread = new Thread(view);
            viewThread.start();


        }

        else if (connectionType.equalsIgnoreCase("Rmi")) {

            serverRmi = new RmiHandler();
        }
        else {
            reader.close();
        }


        System.out.println("Enter the gameplay mode: Single or Multi?");
        String mode = reader.nextLine();

        if (mode.equalsIgnoreCase("single")) {

        }

        else if (mode.equalsIgnoreCase("multi")) {

        }

        else {
            reader.close();
        }
    }
}
