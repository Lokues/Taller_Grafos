package model;

import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.List;

public class ComuNetwork {

    private final Graph<String, DefaultWeightedEdge> network;

    public ComuNetwork() {
        network = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
    }

    public void addNode(String nodeName) {
        if (!network.containsVertex(nodeName)) {
            network.addVertex(nodeName);
            System.out.println("Nodo " + nodeName + " agregado.");
        } else {
            System.out.println("El nodo " + nodeName + " ya existe.");
        }
    }

    public void removeNode(String nodeName) {
        if (network.containsVertex(nodeName)) {
            network.removeVertex(nodeName);
            System.out.println("Nodo " + nodeName + " eliminado.");
        } else {
            System.out.println("El nodo " + nodeName + " no existe.");
        }
    }

    public void addConnection(String node1, String node2, double weight) {
        if (network.containsVertex(node1) && network.containsVertex(node2)) {
            DefaultWeightedEdge edge = network.addEdge(node1, node2);
            if (edge != null) {
                network.setEdgeWeight(edge, weight);
                System.out.println("Conexión entre " + node1 + " y " + node2 + " agregada con peso: " + weight);
            } else {
                System.out.println("La conexión entre " + node1 + " y " + node2 + " ya existe.");
            }
        } else {
            System.out.println("Uno o ambos nodos no existen.");
        }
    }

    public void removeConnection(String node1, String node2) {
        if (network.containsEdge(node1, node2)) {
            network.removeEdge(node1, node2);
            System.out.println("Conexión entre " + node1 + " y " + node2 + " eliminada.");
        } else {
            System.out.println("No existe una conexión entre " + node1 + " y " + node2);
        }
    }

    public List<String> findShortestPath(String source, String target) {
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraAlg = new DijkstraShortestPath<>(network);
        if (dijkstraAlg.getPath(source, target) != null) {
            return dijkstraAlg.getPath(source, target).getVertexList();
        } else {
            return null;
        }
    }

    public double getPathWeight(String source, String target) {
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraAlg = new DijkstraShortestPath<>(network);
        if (dijkstraAlg.getPath(source, target) != null) {
            return dijkstraAlg.getPath(source, target).getWeight();
        } else {
            return -1;
        }
    }

    public Graph<String, DefaultWeightedEdge> getNetwork() {
        return network;
    }

    public int getNodeCount() {
        return network.vertexSet().size();
    }

    public int getConnectionCount() {
        return network.edgeSet().size();
    }
}
