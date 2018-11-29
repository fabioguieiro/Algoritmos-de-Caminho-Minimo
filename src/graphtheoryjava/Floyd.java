package graphtheoryjava;
import graphtheoryjava.util.Graph;
import graphtheoryjava.util.Reader;
import java.io.IOException;
import java.util.Scanner;
public class Floyd {
     public void ideal (int origem, int destino) throws IOException{
        Scanner ler = new Scanner (System.in);
         System.out.print("Entre com o nome do grafo ");
         String nome = ler.nextLine();
         if(!nome.contains(".txt")){
         nome=nome.concat(".txt");  
         }
         Reader reader= new Reader();
         Graph graph= reader.readFile(nome);
         System.out.println(graph);
    }
}
