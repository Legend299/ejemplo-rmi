import interfaces.ICalculator;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

    public static final int PORT = 8888;
    public static final String HOST = "localhost";

    public static void main(String[] args) {
        try{
            Registry registry = LocateRegistry.getRegistry(HOST, PORT);
            ICalculator cal = (ICalculator) registry.lookup("Calculator");

            Scanner scanner = new Scanner(System.in);

            for(;;) {

                System.out.println("\n MENU");
                System.out.println("1. Sumar");
                System.out.println("2. Restar");
                System.out.println("3. Multiplicar");
                System.out.println("4. Salir");

                int op = scanner.nextInt();

                if (op == 4) {
                    System.out.println("Cerrando Cliente.");
                    break;
                }


                System.out.println("Ingresa valor 1: ");
                int value1 = scanner.nextInt();

                System.out.println("Ingresa valor 2: ");
                int value2 = scanner.nextInt();

                int result = 0;

                switch (op) {
                    case 1:
                        result = cal.add(value1, value2);
                        System.out.println("Resultado: " + result);
                        break;
                    case 2:
                        result = cal.subtract(value1, value2);
                        System.out.println("Resultado: " + result);
                        break;
                    case 3:
                        result = cal.multiply(value1, value2);
                        System.out.println("Resultado: " + result);
                        break;
                    default:
                        System.out.println("Ingresa un valor valido.");
                }
            }

            scanner.close();

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
