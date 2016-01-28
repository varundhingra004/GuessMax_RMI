/**
 * Classical: server.java
 *
 * @version   $Id: server.java,v 1.1 11/23/2015 20:46:36 $
 *
 * @author Varun Dhingra
 */

import java.io.*;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Server class is responsible for accepting client connections, calculating the winner and brodcasting the winners to the clients
 */
public class server {

    //    static ServerSocket server;
//    static Socket connect;
//    static final int port = 65281;
//    static final int no_of_players = 4;
//    static ArrayList<NameAndNumber> nameAndNumbers = new ArrayList<>(4);


    /**
     * Main accepts client connections, calculates the winner and posts the winners at the client side
     *
     * @param args
     */
    public static void main(String args[]) {

//        System.setProperty("java.rmi.server.hostname","10.59.5.141");
        System.setProperty("java.rmi.server.hostname","129.21.37.18");
        System.out.println("RMI DEFALUT HOST NAME "+System.getProperty("java.rmi.server.hostname"));


        try {
            ServerLogic serverLogicObject = new ServerLogic();
//            Naming.rebind("RMIserver", serverLogicObject);
            Naming.rebind("rmi://129.21.37.18:65281/RMIserver",serverLogicObject);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }
}


/**
 * Get incomming connections and calculate the highest score.
 */

//            int connections=0;

//            while(connections<no_of_players){
//                connect = server.accept();
//                InputStream inputStream = connect.getInputStream();
//                DataInputStream dataInputStream=new DataInputStream(inputStream);
//                byte[] data=new byte[100];
//                int totalRead = dataInputStream.read(data);

//        public void separateData(String data){
//            try{
//                String nameAndNumberString=new String(data);
//
//                String[] split = nameAndNumberString.split(NameAndNumber.DELIMETER);
//
//
//
//                NameAndNumber nameAndNumber=new NameAndNumber();
//                nameAndNumber.name=split[0];
//
//
//                nameAndNumber.number= Integer.parseInt(split[1]);
//
//
////                nameAndNumber.outputStream=connect.getOutputStream();
//                nameAndNumbers.add(nameAndNumber);
////                connections++;
//            }
//
//    public String calculateWinner(){
//
//            NameAndNumber winner=null;
//            for(NameAndNumber nameAndNumber: nameAndNumbers){
//                if(winner==null|| nameAndNumber.number>winner.number){
//                    winner=nameAndNumber;
//                }
//            }
//        String response;// = "";
//
////            for(NameAndNumber nameAndNumber: nameAndNumbers){
////                DataOutputStream dataOutputStream=new DataOutputStream(nameAndNumber.outputStream);
//                response = winner.name + " is the winner, got the highest number of " + winner.number;
//
////                dataOutputStream.write(response.getBytes());
//
////            }
//        return response;
//
//
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//
//
//
//    }

//}


//class NameAndNumber{
//    static String DELIMETER="\\|";
//    String name;
//    int number;
//
////    OutputStream outputStream;
//}
//
//class Controller{
//    UserInterface userInterface = new UserInterface();
//
//    public String getInputFromView() {
//        return userInterface.getInputFromUser();
//    }
//
//    public void postResultToView(String result)
//    {
//        userInterface.displayResultToUser(result);
//
//    }
//
//
//
//}