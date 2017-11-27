public class ThreadClass {

    public static class BadTestFile implements Runnable {

        public void run() {
            HW4 student = new HW4();
            student.main(null);

        }
    }

    // public class MainThreadClass {
    //     public static void main(String args[]) {
    //         MyRunnable myRunnable = new MyRunnable(10);
    //         Thread t = new Thread(myRunnable)
    //         t.start();
    //     }    
    // }
}