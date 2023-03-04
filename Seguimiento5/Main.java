package Seguimiento5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static BST tree = new BST();
    public static void main(String... args) {
        System.out.println("Digite los nombres separados por un espacio ordenados de menor a mayor");
        Scanner scanner = new Scanner(System.in);
        String names = scanner.nextLine();
        String[] namesArray = names.split(" ");
        ArrayList<String> alist = new ArrayList<String>();
        Collections.addAll(alist, namesArray);
        if (!alist.isEmpty() && !names.equals("")) {
            tree.splitArray(alist);
            System.out.println("Raiz: " + tree.getRoot().getKey());
            tree.inOrderReverse();
            System.out.println("\nProfundidad del arbol: "+ tree.depth());
        } else {
            System.out.println("Por favor ingrese una entrada");
        }
        
        
    }


}
