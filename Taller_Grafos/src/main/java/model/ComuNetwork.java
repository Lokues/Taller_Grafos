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
        initializeNetwork();
    }

    private void initializeNetwork() {

        network.addVertex("Nodo A");
        network.addVertex("Nodo B");
        network.addVertex("Nodo C");
        network.addVertex("Nodo D");
        network.addVertex("Nodo E");
        network.addVertex("Nodo F");
        network.addVertex("Nodo G");
        network.addVertex("Nodo H");

        network.setEdgeWeight(network.addEdge("Nodo A", "Nodo B"), 10);
        network.setEdgeWeight(network.addEdge("Nodo A", "Nodo C"), 15);
        network.setEdgeWeight(network.addEdge("Nodo B", "Nodo D"), 12);
        network.setEdgeWeight(network.addEdge("Nodo C", "Nodo E"), 10);
        network.setEdgeWeight(network.addEdge("Nodo D", "Nodo E"), 2);
        network.setEdgeWeight(network.addEdge("Nodo B", "Nodo E"), 5);
        network.setEdgeWeight(network.addEdge("Nodo E", "Nodo F"), 8);
        network.setEdgeWeight(network.addEdge("Nodo F", "Nodo G"), 6);
        network.setEdgeWeight(network.addEdge("Nodo G", "Nodo H"), 7);
        network.setEdgeWeight(network.addEdge("Nodo C", "Nodo H"), 20);

        network.setEdgeWeight(network.addEdge("Nodo D", "Nodo F"), 3);
        network.setEdgeWeight(network.addEdge("Nodo B", "Nodo F"), 9);
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
}
