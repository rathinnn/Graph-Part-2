/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author dell
 */
public class GraphMat {
    graphNodeMat[] nodes;
    int numnodes;
    
    GraphMat(int[] mainnodes){
        numnodes=mainnodes.length;
        nodes=new graphNodeMat[numnodes];
        for (int i = 0 ;i<numnodes;i++){
            nodes[i]=new graphNodeMat(mainnodes[i],i,mainnodes.length);
        }
    }
    
    
    
    public void addDirecEdge(int from,int to){
        nodes[from].add(nodes[to]);
       
    }
    
   
    public void print(){
        System.out.print("N   : ");
        for (graphNodeMat u:nodes){
        System.out.print((u.Label+" "));
        

        }
        System.out.println();
        System.out.print("------");
        for (graphNodeMat u:nodes){
        System.out.print(("--"));
        

        }
        System.out.println();
        for (graphNodeMat u:nodes){
            u.print();
            System.out.println();
        }
    }

  
    public graphNodeMat[] getNodes() {
        return nodes;
    }
    
}
