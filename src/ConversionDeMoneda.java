import java.util.Scanner;

public class ConversionDeMoneda {

    private final ConsultaMoneda consulta;

    public ConversionDeMoneda() {
        this.consulta = new ConsultaMoneda();
    }

    public void convertir(String monedaBase, String monedaAConvertir, double cantidadAConvertir){

        double tasaDeCambio = consulta.buscarMoneda(monedaBase, monedaAConvertir);

        if (tasaDeCambio != -1){
            double resultado = cantidadAConvertir * tasaDeCambio;
            System.out.println("El resultado de convertir " + cantidadAConvertir + monedaBase + " a " +
                    monedaAConvertir + " es de " + resultado +  " " + monedaAConvertir);
        }

    }

}
