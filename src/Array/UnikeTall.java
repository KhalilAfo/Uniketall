package Array;

import javax.swing.*;
import java.util.Arrays;

public class UnikeTall {
    // Deklarasjon av array for lagring av tilfeldige heltall

    private int[] ArrayTabell;

   /* Konstruktør som mottar arrayets lengde som parameter og
     oppretter arrayet.  */

    public UnikeTall(int lengde) {
        this.ArrayTabell =new int[lengde];
        fyllArrayTabell();
    }
   /* Metode som skal undersøke om et gitt tall finnes i arrayet fra før.
     Tallet det letes etter skal mottas som parameter.
     Metoden skal returnere true hvis tallet finnes i arrayet.
     Hvis ikke skal metoden returnere false. */

    private boolean finnes(int tall) {
        Boolean fant = true;

        for (int i : ArrayTabell) {
            if (tall != i) {
                fant = false;

            }
        }
        return fant;
    }

   /* Metode som skal fylle arrayet med tilfeldige tall
     mellom 100 og 999,
     begge grenser inkludert. .
     Metoden skal ikke ha
     parametre og heller ikke returnere noen verdi.
     Tips bruk (int)(Math.random()*(900)+100); for
     å generere tallene mellom 100 og 999
   */
    private void fyllArrayTabell() {

        int i = 0;
        while (i < ArrayTabell.length){
            int random = (int)(Math.random()*(900) +100);

            //* Metoden skal gjøre dette på en måte som sikrer at alle tallene er forskjellige

            if (!finnes(random)){
                ArrayTabell[i] = random;
                i++;
            }
        }
    }
    // Metode som finner og returnerer det minste tallet i arrayet.

    private int minste() {
        int minste = ArrayTabell[0];

        for (int i : ArrayTabell) {

            if (minste > i) {
                minste = i;
            }
        }
        return minste;
    }
    // Metode som finner og returnerer det største tallet i arrayet.

    private int største() {
        int største = ArrayTabell[0];

        for (int i : ArrayTabell) {
            if (største < i) {
                største = i;

            }
        }
        return største;
    }
   /*  Metode som beregner og returnerer den
      gjennomstnittlige verdien
     (double-verdi) av tallene i arrayet.  */

    private double gjennomsnitt() {
        double gjennomsnitt = 0;
        int teller = 0;
        int sum = 0;

        for (int i: ArrayTabell) {
            sum+= i;
            teller++;

        }
        gjennomsnitt = (double) sum/teller;
        return  gjennomsnitt;

    }

   /* Metode som viser tallene i arrayet i en meldngsboks.
     I tillegg skal det, i meldingsboks, skrives ut
     opplysninger om hvilket tall som er minst,
     hvilket som er størst, og
     hva som er gjennomsnittsverdien, jfr bildet over.
     Gjennomsnittverdien skal skrives ut med en desimal.
     Bruk gjerne String.format("%.2f,tall) til dette.
     Legg inn mellomrom mellom tallene og skriv ut et passende antall tall
     per linje. */

    public void melding(){
        String utmelding = "";
        int teller = 0;
        for (int i = 0; i < ArrayTabell.length; i++){
            Arrays.sort(ArrayTabell);
            utmelding+= ArrayTabell[i] + " ";
            teller++;
            if (teller == 8){
                utmelding+= "\n";
                teller = 0;

            }
        }
        utmelding+= "\nMinste tall er " + minste() + "\n";
        utmelding+= "Største tall er " + største() + "\n";
        utmelding+= "Gjennomsnittsverdien er " + String.format("%.2f",gjennomsnitt());

        JOptionPane.showMessageDialog(null, utmelding);
        
    }
}


