package cores;

abstract public class Sinal {
    private String cor;

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void showCor() {
        System.out.println("Sinal " + this.getCor());
    }
}
