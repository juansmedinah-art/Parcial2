import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {
    private int codigoAfiliacion;
    private CategoriaCliente categoriaCliente;
    private List<Ventas> historialCompras;

    public Cliente(String documento, String nombreCompleto, String correo, int telefono, int codigoAfiliacion, CategoriaCliente categoriaCliente) {
        super(documento, nombreCompleto, correo, telefono);
        this.codigoAfiliacion = codigoAfiliacion;
        this.categoriaCliente = categoriaCliente;
        this.historialCompras = new ArrayList<>();
    }

    public int getCodigoAfiliacion() {
        return codigoAfiliacion;
    }

    public void setCodigoAfiliacion(int codigoAfiliacion) {
        this.codigoAfiliacion = codigoAfiliacion;
    }

    public CategoriaCliente getCategoriaCliente() {
        return categoriaCliente;
    }

    public void setCategoriaCliente(CategoriaCliente categoriaCliente) {
        this.categoriaCliente = categoriaCliente;
    }

    public List<Ventas> getHistorialCompras() {
        return historialCompras;
    }

    public void setHistorialCompras(List<Ventas> historialCompras) {
        this.historialCompras = historialCompras;
    }

    public void agregarCompra(Ventas venta) {
        this.historialCompras.add(venta);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "codigoAfiliacion=" + codigoAfiliacion +
                ", categoriaCliente=" + categoriaCliente +
                ", historialCompras=" + historialCompras +
                '}';
    }
}