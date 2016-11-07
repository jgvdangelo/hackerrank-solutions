import java.util.*;

public class Rotation {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
            int size = scan.nextInt();
            int rot = scan.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = scan.nextInt();
            }
/*        	int size = 5;
        	int rot = 3;
        	int[] arr = {1, 2, 3, 4, 5};*/
        	
            if (size > 1) {
                boolean[] hasBeenUpdated = new boolean[size];
                int displaced = 0;
                int toCopy = 0;
                
                int i = 0;
                
                int newInd = 0;
                int currInd = i;

                while (i < arr.length) {
                    currInd = i;
                    newInd = (currInd - rot + size) % size;
                    displaced = arr[currInd];
                    toCopy = displaced;
                    while (!hasBeenUpdated[newInd]) {
                        displaced = arr[newInd];
                        
                        arr[newInd] = toCopy;
                        
                        hasBeenUpdated[newInd] = true;
                        
                        toCopy = displaced;
                        currInd = newInd;
                        newInd = (currInd - rot + size) % size;
                    }
                    
                    i++;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            scan.close();
    }
}
