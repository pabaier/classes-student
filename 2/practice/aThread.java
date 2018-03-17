class aThread extends Thread {
    private int[] sharedMemory;
    private int value, index;

    aThread(int index, int value, int[] memory) {
        this.value = value;
        this.index = index;
        sharedMemory = memory;
    }
    public void run() {
        updateSharedMemory();
    }
    synchronized public void updateSharedMemory(){
        int waitTime = (int)(Math.random()*5000);
        try{
            Thread.sleep(waitTime);
        }catch(InterruptedException e) {}
        sharedMemory[index] = value;
        System.out.println("updated index " + index + " with " + value + " wait time: " + waitTime);
    }
}