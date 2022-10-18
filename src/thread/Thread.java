package thread;

import cores.Sinal;

public class Thread extends java.lang.Thread {
    private long timeout = 0;

    private java.lang.Thread notifier;

    private Sinal cor;

    public Thread(long timeout, Sinal cor) {
        this.timeout = timeout;
        this.cor = cor;
    }

    @Override
    public void run() {
        try {
            this.syncCor();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void syncCor() throws InterruptedException {
        synchronized (this) {
            java.lang.Thread actualThread = new java.lang.Thread(this);
            this.cor.showCor();
            actualThread.wait(this.getTimeout());
        }
    }

    private long getTimeout() {
        return this.timeout;
    }

    private java.lang.Thread getNotifier() {
        return notifier;
    }

    public void setNotifier(java.lang.Thread notifier) {
        this.notifier = notifier;
    }
}
