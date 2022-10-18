import cores.Sinal;
import cores.Verde;
import cores.Vermelho;
import cores.Amarelo;
import java.util.Scanner;

public class StartSemaforo extends Thread{
    public static void main(String[] args) throws InterruptedException {
        Sinal amarelo = new Amarelo();
        amarelo.setCor("Amarelo");

        Sinal verde = new Verde();
        verde.setCor("Verde");

        Sinal vermelho = new Vermelho();
        vermelho.setCor("Vermelho");

        Runnable runSemaphore = new Runnable() {
            Thread thread = new Thread(new StartSemaforo());

            @Override
            public void run() {
                synchronized (thread) {
                    int fim = 1;
                    do {
                        verde.showCor();
                        try {
                            thread.wait(12000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                        amarelo.showCor();
                        try {
                            thread.wait(3000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                        vermelho.showCor();
                        try {
                            thread.wait(6000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                        System.out.println("Deseja continuar? 1 - Sim / 2 - Não");
                        Scanner input = new Scanner(System.in);
                        fim = input.nextInt();
                    } while (fim == 1);
                }
            }
        };

        Thread runnableThread = new Thread(runSemaphore);
        runnableThread.start();
    }
}
