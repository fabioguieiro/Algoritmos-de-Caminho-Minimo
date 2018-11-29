package graphtheoryjava;
import graphtheoryjava.algorithms.Info;
import graphtheoryjava.algorithms.Search;
import graphtheoryjava.util.Reader;
import graphtheoryjava.util.Graph;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Scanner;
public class Bellman {
     public void ideal (int origem, int destino) throws IOException{
        Scanner ler = new Scanner (System.in);
        int r=-1;
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
        int are = graph.edges.size();
        ArrayList<Integer> pred = new ArrayList<Integer>();
        ArrayList<Integer> retorno = new ArrayList<Integer>();
        long start = System.nanoTime();
        for (int i = 0; i < size_v; i++) {
            dist[i] = 99999;
            pred.add(i,null);
        }
        dist[origem] = 0;
        int u,v,w;
        
        for (int i = 0; i < size_v ; i++) {
            
            for (int j = 0; j < are; j++) {
                u=graph.edges.get(j).source;
                v = graph.edges.get(j).sink;
                w = graph.edges.get(j).weight;
                if(dist[v]>dist[u]+w){
                    dist[v] =dist[u]+w;
                    pred.set(v, u);
                }
            }
        }
        for (int j = 0; j < are; j++) {
                u = graph.edges.get(j).source;
                v = graph.edges.get(j).sink;
                w = graph.edges.get(j).weight;
                if(dist[v]>dist[u]+w){
                    System.out.println("Ciclo Negativo ");
                    System.exit(1);
                }
            }
        long finish = System.nanoTime();
         long total = finish - start;
         
         for(int k=0;r!=origem;k++){
            if(k==0){
                 r=destino;
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
