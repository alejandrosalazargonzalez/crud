
package es.ies.puerto.model.fichero;

import java.io.File;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import es.ies.puerto.model.Empleado;

/**
 *  @author: alejandrosalazargonzalez
 *  @version: 1.0.0
 */
public class FileOperationsMap extends FileOperations {
    public FileOperationsMap(){
        super();
    }

    /**
     * lee un archivo y lo retorna como map
     * @param file a leer
     * @return Map<String,Empleado>
     */
    private Map<String, Empleado> readMap(File file){
        Map<String,Empleado> empleadosMap = new TreeMap();
        Set<Empleado> empleados = super.read(file);
        for (Empleado empleado : empleados) {
            empleadosMap.put(empleado.getIdentificador(), empleado);
        }
        return empleadosMap;
    }

    /**
     * busca empleados por su puerto de trabajo
     * @param puesto
     * @return Map<String,Empleado>
     */
    private Map<String, Empleado> empleadosPorPuestoMap(String puesto){
        Map<String,Empleado> empleadosPorPuestoMap = new TreeMap();
        Set<Empleado> empleados = super.empleadosPorPuesto(puesto);
        for (Empleado empleado : empleados) {
            empleadosPorPuestoMap.put(empleado.getIdentificador(), empleado);
        }
        return empleadosPorPuestoMap;
    }

    /**
     * busca a los empleados segun su edad
     * @param fechaInicio de busqueda
     * @param fechaFin de busqueda
     * @return Map<String,Empleado>
     */
    private Map<String, Empleado> empleadosPorEdadMap(String fechaInicio, String fechaFin){
        Map<String,Empleado> empleadosPorEdadMap = new TreeMap();
        Set<Empleado> empleados = super.empleadosPorEdad(fechaInicio,fechaFin);
        for (Empleado empleado : empleados) {
            empleadosPorEdadMap.put(empleado.getIdentificador(), empleado);
        }
        return empleadosPorEdadMap;
    }

}
