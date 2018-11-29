package graphtheoryjava;

import graphtheoryjava.algorithms.Info;
import graphtheoryjava.algorithms.Search;
import graphtheoryjava.util.Reader;
import graphtheoryjava.util.Graph;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner ler = new Scanner (System.in);
        Floyd floyd = new Floyd();
        Bellman bellman = new Bellman();
        Dijkstra dijkstra = new Dijkstra();
        System.out.print("Informe a origem ");
        int origem = ler.nextInt();
        System.out.print("Informe o destino ");
        int destino = ler.nextInt();
        System.out.println("Algorítmo:\n1-Dijkstra\n2-Bellman Ford\n3-Floyd-Warhsall");
        int alg= ler.nextInt();
        switch(alg){
            case 1:
                
                dijkstra.ideal(origem,destino);
                 
                break;
            case 2:
                bellman.ideal(origem,destino);
                break;
            case 3:
                floyd.ideal(origem,destino);
                break;
        }
    }
    }
