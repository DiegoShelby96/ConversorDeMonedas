import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConvertirMonedas convertir = new ConvertirMonedas();
        DecimalFormat df = new DecimalFormat("#.");
        boolean continuar = true;

        System.out.println("*****************************");
        System.out.println("Bienvenido al conversor de Monedas");
        System.out.println("*****************************");
        System.out.println("1. Convertir Monedas");
        System.out.println("9. Salir");
        System.out.println("Seleccione una opcion:");

        int opcion = lectura.nextInt();
        lectura.nextLine();

        while (continuar) {

            switch (opcion) {
                case 1:
                    System.out.println("************************");
                    System.out.println("Aqui le muestro algunos ejemplos de como buscar las monedas:");
                    System.out.println("ARS - Peso argentino, " +
                                    "BOB - Boliviano boliviano, " +
                                    "BRL - Real brasileño, " +
                                    "CLP - Peso chileno, " +
                                    "COP - Peso colombiano," +
                            "USD - Dólar estadounidense");
                    System.out.println("************************");
                    System.out.println("Escriba la moneda");
                    String monedaBase = lectura.nextLine().toUpperCase();

                    try {
                    ApiMoneda moneda = convertir.consultaMoneda(monedaBase);

                    System.out.println("Ingrese la moneda a convertir");
                    String monedaFinal = lectura.nextLine().toUpperCase();

                    System.out.println("Ingrese el monto a convertir:");
                    double cantidad = lectura.nextDouble();
                    lectura.nextLine();

                    if (moneda.rates().containsKey(monedaFinal)) {
                        double tasa = moneda.rates().get(monedaFinal);
                        double resultado = cantidad * tasa;

                        System.out.println(df.format(cantidad) + monedaBase + " Da en total: " + df.format(resultado) + monedaFinal);
                    }else {
                        System.out.println("Moneda de destino no encontrada");
                    }
                    }catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }
                    System.out.println("¿Desea realizar otra conversion? (si/no):");
                    String respuesta = lectura.nextLine().trim().toLowerCase();

                    if (!respuesta.equals("si")) {
                        continuar = false;
                        System.out.println("Gracias por usar el conversor de monedas. ¡Hasta luego!");
                    }
                    break;
                case 9:
                    continuar = false;
                    System.out.println("Gracias por usar el conversor de monedas. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
                    break;
            }
        }
        lectura.close();
    }
}