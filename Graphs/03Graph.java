// ---------------------------------------
//                  BFS 
// ---------------------------------------
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
    // show BFS treversal of the given graph
    //                (1)
    //              /     \
    //             /       \
    //           (2)       (6)
    //          /   \     /   \
    //        (3)   (4)  (7)   (9)
    //              /     /
    //            (5)----(8)
    // 
    // We will use queue data structure because of its Firest in First Out properties
    // We will use visited array of n size(if starts from 0 based indexing) and n+1 size(if starts from 1 based indexing)

class BFS{
    public ArrayList<Integer> bfsOfGraph(int v, List<List<Integer>> adj){
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visitedArray = new boolean[v+1];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        visitedArray[1] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();
            bfs.add(node);// add the node in final list

            for(int i = 0; i < adj.get(node).size(); i++){// will take each and every neighbour of the node one by one from adjacency list
                if(visitedArray[adj.get(node).get(i)] == false){// if the neighbour is not visited 
                    visitedArray[adj.get(node).get(i)] = true;// mark neighbour as visited
                    queue.offer(adj.get(node).get(i));// add the neighbour in the queue
                }
            }
        }

        return bfs;
    }
}
class Graph {


    public static void main(String[] args){
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i <= 9; i++){
            adj.add(new ArrayList<Integer>());
        }

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(1).add(6);
        adj.get(6).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);
        
        adj.get(2).add(4);
        adj.get(4).add(2);

        adj.get(6).add(7);
        adj.get(7).add(6);

        adj.get(6).add(9);
        adj.get(9).add(6);

        adj.get(4).add(5);
        adj.get(5).add(4);

        adj.get(7).add(8);
        adj.get(8).add(7);

        adj.get(5).add(8);
        adj.get(8).add(5);

        System.out.println("Breath First Search");
        ArrayList<Integer> bfs = new BFS().bfsOfGraph(9, adj);

        for(int i = 0; i < bfs.size(); i++){
            System.out.print(bfs.get(i) + " ");
        }
    }
}
