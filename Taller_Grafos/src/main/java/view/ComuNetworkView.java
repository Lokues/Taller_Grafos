package view;

import java.util.List;
import java.util.Scanner;

public class ComuNetworkView {

    private final Scanner scanner = new Scanner(System.in);

    public void displayWelcomeMessage() {
        System.out.println("Bienvenido/a al sistema de optimización de la red de telecomunicaciones!!!.");
        System.out.println("Puedes agregar/eliminar nodos, agregar/eliminar conexiones y encontrar rutas más cortas.");
    }

    public void displayMenu() {
        System.out.println("\nSelecciona una opción:");
        System.out.println("1. Ver información de la red");
        System.out.println("2. Agregar un nodo");
        System.out.println("3. Eliminar un nodo");
        System.out.println("4. Agregar una conexión");
        System.out.println("5. Eliminar una conexión");
        System.out.println("6. Buscar la ruta más corta entre dos nodos");
        System.out.println("0. Salir");
    }

    public void displayNetworkInfo(int nodeCount, int connectionCount) {
        System.out.println("\nLa red tiene " + nodeCount + " nodos y " + connectionCount + " conexiones.");
    }

    public void displayShortestPath(List<String> shortestPath, double pathWeight, String sourceNode, String targetNode) {
        if (shortestPath != null) {
            System.out.println("La ruta más corta desde " + sourceNode + " hasta " + targetNode + " es:");
            System.out.println(shortestPath);
            System.out.println("Con una distancia total de: " + pathWeight + " MB");
        } else {
            System.out.println("No hay una ruta disponible desde " + sourceNode + " hasta " + targetNode);
        }
    }

    public String promptSourceNode() {
        System.out.print("Ingresa el nodo de origen: ");
        return scanner.nextLine();
    }

    public String promptTargetNode() {
        System.out.print("Ingresa el nodo de destino: ");
        return scanner.nextLine();
    }

    public String promptNodeName() {
        System.out.print("Ingresa el nombre del nodo: ");
        return scanner.nextLine();
    }

    public String promptNodeForConnection() {
        System.out.print("Ingresa el nombre del nodo (para la conexión): ");
        return scanner.nextLine();
    }

    public double promptConnectionWeight() {
        System.out.print("Ingresa el peso (MB) de la conexión: ");
        double weight = scanner.nextDouble();
        scanner.nextLine();
        return weight;
    }

    public void clearScannerBuffer() {
        scanner.nextLine();
    }

    public String getUserInput() {
        return scanner.nextLine();
    }
}
