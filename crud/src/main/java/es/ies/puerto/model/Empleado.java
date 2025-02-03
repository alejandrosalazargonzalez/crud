package es.ies.puerto.model;
import java.time.LocalDate;
import java.util.Objects;

public class Empleado {
    String identificador;
    String nombre;
    String puesto;
    double sueldo;
    String fechaNacimiento;

    /**
     * Constructor vacio
     */
    public Empleado(){
    }

    /**
     * Constructor con el identificadr
     * @param identificador
     */
    public Empleado(String identificador){
        this.identificador = identificador;
    }

    /**
     * Constructor completo
     * @param identificador
     * @param nombre
     * @param puesto
     * @param sueldo
     * @param fechaNacimiento
     */
    public Empleado(String identificador, String nombre, String puesto, double sueldo, String fechaNacimiento){
        this.identificador = identificador;
        this.nombre = nombre;
        this.puesto = puesto;
        this.sueldo = sueldo;
        this.fechaNacimiento = fechaNacimiento;
    }

    //Getters y Setters
    public String getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return this.puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSueldo() {
        return this.sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Calcula la edad del empleado teniendo en cuenta su fecha de nacimiento
     * @return int edad
     */
    public int getEdad(){
        LocalDate edad = LocalDate.parse(fechaNacimiento);
        return edad.compareTo(LocalDate.now());
    }


    @Override
    public String toString() {
        return getNombre() + ", " + getPuesto() + ", " + getSueldo() + ", " + getFechaNacimiento();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Empleado)) {
            return false;
        }
        Empleado empleado = (Empleado) o;
        return Objects.equals(identificador, empleado.identificador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }
    
}
