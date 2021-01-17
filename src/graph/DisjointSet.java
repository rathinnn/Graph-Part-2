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
public class DisjointSet {
    
    DSNode sets[];
    
    DisjointSet(int n){
        sets=new DSNode[n];
        
        for(int i = 0;i<n;i++){
            makeset(i);
        }
    }
    
    void makeset(int label){
        
        sets[label]=new DSNode(label);
        
    }
    
    DSNode find(int label){
        return sets[label].getRoot();
        
    }
    
    boolean Union(int label1,int label2){
        DSNode v1=find(label1);
        DSNode v2=find(label2);
        if(v1!=v2){
            v2.parent=v1;
            return true;
        }
        return false;
        
    }
    
    public void print(){
        for (int i = 0;i<sets.length;i++){
            System.out.println(i+"("+find(i).label+")");
        }
    }
    
    
    
    
}
