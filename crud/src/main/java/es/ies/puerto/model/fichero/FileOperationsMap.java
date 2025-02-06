
package es.ies.puerto.model.fichero;

import java.io.File;
import java.io.IOException;
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

    public boolean createMap(Empleado empleado) {
        if (empleado == null || empleado.getIdentificador().isEmpty() || empleado.getIdentificador() == null) {
            return false;
        }
        Map<String,Empleado> empleados = readMap(fichero);
        if (empleados.containsKey(empleado.getIdentificador())) {
            return false;
        }
        empleados.put(empleado.getIdentificador(), empleado);
        try {
            super.fichero.delete();
            super.fichero.createNewFile();
            for (Empleado empleado2 : empleados.values()) {
                create(empleado.toString(), fichero);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
        }

    /**
     * lee un archivo y lo retorna como map
     * @param file a leer
     * @return Map<String,Empleado>
     */
    private Map<String, Empleado> readMap(File file){
        Map<String,Empleado> empleadosMap = new TreeMap<>();
        Set<Empleado> empleados = super.read(file);
        for (Empleado empleado : empleados) {
            empleadosMap.put(empleado.getIdentificador(), empleado);
        }
        return empleadosMap;
    }

    /**
     * Actualiza la informcion 
     * @param empleado
     * @return
     */
    public boolean updateMap(Empleado empleado) {
        if (empleado == null || empleado.getIdentificador().isEmpty() || empleado.getIdentificador() == null) {
            return false;
        }
        Map<String,Empleado> empleados = readMap(fichero);
        if (!empleados.containsKey(empleado.getIdentificador())) {
            return false;
        }
        for (Empleado empleadoBuscada : empleados.values()) {
            if (empleadoBuscada.equals(empleado)) {
                empleados.put(empleado.getIdentificador(),empleado);
                return updateFileMap(empleados, fichero);
            }
        }
        System.out.println(empleados);
        return true;
    }

    /**
     * Actualiza la informacion del ficher0
     * @param empleados de la empresa
     * @param file donde va la informacion
     * @return true/false
     */
    protected boolean updateFileMap(Map<String,Empleado> empleados, File file){
        try {
            file.delete();
            file.createNewFile();
        } catch (IOException e) {
            return false;
        }
        for(Empleado empleado : empleados.values()){
            create(empleado);
        }
        return true;
    }

    /**
     * Elimina a un empleado
     */
    @Override
    public boolean delete(Empleado empleado) {
        if (empleado == null || empleado.getIdentificador().isEmpty() || empleado.getIdentificador() == null) {
            return false;
        }
        Map<String,Empleado> empleados = readMap(fichero);
        if (!empleados.containsKey(empleado.getIdentificador())) {
            return false;
        }
        for (Empleado empleadoBuscada : empleados.values()) {
            if (empleadoBuscada.equals(empleado)) {
                empleados.remove(empleadoBuscada.getIdentificador());
                return updateFileMap(empleados, fichero);
            }
        }
        System.out.println(empleados);
        return true;
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
