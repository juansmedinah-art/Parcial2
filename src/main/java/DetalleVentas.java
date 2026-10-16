public class DetalleVentas {
    private int cantidad;
    private double precioFinal;
    private double subtotal;
    private Inventario inventario;

    public DetalleVentas(int cantidad, double precioFinal, double subtotal, Inventario inventario) {
        this.cantidad = cantidad;
        this.precioFinal = precioFinal;
        this.subtotal = subtotal;
        this.inventario = inventario;
    }

    public DetalleVentas(int cantVenta, Inventario itemInv, Cliente clienteVenta) {
    }

    public double calcularPrecioFinal(Cliente cliente) {
        double precioConRecargo = inventario.getPrenda().calcularPrecioConRecargo();
        double descuentoCliente = cliente.getCategoriaCliente().getDescuento();
        return precioConRecargo - (precioConRecargo * descuentoCliente);
    }

    public double calcularSubtotal() {
        return this.precioFinal * this.cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    @Override
    public String toString() {
        return "DetalleVentas: " +
                "cantidad=" + cantidad +
                ", precioFinal=" + precioFinal +
                ", subtotal=" + subtotal +
                ", inventario=" + inventario;
    }
}