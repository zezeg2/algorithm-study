public class Edge implements Comparable<Edge>{
//    public int weight;
//    public String nodeV;
//    public String nodeU;
//
//    public Edge(int weight, String nodeV, String nodeU){
//        this.weight = weight;
//        this.nodeV = nodeV;
//        this.nodeU = nodeU;
//    }
//
//    public String toString(){
//        return "(" + this.weight + "," + this.nodeU + "," + this.nodeV + ")";
//    }
//
//    @Override
//    public int compareTo(Edge edge){
//        return this.weight - edge.weight;
//    }

    public int weight;
    public String node1;
    public String node2;

    public Edge(int weight, String node1, String node2) {
        this.weight = weight;
        this.node1 = node1;
        this.node2 = node2;
    }

    public String toString() {
        return "(" + this.weight + ", " + this.node1 + ", " + this.node2 + ")";
    }

    @Override
    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }
    //for PrimPath
}
