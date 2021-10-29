package task1;

public class HelloFromThreadPrinterTask extends Thread {

    private final int number;

    public HelloFromThreadPrinterTask(String name, int number) {
        super(name);
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + number);
    }

    public static void startTheProgramHelloFromThread() {
        for (int i = 49; i >= 0; i--) {
            Thread helloFromThreadPrinterTask = new HelloFromThreadPrinterTask("Hello from Thread ", i);
            helloFromThreadPrinterTask.start();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
