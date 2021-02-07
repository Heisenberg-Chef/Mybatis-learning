
import org.junit.jupiter.api.Test;
import java.util.concurrent.*;

public class main {
    /**
     * 1.创建一个可缓存的线程池。如果线程池的大小超过了处理任务所需要的线程，那么就会回收部分空闲（60秒不执行任务）的线程<br>
     * 2.当任务数增加时，此线程池又可以智能的添加新线程来处理任务
     * 3.此线程池不会对线程池大小做限制，线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小
     */
    @Test
    public void cacheThreadPool(){
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for(int i = 1;i<50;i++)
        {
            final int ii = i;

            cachedThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println("线程名字:"+Thread.currentThread().getName()+",执行"+ii);
                }
            });
        }
    }

    /**
     * 1.创建固定大小的线程池。每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小
     * 2.线程池的大小一旦达到最大值就会保持不变，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程
     * 3.因为线程池大小为3，每个任务输出index后sleep 2秒，所以每两秒打印3个数字，和线程名称
     */
    @Test
    public void fixThreadPoolTest(){
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int ii = i;
            fixedThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println("线程名称：" + Thread.currentThread().getName() + "，执行" + ii);
                }
            });
        }
    }

    /**
     * 创建一个定长线程,支持定时以及周期性的任务执行,延迟执行
     */
    @Test
    public void scheduledThreadPool() throws InterruptedException {
        final ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        /**
         * 分配任务r1
         */
        Runnable r1 = new Runnable() {
            public void run() {
                System.out.println("线程名称：" + Thread.currentThread().getName() + "，执行:3秒后执行");
            }
        };
        scheduledThreadPool.schedule(r1,3, TimeUnit.SECONDS);
        /**
         * 分配任务r2
         */
        Runnable r2 = new Runnable() {
            public void run() {
                System.out.println("线程名称：" + Thread.currentThread().getName() + "，执行:延迟2秒后每3秒执行一次");
            }
        };
        scheduledThreadPool.schedule(r2,2,TimeUnit.SECONDS);
        /**
         * 分配任务r3
         */
        Runnable r3 = new Runnable() {
            public void run() {
                System.out.println("线程名称：" + Thread.currentThread().getName() + "，执行:普通任务");
            }
        };
        for (int i = 0; i < 10; i++) {
            scheduledThreadPool.execute(r3);
        }
        while (!scheduledThreadPool.isTerminated()) {
        }
    }
}
