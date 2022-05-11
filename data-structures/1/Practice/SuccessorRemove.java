public class SuccessorRemove{

    public static void main(String[] args){
        UF a = new UF(10);
        int in = Integer.parseInt(args[0]);
        //a.union(3,4);a.union(1,8);a.union(8,3);
        //a.union(9,6);a.union(2,9);a.union(7,2);a.union(5,7);
        
        a.union(4,3);
        System.out.println("\n" + a);
        a.union(3,8);
        System.out.println("\n" + a);
        a.union(6,5);
        System.out.println("\n" + a);
        a.union(9,4);
        System.out.println("\n" + a);
        a.union(2,1);
        System.out.println("\n" + a);
        System.out.println(a.connected(8,9));
        System.out.println(a.connected(5,4));
        a.union(5,0);
        System.out.println("\n" + a);
        a.union(7,2);
        System.out.println("\n" + a);
        a.union(6,1);
        System.out.println("\n" + a);
        System.out.println(a.find(in));
/*
        a.union(7,3);
        System.out.println("\n" + a);
*/

    }


    static class UF{

        private int[] id;
        private int[] count;
        private int[] largest;

        public UF(int n){
            id = new int[n];
            count = new int[n];
            largest = new int[n];
            for(int i = 0; i < n; i++){
                id[i] = i;
                count[i] = 1;
                largest[i] = i;
            }
        }

        public void union(int a, int b){
            int rootA = findRoot(a);
            int rootB = findRoot(b);
            if(count[rootA] < count[rootB]){
                id[rootA] = rootB;
                count[rootB] = count[rootA] + count[rootB];
                largest[rootB] = Math.max(largest[rootB], largest[rootA]);
            }
            else{
                id[rootB] = rootA;
                count[rootA] = count[rootA] + count[rootB];
                largest[rootA] = Math.max(largest[rootB], largest[rootA]);
            }
        }

        public boolean connected(int a, int b){
            return findRoot(a) == findRoot(b);
        }

        public int findRoot(int a){
            while(id[a] != a){
                id[a] = id[id[a]];
                a = id[a];
            }
            return a;
        }

        // returns the largest element of the connected component
        // containing i
        public int find(int i){
            return largest[findRoot(i)];
        }

        public void remove(int i){
            
        }

        public String toString(){
            String values = " ";
            String unions = "[";
            String line = "";
            for(int i = 0; i < id.length - 1; i++){
                unions += id[i] + ", ";
                values += i + ", ";
                line += "----";
            }
            values += id.length - 1 + "";
            unions += id[id.length - 1] + "]";
            return values + "\n" + line + "\n" + unions;
        }

        public void printCount(){
            String s = " ";
            for(int i = 0; i < count.length; i++){
                s += count[i] + ", ";
            }
            System.out.println(s);
        }
    }
}