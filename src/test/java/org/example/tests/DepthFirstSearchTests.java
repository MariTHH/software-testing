package org.example.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class DepthFirstSearchTests {
    private final Map<Integer, List<Integer>> graph;

    public DepthFirstSearchTests() {
        this.graph = new HashMap<>();
    }

    public void addEdge(int from, int to) {
        graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
    }

    public List<Integer> dfs(int start) {
        List<Integer> nodes = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        dfsTraversal(start, nodes, visited);
        return nodes;
    }

    private void dfsTraversal(int node, List<Integer> nodes, Set<Integer> visited) {
        if (visited.contains(node)) {
            return;
        }

        visited.add(node);
        nodes.add(node);
        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            dfsTraversal(neighbor, nodes, visited);
        }
    }

    @Test
    public void testSimple() {
        DepthFirstSearchTests graph = new DepthFirstSearchTests();
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);

        List<Integer> result = graph.dfs(0);
        List<Integer> expected = List.of(0, 1, 2, 3, 4);
        assertEquals(expected, result);
        ;
    }

    @Test
    void testGraphWithCycle() {
        DepthFirstSearchTests graph = new DepthFirstSearchTests();
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);

        List<Integer> result = graph.dfs(0);
        List<Integer> expected = List.of(0, 1, 2, 3, 4);
        assertEquals(expected, result);
    }

    @Test
    void testDisconnectedGraph() {
        DepthFirstSearchTests graph = new DepthFirstSearchTests();
        graph.addEdge(0, 1);
        graph.addEdge(2, 3);

        List<Integer> result = graph.dfs(0);
        List<Integer> expected = List.of(0, 1);
        assertEquals(expected, result);
    }

    @Test
    void testStartFromMiddle() {
        DepthFirstSearchTests graph = new DepthFirstSearchTests();
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        List<Integer> result = graph.dfs(2);
        List<Integer> expected = List.of(2, 3);
        assertEquals(expected, result);
    }

    @Test
    void testSelfLoop() {
        DepthFirstSearchTests graph = new DepthFirstSearchTests();
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 2);

        List<Integer> result = graph.dfs(0);
        List<Integer> expected = List.of(0, 1, 2);
        assertEquals(expected, result);
    }
}