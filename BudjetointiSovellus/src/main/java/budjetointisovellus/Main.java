package budjetointisovellus;

import java.util.Scanner;

/**
 *
 * @author mxsampsa
 */
public class Main {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        System.out.println("Anna budjetin nimi:");
        String nimi = lukija.nextLine();
        Budjetti budget = new Budjetti(nimi, "testaaja");
        System.out.println(budget.lueTiedosto());
        budget.tulosta();
        System.out.println(budget.palautaTekstina());
        budget.tallenna();
        budget.tulosta();
    }
}
