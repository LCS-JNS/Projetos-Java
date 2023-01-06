package ManipuladorDeDados.ManipuladorDeNumeros;

public class MaiorNum {
    
    private Integer[] nList;
    
    public MaiorNum(Integer[] nList) {
        setnList(nList);
    }

    public int getMaior() {
        int maior = 0;
        for (int i = 0; i < nList.length; i++) {
            if(nList[i] > maior) {
                maior = nList[i];
            }
        }
        return maior;
    }

    private void setnList(Integer[] nList) {
        this.nList = nList;
    }
}
