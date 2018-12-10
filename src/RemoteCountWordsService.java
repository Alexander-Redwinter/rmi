import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RemoteCountWordsService implements RemoteCountWords {

    public int countWords(String s) throws RemoteException{ //service method to be called. very useful
        if(s.equals("sudo kill")){
            System.out.println("shutting down...");
            System.exit(1);
        }
        return s.split(" ").length;
    }

}