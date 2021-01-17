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
public class DSNode {
    
    int label;
    DSNode parent;
    
    DSNode(int label){
        this.label=label;
        parent=null;
    }
    
    DSNode getRoot(){
        if(parent==null){
            return this;
        }
        return parent.getRoot();
    }
    
}
