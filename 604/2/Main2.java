public class Main2 {
    public static void main(String[] args) {
        int memory[] = new int[10];
        aThread R1 = new aThread(0, 0, memory);
        aThread R2 = new aThread(0, 0, memory);

        long startTime = System.currentTimeMillis();

        int i = 0;
        while(i < 10) {
            if(!R1.isAlive()) {
                R1 = new aThread(i++, 1, memory);
                R1.start();
            }
            if(!R2.isAlive()) {
                R2 = new aThread(i++, 2, memory);
                R2.start();
            }
        }
        while(R1.isAlive() || R2.isAlive()){};
        for(int j=0;j<10;++j) {
            System.out.print(memory[j] + ", ");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("\nTotal run time: " + (endTime - startTime));
    }
}