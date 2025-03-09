import java.util.LinkedList;
import java.util.Random;
import java.util.ArrayList;

public class Lab1 {
    public static void main(String[] args) {
        Lab1 lab1 = new Lab1();
        if (args.length == 2) {
            int n = Integer.parseInt(args[0]);
            int k = Integer.parseInt(args[1]);
            lab1.homework(n, k);
        } else lab1.compulsory();
    }

    void compulsory() {
        System.out.println("Hello world!");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000); //alegem un numar random
        n *= 3;             //efectuam operatiile cerute
        n += 0b10101;
        n += 0xFF;
        n *= 6;
        int result = 0;
        while (n > 0) { //adunam cifrele pana cand obtinem un nr de o cifra
            result = result + n % 10;
            n /= 10;
            if (result > 9 && n == 0) {
                n = result;
                result = 0;
            }
        }
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }

    void homework(int n, int k) {
        //Do stuff
        //Start measuring time:
        long t1 = System.currentTimeMillis();
        System.out.println("\u0394\u03B4"); //greek characters

        if (k > n) { //eroare pentru cererea de clique/mult stabila > graf
            System.out.println("Error: subgraph bigger than graph");
            System.exit(-1);
        }
        int i = 0, i2 = 0;
        int[] positionsTaken = new int[n];
        for (i = 0; i < n; i++)
            positionsTaken[i] = 0;
        int[][] graphMatrix = new int[n][n];
        for (i = 0; i < n; i++)
            for (i2 = 0; i2 < n; i2++)
                graphMatrix[i][i2] = 0;
        Random rand = new Random();

        int x, y;
        for (i = 1; i <= k; i++) {
            x = rand.nextInt(n);
            while (positionsTaken[x] == 1) {
                x = rand.nextInt(n);
            }
            positionsTaken[x] = 1;
            System.out.print(x + " ");
        }
        //generare subgraf complet de marime k
        for (i = 0; i < n; i++)
            for (i2 = 0; i2 < n; i2++)
                if (positionsTaken[i] == 1 && positionsTaken[i2] == 1 && i != i2)
                    graphMatrix[i][i2] = graphMatrix[i2][i] = 1;
        System.out.println("\nNoduri clique:");
        for (i = 0; i < n; i++)
            if (positionsTaken[i] == 1)
                System.out.print(i + " ");
        System.out.println("\nNoduri multime stabila initiala:");
        for (i = 0; i < n; i++)
            if (positionsTaken[i] == 0)
                System.out.print(i + " ");
        System.out.println();
        //Daca au ramas noduri cat sa existe clique si multime stabila de dim k:
        for (i = 1; i <= n - 2 * k; i++) {//adaugam muchii de la nodurile ramase
            x = rand.nextInt(n); //alegem o pereche de noduri x si y
            while (positionsTaken[x] > 0) {
                x = rand.nextInt(n);
            }
            positionsTaken[x] = 2;
            for (i2 = 0; i2 < n; i2++)
                if (i2 != x) {
                    //adaugam sau nu random o muchie intre ele
                    graphMatrix[x][i2] = graphMatrix[i2][x] = rand.nextInt(2);
                    if (positionsTaken[i2] == 0 && graphMatrix[x][i2] == 1) //ne asiguram sa nu eliminam mult stabila
                    {
                        i++;
                        positionsTaken[i2] = 2;
                    }
                }
        }
        //string representation matrice de adiacenta
        if (n <= 50) {
            System.out.println("\nMatrix string representation:");
            System.out.println("[ "); //change to print for string
            for (i = 0; i < n; i++) {
                System.out.print("[");
                for (i2 = 0; i2 < n - 1; i2++)
                    System.out.print(graphMatrix[i][i2] + ", ");
                System.out.println(graphMatrix[i][n - 1] + "]");//change to print for string
            }
            System.out.println(" ]");
        }

        System.out.println("\nNoduri multime stabila finala:");
        for (i = 0; i < n; i++)
            if (positionsTaken[i] == 0)
                System.out.print(i + " ");
        System.out.println("\nNoduri muchii random:");
        for (i = 0; i < n; i++)
            if (positionsTaken[i] == 2)
                System.out.print(i + " ");

        int m = 0;
        for (i = 0; i < n; i++)
            for (i2 = i + 1; i2 < n; i2++)
                if (graphMatrix[i][i2] != 0)
                    m++;
        System.out.println("\nNumarul de muchii din graf: " + m);

        int min1 = n + 1, max1 = -1;
        int grad, sumaGrade = 0;
        for (i = 0; i < n; i++) {
            grad = 0;
            for (i2 = 0; i2 < n; i2++)
                if (graphMatrix[i][i2] != 0)
                    grad++;
            if (grad > max1) max1 = grad;
            if (grad < min1) min1 = grad;
            sumaGrade += grad;
        }
        System.out.println("Grad maxim, Δ(G) = " + max1);
        System.out.println("Grad minim, δ(G) = " + min1);
        System.out.println("Suma grade: " + sumaGrade + "; 2*m: " + (2 * m));

        //Dysplay time to run app for n>30000:
        long t2 = System.currentTimeMillis();
        if (n > 30000)
            System.out.println("Time taken: " + (t2 - t1) / 1000 + " seconds");
        System.out.println(("\n\n\nBonus:"));
        bonus(graphMatrix, n, k);
    }

    void bonus(int[][] graph, int n, int k) {
        ArrayList<Integer> subgraph = new ArrayList<Integer>();
        int gasitClique = 0, gasitMultStabila = 0;

        for (int i = 0; i < n; i++) {
            subgraph.clear();  // Clear the subgraph for each new check
            if (generateSubgraph(graph, n, k, 0, i, 0, subgraph) && gasitMultStabila == 0) {
                System.out.println("Exista o multime stabila de dimensiune " + k);
                gasitMultStabila = 1;
                for (int i2 = 0; i2 < subgraph.size(); i2++) {
                    System.out.print(subgraph.get(i2) + " ");
                }
                System.out.println();
            }

            subgraph.clear();  // Clear the subgraph for the next check
            if (generateSubgraph(graph, n, k, 0, i, 1, subgraph) && gasitClique == 0) {
                System.out.println("Exista un clique de dimensiune " + k);
                gasitClique = 1;
                for (int i2 = 0; i2 < subgraph.size(); i2++) {
                    System.out.print(subgraph.get(i2) + " ");
                }
                System.out.println();
            }
        }

        if (gasitClique == 0) {
            System.out.println("Nu exista clique de dimensiune " + k);
            for (int i2 = 0; i2 < subgraph.size(); i2++) {
                System.out.print(subgraph.get(i2) + " ");
            }
            System.out.println();
        }
        if (gasitMultStabila == 0) {
            System.out.println("Nu exista multime stabila de dimensiune " + k);
            for (int i2 = 0; i2 < subgraph.size(); i2++) {
                System.out.print(subgraph.get(i2) + " ");
            }
            System.out.println();
        }
    }

    boolean generateSubgraph(int[][] graph, int n, int k, int size, int start, int val, ArrayList<Integer> subgraph) {
        subgraph.add(start);
        size++;
        // If we found a subgraph of size k, return true
        if (size == k) {
            return true;
        }
        for (int i = start + 1; i < n; i++) {
            boolean valid = true;
            // Check if this node is valid
            for (int node : subgraph) {
                if (graph[node][i] != val) {
                    valid = false;
                    break;
                }
            }
            // If valid, recurse
            if (valid) {
                if (generateSubgraph(graph, n, k, size, i, val, subgraph)) {
                    return true;
                }
            }
        }
        // Backtrack: remove the last element before returning
        subgraph.remove(subgraph.size() - 1);
        return false;
    }
}
