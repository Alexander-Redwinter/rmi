import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.ConnectException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    public static void main(String... args) throws Exception {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 2099); //getting our server's registry of shared services


            RemoteCountWords service = (RemoteCountWords) registry.lookup("countWords"); //finding a service with required name
            System.out.println("we're in");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            //happily count words from console until you kill remote server. you monster
            while (true)
                System.out.println(service.countWords(reader.readLine()));
        } catch (ConnectException e) {
            System.out.println("remote server is offline");
        }

    }

}