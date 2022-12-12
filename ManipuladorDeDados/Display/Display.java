package ManipuladorDeDados.Display;

import java.util.InputMismatchException;
import java.util.Scanner;

import ManipuladorDeDados.ManipuladorDeNumeros.ManipularNumeros;
import ManipuladorDeDados.ManipuladorLetras.ManipularLetras;

public class Display {

    private int decision;
    private Scanner scan = new Scanner(System.in);

    public Display() {
        setDecision();
        openMenu();
    }

    public void setDecision() {
        System.out.println("\n-----------Menu Principal-----------");
        System.out.print("1- Manipular Letras \n2- Manipular Números\nEscolha: ");
        try {
            this.decision = scan.nextInt();
        } catch(InputMismatchException e) {
            System.out.println("Entrada Inválida");
            new Display();
        }
        
    }

    public void openMenu() {
        switch(decision) {
            case 1:
                new ManipularLetras();
            break;

            case 2:
                new ManipularNumeros();
            break;

            default:
                System.out.println("Entrada Inválida");
                new Display();
            break;
        }
    }

    public static void main(String[] args) {
        new Display();
    }
}
