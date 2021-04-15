package PAC_DESARROLLO;

import java.util.Scanner;


public class Main {

    // LISTA DE VARIABLES PARA LA LECTURA DE DATOS Y LAS OPCIONES

    private static Scanner leer = new Scanner(System.in); //Variable para leer los datos
    private static String opciones; //Varible que uso para asignar el numero de opcion que pulsa el usuario
    private static int opciones_int; //Varible para convertir la a int el numero de opcion


    // VARIBALES PARA LA CREACIÓN DE USUARIO NUEVO

    private static Usuario nvoUsuario = new Usuario(); //Variable para asignar objetos Usuario
    private static boolean usuCreado=false; //Varible que indica si el usuario ha sido creado con true-false
    private static String nombre=""; //Varible para asignar el nombre del usuario
    private static String edad=""; //Varible para asignar la edad del usuario
    private static int edad_int=-1; //Varible para pasar edad a int
    private static String dni=""; //Varible para asignar el dni del usuario


     // VARIBLES PARA LA CREACIÓN DE UNA NUEVA CUENTA

    private static Cuenta nvoCuenta = null; //Varible para asignar objetos Cuenta, la dejo en NULL porque previamente tiene que estar el usuario creado
    private static String descripcion=""; //Varible para la descripcion del importe
    private static String importe=""; //Varible para asignar el importe
    private static double importe_int=0; //Varible para pasar el importe a int



                       // LISTA DE FUNCIONES


    private static void menu(){

        //Muestro la lista de opciones por pantalla, con su numero correspondiente
        do{
            System.out.println("1 Introduce un nuevo gasto");
            System.out.println("2 Introduce un nuevo ingreso");
            System.out.println("3 Mostrar gastos");
            System.out.println("4 Mostrar ingresos");
            System.out.println("5 Mostrar saldo");
            System.out.println("0 Salir");

            //Creo un bloque try/catch para comprobar si el usuario a pulsado correctamente el numero de opcion
            try{
                System.out.print("Selecciona la opcion deseada: " + "\n");
                opciones = leer.nextLine();
                opciones_int = Integer.parseInt(opciones);
            }
            catch(NumberFormatException e){
                System.out.println(e.getMessage() + "Error en los caracteres introducidos, pulsar numeros de 0 a 5 ");
            }
            //Mostrara la lista mientras el usuario no pulse de 0 a 5
        }while(opciones_int < 0 && opciones_int > 5);
    }

    public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }


    private static void datosUsuario(){

        // Pido el nombre del usuario

        do {
            System.out.println("Introduce el nombre del usuario");
            nombre = leer.nextLine();

            //Mientras el nombre no este vacio
        }while (nombre.isEmpty()) ;

        nvoUsuario.setNombre(nombre);

            //Pido la edad del usuario
            do {
                System.out.println("Introduce la edad del usuario");
                edad = leer.nextLine();
                //Creo un bloque try/catch para comprobar que el usuario introduce numeros
                try {
                    edad_int = Integer.parseInt(edad);
                    nvoUsuario.setEdad(edad_int);
                } catch (NumberFormatException e) {
                    System.out.println("La edad tiene que ser de caracter numerico");
                }
                //Mientras edad no este vacia
            } while (edad.isEmpty() || edad == "0");


            //Pido el dni del usuario
            do {
                System.out.println("Introduce el DNI del usuario");
                dni = leer.nextLine();

                //Si el valor introducido es correcto, lo asignamos
                if (nvoUsuario.setDni(dni)) {
                    nvoUsuario.setDni(dni);
                }
                //De lo contrario saldra este mensaje
                else {
                    System.out.println("El formato del dni introducido no es correcto");
                }
                //Mientras dni no sea una cadena vacia o no se valide el dni correctamente
            } while (dni.isEmpty() || nvoUsuario.setDni(dni) == false);

        //Si todos los campos anteriores se cumplen, se crea el usuario
        usuCreado=true;

    }
    private static void introduceIngresos(){

        // Reinicio las variables para evitar valores dobles
        importe="";
        descripcion="";
        importe_int=0;

        // Pido la descripción del ingreso
        do{
            System.out.print("Introduce el concepto del ingreso: ");
            descripcion = leer.nextLine();
        //Mientras el campo este vacio
        }while(descripcion.isEmpty());

        
        // Pido el importe
        do{
            System.out.print("Introduce el importe del ingreso: ");
            importe = leer.nextLine();

            //Creo bloque try/catch para intentar pasar el valor introducido a int
            try{
                importe_int=Double.parseDouble(importe);
            }catch(NumberFormatException e){
                System.out.println(e.getMessage() + "El importe introducido no es valido");
            }
            //Mientras importe esta vacio
        }while(importe.isEmpty());

        // Si se cumplen los anteriores bloques, estos los agregamos a la nueva cuenta
        nvoCuenta.addIngresos(importe_int, descripcion);

        // Mando imprimir que el ingreso se hizo correctamente

        System.out.println("El ingreso ha sido almacenado correctamente");
    }



    private static void introduceGastos(){

        // Reiniciamos las variables para evitar valores dobles
        importe="";
        descripcion="";
        importe_int=0;

        // Pido la descripcion del gasto
        do{
            System.out.print("Introducir el concepto del gasto: ");
            descripcion = leer.nextLine();

         //Mientras descripcion no sea una cadena vacia
        }while(descripcion.isEmpty());

        // Pido el importe del gasto
        do{
            System.out.print("Introduce el importe del gasto: ");
            importe = leer.nextLine();

            //Creo bloque try/catch para intentar pasar el valor introducido a int
            try{
                importe_int = Double.parseDouble(importe);
            }catch(NumberFormatException e){
                System.out.println("El importe del ingreso debe ser numérico +"
                        + e.getMessage());
            }
            //Mientras el importe no este vacio
        }while(importe.isEmpty());

        //En el caso de que el gasto sea mayor al saldo de la cuenta, saltara el siguiente mensaje en pantalla
        if(nvoCuenta.getSaldo()<importe_int || nvoCuenta.getSaldo()==0){

            System.out.println("Saldo insuficiente, es necesario hacer un ingreso,");
        }
        //Si no se agregan los gastos
        else{
            nvoCuenta.addGastos(importe_int,descripcion);

            System.out.println("El gasto ha sido almacenado correctamente");
        } }

     private static void mostrarIngresos(){

        // Compruebo que la lista de ingresos no esta vacia
        if(!nvoCuenta.getIngresos().isEmpty()){

            // Recorro con un for toda la lista
            for(int x=0;x<nvoCuenta.getIngresos().size();x++){
                System.out.println(nvoCuenta.getIngresos().get(x).toString());
            }
        }
        //Si la lista esta vacia se imprime el siguiente mensaje
        else{
            System.out.println("No hay ningun ingreso en esta cuenta.");
        }
    }


        private static void mostrarGastos(){

            // Compruebo que la lista de gastos no esta vacia
            if(!nvoCuenta.getGastos().isEmpty()){

                // Recorro con un for la lista
                for(int x=0;x<nvoCuenta.getGastos().size();x++){
                    System.out.println(nvoCuenta.getGastos().get(x).toString());
                }
            }
            //Si la lista esta vacia se imprime el siguiente mensaje
            else{
                System.out.println("No hay gastos en esta cuenta");
            }
        }




        //--------------MAIN------------//

        public static void main(String[] args) {

       //Pido crear el usuario
            do{
                datosUsuario();
            }while(usuCreado=false);

            //Si se cumplen las condiciones del do while, se crea la nueva cuenta y se imprime el siguiente mensaje
            nvoCuenta=new Cuenta(nvoUsuario);
            System.out.println("El usuario ha sido creado correctamente " + "\n");
            System.out.println("Bienvenido ami App " + nvoUsuario.getNombre());

            //Ahora muestro el menu de opciones
            do{

                menu();

            // Con el Switch conozco que funcion debo ejecutar dependiendo lo introducido por el usuario
                switch(opciones_int){


                    case 0:
                        System.out.println("Muchas gracias por usar mi App de gestión de gastos, hasta la proxima!");
                        break;

                    case 1:
                        introduceGastos();
                        break;

                    case 2: // Eligiendo un dos se registra un nuevo ingreso
                        introduceIngresos();
                        break;

                    case 3:
                        mostrarGastos();
                        break;

                    case 4:
                        mostrarIngresos();
                        break;

                    case 5:
                        System.out.println(nvoCuenta.toString());
                        break;
                        // SI EL USUARIO PULSA UN NUMERO DIFERENTE, LE SALTARA POR PANTALLA EL SIGUIENTE MENSAJE
                    default:
                        System.out.println("Introduce el valor correcto");
                        break;
                }

                //Mientras el numero de opciones sea diferente a 0
            }while(opciones_int !=0);

            // Si termina el bucle, cerramos el objeto Scanner
            leer.close();
        }

    }



