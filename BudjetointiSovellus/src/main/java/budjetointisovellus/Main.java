package budjetointisovellus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mxsampsa
 */
public class Main {
    public static void main(String[] args) { //tällä hetkellä lähinnä vain omia testauksia varten.
        
        try {
            String salasana = "123456";
            TiedostonKasittelija budget = new TiedostonKasittelija("test", "testaaja");
            budget.lueTiedosto("-");
            Salaus salaaja = new Salaus(salasana);
            salaaja.salaa(budget.palautaTekstina());
            budget.lueTiedosto(salasana);
            System.out.println(budget.palautaTekstina());
        } catch (Exception e) {
            System.out.println("nah");
        }
        
        /*Scanner lukija = new Scanner(System.in);
        System.out.println("Anna budjetin nimi:");
        String nimi = lukija.nextLine();
        TiedostonKasittelija budget = new TiedostonKasittelija(nimi, "testaaja");
        System.out.println(budget.lueTiedosto("-"));
        budget.tulosta();
        System.out.println(budget.palautaTekstina());
        budget.tallenna("-", new HashMap<String, Integer>());
        budget.tulosta();*/
    }
}
