import java.util.ArrayList;
import java.util.List;

public class Prenda {
    private int codigo;
    private String nombre;
    private String marca;
    private double precioUnitario;
    private CategoriaPrenda categoriaPrenda;

    public Prenda(int codigo, String nombre, String marca, double precioUnitario, CategoriaPrenda categoriaPrenda) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.precioUnitario = precioUnitario;
        this.categoriaPrenda = categoriaPrenda;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public CategoriaPrenda getCategoriaPrenda() {
        return categoriaPrenda;
    }

    public void setCategoriaPrenda(CategoriaPrenda categoriaPrenda) {
        this.categoriaPrenda = categoriaPrenda;
    }
    @Override
    public String toString() {
        return "Prenda: " +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                ", precioUnitario=" + precioUnitario +
                ", categoriaPrenda=" + categoriaPrenda;
    }

    public double calcularPrecioConRecargo() {
        double recargo = categoriaPrenda.getRecargo();
        return precioUnitario + (precioUnitario * recargo);
    }
}