package ManipuladorDeDados.ManipuladorDeNumeros;

public class MenorNum {
    private Integer[] nList;
    
    public MenorNum(Integer[] nList) {
        setnList(nList);
        System.out.println(getMenor());
    }

    private int getMenor() {
        int menor = 999999999;
        for (int i = 0; i < nList.length; i++) {
            if(nList[i] < menor) {
                menor = nList[i];
            }
        }
        return menor;
    }

    private void setnList(Integer[] nList) {
        this.nList = nList;
    }
}

