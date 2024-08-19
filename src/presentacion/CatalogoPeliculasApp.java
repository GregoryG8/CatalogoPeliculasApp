package presentacion;

import dominio.Pelicula;
import servicio.IServicioPeliculas;
import servicio.ServicioPeliculasLista;

import java.util.Scanner;

public class CatalogoPeliculasApp {
    public static void main(String[] args) {
        var salir = false;
        var console = new Scanner(System.in);
        //Implementacion del servicio
        IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();
        while (!salir){
            try {
                mostrarMenu();
                salir = ejecutarOpciones(console, servicioPeliculas)
            }catch (Exception e){
                System.out.println("Ocurrio un error: " + e.getMessage());
            }
            System.out.println();
        }
    }

    private static void mostrarMenu(){
        System.out.println("""
                *** Catalogo de Peliculas ***
                1.Agregar pelicula
                2.Listar peliculas
                3.Buscar pelicula
                """);
    }

    private static boolean ejecutarOpciones(Scanner console, IServicioPeliculas servicioPeliculas){
        var opcion = Integer.parseInt(console.nextLine());
        var salir = false;
        switch (opcion){
            case 1:
                System.out.println("Introduzca el titulo: ");
                var nombrePelicula = console.nextLine();
                servicioPeliculas.agregarPelicula(new Pelicula(nombrePelicula));

            case 2:
                servicioPeliculas.listarPeliculas();

            case 3:
                System.out.println("Introduzca el titulo a buscar: ");
                var buscar = console.nextLine();
                servicioPeliculas.buscarPelicula(new Pelicula(buscar));

            case 4:
                System.out.println("Hasta luego.");
                salir = true;

            default:
                System.out.println("Opcion no reconocida: " + opcion);
        }
        return salir;
    }
}