package Lab2ex4;


import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
class Persoana{
    private String nume;
    private String cnp;
    private long varsta;
    public Persoana(String nume, String cnp) {
        this.nume = nume;
        this.cnp = cnp;
    }
    public String getNume() { return nume; }
    public String getCnp() { return cnp; }
    public void setNume(String nume) { this.nume = nume; }
    public void setCnp(String cnp) { this.cnp = cnp; }
    public long getVarsta() { return varsta; }
    public void setVarsta(){
        String an_aux = cnp.substring(1, 3);
        if(an_aux.charAt(0) > '2'){
            an_aux = "19" + an_aux;
        }
        else an_aux = "20" + an_aux;
        int an = Integer.parseInt(an_aux);
        int luna = Integer.parseInt(cnp.substring(3,5));
        int zi = Integer.parseInt(cnp.substring(5,7));
        LocalDate data_nasterii = LocalDate.of(an, luna, zi);
        LocalDate data_curenta = LocalDate.now();
        varsta = ChronoUnit.YEARS.between(data_nasterii, data_curenta);
    }
    public boolean validareCNP(){
        String cifre_control = "279146358279";
        String digits = "1234567890";
        String first_digit = "1256";
        int control_digit_sum = 0;
        int cnp_digit, cif_control_digit;
        //conditia 1
        if(cnp.length()!=13) { return false; }
        //conditia 2
        if(first_digit.indexOf(cnp.charAt(0))==-1) { return false; }
        //conditia 3
        for(int i=0; i<cnp.length(); i++){
            if(digits.indexOf(cnp.charAt(i))==-1)
                return false;
        }
        //conditia 4
        for(int i=0; i<cnp.length()-1; i++){
            cnp_digit = cnp.charAt(i)-'0';
            cif_control_digit = cifre_control.charAt(i)-'0';
            control_digit_sum += cnp_digit*cif_control_digit;
        }
        int cnp_control_digit = cnp.charAt(cnp.length()-1)-'0';
        if(control_digit_sum % 11 != cnp_control_digit) { return false; }
        return true;
    }
    public void afisarePersoana(){
        System.out.println("Nume: " + nume);
        System.out.println("CNP: " + cnp);
        System.out.println("Varsta: " + varsta);
        System.out.println("_____________");
    }
}
public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti nr de persoane:");
        int n = scanner.nextInt();
        scanner.nextLine();
        Persoana[] lista_persoane = new Persoana[n];
        String nume, cnp;
        for(int i = 0; i < lista_persoane.length; i++) {
            System.out.print("Introduceti numele persoanei:");
            nume = scanner.nextLine();
            System.out.print("Introduceti CNP-ul persoanei:");
            cnp = scanner.nextLine();
            lista_persoane[i] = new Persoana(nume, cnp);
            while(!lista_persoane[i].validareCNP()){
                System.out.print("CNP invalid! reintroduceti CNP-ul:");
                cnp = scanner.nextLine();
                lista_persoane[i].setCnp(cnp);
            }
            lista_persoane[i].setVarsta();
            System.out.println("\nPersoana introdusa!\n");
        }
        for(int i = 0; i < lista_persoane.length; i++) {
            lista_persoane[i].afisarePersoana();
        }
    }
}