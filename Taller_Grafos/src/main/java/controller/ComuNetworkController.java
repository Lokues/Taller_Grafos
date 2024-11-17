package controller;

import model.ComuNetwork;
import view.ComuNetworkView;

import java.util.List;

public class ComuNetworkController {

    private final ComuNetwork model;
    private final ComuNetworkView view;

    public ComuNetworkController(ComuNetwork model, ComuNetworkView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        view.displayWelcomeMessage();
        while (true) {
            view.displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    displayNetworkInfo();
                    break;
                case 2:
                    addNode();
                    break;
                case 3:
                    removeNode();
                    break;
                case 4:
                    addConnection();
                    break;
                case 5:
                    removeConnection();
                    break;
                case 6:
                    findShortestPath();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private int getUserChoice() {
        int choice = -1;
        try {
            choice = Integer.parseInt(view.getUserInput());
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida, ingresa un número.");
        }
        return choice;
    }

    private void displayNetworkInfo() {
        int nodeCount = model.getNodeCount();
        int connectionCount = model.getConnectionCount();
        view.displayNetworkInfo(nodeCount, connectionCount);
    }

    private void addNode() {
        String nodeName = view.promptNodeName();
        model.addNode(nodeName);
    }

    private void removeNode() {
        String nodeName = view.promptNodeName();
        model.removeNode(nodeName);
    }

    private void addConnection() {
        String node1 = view.promptNodeForConnection();
        String node2 = view.promptNodeForConnection();
        double weight = view.promptConnectionWeight();
        model.addConnection(node1, node2, weight);
    }

    private void removeConnection() {
        String node1 = view.promptNodeForConnection();
        String node2 = view.promptNodeForConnection();
        model.removeConnection(node1, node2);
    }

    private void findShortestPath() {
        String sourceNode = view.promptSourceNode();
        String targetNode = view.promptTargetNode();

        List<String> shortestPath = model.findShortestPath(sourceNode, targetNode);
        double pathWeight = model.getPathWeight(sourceNode, targetNode);

        view.displayShortestPath(shortestPath, pathWeight, sourceNode, targetNode);
    }
}
