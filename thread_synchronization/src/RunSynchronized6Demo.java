/**
 * 死锁
 */
public class RunSynchronized6Demo {

    private String name;
    private int x;
    private final Object monitor1 = new Object();
    private final Object monitor2 = new Object();
    public void setX(int x) {
        synchronized (monitor1){
            this.x = x;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (monitor2){
                name = "老王";
            }
        }
    }
    public void setName(String name) {
        synchronized (monitor2){
            this.name = name;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (monitor1){
                x = 5;
            }
        }
    }
    public static void main(String[] args) {

        RunSynchronized6Demo demo = new RunSynchronized6Demo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.setX(0);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.setName("老李");
            }
        }).start();


    }
}
