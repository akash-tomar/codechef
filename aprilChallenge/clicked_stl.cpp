// Program to find Dijkstra's shortest path using
// priority_queue in STL
#include<bits/stdc++.h>
using namespace std;
# define INF 0x3f3f3f3f
 
// iPair ==>  Integer Pair
typedef pair<int, int> iPair;
 
// This class represents a directed graph using
// adjacency list representation
class Graph
{
    int V;    // No. of vertices
 
    // In a weighted graph, we need to store vertex
    // and weight pair for every edge
    list< pair<int, int> > *adj;
 
public:
    Graph(int V);  // Constructor
 
    // function to add an edge to graph
    void addEdge(int u, int v, int w);
 
    // prints shortest path from s
    void shortestPath(int s);
};
 
// Allocates memory for adjacency list
Graph::Graph(int V)
{
    this->V = V;
    adj = new list<iPair> [V];
}
 
void Graph::addEdge(int u, int v, int w)
{
    adj[u].push_back(make_pair(v, w));
    adj[v].push_back(make_pair(u, w));
}
 
// Prints shortest paths from src to all other vertices
void Graph::shortestPath(int src)
{
    // Create a priority queue to store vertices that
    // are being preprocessed. This is weird syntax in C++.
    // Refer below link for details of this syntax
    // http://geeksquiz.com/implement-min-heap-using-stl/
    priority_queue< iPair, vector <iPair> , greater<iPair> > pq;
 
    // Create a vector for distances and initialize all
    // distances as infinite (INF)
    vector<int> dist(V, INF);
 
    // Insert source itself in priority queue and initialize
    // its distance as 0.
    pq.push(make_pair(0, src));
    dist[src] = 0;
 
    /* Looping till priority queue becomes empty (or all
      distances are not finalized) */
    while (!pq.empty())
    {
        // The first vertex in pair is the minimum distance
        // vertex, extract it from priority queue.
        // vertex label is stored in second of pair (it
        // has to be done this way to keep the vertices
        // sorted distance (distance must be first item
        // in pair)
        int u = pq.top().second;
        pq.pop();
 
        // 'i' is used to get all adjacent vertices of a vertex
        list< pair<int, int> >::iterator i;
        for (i = adj[u].begin(); i != adj[u].end(); ++i)
        {
            // Get vertex label and weight of current adjacent
            // of u.
            int v = (*i).first;
            int weight = (*i).second;
 
            //  If there is shorted path to v through u.
            if (dist[v] > dist[u] + weight)
            {
                // Updating distance of v
                dist[v] = dist[u] + weight;
                pq.push(make_pair(dist[v], v));
            }
        }
    }
 
    // Print shortest distances stored in dist[]
    // printf("Vertex   Distance from Source\n");

    for (int i = 0; i < V; ++i)
        cout<<dist[i]<<" ";
    cout<<endl;
}
 
// Driver program to test methods of graph class
int main()
{

    int test;
    cin>>test;
    for(int t=0;t<test;t++) {
        // create the graph given in above fugure
        int num_of_cities;//=s.nextInt();
        int num_of_old_cities;// =s.nextInt();
        int length_of_road_old_city;// = s.nextInt();
        int num_of_new_roads;// =s.nextInt();
        int source;// = s.nextInt();
        cin>>num_of_cities>>num_of_old_cities>>length_of_road_old_city>>num_of_new_roads>>source;
        Graph g(num_of_cities);
        for(int i=0;i<num_of_new_roads;i++) {
            int a;
            int b;
            int c;
            cin>>a>>b>>c;
            g.addEdge(a-1,b-1,c);
        }
        for(int i=1;i<=num_of_old_cities;i++) {
            for(int j=1;j<=num_of_old_cities;j++) {
                if(i!=j) {
                    g.addEdge(i-1,j-1,length_of_road_old_city);
                }
            }
        }
        
        g.shortestPath(source-1);
    }
    return 0;
}