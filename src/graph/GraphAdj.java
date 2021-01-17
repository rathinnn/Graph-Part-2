/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;
import java.util.ArrayDeque;
import java.util.ArrayList;
/**
 *
 * @author dell
 */
public class GraphAdj  {
    graphNodeAdj[] nodes;
    int numnodes;
    ArrayList<UndirecEdge> edges;
    
    String[] forTop=null;
    
   
    
    GraphAdj(int[] mainnodes){
        numnodes=mainnodes.length;
        nodes=new graphNodeAdj[numnodes];
       
        for (int i = 0 ;i<numnodes;i++){
            nodes[i]=new graphNodeAdj(mainnodes[i],i);
        }
    }
    
    GraphAdj(int n){
        numnodes=n;
        nodes=new graphNodeAdj[numnodes];
        for (int i = 0 ;i<numnodes;i++){
            nodes[i]=new graphNodeAdj(i,i);
        }
    }
    
    //Constructor for Topological Sort
    GraphAdj(String[] mainnodes){
        numnodes=mainnodes.length;
        nodes=new graphNodeAdj[numnodes];
       
        for (int i = 0 ;i<numnodes;i++){
            nodes[i]=new graphNodeAdj(i,i);
        }
        forTop=mainnodes;
        
    }
    
    public void init_sing_srce(int label){
        for (graphNodeAdj u:nodes){
            u.d=Integer.MAX_VALUE;
            u.visited=false;
            
            
        }
        nodes[label].d=0;
        nodes[label].parent=nodes[label];
        
    }
    
    public void Djistrax(int label){
        graphNodeAdj cur=nodes[label];
        init_sing_srce(label);
        
        while(!isEmpty()){
            cur=extractMin();
            
            cur.setVisited();
            
            
            for (Edge e : cur.Edges){
                
                relax(cur,e.vertex,e.weight);
               
            }
        
        }
        //System.out.println();
        for (graphNodeAdj u:nodes){
            
            System.out.print(u.Label+"("+u.d+")"+" ");
            }
        System.out.println();
        
        
    }
    
    public int Prim(int label){
        graphNodeAdj cur=nodes[label];
        init_sing_srce(label);
        int mstv=0;
        while(!isEmpty()){
            cur=extractMin();
            mstv=mstv+cur.d;
            cur.setVisited();
            System.out.println(cur.parent.Label+"--("+cur.d+")--"+cur.Label);
           
            for (Edge e : cur.Edges){
                if(!e.vertex.visited && e.weight<e.vertex.d)
                e.vertex.d=e.weight;
                e.vertex.parent=cur;
            }
        
        }
        //System.out.println();
        return mstv;
        
        
    }
    
    public void relax(graphNodeAdj u,graphNodeAdj v,int weight){
        if(v.d>u.d+weight){
            v.d=u.d+weight;
            v.parent=u;
        }
        
    }
    
    
    
    public graphNodeAdj extractMin(){
        int min = Integer.MAX_VALUE;
        graphNodeAdj extracted=null;
        for (graphNodeAdj u:nodes){
            
            if(!u.visited && u.d<=min){
                min=u.d;
                
                extracted=u;
            }
            
            
        }
        return extracted;
    }
    
    public boolean isEmpty(){
        for (graphNodeAdj u:nodes){
            if(!u.visited){
                return false;
            }
            
            
        }
        return true;
    }
    
   
    
    
   
    public void addDirecEdge(int from,int to){
        nodes[from].add(nodes[to]);
        
    }
    
    public void addDirecEdge(int from,int to,int weight){
        nodes[from].add(nodes[to],weight);
        
    }
    
    public void addUnDirecEdge(int from,int to,int weight){
        if(edges==null){
            edges=new ArrayList<>();
        }
        nodes[from].add(nodes[to],weight);
        nodes[to].add(nodes[from],weight);
        edges.add(new UndirecEdge(nodes[from],nodes[to],weight));
        
    }
    
    public boolean checkCycle(){
        DisjointSet set = new DisjointSet(nodes.length);
        
        for(UndirecEdge e: edges){
            if(!set.Union(e.vertex1.Label, e.vertex2.Label)){
                
                return true;
            }
        }
        
        return false;
    }
    
 
    public void print(){
        for (graphNodeAdj u:nodes){
            u.print();
            System.out.println();
        }
    }


    public graphNodeAdj[] getNodes() {
        return nodes;
    }
    
    
    public boolean BFS(int j){
        ArrayDeque<graphNodeAdj> Q= new ArrayDeque<>();
        for (graphNodeAdj u:nodes){
            u.colour=-1;
            u.distance=-1;
        }
        graphNodeAdj s = nodes[j];
        s.distance=0;
        s.colour=0;
        Q.addFirst(s);
        graphNodeAdj temp = null;
        while(!Q.isEmpty()){
            temp=Q.pollLast();
            System.out.println(temp.Label+"("+temp.data+")"+":d="+temp.distance);
            for (graphNodeAdj v:temp.adjList){
            if(v.colour==-1){
                v.colour=0;
                v.distance=temp.distance+1;
                Q.addFirst(v);
                }
            
            }
            temp.colour=1;
        }
        for (graphNodeAdj u:nodes){
            if(u.colour==-1){
                System.out.println(u.Label+" Not accesible from "+s.Label);
                return false;
            }
        }
        return true;
        
    }
    
    public void DFS(){
        graphNodeAdj.resettime();
        for (graphNodeAdj u:nodes){
            u.colour=-1;
            
        }
        for (graphNodeAdj u:nodes){
            if(u.colour==-1){
                u.dfs();
            }
            
        }
        graphNodeAdj.resettime();
    }
    
    
    
    public void doDFS(){
        DFS();
        for (graphNodeAdj u:nodes){
            System.out.println(u.Label+"("+u.data+")"+":discovery="+u.discovery+":finish="+u.finish);
            
        }
    }
    
    
    
    
   
    
    public static GraphAdj getTranspose(GraphAdj graph){
        int[] mainnodes= new int[graph.nodes.length];
        for (int i = 0;i<mainnodes.length;i++){
            mainnodes[i]=graph.nodes[i].data;
        }
        GraphAdj grapht=new GraphAdj(mainnodes);
        
        
        for (int i = 0;i<mainnodes.length;i++){
            graphNodeAdj temp = graph.nodes[i];
            for (graphNodeAdj v:temp.adjList){
            
                grapht.addDirecEdge(v.Label, i);
                
            
            
            }
        } 
        
        
        
        return grapht;
        
    }
   
}
