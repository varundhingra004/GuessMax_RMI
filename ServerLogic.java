import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Classical: ServerLogic.java
 *
 * @version   $Id: ServerLogic.java,v 1.0 11/23/2015 20:46:36 $
 *
 * @author Varun Dhingra
 */
public class ServerLogic extends UnicastRemoteObject implements ServerLogicInterface{

    static int no_of_players = 4;
    static ArrayList<NameAndNumber> nameAndNumbers=new ArrayList<>(no_of_players);


    protected ServerLogic() throws RemoteException {
        super();
    }

    /**
     * This method will separate the string based on delimiter |
     * @param data
     * @return
     */
    public String separateData(String data){
//            try{
        String nameAndNumberString=new String(data);

        String[] split = nameAndNumberString.split(NameAndNumber.DELIMETER);



        NameAndNumber nameAndNumber=new NameAndNumber();
        nameAndNumber.name=split[0];


        nameAndNumber.number= Integer.parseInt(split[1]);


//                nameAndNumber.outputStream=connect.getOutputStream();
        nameAndNumbers.add(nameAndNumber);
//        System.out.println("SIZEEEE ======= >>> "+nameAndNumbers.size());
//                connections++;

        if(nameAndNumbers.size() == no_of_players)
            return calculateWinner();

        return "\nWaiting for other players to connect ......\n";
    }

    /**
     * All winners are enterd into an array list and sorted. First person is the winner
     * @return String
     */
    public String calculateWinner(){

        NameAndNumber winner=null;
        for(NameAndNumber nameAndNumber: nameAndNumbers){
            if(winner==null|| nameAndNumber.number>winner.number){
                winner=nameAndNumber;
            }
        }
        String response;// = "";

//            for(NameAndNumber nameAndNumber: nameAndNumbers){
//                DataOutputStream dataOutputStream=new DataOutputStream(nameAndNumber.outputStream);
        response = winner.name + " is the winner, got the highest number of " + winner.number;

//                dataOutputStream.write(response.getBytes());

//            }
        return response;


//        } catch (IOException e) {
//            e.printStackTrace();
//        }



    }

}


class NameAndNumber{
    static String DELIMETER="\\|";
    String name;
    int number;

//    OutputStream outputStream;
}

class Controller{
    UserInterface userInterface = new UserInterface();

    public String getInputFromView() {
        return userInterface.getInputFromUser();
    }

    public void postResultToView(String result)
    {
        userInterface.displayResultToUser(result);

    }



}