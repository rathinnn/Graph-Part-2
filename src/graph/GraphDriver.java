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
public class GraphDriver {
    public static void main(String[] args){
        
        //Graph Vertices are printed in the the folloeing Format: Label(Data)
       
        GraphAdj g = new GraphAdj(5);
        
        g.addDirecEdge(0, 1,10);
        g.addDirecEdge(0, 3,5);
        g.addDirecEdge(1, 2,1);
        g.addDirecEdge(1, 3,2);
        g.addDirecEdge(2, 4,4);
        g.addDirecEdge(3, 1,3);
        g.addDirecEdge(3, 2,9);
        g.addDirecEdge(3, 4,2);
        g.addDirecEdge(4, 0,7);
        g.addDirecEdge(4, 2,6);
        System.out.println("Djistrax Distances from 0 Node");
        g.Djistrax(0);
        System.out.println();
        
        GraphAdj g1 = new GraphAdj(4);
       
        g1.addUnDirecEdge(0, 1,2); 
        g1.addUnDirecEdge(0, 3,5);
        g1.addUnDirecEdge(1, 3,1);
        g1.addUnDirecEdge(1, 2,4);
        g1.addUnDirecEdge(2, 3,3);
        System.out.println("MST");
        System.out.println(g1.Prim(0));
        
        //g1.Djistrax(0);
        
        if(g1.checkCycle()){
            System.out.println("Has Cycle");
        }
        else{
            System.out.println("No Cycle");
        }
        System.out.println();
        DisjointSet set1 = new DisjointSet(10);
        set1.Union(5, 6);
        set1.print();
        System.out.println();
        
        GraphAdj g2 = new GraphAdj(6);
       
        g2.addUnDirecEdge(0, 1,2); 
        g2.addUnDirecEdge(1, 2,5);
        g2.addUnDirecEdge(2, 3,1);
        g2.addUnDirecEdge(3, 4,4);
        g2.addUnDirecEdge(4, 5,3);
        
        
        if(g2.checkCycle()){
            System.out.println("Has Cycle");
        }
        else{
            System.out.println("No Cycle");
        }
        
        
    }
}
