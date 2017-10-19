class twoD {

    public static void main(String[] args) {
        int[][] x = {{1,2,3}, {4,5,6}, {7,8,9}, {7,7,7}};

        System.out.println(x.length);
        System.out.println(x[0].length);
        for(int i = 0; i < x.length; i++) {
            for(int j = 0; j < x[0].length; j++)
                System.out.print(x[i][j] + " ");
            System.out.println();
        }
    }

}