package org.example;

import org.graph4j.generators.GraphGenerator;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Random;

import org.graph4j.Graph;
import org.graph4j.shortestpath.DijkstraShortestPathDefault;
import org.graph4j.util.Path;

//bonus
public class Problem {
    private List<Location> locations;

    public void generate(){
        int locationLength,i;
        Random random = new Random();
        locationLength = random.nextInt(1000);
        for (i=1;i<=locationLength;i++){
            Location randomLoc = new Location();
            this.locations.add(randomLoc);
        }
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

    public void GenerateSafetyGraph(int CurrentNode){
        MakePairs(this.locations);
        int nrNodes=size;
        Graph g = GraphGenerator.complete(nrNodes);
        int i;
        int n=g.numVertices();
        for (i = 0; i < n - 1; i++) {
            int v = g.vertexAt(i);
            for (int j = i + 1; j < n; j++) {
                int u = g.vertexAt(j);
                g.setEdgeWeight(v, u, roads[i][j].getSafetyPenalty());
                g.setEdgeWeight(u, v, roads[i][j].getSafetyPenalty());
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

    }

    /*
    Determine the safest routes for any pair of locations.
    Create a data structure that stores, for each computed route, the number of locations of each type.

    Create a random problem generator and run the algorithms for large instances,
    having a number of locations ranging from hundreds to thousands.
    Store the results of your tests in a data structure
    and compute various statistics, using Java Stream API.

*/
}
