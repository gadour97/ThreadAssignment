public class ThreadAssignment {

    static class Counter {
        void count() {
            for(int i=1;i<=350;i++) {
                System.out.println(i);
            }
            System.out.println("FINISH !");
        }
    }

    static class MyThread extends Thread {
        private final Counter counter;

        public MyThread(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            synchronized (counter){
                counter.count();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1=new MyThread(counter);
        Thread t2=new MyThread(counter);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("DONE !");

    }
}
