public class RequestThread extends Thread {
    private int index;
    private String initialState;
    private String goalState;
    private HashMap<Integer, Integer> solutions; // <index, solution>

    RequestThread(
        int index,
        String initialState, 
        String goalState, 
        HashMap<Integer, String> solutions )
    {
        this.index = index;
        this.initialState = initialState;
        this.goalState = goalState;
        this.solutions = solutions;
    }

    public void run(){
        getSolutionFromServer();
    }

    /** 
     * connect to server
     * send index, initialState, goalState to server as Json
     * {"id":1234, "initial":"0123456789", "goal":"1203456789"}
     * eg: Here      - writer.write(JSON)
     *     In server - reader.readLine()
     * eg: writer.write(JSON)
     * receive from server index, solution as Json
     * eg: In server - writer.write(JSON)
     *     Here      - reader.readLine()
     * {"id":1234, "solution":"01234567802345678120345678"}
     */
    synchronized public void getSolutionFromServer() {
        
    }

}