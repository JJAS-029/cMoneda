import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] monedas = {"USD", "MXN", "EUR", "JPY", "GBP", "CAD"};
        String[] nombresMonedas = {"Dólares", "Pesos Mexicanos", "Euros", "Yen Japonés", "Libra Esterlina", "Dólar Canadiense"};
        System.out.println("Bienvenido al conversor de moneda");
        // Mostrar monedas en columnas
        System.out.println("Seleccione la moneda base:");
        for (int i = 0; i < monedas.length; i++) {
            System.out.printf("%d. %s = %s\t", i + 1, monedas[i], nombresMonedas[i]);
            if ((i + 1) % 2 == 0) {
                System.out.println();
            }
        }

        try{ //Arrojara mensaje de valor no valido si se ingresa letras
        Scanner scanner = new Scanner(System.in);
        int opcionBase = scanner.nextInt(); // Usuario elige la moneda base

        System.out.println("Seleccione la moneda a la cual quiere convertir:");
        for (int i = 0; i < monedas.length; i++) {
            System.out.printf("%d. %s = %s\t", i + 1, monedas[i], nombresMonedas[i]);
            if ((i + 1) % 2 == 0) {
                System.out.println();
            }
        }

        int opcionDestino = scanner.nextInt(); // Usuario elige la moneda destino

        System.out.println("Ingrese el monto que desea convertir: ");
        double monto = scanner.nextDouble(); // Usuario ingresa el monto a convertir

        String monedaBase = monedas[opcionBase - 1];
        String monedaDestino = monedas[opcionDestino - 1];

        // Consultar tasa de cambio y realizar la conversión
        ConsultarMoneda consulta = new ConsultarMoneda();
        double tasaCambio = consulta.obtenerTasa(monedaBase, monedaDestino);



            if (tasaCambio > 0) {
            double montoConvertido = monto * tasaCambio;
            System.out.printf("Monto convertido de %s a %s: %.2f\n", monedaBase, monedaDestino, montoConvertido);
        } else {
            System.out.println("No se pudo obtener la tasa de cambio.");
        }
        }catch(Exception e ){
            System.out.println("Valor invalido");
        }

    }
}
