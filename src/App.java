import java.util.Scanner;

public class App {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        int opcion = 0;
        int saldo = 0;
        int totalIngresos = 0;
        int totalRetiros = 0;
        int numeroIngresos = 0;
        int numeroRetiros = 0;

        while (opcion != 4) {
            System.err.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
            System.err.println("|     Cajero Automático       |");
            System.err.println("|_ _ _ _ _ _ _ _ _ _ _ _ _ _ _|");
            System.err.println("|     1. Consultar saldo      |");
            System.err.println("|     2. Depositar dinero     |");
            System.err.println("|     3. Retirar dinero       |");
            System.err.println("|     4. Salir                |");
            System.err.println("|_ _ _ _ _ _ _ _ _ _ _ _ _ _ _|");
            System.out.println();
            System.err.print("Elija una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    // int saldo = 0;
                    System.out.println("Su saldo actual es : $" + saldo);
                    break;

                case 2:
                    System.out.print("Ingrese la cantidad a depositar: ");
                    int cantidadDeposito = sc.nextInt();

                    if (cantidadDeposito > 0) {
                        saldo += cantidadDeposito;
                        totalIngresos += cantidadDeposito;
                        numeroIngresos++;
                        System.out.println("Depósito exitoso.Saldo actualizado: $" + saldo);
                    } else {
                        System.out.println("Error: El importe debe ser mayor a 0.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese la cantidad a retirar: ");
                    int cantidadRetiro = sc.nextInt();

                    if (cantidadRetiro > 0) {
                        if (cantidadRetiro <= saldo) {
                            saldo -= cantidadRetiro;
                            totalRetiros += cantidadRetiro;
                            numeroRetiros++;
                            System.out.println("Retiro exitoso. Saldo actualizado: $" + saldo);

                        } else {
                            System.out.println("Error : Saldo insuficiente");
                        }
                    } else {
                        System.out.println("Error: El importe debe ser mayor a 0.");
                    }
                    break;

                case 4:
                    System.out.println("Gracias por usar el cajero automático.¡Hasta luego!");
                    System.out.println("----------------ESTADÍSTICAS DE USO------------------");
                    System.out.println("Número total de Ingresos: " + numeroIngresos);
                    System.out.println("Importe total Ingresado: $ " + totalIngresos);
                    System.out.println("Número total de Retiradas: " + numeroRetiros);
                    System.out.println("Importe total Retirado: $ " + totalRetiros);
                    System.out.println("Saldo Final en cuenta:" + saldo);
                    System.out.println("-----------------------------------------------------");
                    break;

                default:

                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
                    break;
            }

        }

    }

}
