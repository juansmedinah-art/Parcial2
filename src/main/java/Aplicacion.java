import java.util.List;
import java.util.Scanner;

public class Aplicacion {

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Empresa empresa = new Empresa("Moda Style", 111, "carrerra 19 # 23");
        Sucursal sucursal = new Sucursal(123, "Belen", "calle 18# 12-47,", " Genova");
        empresa.registrarSucursal(sucursal);

        int n;
        do {
            System.out.println("----Bienvenido a Moda Style----");
            System.out.println("1. Registrar sucursal");
            System.out.println("2. Registrar prendas de vestir");
            System.out.println("3. Registrar persona");
            System.out.println("4. Registrar venta");
            System.out.println("5. registrar inventario");
            System.out.println("6. Consultar inventarios");
            System.out.println("7. Consultar prendas agotadas");
            System.out.println("8. Consultar ventas de los clientes");
            System.out.println("9. Consultar ventas de empleados");
            System.out.println("10. Consultar ingresos de cada Sucursal");
            System.out.println("11. Consultar prenda mas vendida");
            System.out.println("0. salir");

            n = sc.nextInt();
            sc.nextLine();
            switch (n) {

                case 1:
                    System.out.println("----Registrar sucursal----");

                    System.out.println("ingrese el codigo: ");
                    int codigoS = sc.nextInt();
                    sc.nextLine();
                    System.out.println("ingrese el nombre de la sucursal: ");
                    String nombreS = sc.nextLine();
                    System.out.println("ingrese la direccion: ");
                    String direccionS = sc.nextLine();
                    System.out.println("ingrese la ciudad donde esta ubicada: ");
                    String ciudadS = sc.nextLine();

                    Sucursal sucursal1 = new Sucursal(codigoS, nombreS, direccionS, ciudadS);

                    if (empresa.registrarSucursal(sucursal1)) {
                        System.out.println("sucursal agregada correctamente");
                    } else {
                        System.out.println("sucursal ya existe");
                    }
                    break;

                case 2:
                    System.out.println("----Registrar prendas de vestir----");

                    System.out.println("ingrese el codigo de la prenda: ");
                    int codigoP = sc.nextInt();
                    sc.nextLine();
                    System.out.println("ingrese eñ nombre de la prenda: ");
                    String nombreP = sc.nextLine();
                    System.out.println("ingrese marca de la prenda: ");
                    String marca = sc.nextLine();
                    System.out.println("ingrese el precio por unidad: ");
                    double precioUnitario = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("Digite la categoria de la prenda: ");
                    int i = 1;
                    for (CategoriaPrenda catetegoria : CategoriaPrenda.values()) {
                        System.out.println(i + ". " + catetegoria);
                        i++;
                    }
                    int opcionCategoria = sc.nextInt();
                    sc.nextLine();
                    CategoriaPrenda categoriaP = null;
                    switch (opcionCategoria) {
                        case 1:
                            categoriaP = CategoriaPrenda.CAMISETA;
                            break;
                        case 2:
                            categoriaP = CategoriaPrenda.PANTALON;
                            break;
                        case 3:
                            categoriaP = CategoriaPrenda.VESTIDO;
                            break;
                        case 4:
                            categoriaP = CategoriaPrenda.CHAQUETA;
                            break;
                        case 5:
                            categoriaP = CategoriaPrenda.CALZADO;
                            break;
                        default:
                            System.out.println("opcion no valida");
                    }

                    Prenda prenda = new Prenda(codigoP, nombreP, marca, precioUnitario, categoriaP);
                    if (empresa.registrarPrenda(prenda)) {
                        System.out.println("la prenda ha sido registrada correctamente");
                    }else{
                        System.out.println("el codigo o la prenda ya existe");
                    }
                    break;

                case 3:
                    System.out.println("----Registrar persona----");
                    System.out.println("¿que tipo de persona desea registrar?");
                    System.out.println("1.Cliente");
                    System.out.println("2.Empleado");

                    System.out.println("ingrese el documento de la persona: ");
                    int documentoP = sc.nextInt();
                    sc.nextLine();
                    System.out.println("ingrese el nombre completo: ");
                    String nombreCompleto = sc.nextLine();
                    System.out.println("ingrese el correo electronico: ");
                    String correo = sc.nextLine();
                    System.out.println("ingrese el numero de telefono: ");
                    int telefono = sc.nextInt();
                    sc.nextLine();

                    int tipo = sc.nextInt();
                    sc.nextLine();

                    switch (tipo) {
                        case 1:
                            System.out.println("ingrese el codigo de afiliacion: ");
                            int codigoC = sc.nextInt();
                            sc.nextLine();

                            System.out.println("Digite la categoria del cliente: ");
                            int j = 1;
                            for (CategoriaCliente catetegoria : CategoriaCliente.values()) {
                                System.out.println(j + ". " + catetegoria);
                                j++;
                            }
                            int opcionCategoriaC = sc.nextInt();
                            sc.nextLine();
                            CategoriaCliente categoriaC = null;
                            switch (opcionCategoriaC) {
                                case 1:
                                    categoriaC = CategoriaCliente.BRONCE;
                                    break;
                                case 2:
                                    categoriaC = CategoriaCliente.PLATA;
                                    break;
                                case 3:
                                    categoriaC = CategoriaCliente.ORO;
                                    break;
                                default:
                                    System.out.println("opcion no valida");
                            }

                            Cliente cliente = new Cliente(documentoP, nombreCompleto, correo, telefono, codigoC, categoriaC);
                            if (empresa.registrarCliente(cliente)) {
                                System.out.println("cliente registrado correctamente");
                            } else {
                                System.out.println("cliente ya existe");
                            }
                            break;
                        case 2:
                            System.out.println("ingrese el codigo de empleado: ");
                            int codigoE = sc.nextInt();
                            sc.nextLine();
                            System.out.println("ingrese la fecha de contratacion (DD/MM/AAAA): ");
                            String fechaContratacion = sc.nextLine();
                            System.out.println("ingrese el salario basico: ");
                            double salario = sc.nextDouble();
                            sc.nextLine();
                            System.out.println("ingrese el codigo de la sucursal a la que pertenecera:");
                            int codigoSs = sc.nextInt();
                            sc.nextLine();

                            Vendedor vendedor = new Vendedor(documentoP, nombreCompleto, correo, telefono, codigoE, fechaContratacion, salario);
                            if (empresa.registrarVendedor(codigoSs, vendedor)) {
                                System.out.println("el vendedor ha sido registrado correctamente");
                            } else {
                                System.out.println("vendedor ya existente");
                            }
                            break;
                    }
                    break;

                case 4:
                    System.out.println("====Registrar venta====");

                    System.out.println("ingrese el codigo de la sucursal: ");
                    int codSucursalVenta = sc.nextInt();
                    sc.nextLine();

                    Sucursal sucursalVenta = null;
                    for (Sucursal s : empresa.getListaSucursales()) {
                        if (s.getCodigo() == codSucursalVenta) {
                            sucursalVenta = s;
                            break;
                        }
                    }

                    if (sucursalVenta == null) {
                        System.out.println("la sucursal no existe");
                        break;
                    }

                    System.out.println("ingrese el documento del cliente: ");
                    int docClienteVenta = sc.nextInt();
                    sc.nextLine();

                    Cliente clienteVenta = null;
                    for (Cliente c : empresa.getListaClientes()) {
                        if (c.getDocumento() == docClienteVenta) {
                            clienteVenta = c;
                            break;
                        }
                    }

                    if (clienteVenta == null) {
                        System.out.println("el cliente no esta registrado");
                        break;
                    }

                    System.out.println("ingrese el documento del vendedor: ");
                    int docVendedorVenta = sc.nextInt();
                    sc.nextLine();

                    Vendedor vendedorVenta = null;
                    for (Vendedor v : sucursalVenta.getListaVendedores()) {
                        if (v.getDocumento() == docVendedorVenta) {
                            vendedorVenta = v;
                            break;
                        }
                    }

                    if (vendedorVenta == null) {
                        System.out.println("el vendedor no pertenece a esta sucursal");
                        break;
                    }

                    System.out.println("ingrese el codigo de la venta: ");
                    int codigoVenta = sc.nextInt();
                    sc.nextLine();

                    System.out.println("ingrese la fecha de la venta (DD/MM/AAAA): ");
                    String fechaVenta = sc.nextLine();

                    Ventas nuevaVenta = new Ventas(codigoVenta, fechaVenta, clienteVenta, vendedorVenta);

                    boolean continuarAgregando = true;
                    while (continuarAgregando) {
                        System.out.println("ingrese el codigo del inventario a comprar: ");
                        int codInvVenta = sc.nextInt();
                        sc.nextLine();

                        Inventario itemInv = null;
                        for (Inventario inv : sucursalVenta.getListaInventario()) {
                            if (inv.getCodigo() == codInvVenta) {
                                itemInv = inv;
                                break;
                            }
                        }

                        if (itemInv == null) {
                            System.out.println("el inventario no existe en esta sucursal");
                        } else {
                            System.out.println("ingrese la cantidad a comprar: ");
                            int cantVenta = sc.nextInt();
                            sc.nextLine();

                            DetalleVentas detalle = new DetalleVentas(cantVenta, itemInv, clienteVenta);
                            nuevaVenta.agregarDetalleVenta(detalle);
                            System.out.println("producto agregado a la venta");
                        }

                        System.out.println("¿desea agregar otro producto? (1: Si / 0: No): ");
                        int respVenta = sc.nextInt();
                        sc.nextLine();
                        if (respVenta != 1) {
                            continuarAgregando = false;
                        }
                    }

                    if (empresa.registrarVenta(codSucursalVenta, nuevaVenta)) {
                        System.out.println("venta registrada con exito");
                        System.out.println("total de la venta: " + nuevaVenta.calcularTotalVenta());
                    } else {
                        System.out.println("no se pudo registrar la venta (stock insuficiente o datos incorrectos)");
                    }
                    break;

                case 5:
                    System.out.println("----registrar inventario----");

                    System.out.println("ingrese el codigo de la sucursal: ");
                    int codSucInv = sc.nextInt();
                    sc.nextLine();

                    Sucursal sucursalInv = null;
                    for (Sucursal s : empresa.getListaSucursales()) {
                        if (s.getCodigo() == codSucInv) {
                            sucursalInv = s;
                            break;
                        }
                    }

                    if (sucursalInv == null) {
                        System.out.println("la sucursal no existe");
                        break;
                    }

                    System.out.println("ingrese el codigo del inventario: ");
                    int codigoI = sc.nextInt();
                    sc.nextLine();
                    System.out.println("ingrese la talla: ");
                    String talla = sc.nextLine();
                    System.out.println("ingrese color: ");
                    String color = sc.nextLine();
                    System.out.println("ingrese la cantidad: ");
                    int cantidad = sc.nextInt();
                    sc.nextLine();
                    System.out.println("ingrese el codigo de la prenda elegida: ");
                    int codigo = sc.nextInt();
                    sc.nextLine();

                    Prenda prendaElegida = null;
                    for (Prenda p : empresa.getCatalogoPrendas()) {
                        if (p.getCodigo() == codigo) {
                            prendaElegida = p;
                            break;
                        }
                    }

                    if (prendaElegida == null) {
                        System.out.println("la prenda no existe");
                    } else {
                        Inventario inventario = new Inventario(codigoI, talla, color, cantidad, prendaElegida);
                        if (sucursalInv.registrarInventario(inventario)) {
                            System.out.println("inventario agregado correctamente");
                        } else {
                            System.out.println("datos incorrectos");
                        }
                    }
                    break;

                case 6:
                    System.out.println("----consultar inventarios----");

                    System.out.println("ingrese el codigo de la sucursal: ");
                    int codSucConsulta = sc.nextInt();
                    sc.nextLine();

                    Sucursal sucConsulta = null;
                    for (Sucursal s : empresa.getListaSucursales()) {
                        if (s.getCodigo() == codSucConsulta) {
                            sucConsulta = s;
                            break;
                        }
                    }

                    if (sucConsulta == null) {
                        System.out.println("la sucursal no existe");
                    } else {
                        System.out.println("Inventario de la sucursal " + sucConsulta.getNombre() + ":");
                        for (Inventario inv : sucConsulta.consultarPrendasDisponibles()) {
                            System.out.println("Codigo: " + inv.getCodigo() +
                                    "Prenda: " + inv.getPrenda().getNombre() +
                                    "Talla: " + inv.getTalla() +
                                    "Color: " + inv.getColor() +
                                    "Cantidad disponible: " + inv.getCantidadD());
                        }
                    }
                    break;

                case 7:
                    System.out.println("----consultar prendas agotadas----");

                    for (Inventario agota : empresa.consultarPrendasAgotadasEmpresa()) {
                        System.out.println(agota);
                    }
                    break;

                case 8:
                    System.out.println("----consultar compras de los clientes----");

                    System.out.println("ingrese el documento del cliente: ");
                    int documentoCliente = sc.nextInt();
                    sc.nextLine();

                    List<Ventas> comprasCliente = empresa.consultarComprasPorCliente(documentoCliente);
                    if (comprasCliente != null) {
                        for (Ventas v : comprasCliente) {
                            System.out.println(v);
                        }
                    }
                    break;

                case 9:
                    System.out.println("----consultar ventas de empleados----");
                    int documentoEmpleado = sc.nextInt();
                    sc.nextLine();

                    List<Ventas> ventasVendedor = empresa.consultarVentasPorVendedor(documentoEmpleado);
                    if (ventasVendedor != null) {
                        for (Ventas e : ventasVendedor) {
                            System.out.println(e);
                        }
                    }
                    break;

                case 10:
                    System.out.println("----consultar ingresos de cada sucursal----");

                    System.out.println("ingrese el codigo de la sucursal que desea averiguar: ");
                    int codigoSucursal = sc.nextInt();
                    sc.nextLine();

                    double ingresosSucursal = empresa.consultarIngresosSucursal(codigoSucursal);

                    System.out.println(ingresosSucursal);
                    break;

                case 11:
                    System.out.println("----consultar prenda mas vendida----");

                    Prenda masVendida = empresa.consultarPrendaMasVendida();
                    System.out.println(masVendida);
                    break;

                case 0:
                    System.out.println("programa finalizado");
                    break;

                default:
                    System.out.println("opcion no valida");
            }
        }while (n!=0);

    }
}