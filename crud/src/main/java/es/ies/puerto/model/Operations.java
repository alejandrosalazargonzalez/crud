package es.ies.puerto.model;
import java.util.Set;

/**
 *  @author: alejandrosalazargonzalez
 *  @version: 1.0.0
 */
public interface Operations {
    public boolean create(Empleado empleado);
    public Empleado read(String identificador);
    public Empleado read(Empleado empleado);
    public boolean update(Empleado empleado);
    public boolean delete(Empleado empleado);
    public Set<Empleado> empleadosPorPuesto(String puesto);
    public Set<Empleado> empleadosPorEdad(String fechaInicio, String fechaFin);
}
