public class RunSynchronized4Demo {
    private int age = 6;
    private String name = "lik";
    public synchronized void setName(String name) {
        this.name = name;
    }
    public synchronized String getName() {
        return name;
    }
    public synchronized void setAge(int age) {
        this.age = age;
    }
    public synchronized int getAge() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return age;
    }
    public static void main(String[] args) {
        RunSynchronized4Demo demo = new RunSynchronized4Demo();
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
