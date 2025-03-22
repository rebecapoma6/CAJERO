import java.util.InputMismatchException;
import java.util.Scanner;

/**@author Rebeca Poma  */

/**
 * Simula un sistema de cajero automatico,en el que las personas
 * puedan revisar cuanto dinero tienen,depositar dinero,retirar dinero y
 * ver sus estatadisticas de transacciones.
 */
public class CajeroAutomatico {
    public static Scanner sc = new Scanner(System.in);

    private static int saldo = 0;
    private static int totalIngresos = 0;
    private static int totalRetiros = 0;
    private static int numeroIngresos = 0;
    private static int numeroRetiros = 0;

    /**
     * Metodo principal que implementa al cajero automatico
     * Nos muestra un menu con alternativas ha elegir,hasta que el usuario decide salir. 
     * @param args Argumentos de la linea de comandos
     **/
    public static void main(String[] args) {

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
                    System.out.println();
                    System.out.println("Gracias por usar el cajero automático.¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
                    break;
            }
        } while (opcion != 4);

    }

    /**
     * Nos muestra el menu con opciones para nuestro cajero
     */
    private static void mostrarMenu() {
        System.err.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
        System.err.println("|     Cajero Automático       |");
        System.err.println("|_ _ _ _ _ _ _ _ _ _ _ _ _ _ _|");
        System.err.println("|     1. Consultar saldo      |");
        System.err.println("|     2. Depositar dinero     |");
        System.err.println("|     3. Retirar dinero       |");
        System.err.println("|     4. Salir                |");
        System.err.println("|_ _ _ _ _ _ _ _ _ _ _ _ _ _ _|");
    }

    /**
     * Aqui nos muestra el saldo actual que tiene la cuenta el cliente.
     */
    private static void consultarSaldo() {
        System.out.printf("Su saldo actual es: $%.2f%n", (double) saldo);

    }

    /**
     * Aqui lleva a cabo las transacciones de deposito o retiro en la cuenta del cliente.
     * 
     * @param tipoTransaccion que transaccion desea hacer el cliente tipo "Deposito o Retiro"
     * @param cantidad el monto de dinero ya sea a Depositar o Retirar.
     * @param saldoActual nos muestra el saldo actual de la cuenta antes de cualquier transaccion
     * @param totalTransacciones nos muestra el total de transacciones acumulado ya sea de Deposito o Retiro.
     * @param numeroTransacciones cuenta el numero de transacciones que ha realizado el cliente.
     * @return nos devuelve el nuevo saldo despues de cualquier transaccion.
     */
    private static int realizarOperaciones(String tipoTransaccion, int cantidad, int saldoActual,
            int totalTransacciones, int numeroTransacciones) {
        if (cantidad > 0) {
            if (tipoTransaccion.equals("Deposito")) {
                saldoActual += cantidad;
                totalTransacciones += cantidad;
                numeroTransacciones++;
                System.out.printf("Depósito exitoso. Saldo actualizado: $%.2f%n", (double) saldoActual);
            } else if (tipoTransaccion.equals("Retiro")) {
                if (cantidad <= saldoActual) {
                    saldoActual -= cantidad;
                    totalTransacciones += cantidad;
                    numeroTransacciones++;
                    System.out.printf("Retiro exitoso. Saldo actualizado:  $%.2f%n", (double) saldoActual);
                } else {
                    System.out.println("Error : Saldo insuficiente");
                }
            }

        } else {
            System.out.println("Error: El importe debe ser mayor a 0.");
        }
        return saldoActual;
    }

  /**
   * Nos permite que el cliente deposite dinero a su cuenta.
   * valida la suma que se ha ingresado, antes de procesar la transaccion.
   */
    private static void depositarDinero() {
        int cantidad = leerEntero("Ingrese la cantidad a depositar: ");
        saldo = realizarOperaciones("Deposito", cantidad, saldo, totalIngresos, numeroIngresos);
        totalIngresos += cantidad;
        numeroIngresos++;
    }

    /**
     * Nos permite que el cliente retire dinero de su cuenta.
     * Valida de tener suficiente dinero antes de proceder con la transaccion.
     */
    private static void retirarDinero() {
        int cantidad = leerEntero("Ingrese la cantidad a retirar: ");
        saldo = realizarOperaciones("Retiro", cantidad, saldo, totalRetiros, numeroRetiros);
        totalRetiros += cantidad;
        numeroRetiros++;
    }

    /**
     * Nos muestra la estadistica de las transacciones realizadas por el cliente.
     */
    private static void mostrarEstadistica() {
        System.out.println("----------------ESTADÍSTICAS DE USO------------------");
        System.out.printf("Número total de Ingresos: %d%n", numeroIngresos);
        System.out.printf("Importe total Ingresado: $%.2f%n", (double) totalIngresos);
        System.out.printf("Número total de Retiradas:%d%n", numeroRetiros);
        System.out.printf("Importe total Retirado: $%.2f%n", (double) totalRetiros);
        System.out.printf("Saldo Final en cuenta:$%.2f%n", (double) saldo);
    }

  /**
   * Lee un numero entero que introduce el cliente , asegurandose que sea valido.
   * @param mensaje Nos muestra un mensaje para pedir la entrada del cliente.
   * @return numero entero que ha ingresado el cliente.
   */
    private static int leerEntero(String mensaje) {
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
