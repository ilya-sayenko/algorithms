package dijkstra;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Node {

    private String name;

    private Map<Node, Integer> neighbours = new HashMap<>();

    public Node(String name) {
        this.name = name;
    }

    public void addDestination(Node destination, int distance) {
        neighbours.put(destination, distance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Node, Integer> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(Map<Node, Integer> neighbours) {
        this.neighbours = neighbours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(name, node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
