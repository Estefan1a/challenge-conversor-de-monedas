import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        System.out.println("Ingrese el tipo de conversión que quiere realizar: USD, MXM");

        var tipoDeMoneda = teclado.nextLine();
        Moneda moneda = consulta.buscarMoneda(tipoDeMoneda);

        System.out.println(moneda);

    }


}
