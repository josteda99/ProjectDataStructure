package BussinnessLogic;

import GUI.UI;
import java.util.*;
import data.*;

public class Tienda {

    public static void main(String[] args) {
        System.out.println("Bienvenido a SU TIENDA AMIGA");
        Scanner sc = new Scanner(System.in);
        /*
         int id;
         //rellenamos de pedidos teniendo en cuenta que el primero que realizo el
         //pedio va a ser el primero que se atienda
         int opcion = -1;
         QueueGeneric<Cliente> colaPedidos = null;
         while (opcion != 0) {
         System.out.println("que opcion desea?: solo numeros");
         UI.imprimirOpciones();
         opcion = sc.nextInt();
         switch (opcion) {
         case 1:
         colaPedidos = new QueueGeneric<Cliente>();
         UI.TareaExitosa();
         break;
         case 2:
         System.out.println("escriba el nombre");
         String nombre = sc.nextLine();
         System.out.println("escriba el id:");
         id = sc.nextInt();
         Cliente clienteSolo = new Cliente(id, nombre);
         colaPedidos.enqueue(clienteSolo);
         UI.TareaExitosa();
         break;
         case 3:

         break;
         case 4:
         System.out.println("el usuario ha sido atendido");
         colaPedidos.dequeue();
         UI.TareaExitosa();
         break;
         case 5:

         break;
         case 6:
         colaPedidos.show();
         UI.TareaExitosa();
         break;
         case 7:
         Random rand = new Random();
         for (int i = 0; i < colaPedidos.size(); i++) {
         id = rand.nextInt(10000);
         Cliente cliente = new Cliente(id);
         colaPedidos.enqueue(cliente);
         }
         UI.TareaExitosa();
         break;
         case 0:
         break;
         default:
         System.out.println("opcion no valida");
         break;

         }
         }
         */
        ListArrayGeneric<Integer> inventario = null;
        ArrayList<Celular> celDis = null;

        Random rand = new Random();
        int nSerie;

        int opcion = -1;

        while (opcion != 0) {
            System.out.println("que opcion desea?: solo numeros");
            UI.impOpcInv();
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    inventario = new ListArrayGeneric<>();
                    celDis = new ArrayList<>();
                    break;
                case 2:
                    System.out.println("cual celular desea eliminar: digite el numero de serie");
                    int nSerieEli = sc.nextInt();
                    inventario.delete(nSerieEli);
                    break;
                case 3:
                    int nSerieBus = sc.nextInt();
                    for (int i = 0; i < celDis.size(); i++) {
                        if (celDis.get(i).getnSerie() == nSerieBus) {
                            System.out.println(celDis.get(nSerieBus).toString());
                        }
                    }
                    break;
                case 4:
                    inventario.show();
                    break;
                case 5:
                    for (int i = 0; i < inventario.size(); i++) {
                        nSerie = rand.nextInt(10000);
                        Celular cel = new Celular(nSerie);
                        celDis.add(cel);
                        inventario.insert(cel.getnSerie());
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }
        }

    }
}
