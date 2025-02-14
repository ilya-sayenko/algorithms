package dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Dijkstra {

    public static Result calculateShortestPathFromSource(Node source) {
        Map<Node, Integer> distances = new HashMap<>();
        Map<Node, List<Node>> shortestPaths = new HashMap<>();
        distances.put(source, 0);
        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();
        unsettledNodes.add(source);

        while (!unsettledNodes.isEmpty()) {
            Node currentNode = getLowestDistanceNode(unsettledNodes, distances);
            for (Map.Entry<Node, Integer> neighbourEntry : currentNode.getNeighbours().entrySet()) {
                Node neighbour = neighbourEntry.getKey();
                int neighbourWeigh = neighbourEntry.getValue();

                if (!settledNodes.contains(neighbour)) {
                    calculateMinimumDistance(currentNode, neighbour, neighbourWeigh, distances, shortestPaths);
                    unsettledNodes.add(neighbour);
                }
            }
            unsettledNodes.remove(currentNode);
            settledNodes.add(currentNode);
        }

        return new Result(distances, shortestPaths);
    }

    private static Node getLowestDistanceNode(Set<Node> unsettledNodes, Map<Node, Integer> distances) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node: unsettledNodes) {
            int nodeDistance = distances.get(node);
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    private static void calculateMinimumDistance(
            Node from,
            Node to,
            Integer edgeWeigh,
            Map<Node, Integer> distances,
            Map<Node, List<Node>> shortestPaths
    ) {
        Integer fromDistance = distances.get(from);
        int newDistance = fromDistance + edgeWeigh;
        if (newDistance < distances.getOrDefault(to, Integer.MAX_VALUE)) {
            distances.put(to, newDistance);
            List<Node> shortestPath = new ArrayList<>(shortestPaths.getOrDefault(from, new ArrayList<>()));
            shortestPath.add(from);
            shortestPaths.put(to, shortestPath);
        }
    }
}
