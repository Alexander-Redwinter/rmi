import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteCountWords extends Remote {

    int countWords(String name) throws RemoteException;
}