import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private int codigo;
    private String talla;
    private String color;
    private int cantidadD;
    private Prenda prenda;
    private List<DetalleVentas> historialVentasInventario;

    public Inventario(int codigo, String talla, String color, int cantidadD, Prenda prenda) {
        this.codigo = codigo;
        this.talla = talla;
        this.color = color;
        this.cantidadD = cantidadD;
        this.prenda = prenda;
        this.historialVentasInventario = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCantidadD() {
        return cantidadD;
    }

    public void setCantidadD(int cantidadD) {
        this.cantidadD = cantidadD;
    }

    public Prenda getPrenda() {
        return prenda;
    }

    public void setPrenda(Prenda prenda) {
        this.prenda = prenda;
    }

    public List<DetalleVentas> getHistorialVentasInventario() {
        return historialVentasInventario;
    }

    public void setHistorialVentasInventario(List<DetalleVentas> historialVentasInventario) {
        this.historialVentasInventario = historialVentasInventario;
    }

    @Override
    public String toString() {
        return "Inventario: " +
                "codigo=" + codigo +
                ", talla='" + talla + '\'' +
                ", color='" + color + '\'' +
                ", cantidadD=" + cantidadD +
                ", prenda=" + prenda +
                ", historialVentasInventario=" + historialVentasInventario;
    }



    public void agregarDetalleHistorial(DetalleVentas detalle) {
        this.historialVentasInventario.add(detalle);
    }

    public void descontarStock(int cantidad) {
        this.cantidadD -= cantidad;
    }
}