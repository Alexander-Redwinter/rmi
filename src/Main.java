import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Main {
    public static void main(String[] args) throws Exception {
        final String BINDING_NAME = "countWords"; //creating a name for our service
        int port = 2099;
        System.out.print("creating registry, port " + port + " ...");
        final Registry registry = LocateRegistry.createRegistry(port);
        System.out.println(" done");

        final RemoteCountWordsService service = new RemoteCountWordsService();
        Remote stub = UnicastRemoteObject.exportObject(service, 0);

        System.out.print("binding service...");
        registry.bind(BINDING_NAME, stub);
        System.out.println(" done");

        while (true) { //put main thread to sleep... forever... sweet dreams, main thready...
            Thread.sleep(Integer.MAX_VALUE); //is there a better way to put a thread to sleep forever?
        }
    }
}
