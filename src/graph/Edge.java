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
public class Edge {
    graphNodeAdj vertex;
    int weight;
    
    Edge(int weight){
        this.weight=weight;
    }
    
    Edge(graphNodeAdj vertex,int weight){
        this.weight=weight;
        this.vertex=vertex;
    }
    
//0(0) 1(8) 2(9) 3(5) 4(7) 
}
