import java.util.ArrayList;
import java.util.List;

public class Sucursal {
    private int codigo;
    private String nombre;
    private String direccion;
    private String ciudad;

    private List<Inventario> listaInventario;
    private List<Vendedor> listaVendedores;
    private List<Ventas> listaVentas;

    public Sucursal(int codigo, String nombre, String direccion, String ciudad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;

        this.listaInventario = new ArrayList<>();
        this.listaVendedores = new ArrayList<>();
        this.listaVentas = new ArrayList<>();
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Inventario> getListaInventario() {
        return listaInventario;
    }

    public void setListaInventario(List<Inventario> listaInventario) {
        this.listaInventario = listaInventario;
    }

    public List<Vendedor> getListaVendedores() {
        return listaVendedores;
    }

    public void setListaVendedores(List<Vendedor> listaVendedores) {
        this.listaVendedores = listaVendedores;
    }

    public List<Ventas> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Ventas> listaVentas) {
        this.listaVentas = listaVentas;
    }

    @Override
    public String toString() {
        return "Sucursal: " +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", listaInventario=" + listaInventario +
                ", listaVendedores=" + listaVendedores +
                ", listaVentas=" + listaVentas;
    }

    public boolean registrarInventario(Inventario inventario) {
        for (Inventario inv : listaInventario) {
            if (inv.getPrenda().getCodigo() == inventario.getPrenda().getCodigo() &&
                    inv.getTalla().equalsIgnoreCase(inventario.getTalla()) &&
                    inv.getColor().equalsIgnoreCase(inventario.getColor())) {
                return false;
            }
        }
        listaInventario.add(inventario);
        return true;
    }

    public List<Inventario> consultarPrendasDisponibles() {
        List<Inventario> disponibles = new ArrayList<>();
        for (Inventario inv : listaInventario) {
            if (inv.getCantidadD() > 0) {
                disponibles.add(inv);
            }
        }
        return disponibles;
    }

    public List<Inventario> consultarPrendasAgotadas() {
        List<Inventario> agotadas = new ArrayList<>();
        for (Inventario inv : listaInventario) {
            if (inv.getCantidadD() == 0) {
                agotadas.add(inv);
            }
        }
        return agotadas;
    }

    public double calcularIngresosTotales() {
        double ingresos = 0;
        for (Ventas venta : listaVentas) {
            ingresos += venta.calcularTotalVenta();
        }
        return ingresos;
    }
}