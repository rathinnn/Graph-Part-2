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
public class UndirecEdge {
    graphNodeAdj vertex1;
    graphNodeAdj vertex2;
    int weight;
    
    
    UndirecEdge(graphNodeAdj vertex1,graphNodeAdj vertex2,int weight){
        this.weight=weight;
        this.vertex1=vertex1;
        
        this.vertex2=vertex2;
    }

}
