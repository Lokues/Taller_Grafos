package model;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        ComuNetwork telecomNetwork = new ComuNetwork();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al sistema de optimización de la red de telecomunicaciones.");
        System.out.println("Nodos disponibles: Nodo A, Nodo B, Nodo C, Nodo D, Nodo E, Nodo F, Nodo G, Nodo H");

        System.out.print("Ingrese el nodo de origen: ");
        String sourceNode = scanner.nextLine();

        System.out.print("Ingrese el nodo de destino: ");
        String targetNode = scanner.nextLine();


        List<String> shortestPath = telecomNetwork.findShortestPath(sourceNode, targetNode);
        if (shortestPath != null) {
            double pathWeight = telecomNetwork.getPathWeight(sourceNode, targetNode);
            System.out.println("La ruta más corta desde " + sourceNode + " hasta " + targetNode + " es:");
            System.out.println(shortestPath);
            System.out.println("Con una distancia total de: " + pathWeight);
        } else {
            System.out.println("No hay una ruta disponible desde " + sourceNode + " hasta " + targetNode);
        }
    }
}

