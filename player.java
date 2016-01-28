

/**
 * Classical: player.java
 *
 * @version   $Id: player.java,v 1.0 11/23/2015 20:46:36 $
 *
 * @author Varun Dhingra
 */

import java.io.*;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Random;
import java.util.Scanner;


public class player extends Thread {
    String player_name;
    static final int port = 65281;
    Socket socket;
    int generatedNumber;

    /**
     * Player Constructor, initialized everytime a new player is instantialted
     *
     * @param player_name
     * @param
     */
    public player(String player_name) {
        this.player_name = player_name;
        this.generatedNumber = 0;
//        this.socket = socket;
    }

    @Override
    public String toString() {
        return "player{" +
                "player_name='" + player_name + '\'' +
                ", generatedNumber=" + generatedNumber +
                '}';
    }

    /**
     * This method will generate Random numbers and pass the number to the Constructor
     */
    public void generateRandom() {
        Random random = new Random();
        int min = 1;
        int max = 100;
        int randomNo;

        randomNo = random.nextInt((max - min) + 1) + min;
        this.generatedNumber = randomNo;


    }

    /**
     * Everytime, a new thread is started, random numbers are generated
     */
    public void run() {
//
        generateRandom();

    }

    /**
     * main will take player name and assign the name to the constructor and pass a delimited String value to the server.
     * It then reads from the result from the server and prints the result. This will happen for all player Objects
     *
     * @param args
     */
    public static void main(String args[]) {
        Controller controllerObject = new Controller();

        //System.out.println("Enter player name");
        Scanner scan = new Scanner(System.in);

        player p = null;
//        try {
            p = new player(controllerObject.getInputFromView());
//         p = new player(scan.nextLine(),new Socket(InetAddress.getLocalHost(),port));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        p.start();
        try {
            p.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String StatusString = p.player_name + "|" + p.generatedNumber + "|";
        // System.out.println("STATUS STRING === "+StatusString);

//        OutputStream out = null;
//        InputStream in = null;
//        byte bytearr[] = new byte[500]clear
// ;

        try {

            controllerObject.postResultToView("generated number " + p.generatedNumber);
//            ServerLogicInterface serverLogicInterface = (ServerLogicInterface) Naming.lookup("rmi://localhost:65281/RMIserver");
            ServerLogicInterface serverLogicInterface = (ServerLogicInterface) Naming.lookup("rmi://129.21.37.18:65281/RMIserver");
//            System.out.println(serverLogicInterface.separateData(StatusString));

            controllerObject.postResultToView(serverLogicInterface.separateData(StatusString));

            //System.out.println("generated number "+p.generatedNumber);
//            out = p.socket.getOutputStream();

//            out.write(StatusString.getBytes());
            //read from server
            //  System.out.println("response from server:");
//            in = p.socket.getInputStream();
//            DataInputStream dataInputStream=new DataInputStream(in);
//            dataInputStream.read(bytearr);
//            String str = new String(bytearr);

//            controllerObject.postResultToView(serverLogicInterface.separateData(StatusString));/////THIS NEEDS TO   CHANGE
            //System.out.println(str)


//        } catch (IOException e) {
//            e.printStackTrace();
//        }clear



//     System.out.println(p.player_name+"\t"+p.generatedNumber);
            //send to server

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

    }
}