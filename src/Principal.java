import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        int opcion = 0;
        Scanner teclado = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        ConversionDeMoneda conversion = new ConversionDeMoneda();

        String menu = """
            Incerta la conversión que deseas realizar
            
            1.- Convertir de Dólares a Pesos Mexicanos
            2.- Convertir de Pesos Mexinanos a Dólares
            3.- Convertir de Dólares a Pesos Argentinos
            4.- Convertir de Pesos Argentinos a Dólares
            5.- Convertir de Dólares a Pesos Colombianos
            6.- Convertir de Pesos Colombianos a Dólares
            7.- Convertir de Dólares a Reales Brasileños
            8.- Convertir de Pesos Reales Brasileños a Dólares
            9.- Salir
            """;


        while (true){
            try {
                System.out.println(menu);
                opcion = teclado.nextInt();

                if(opcion == 9){
                    break;
                }

                System.out.println("Incerte la cantidad que desea convertir: ");
                double cantidadAConvertir = teclado.nextDouble();

                switch (opcion) {
                    case 1:
                        conversion.convertir("USD", "MXN", cantidadAConvertir);
                        break;
                    case 2:
                        conversion.convertir("MXN", "USD", cantidadAConvertir);
                        break;
                    case 3:
                        conversion.convertir("USD", "ARS", cantidadAConvertir);
                        break;
                    case 4:
                        conversion.convertir("ARS", "USD", cantidadAConvertir);
                        break;
                    case 5:
                        conversion.convertir("USD", "COP", cantidadAConvertir);
                        break;
                    case 6:
                        conversion.convertir("COP", "USD", cantidadAConvertir);
                        break;
                    case 7:
                        conversion.convertir("USD", "BRL", cantidadAConvertir);
                        break;
                    case 8:
                        conversion.convertir("BRL", "USD", cantidadAConvertir);
                        break;
                    default:
                        System.out.println("Por favor ingrese una opción válida");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número válido.");
                teclado.nextLine(); // limpia la entrada inválida para evitar el bucle infinito
            } catch (NumberFormatException e) {
                System.out.println("Error, el formato del número es inválido " + e.getMessage());
            } catch (NullPointerException e) {
                System.out.println("Se intentó usar una variable que es null." + e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("FINALIZANDO LA APLICACIÓN");
            }
        }
        teclado.close();
    }
}

