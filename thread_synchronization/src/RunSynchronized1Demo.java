public class RunSynchronized1Demo {
    private static int x = 0;
    private static int y = 0;
    private synchronized static void count(int newValue) {
        x = newValue;
        y = newValue;
        if (x != y) {
            System.out.println("x:" + x + ",y:" + y);
        }
    }
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000_000; i++) {
                    count(i);
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000_000; i++) {
                    count(i);
                }
            }
        }).start();
    }
}
