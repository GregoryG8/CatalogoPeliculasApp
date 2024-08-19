package servicio;

import dominio.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ServicioPeliculasLista implements IServicioPeliculas {

    private final List<Pelicula> peliculas;

    public ServicioPeliculasLista() {
        this.peliculas = new ArrayList<>();
    }

    @Override
    public void listarPeliculas() {
        System.out.println("Listado de Peliculas...");
        peliculas.forEach(System.out::println);
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Se agrego la pelicula: " + pelicula);
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        //Regresa indice de la pelicula encontrada en la lista
        var indice = peliculas.indexOf(pelicula);
        if (indice == -1) {
            System.out.println("No se encontro la pelicula: " + pelicula);
        }
        System.out.println("Pelicula encontrada en el indice: " + indice);
    }

    public static void main(String[] args) {
        var pelicula1 = new Pelicula("Batman");

        //Creamos el servicio (patron de diseno service)
        IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();
        //Agrega la pelicula a la lista
        servicioPeliculas.agregarPelicula(pelicula1);
        // Listar peliculas
        servicioPeliculas.listarPeliculas();
        //Buscar pelicula, se implementa equals y hash code
        servicioPeliculas.buscarPelicula(pelicula1);
    }
}
