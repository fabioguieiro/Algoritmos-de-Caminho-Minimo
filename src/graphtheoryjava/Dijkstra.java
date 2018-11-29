package graphtheoryjava;
import graphtheoryjava.algorithms.Search;
import graphtheoryjava.util.Graph;
import graphtheoryjava.util.Reader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Dijkstra {
    public void ideal (int origem, int destino) throws IOException{
        Scanner ler = new Scanner (System.in);
        int u,v,w,r=-1,k=0;
        System.out.print("Entre com o nome do grafo ");
        String nome = ler.nextLine();
        if(!nome.contains(".txt")){
        nome=nome.concat(".txt");  
        }
        Reader reader= new Reader();
        Graph graph= reader.readFile(nome);
        
        Search search= new Search(graph); 
        ArrayList<Integer> Q = new ArrayList<Integer> ();
        Q = search.buscaLargura(origem);
        int size_v=graph.vertices.size();
        int[] dist = new int[size_v];
        ArrayList<Integer> pred = new ArrayList<Integer>();
        ArrayList<Integer> retorno = new ArrayList<Integer>();
        long start = System.nanoTime();
         for (int i = 0; i < size_v; i++) {
             dist[i] = Integer.MAX_VALUE;
             pred.add(i,null);
         }
         dist[origem] = 0;
         while (!Q.isEmpty()){
              u=Q.get(0);
              Q.remove(0);
              for (int i = 0; i <graph.adjList.get(u).size(); i++){
                  v = graph.adjList.get(u).get(i).sink;
                  w = graph.adjList.get(u).get(i).weight;
                  if(dist[v]>dist[u]+w){
                      dist[v]=dist[u]+w;
                      pred.set(v, u);
                  }
              }
         }   
         long finish = System.nanoTime();
         long total = finish - start;
          
         for(k=0;r!=origem;k++){
             if(k==0){
                 r=destino;
                System.out.println("predecessor de destino "+pred.get(r));

                 retorno.add(k,destino);
             }else{
                 r=pred.get(r);
                 retorno.add(k,r);
             }
             
         }
         System.out.println(retorno);
         System.out.println("tempo "+total+" nanossegundos");
         System.out.println("Custo: "+ dist[destino]);
    }
}
