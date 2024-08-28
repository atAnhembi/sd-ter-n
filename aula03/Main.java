public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("T1", 2000);
        MyThread t2 = new MyThread("T2", 1000);
        MyThread t3 = new MyThread("T3", 3000);

        t1.start();
        t2.start();
        t3.start();

        try {
            t2.join();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        

        System.out.println("Fim do programa");
    }
}
