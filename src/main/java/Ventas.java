import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ventas {
    private int codigo;
    private Date fechaCompra;
    private Cliente cliente;
    private Vendedor vendedor;
    private List<DetalleVentas> listaDetalleVentas;

    public Ventas(int codigo, String fechaCompra, Cliente cliente, Vendedor vendedor) {
        this.codigo = codigo;
        this.fechaCompra = fechaCompra;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.listaDetalleVentas = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public List<DetalleVentas> getListaDetalleVentas() {
        return listaDetalleVentas;
    }

    public void setListaDetalleVentas(List<DetalleVentas> listaDetalleVentas) {
        this.listaDetalleVentas = listaDetalleVentas;
    }

    @Override
    public String toString() {
        return "Ventas: " +
                "codigo=" + codigo +
                ", fechaCompra=" + fechaCompra +
                ", cliente=" + cliente +
                ", vendedor=" + vendedor +
                ", listaDetalleVentas=" + listaDetalleVentas;
    }

    public void agregarDetalleVenta(DetalleVentas detalle) {
        this.listaDetalleVentas.add(detalle);
    }

    public double calcularTotalVenta() {
        double total = 0;
        for (DetalleVentas detalle : listaDetalleVentas) {
            total += detalle.getSubtotal();
        }
        return total;
    }

    public boolean verificarStockDisponible() {
        for (DetalleVentas detalleEvaluado : listaDetalleVentas) {
            Inventario inv = detalleEvaluado.getInventario();
            int cantidadSolicitadaTotal = 0;

            for (DetalleVentas d : listaDetalleVentas) {
                if (d.getInventario().getCodigo() == inv.getCodigo()) {
                    cantidadSolicitadaTotal += d.getCantidad();
                }
            }

            if (cantidadSolicitadaTotal > inv.getCantidadD()) {
                return false;
            }
        }
        return true;
    }

    public boolean confirmarVenta() {
        if (!verificarStockDisponible() || listaDetalleVentas.isEmpty()) {
            return false;
        }

        for (DetalleVentas detalle : listaDetalleVentas) {
            Inventario inv = detalle.getInventario();
            inv.descontarStock(detalle.getCantidad());
            inv.agregarDetalleHistorial(detalle);
        }

        cliente.agregarCompra(this);
        vendedor.agregarVenta(this);
        return true;
    }
}