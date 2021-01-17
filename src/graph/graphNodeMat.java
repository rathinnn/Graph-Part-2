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
public class graphNodeMat {
    int Label;
    int data;
    int[] row;
    
    graphNodeMat(int data,int label,int n){
        
        this.data=data;
        this.Label=label;
        //adjList=new ArrayList<>();
        //white is -1 grey is 0 black is 1
        
        row=new int[n];
        
        
        
    }
    
    
    public void add(graphNodeMat node){
        row[node.Label]=1;
    }
    
    
    public void print(){
         System.out.print(Label+"("+data+")"+": ");
         for (int i = 0;i<row.length;i++){
             System.out.print(row[i]+" ");
         }
        
    }
    
}
