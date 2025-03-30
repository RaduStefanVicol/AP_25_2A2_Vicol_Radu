package org.example;
import org.graph4j.generators.GraphGenerator;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.graph4j.Graph;
import org.graph4j.shortestpath.DijkstraShortestPathDefault;
import org.graph4j.util.Path;


public class GraphSolution {
    private List<Location> locations;

    public GraphSolution(List<Location> locations) {
        this.locations = locations;
        size = this.locations.size();
        roads = new LocationPair[size][size];
    }
    private int size = 0;

    private LocationPair[][] roads;

    public void MakePairs(List<Location> locations) {
        int i, j;
        for (i = 0; i < size; i++) {
            for (j = i + 1; j < size; j++) {
                roads[j][i]=roads[i][j]= new LocationPair(locations.get(i), locations.get(j));
            }
        }
    }
    public void GenerateGraph(int CurrentNode){
        MakePairs(this.locations);
        int nrNodes=size;
        Graph g = GraphGenerator.complete(nrNodes);
        int i;
        int n=g.numVertices();
        for (i = 0; i < n - 1; i++) {
            int v = g.vertexAt(i);
            for (int j = i + 1; j < n; j++) {
                int u = g.vertexAt(j);
                g.setEdgeWeight(v, u, roads[i][j].getDirectTime());
                g.setEdgeWeight(u, v, roads[i][j].getDirectTime());
            }
        }
        var alg = new DijkstraShortestPathDefault(g, CurrentNode); //source vertex
        Path path = alg.findPath(n-1); //the shortest path from CurrentNode to i
        System.out.println("From " + CurrentNode + " to the node:");
        for (i = 0; i < n - 1; i++)
            if (i!=CurrentNode) {
                path = alg.findPath(i); //the shortest path from CurrentNode to i
                System.out.print("i = " + i + " type:" + locations.get(i).getType());
                System.out.println(path);
                System.out.println("With time: " + alg.getPathWeight(i));
                this.locations.get(i).setSortNumber((int)(alg.getPathWeight(i)));
            }
        System.out.println();
        System.out.println("Time to friendly locations: ");
        for (i = 0; i < n - 1; i++)
            if (i!=CurrentNode && locations.get(i).getType() == Location.LocationType.FRIENDLY) {
                path = alg.findPath(i);
                System.out.print("i = " + i + ": ");
                System.out.println(alg.getPathWeight(i));
            }
        System.out.println("Time to neutral locations: ");
        for (i = 0; i < size; i++)
            if (i!=CurrentNode && locations.get(i).getType() == Location.LocationType.NEUTRAL) {
                path = alg.findPath(i);
                System.out.print("i = " + i + ": ");
                System.out.println(alg.getPathWeight(i));
            }
        System.out.println("Time to enemy locations: ");
        for (i = 0; i < size; i++)
            if (i!=CurrentNode && locations.get(i).getType() == Location.LocationType.ENEMY) {
                path = alg.findPath(i);
                System.out.print("i = " + i + ": ");
                System.out.println(alg.getPathWeight(i));
            }
        LinkedList<Location> frienlyLocations = locations.stream()
                .filter(loc -> loc.getType() == Location.LocationType.FRIENDLY)
                .sorted(Comparator.comparing(Location::getSortNumber)
                        .thenComparing(Location::getName))
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println("Sorted FRIENDLY Locations: ");
        frienlyLocations.forEach(System.out::println);

        LinkedList<Location> neutralLocations = locations.stream()
                .filter(loc -> loc.getType() == Location.LocationType.NEUTRAL)
                .sorted(Comparator.comparing(Location::getSortNumber)
                        .thenComparing(Location::getName))
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println();

        System.out.println("Sorted NEUTRAL Locations: ");
        neutralLocations.forEach(System.out::println);
        LinkedList<Location> enemyLocations = locations.stream()
                .filter(loc -> loc.getType() == Location.LocationType.ENEMY)
                .sorted(Comparator.comparing(Location::getSortNumber)
                        .thenComparing(Location::getName))
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println();

        System.out.println("Sorted Enemy Locations: ");
        enemyLocations.forEach(System.out::println);
        System.out.println();
    }


}