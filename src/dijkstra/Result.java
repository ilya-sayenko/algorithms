package dijkstra;

import java.util.List;
import java.util.Map;

public record Result(
    Map<Node, Integer> distances,
    Map<Node, List<Node>> shortestPaths
) {
}
