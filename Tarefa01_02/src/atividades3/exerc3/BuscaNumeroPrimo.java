package atividades3.exerc3;

import java.util.ArrayList;
import java.util.List;

public class BuscaNumeroPrimo implements Runnable {
    
    int de;
    int ate;
    List<Integer> primos;

    public BuscaNumeroPrimo(int de, int ate, List<Integer> primos) {
        this.de = de;
        this.ate = ate;
        this.primos = primos;
    }
    
    @Override
    public void run() {
        for (int numero = this.de; numero <= this.ate; numero++) {
            if (!this.verificaNumeroPrimo(numero)) {
                continue;
            }
            
            primos.add(numero);
        }
    }
    
    private boolean verificaNumeroPrimo(int numero) {
        for (int i = 2; i < numero; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        int ultimoValor = 100000;
        int quantidadeThreads = 20;
        final List<Integer> primos = new ArrayList<>();
        
        int quantidadePorThread = ultimoValor / quantidadeThreads;
        for (int de = 2; de <= ultimoValor; de += quantidadePorThread) {
            int ate = de + quantidadePorThread - 1;
            
            System.out.println("pos inicio: "+ de);
            System.out.println("pos final: "+ ate);
            System.out.println("-------------");
            
            try {
                Thread t = new Thread(new BuscaNumeroPrimo(de, ate, primos));
                t.start();
                t.join();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        System.out.println("Estes são os números primos:");
        for (int primo : primos) {
            System.out.println(primo);
        }
    }
}
