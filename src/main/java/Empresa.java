import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nombre;
    private int nit;
    private String direccion;

    private List<Sucursal> listaSucursales;
    private List<Cliente> listaClientes;
    private List<Prenda> catalogoPrendas;

    public Empresa(String nombre, int nit, String direccion) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;

        this.listaSucursales = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        this.catalogoPrendas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Sucursal> getListaSucursales() {
        return listaSucursales;
    }

    public void setListaSucursales(List<Sucursal> listaSucursales) {
        this.listaSucursales = listaSucursales;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Prenda> getCatalogoPrendas() {
        return catalogoPrendas;
    }

    public void setCatalogoPrendas(List<Prenda> catalogoPrendas) {
        this.catalogoPrendas = catalogoPrendas;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", nit=" + nit +
                ", direccion='" + direccion + '\'' +
                ", listaSucursales=" + listaSucursales +
                ", listaClientes=" + listaClientes +
                ", catalogoPrendas=" + catalogoPrendas;
    }

    public boolean registrarSucursal(Sucursal sucursal) {
        for (Sucursal s : listaSucursales) {
            if (s.getCodigo() == sucursal.getCodigo()) {
                return false;
            }
        }
        listaSucursales.add(sucursal);
        return true;
    }

    public boolean registrarPrenda(Prenda prenda) {
        for (Prenda p : catalogoPrendas) {
            if (p.getCodigo() == prenda.getCodigo()) {
                return false; // Código duplicado
            }
        }
        catalogoPrendas.add(prenda);
        return true;
    }

    public boolean registrarCliente(Cliente cliente) {
        for (Cliente c : listaClientes) {
            if (c.getDocumento().equals(cliente.getDocumento())) {
                return false; // Documento duplicado
            }
        }
        listaClientes.add(cliente);
        return true;
    }

    public boolean registrarVendedor(int codigoSucursal, Vendedor vendedor) {

        for (Sucursal s : listaSucursales) {
            for (Vendedor v : s.getListaVendedores()) {
                if (v.getDocumento().equals(vendedor.getDocumento())) {
                    return false; // Documento duplicado
                }
            }
        }

        for (Sucursal s : listaSucursales) {
            if (s.getCodigo() == codigoSucursal) {
                s.getListaVendedores().add(vendedor);
                return true;
            }
        }
        return false;
    }

    public boolean registrarVenta(int codigoSucursal, Ventas venta) {
        Sucursal sucursal = null;
        for (Sucursal s : listaSucursales) {
            if (s.getCodigo() == codigoSucursal) {
                sucursal = s;
                break;
            }
        }

        if (sucursal == null) {
            return false;
        }

        for (DetalleVentas detalle : venta.getListaDetalleVentas()) {
            boolean perteneceASucursal = false;
            for (Inventario inv : sucursal.getListaInventario()) {
                if (inv.getCodigo() == detalle.getInventario().getCodigo()) {
                    perteneceASucursal = true;
                    break;
                }
            }
            if (!perteneceASucursal) {
                return false;
            }
        }

        if (venta.confirmarVenta()) {
            sucursal.getListaVentas().add(venta);
            return true;
        }

        return false;
    }

    public List<Inventario> consultarPrendasAgotadasEmpresa() {
        List<Inventario> agotadas = new ArrayList<>();
        for (Sucursal sucursal : listaSucursales) {
            agotadas.addAll(sucursal.consultarPrendasAgotadas());
        }
        return agotadas;
    }

    public List<Ventas> consultarVentasPorVendedor(String documentoVendedor) {
        for (Sucursal sucursal : listaSucursales) {
            for (Vendedor v : sucursal.getListaVendedores()) {
                if (v.getDocumento().equals(documentoVendedor)) {
                    return v.getHistorialVentas();
                }
            }
        }
        return null;
    }

    public List<Ventas> consultarComprasPorCliente(String documentoCliente) {
        for (Cliente c : listaClientes) {
            if (c.getDocumento().equals(documentoCliente)) {
                return c.getHistorialCompras();
            }
        }
        return null;
    }

    public double consultarIngresosSucursal(int codigoSucursal) {
        for (Sucursal sucursal : listaSucursales) {
            if (sucursal.getCodigo() == codigoSucursal) {
                return sucursal.calcularIngresosTotales();
            }
        }
        return 0.0;
    }

    public Prenda consultarPrendaMasVendida() {
        Prenda masVendida = null;
        int maxCantidadVendida = 0;

        for (Prenda prenda : catalogoPrendas) {
            int acumuladoPrenda = 0;

            for (Sucursal sucursal : listaSucursales) {
                for (Ventas venta : sucursal.getListaVentas()) {
                    for (DetalleVentas detalle : venta.getListaDetalleVentas()) {
                        if (detalle.getInventario().getPrenda().getCodigo() == prenda.getCodigo()) {
                            acumuladoPrenda += detalle.getCantidad();
                        }
                    }
                }
            }

            if (acumuladoPrenda > maxCantidadVendida) {
                maxCantidadVendida = acumuladoPrenda;
                masVendida = prenda;
            }
        }

        return masVendida;
    }
}