public class MyThread extends Thread {
    private long time;

    public MyThread(String name, long time) {
        super(name);
        this.time = time;
    }

    @Override
    public void run() {
        try {
            sleep(time);
        } catch (Exception e) {
            System.out.println("Erro: "+ e.getMessage());
        }
        System.out.println("Thread " + getName());
    }
}
