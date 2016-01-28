import java.rmi.Remote;
import java.rmi.RemoteException;


/**
 * Classical: ServerLogicInterface.java
 *
 * @version   $Id: ServerLogicInterface.java,v 1.0 11/23/2015 20:46:36 $
 *
 * @author Varun Dhingra
 */
public interface ServerLogicInterface extends Remote{
    String separateData(String data) throws RemoteException;
//    String calculateWinner()throws RemoteException;
}
