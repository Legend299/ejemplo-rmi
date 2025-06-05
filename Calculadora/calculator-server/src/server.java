import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class server {

    public static final int PORT = 8888;

    public static void main(String[] args) throws RemoteException {

        Calculator cal = new Calculator();
        Registry registry = LocateRegistry.getRegistry(PORT);
        registry.rebind("Calculator", cal);

        System.out.println("Servidor Listo, "+PORT);

    }
}
