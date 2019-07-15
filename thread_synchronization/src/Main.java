import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {

        thread();
        runnable();
        threadFactory();
        executor();
        callable();

    }

    /**
     * 使用Tread类定义工作
     */
    private static void thread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程工作");
            }
        });
        thread.start();
    }

    /**
     * 使用Runnable类定义工作
     */
    private static void runnable() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("线程工作");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    /**
     * 使用ThreadFactory类定义工作
     */
    private static void threadFactory() {

        ThreadFactory factory = new ThreadFactory() {
            int count = 0;

            @Override
            public Thread newThread(Runnable runnable) {
                count++;
                return new Thread(runnable, "Thread-" + count);
            }
        };

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("线程工作");
            }
        };

        Thread thread1 = factory.newThread(runnable);
        thread1.start();
        Thread thread2 = factory.newThread(runnable);
        thread2.start();
    }

    /**
     * 使用线程池定义工作
     */
    private static void executor() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("线程工作");
            }
        };
        /**可以无限制的创建线程*/
        ExecutorService executor = Executors.newCachedThreadPool();
        /**最多创建一个线程*/
        ExecutorService executor1 = Executors.newSingleThreadExecutor();
        /**最多创建指定数目的线程*/
        ExecutorService executor2 = Executors.newFixedThreadPool(16);
        /**调用execute方法就创建一个线程*/
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);


        /**保守型的关闭线程池,会等加入线程池中的线程全部执行结束后才会销毁*/
        executor.shutdown();
        /**强制型的关闭线程池,会立刻销毁所有线程*/
        executor.shutdownNow();


        /**自定义线程池*/
        BlockingDeque<Runnable> queue = new LinkedBlockingDeque<>(10000);//线程存储队列
        /**创建线程池(参数介绍:初始线程池大小,同时执行的线程最大数,线程没在使用的回收等待时间,时间计算单位,线程池存储线程任务队列)*/
        ExecutorService executorService = new ThreadPoolExecutor(0, 16, 60L, TimeUnit.SECONDS, queue);
    }


    /**
     *
     */
    private static void callable() {
        Callable<String> callable= new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                return "完成";
            }
        };

        ExecutorService executor = Executors.newCachedThreadPool();
        Future<String> future = executor.submit(callable);

        /**获取线程是否执行结束*/
        boolean bol = future.isDone();

        /**取出线程结束的返回值,get()方法会堵塞主线程*/
        try {
            String result = future.get();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
