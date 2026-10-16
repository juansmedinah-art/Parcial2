import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Vendedor extends Persona {
    private int codigoEmpleado;
    private String fechaContratacion;
    private double salario;
    private List<Ventas> historialVentas;

    public Vendedor(int documento, String nombreCompleto, String correo, int telefono, int codigoEmpleado, String fechaContratacion, double salario) {
        super(documento, nombreCompleto, correo, telefono);
        this.codigoEmpleado = codigoEmpleado;
        this.fechaContratacion = fechaContratacion;
        this.salario = salario;
        this.historialVentas = new ArrayList<>();
    }

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public List<Ventas> getHistorialVentas() {
        return historialVentas;
    }

    public void setHistorialVentas(List<Ventas> historialVentas) {
        this.historialVentas = historialVentas;
    }
    @Override
    public String toString() {
        return "Vendedor: " +
                "codigoEmpleado=" + codigoEmpleado +
                ", fechaContratacion=" + fechaContratacion +
                ", salario=" + salario +
                ", historialVentas=" + historialVentas;
    }
    public void agregarVenta(Ventas venta) {
        this.historialVentas.add(venta);
    }


}