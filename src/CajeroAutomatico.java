import java.util.InputMismatchException;
import java.util.Scanner;

public class CajeroAutomatico {
    public static Scanner sc = new Scanner(System.in);

    private static int saldo = 0;
    private static int totalIngresos = 0;
    private static int totalRetiros = 0;
    private static int numeroIngresos = 0;
    private static int numeroRetiros = 0;

    public static void main(String[] args) throws Exception {

        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Elija una opción: ");
            switch (opcion) {
                case 1:
                    consultarSaldo();
                    break;
                case 2:
                    depositarDinero();
                    break;
                case 3:
                    retirarDinero();
                    break;
                case 4:
                    mostrarEstadistica();
                    System.out.println("Gracias por usar el cajero automático.¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
                    break;
            }
        } while (opcion != 4);

    }

    public static void mostrarMenu() {
        System.err.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
        System.err.println("|     Cajero Automático       |");
        System.err.println("|_ _ _ _ _ _ _ _ _ _ _ _ _ _ _|");
        System.err.println("|     1. Consultar saldo      |");
        System.err.println("|     2. Depositar dinero     |");
        System.err.println("|     3. Retirar dinero       |");
        System.err.println("|     4. Salir                |");
        System.err.println("|_ _ _ _ _ _ _ _ _ _ _ _ _ _ _|");
    }

    public static void consultarSaldo() {
        System.out.printf("Su saldo actual es: $%.2f%n", (double) saldo);

    }

    public static void depositarDinero() {

        int cantidadDeposito = leerEntero("Ingrese la cantidad a depositar: ");
        if (cantidadDeposito > 0) {
            saldo += cantidadDeposito;
            totalIngresos += cantidadDeposito;
            numeroIngresos++;
            System.out.printf("Depósito exitoso. Saldo actualizado: $%.2f%n", (double) saldo);
        } else {
            System.out.println("Error: El importe debe ser mayor a 0.");
        }
    }

    public static void retirarDinero() {
        int cantidadRetiro = leerEntero("Ingrese la cantidad a retirar: ");

        if (cantidadRetiro > 0) {
            if (cantidadRetiro <= saldo) {
                saldo -= cantidadRetiro;
                totalRetiros += cantidadRetiro;
                numeroRetiros++;
                System.out.printf("Retiro exitoso. Saldo actualizado:  $%.2f%n", (double) saldo);

            } else {
                System.out.println("Error : Saldo insuficiente");
            }
        } else {
            System.out.println("Error: El importe debe ser mayor a 0.");
        }
    }

    public static void mostrarEstadistica() {
        System.out.println("----------------ESTADÍSTICAS DE USO------------------");
        System.out.printf("Número total de Ingresos: $%d%n", numeroIngresos);
        System.out.printf("Importe total Ingresado: $%.2f%n", (double) totalIngresos);
        System.out.printf("Número total de Retiradas:%d%n", numeroRetiros);
        System.out.printf("Importe total Retirado: $%.2f%n", (double) totalRetiros);
        System.out.printf("Saldo Final en cuenta:$%.2f%n", (double) saldo);
        System.out.printf("-----------------------------------------------------");
    }

    public static int leerEntero(String mensaje) {
        int numero = -1;
        boolean entradaOk = false;
        while (!entradaOk) {
            try {
                System.out.println(mensaje);
                numero = sc.nextInt();
                entradaOk = true;
            } catch (InputMismatchException e) {
                System.out.println("Error:Entrada inválida , ingrese un número entero.");
                sc.next();
            }
        }
        return numero;
    }

}
