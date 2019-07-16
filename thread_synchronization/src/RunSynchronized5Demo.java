public class RunSynchronized5Demo {
    private int age = 6;
    private String name = "lik";
    private final Object monitorName = new Object();
    private final Object monitorAge = new Object();
    public void setName(String name) {
        synchronized (monitorName){
            this.name = name;
        }
    }
    public String getName() {
        synchronized (monitorName){
            return name;
        }
    }
    public void setAge(int age) {
        synchronized (monitorAge){
            this.age = age;
        }
    }
    public synchronized int getAge() {
        synchronized (monitorAge){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return age;
    }
    public static void main(String[] args) {
        RunSynchronized5Demo demo = new RunSynchronized5Demo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int age = demo.getAge();
                System.out.println("age:"+age);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String name = demo.getName();
                System.out.println("name:"+name);
            }
        }).start();
    }
}
