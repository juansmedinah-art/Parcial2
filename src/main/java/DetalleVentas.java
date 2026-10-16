public class DetalleVentas {
    private int cantidad;
    private double precioFinal;
    private double subtotal;
    private Inventario itemInv;

    public DetalleVentas(int cantidad, double precioFinal, double subtotal, Inventario itemInv) {
        this.cantidad = cantidad;
        this.precioFinal = precioFinal;
        this.subtotal = subtotal;
        this.itemInv = itemInv;
    }

    public DetalleVentas(int cantVenta, Inventario itemInv, Cliente clienteVenta) {
        this.cantidad = cantVenta;
        this.itemInv = itemInv;
        this.precioFinal = calcularPrecioFinal(clienteVenta);
        this.subtotal = calcularSubtotal();
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
        return itemInv;
    }

    public void setInventario(Inventario inventario) {
        this.itemInv = inventario;
    }

    @Override
    public String toString() {
        return "DetalleVentas: " +
                "cantidad=" + cantidad +
                ", precioFinal=" + precioFinal +
                ", subtotal=" + subtotal +
                ", inventario=" + itemInv;
    }

    public double calcularPrecioFinal(Cliente cliente) {
        double precioConRecargo = itemInv.getPrenda().calcularPrecioConRecargo();
        double descuentoCliente = cliente.getCategoriaCliente().getDescuento();
        return precioConRecargo - (precioConRecargo * descuentoCliente);
    }

    public double calcularSubtotal() {
        return this.precioFinal * this.cantidad;
    }
}