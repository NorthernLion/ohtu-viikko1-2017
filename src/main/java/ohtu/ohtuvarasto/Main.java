package ohtu.ohtuvarasto;

public class Main {

    public static void main(String[] args) {

        Varasto varasto = new Varasto(10.0);
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(9);
        System.out.println(varasto.getSaldo());
        System.out.println(varasto.toString());
    }
}
