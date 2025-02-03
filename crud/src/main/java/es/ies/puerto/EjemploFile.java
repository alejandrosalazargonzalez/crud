package es.ies.puerto;

import es.ies.puerto.model.Empleado;
import es.ies.puerto.model.Operations;
import es.ies.puerto.model.fichero.FileOperations;

/**
 *  @author: alejandrosalazargonzalez
 *  @version: 1.0.0
 */
public class EjemploFile {
    
    public static void main(String[] args) {
        Empleado empleado = new Empleado("1", "Alex", "Vicedirector", 20000,"13/10/1994");
        System.out.println(empleado);

        FileOperations operaciones = new FileOperations();
        boolean insertar = operaciones.create(empleado);
        if (insertar) {
            System.out.println("Se ha insertado correctamente");
        }  else{
            System.out.println("No se ha insertado el elemento");
        }
        Empleado personaBuscar = new Empleado("1");
        personaBuscar = operaciones.read(personaBuscar);
        System.out.println("Persona encontrada: " + personaBuscar);
        Empleado personaBuscar2 = new Empleado("1","Nicolas","Accionista",100000,"14/11/1987");
        System.out.println(operaciones.update(personaBuscar2));
    }    
}