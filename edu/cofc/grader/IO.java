public class IO {

    // set input
    public static InputStream originalInput = System.in;
    // FileInputStream in = new FileInputStream(new File("input"));

    // get output
    public static PrintStream originalOutput = System.out;
    public static ByteArrayOutputStream baos = new ByteArrayOutputStream();
    public static PrintStream output = new PrintStream(baos);

    /* prepares output to be captured in ByteArrayOutputStream output
        use baos.toString()
    */
    public static void resetOutputStream() {
        baos.reset();
        System.setOut(output);
    }

    public static void restoreOutput() {
        System.setOut(originalOutput);
    }

    /* gives System.in a string for input
     * System.setIn(bais("2 3 1945"));
    */
    public static ByteArrayInputStream bais(String inpt) {
        try {
            return new ByteArrayInputStream(inpt.getBytes("UTF-8"));
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
/*
    // public static void stealOutput() {
    //     System.setOut(new PrintStream(new ByteArrayOutputStream()));
    // }

    // public static void returnOutput() {
    //     System.setOut(originalPrintStream);
    // }
}