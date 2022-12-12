package ManipuladorDeDados.ManipuladorDeNumeros;

import java.util.InputMismatchException;
import java.util.Scanner;
import ManipuladorDeDados.Display.Display;

public class ManipularNumeros {
    private Scanner scan = new Scanner(System.in);
    private Integer[] nList;
    private int decision;

    public ManipularNumeros() {
        printMenu();
        setDecision();
        openManipulador();
    }

    private void setDecision() {
        try {
            this.decision = scan.nextInt();
        } catch(InputMismatchException e) {
            System.out.println("Entrada Inválida");
            new ManipularNumeros();
        }
        if(decision != 0) {
            System.out.print("Quantidade de números a serem lidos: ");
            int length = scan.nextInt();
            Integer[] list = new Integer[length];
            for(int i = 0; i < length; i++) {
                System.out.print((i + 1) + "° número: ");
                list[i] = scan.nextInt();
            }
            this.nList = list;
            System.out.print("Resultado: ");
        }
    }

    private void setDecisionAgain() {
        try {
            this.decision = scan.nextInt();
        } catch(InputMismatchException e) {
            System.out.println("Entrada Inválida");
            new ManipularNumeros();
        }
        if(decision != 0) {
            System.out.print("Resultado: ");
        }
    }

    private void openManipulador() {
        switch(decision) {
            case 1:
                new OrganizaCrescente(nList);
                postFstUse();
            break;

            case 2:
                new OrganizaDecrescente(nList);
                postFstUse();
            break;

            case 3:
                new MaiorNum(nList);
                postFstUse();
            break;

            case 4:
                new MenorNum(nList);
                postFstUse();
            break;

            case 5:
                new ApagaNumDup(nList);
                postFstUse();
            break;

            case 0:
                new Display();
            break;

            default:
                System.out.println("Entrada Inválida");
                new ManipularNumeros();
            break;
        }
    }

    private void printMenu() {
        System.out.println("\n-----------Menu Números-----------");
        System.out.println("1- Organizar em ordem crescente");
        System.out.println("2- Organizar em ordem decrescente");
        System.out.println("3- Mostrar o maior número");
        System.out.println("4- Mostrar o menor número");
        System.out.println("5- Apagar numeros duplicados");
        System.out.println("0- Retornar ao Menu Principal");
        System.out.print("Escolha: ");
    }

    private void postFstUse() {
        System.out.println("\nDeseja utilizar a mesma lista para outro propósito?\n1- Sim\n2-Não");
        System.out.print("Escolha: ");
        int escolha = scan.nextInt();
        if(escolha == 1) {
            printMenu();
            setDecisionAgain();
            openManipulador();
        } else if(escolha == 2) {
            new ManipularNumeros();
        }
    }
}
