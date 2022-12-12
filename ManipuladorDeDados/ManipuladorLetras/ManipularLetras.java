package ManipuladorDeDados.ManipuladorLetras;

import java.util.InputMismatchException;
import java.util.Scanner;
import ManipuladorDeDados.Display.Display;

public class ManipularLetras {

    private Scanner scan = new Scanner(System.in);
    private String str;
    private int decision;

    public ManipularLetras() {
        printMenu();
        setDecision();
        openManipulador();
    }

    private void setDecision() {
        try {
            this.decision = Integer.parseInt(scan.nextLine());
        } catch(InputMismatchException e) {
            System.out.println("Entrada Inválida");
            new ManipularLetras();
        }
        if(decision != 0) {
            System.out.print("Frase/Palavra: ");
            this.str = scan.nextLine();
            System.out.print("Resultado: ");
        }
    }

    private void setDecisionAgain() {
        try {
            this.decision = Integer.parseInt(scan.nextLine());
        } catch(InputMismatchException e) {
            System.out.println("Entrada Inválida");
            new ManipularLetras();
        }
        if(decision != 0) {
            System.out.print("Resultado: ");
        }
    }

    private void openManipulador() {
        switch(decision) {
            case 1:
                new Espelhado(str);
                postFstUse();
            break;

            case 2:
                new TudoMaiusculo(str);
                postFstUse();
            break;

            case 3:
                new TudoMinusculo(str);
                postFstUse();
            break;

            case 4:
                new ContaCaractere(str);
                postFstUse();
            break;

            case 5:
                new ApagaDuplicado(str);
                postFstUse();
            break;

            case 0:
                new Display();
            break;

            default:
                System.out.println("Entrada Inválida");
                new ManipularLetras();
            break;
        }
    }

    private void printMenu() {
        System.out.println("\n-----------Menu Letras-----------");
        System.out.println("1- Escrever frase/palavra espelhado");
        System.out.println("2- Deixar todas as letras maíusculas");
        System.out.println("3- Deixar todas as letras minúsculas");
        System.out.println("4- Informar quantos caracteres a frase/palavra possui");
        System.out.println("5- Apagar caracteres duplicados");
        System.out.println("0- Retornar ao Menu Principal");
        System.out.print("Escolha: ");
    }

    private void postFstUse() {
        System.out.println("\nDeseja utilizar a mesma palavra/frase para outro propósito?\n1- Sim\n2-Não");
        System.out.print("Escolha: ");
        int escolha = scan.nextInt();
        if(escolha == 1) {
            printMenu();
            setDecisionAgain();
            openManipulador();
        } else if(escolha == 2) {
            new ManipularLetras();
        }
    }
}
