# Ex2_OOP
### Directed weighted graph :
In this project we implemented a directed weighted graph. Reading from json file or manually adding nodes,edges etc. <br>
### packages: 
- __implementation :__ In this package  you will find our implementation classes for the 5 interfaces. <br>
- __JAR external libraries :__ In this package you will find the JAR external libraries we used in our code. <br>
- __Save Here :__ In this package we added 3 json files to test `save(String file)` method. <br>
- __api :__ In this package you will find all Interfaces and main class to test your implementation. <br>
- __json files :__ In this package we added 3 json files to test `load(String file)` method. <br>
- __test :__ In this package contains Junit tests for each class. <br>
---
### Classes:
1) __GeoL :__ This class implements GeoLocation Interface, it contains a specifc nodes location <x,y,z>.
2) __Edge :__ This class implements EdgeData Interface, it contains the source,destination,weight,info and tag of this edge.
3) __Node :__ This class implements NodeData Interface, it contains the key,location,tag,weight,info,previous node,hashmap of edges out and hashmap of edges in of the node.
4) __DWG :__ This class implements DirectedWeightedGraph Interface, it contains two hasmaps, one for the nodes and the other is for the edges, it also contains an counter named MC (short for Mode Count) that counts the changes made in graph.
5) __DWGalgo :__ This class implements DirectedWeightedGraphAlgorithms Interface, it contains a DWG(directed weighted graph) that we implemented, and a copy of this graph. <br> In this class we implemented some algotiyhms for searching shortest path,tsp, etc.

### Algorithms:
- [Dijkstra Algorithm ](https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm): Dijkstra's original algorithm found the shortest path between two given nodes.
- [Depth-First Search ](https://en.wikipedia.org/wiki/Depth-first_search): (DFS) is an algorithm for traversing or searching tree or graph data structures,  and takes time O(|V| + |E|).
- [Travelin Salesman Problem ](https://en.wikipedia.org/wiki/Travelling_salesman_problem): (TSP) asks the following question: "Given a list of cities and the distances between each pair of cities, what is the shortest possible route that visits each city exactly once and returns to the origin city?" It is an NP-hard problem in combinatorial optimization, important in theoretical computer science and operations research.
---
### Performance Analysis :
| GraphSize | isConnected |	Center |
|-----------|-------------|--------|
|    G1     |    39ms     |  119ms |
|    G2   	|		 25ms     |  424ms |
|    G3     |    25ms     |1.435sec|
|   1000   	|		 68ms     |        |
|   10000   |    647ms    |        |
|  1000000 	|		 2.4sec   |        |
