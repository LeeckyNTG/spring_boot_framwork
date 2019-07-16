public class RunSynchronized2Demo {
    private static int x = 0;
    private static void count() {
        x++;
    }
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000; i++) {
                    count();
                }
                System.out.println("线程1最后的x的值:" + x);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000; i++) {
                    count();
                }
                System.out.println("线程2最后的x的值:" + x);
            }
        }).start();
    }
}
