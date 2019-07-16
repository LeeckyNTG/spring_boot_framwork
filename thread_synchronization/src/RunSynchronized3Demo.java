public class RunSynchronized3Demo {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.name = name;
    }
    public static void main(String[] args) {
        RunSynchronized3Demo demo = new RunSynchronized3Demo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.setName("Likui");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String name = demo.getName();
                System.out.println(name);
            }
        }).start();
    }
}
