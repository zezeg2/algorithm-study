import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.ArrayList;
public class PrimPath {
    public ArrayList<Edge> primFunc(String startNode, ArrayList<Edge> edges){
        Edge currentEdge;
        ArrayList<Edge> currentEdgeList;
        ArrayList<Edge> candidateEdgeList;
        PriorityQueue<Edge> priorityQueue;
        Edge poppedEdge;
        ArrayList<Edge> adjacentEdgeNodes;
        Edge adjacentEdgeNode;
        ArrayList<String> connectionNodes = new ArrayList<String>();
        ArrayList<Edge> mst = new ArrayList<Edge>();
        HashMap<String, ArrayList<Edge>> adjacentEdges = new HashMap<String, ArrayList<Edge>>();

        for (int i=0; i < edges.size(); i++){
            currentEdge = edges.get(i);
            if (!adjacentEdges.containsKey(currentEdge.node1)){
                adjacentEdges.put(currentEdge.node1, new ArrayList<Edge>());
            }
            if (!adjacentEdges.containsKey(currentEdge.node2)){
                adjacentEdges.put(currentEdge.node2, new ArrayList<Edge>());
            }
        }

        for (int i = 0; i < edges.size(); i++){
            currentEdge = edges.get(i);
            currentEdgeList = adjacentEdges.get(currentEdge.node1);
            currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.node1, currentEdge.node2));
            currentEdgeList = adjacentEdges.get(currentEdge.node2);
            currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.node2, currentEdge.node1));
        }

        connectionNodes.add(startNode);
        candidateEdgeList = adjacentEdges.getOrDefault(startNode, new ArrayList<Edge>());
        priorityQueue = new PriorityQueue();

        for (int i = 0; i < candidateEdgeList.size(); i++){
            priorityQueue.add(candidateEdgeList.get(i));
        }

        while(priorityQueue.size() == 0){
            poppedEdge = priorityQueue.poll();
            if(!connectionNodes.contains(poppedEdge.node2)){
                // 해당 edge를 mst에 추가
                connectionNodes.add(poppedEdge.node2);
                mst.add(new Edge(poppedEdge.weight, poppedEdge.node1, poppedEdge.node2));
                adjacentEdgeNodes = adjacentEdges.getOrDefault(poppedEdge.node2, new ArrayList<Edge>());

                for (int i = 0; i < adjacentEdgeNodes.size(); i++){
                    adjacentEdgeNode = adjacentEdgeNodes.get(i);
                    if(!connectionNodes.contains(adjacentEdgeNode.node2)){
                        priorityQueue.add(adjacentEdgeNode);
                    }
                }
            }
        }

        return mst;
    }
}
