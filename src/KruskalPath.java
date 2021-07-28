import java.util.HashMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class KruskalPath {
        HashMap<String, String> parent = new HashMap<String,String>();
        HashMap<String, Integer> rank = new HashMap<String,Integer>();

        public String find(String node){
            //path compression 기법
            if (this.parent.get(node) != node){
                this.parent.put(node, this.find(this.parent.get(node)));
            }
            return parent.get(node);
        }

        public void union(String nodeV, String nodeU){
            String root1= this.find(nodeV);
            String root2= this.find(nodeU);

            if(this.rank.get(root1) > this.rank.get(root2)){
                this.parent.put(root2,root1);
            }
            else{
                this.parent.put(root1, root2);
                if (this.rank.get(root1) == this.rank.get(root2)){
                    this.rank.put(root2, this.rank.get(root2) + 1);
                }
            }
        }

        public void makeSet(String node){
            this.parent.put(node,node);
            this.rank.put(node,0);
        }

        public ArrayList<Edge> kruskalFunc(ArrayList<String> vetices, ArrayList<Edge> edges){
            ArrayList<Edge> mst = new ArrayList<Edge>();
            Edge currentEdge;

            for (int i = 0; i < vetices.size(); i++){
                this.makeSet(vetices.get(i));
            }

            Collections.sort(edges);

            for (int i = 0; i < edges.size(); i++){
                currentEdge = edges.get(i);
                if(this.find(currentEdge.nodeV) != this.find(currentEdge.nodeU)){
                    this.union(currentEdge.nodeV,currentEdge.nodeU);
                    mst.add(currentEdge);
                }
            }

            return mst;
        }

    }
}
