import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Aplicacion {

    public void main() {
        Scanner sc=new Scanner(System.in);

        Empresa empresa = new Empresa("Moda Style", 111, "carrerra 19 # 23");
        Sucursal sucursal=new Sucursal(123, "Belen", "calle 18# 12-47,", " Genova");
        int n;
        do{
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

            n= sc.nextInt();
            sc.nextLine();
            switch (n){

                case 1:
                    System.out.println("----Registrar sucursal----");

                    System.out.println("ingrese el codigo: ");
                    int codigoS= sc.nextInt();
                    System.out.println("ingrese el nombre de la sucursal: ");
                    String nombreS=sc.nextLine();
                    System.out.println("ingrese la direccion: ");
                    String direccionS= sc.nextLine();
                    System.out.println("ingrese la ciudad donde esta ubicada: ");
                    String ciudadS= sc.nextLine();

                    Sucursal sucursal1= new Sucursal(codigoS, nombreS, direccionS, ciudadS);

                    if(empresa.registrarSucursal(sucursal)){
                        System.out.println("sucursal agregada correctamente");

                    }else{
                        System.out.println("sucursal ya existe");
                    }

                case 2:

                    System.out.println("----Registrar prendas de vestir----");

                    System.out.println("ingrese el codigo de la prenda: ");
                    int codigoP= sc.nextInt();
                    System.out.println("ingrese eñ nombre de la prenda: ");
                    String nombreP= sc.nextLine();
                    System.out.println("ingrese marca de la prenda: ");
                    String marca= sc.nextLine();
                    System.out.println("ingrese el precio por unidad: ");
                    double precioUnitario= sc.nextDouble();


                    System.out.println("Digite la categoria de la prenda: ");
                    int i=1;
                    for (CategoriaPrenda catetegoria: CategoriaPrenda.values()){
                        System.out.println(i+". "+catetegoria);
                        i++;
                    }
                    int opcionCategoria= sc.nextInt();
                    sc.nextLine();
                    CategoriaPrenda categoriaP=null;
                    switch (opcionCategoria){
                        case 1:
                            categoriaP=CategoriaPrenda.CAMISETA;
                            break;
                        case 2:
                            categoriaP=CategoriaPrenda.PANTALON;
                            break;
                        case 3:
                            categoriaP=CategoriaPrenda.VESTIDO;
                            break;
                        case 4:
                            categoriaP=CategoriaPrenda.CHAQUETA;
                            break;

                        case 5:
                            categoriaP=CategoriaPrenda.CALZADO;
                            break;
                        default:
                            System.out.println("opcion no valida");

                    }

                    Prenda prenda=new Prenda(codigoP, nombreP, marca, precioUnitario, categoriaP);
                    if(empresa.registrarPrenda(prenda)){
                        System.out.println("la prenda ha sido registrada correctamente");
                    }else{
                        System.out.println("el codigo o la prenda ya existe");
                    }

                case 3:

                    System.out.println("----Registrar persona----");
                    System.out.println("¿que tipo de persona desea registrar?");
                    System.out.println("1.Cliente");
                    System.out.println("2.Empleado");

                    System.out.println("ingrese el documento de la persona: ");
                    int documentoP= sc.nextInt();
                    System.out.println("ingrese el nombre completo: ");
                    String nombreCompleto= sc.nextLine();
                    System.out.println("ingrese el correo electronico: ");
                    String correo= sc.nextLine();
                    System.out.println("ingrese el numero de telefono: ");
                    int telefono= sc.nextInt();



                    int tipo= sc.nextInt();
                    switch (tipo) {
                        case 1:
                            System.out.println("ingrese el codigo de afiliacion: ");
                            int codigoC = sc.nextInt();

                            System.out.println("Digite la categoria de la prenda: ");
                            int j = 1;
                            for (CategoriaPrenda catetegoria : CategoriaPrenda.values()) {
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

                            Cliente cliente=new Cliente(documentoP, nombreCompleto, correo, telefono, codigoC, categoriaC);
                            if(empresa.registrarCliente(cliente)){

                                System.out.println("cliente registrado correctamente");

                            }else{
                                System.out.println("cliente ya existe");
                            }
                            break;
                        case 2:

                            System.out.println("ingrese el codigo de empleado: ");
                            int codigoE = sc.nextInt();
                            System.out.println("ingrese la fecha de contratacion (DD/MM/AAAA):\"): ");
                            String fechaContratacion= sc.nextLine();
                            System.out.println("ingrese el salario basico: ");
                            double salario=sc.nextDouble();
                            System.out.println("ingrese el codigo de la sucursal a la que pertenecera:");
                            int codigoSs= sc.nextInt();
                            Vendedor vendedor=new Vendedor(documentoP, nombreCompleto, correo, telefono, codigoE, fechaContratacion, salario);
                            if(empresa.registrarVendedor(codigoSs, vendedor)){
                                System.out.println("el vendedor ha sido registrado correctamente");
                            }else{
                                System.out.println("vendedor ya existente");
                            }
                            break;
                    }
                    break;

                case 4:


                case 5:
                    System.out.println("----registrar inventario----");


                    System.out.println("ingrese el codigo del inventario: ");
                    int codigoI= sc.nextInt();
                    System.out.println("ingrese la talla: ");
                    String talla=sc.nextLine();
                    System.out.println("ingrese color: ");
                    String color=sc.nextLine();
                    System.out.println("ingrese la cantidad: ");
                    int cantidad= sc.nextInt();
                    System.out.println("ingrese el codigo de la prenda elegida: ");
                    int codigo= sc.nextInt();
                    Prenda prendaElegida=null;
                    if(empresa.agregarPrenda(codigo)==null){
                        System.out.println("la prenda no existe");
                    }else{
                        prendaElegida=empresa.agregarPrenda(codigo);
                    }

                    Inventario inventario=new Inventario(codigoI, talla, color, cantidad, prendaElegida);
                    if(sucursal.registrarInventario(inventario)){
                        System.out.println("inventario agregado correctamente");
                    }else{
                        System.out.println("datos incorrectos");
                    }



                case 6:

                    System.out.println("----consultar inventarios----");




                case 7:

                    System.out.println("----consultar prendas agotadas----");

                    for(Inventario agota: empresa.consultarPrendasAgotadasEmpresa()){
                        System.out.println(agota);
                    }
                    break;

                case 8:
                    System.out.println("----consultar compras de los clientes----");

                    System.out.println("ingrese el documento del cliente: ");
                    int documentoCliente= sc.nextInt();
                    for(Ventas v: empresa.consultarComprasPorCliente(documentoCliente)){
                        System.out.println(v);
                    }
                    break;

                case 9:
                    System.out.println("----consultar ventas de empleados----");
                    int documentoEmpleado= sc.nextInt();
                    for(Ventas e: empresa.consultarVentasPorVendedor(documentoEmpleado));
                    break;

                case 10:
                    System.out.println("----consultar ingresos de cada sucursal----");

                    System.out.println("ingrese el codigo de la sucursal que desea averiguar: ");
                    int codigoSucursal= sc.nextInt();

                    double ingresosSucursal=empresa.consultarIngresosSucursal(codigoSucursal);

                    System.out.println(ingresosSucursal);
                    break;

                case 11:

                    System.out.println("----consultar prenda mas vendida----");

                    Prenda masVendida=empresa.consultarPrendaMasVendida();
                    System.out.println(masVendida);

                case 0:
                    System.out.println("programa finalizado");
                    break;

                default:
                    System.out.println("opcion no valida");
            }
        }while (n!=0);

    }
}
