// "static void main" must be defined in a public class.
import java.util.*;


public class Program8 {


    static void firstFitCreate(int[] blockSize, int processSize,int processId)
    {
        int m = blockSize.length;

        for(int i=0;i<processSize;i++){
            for (int j = 0; j < m; j++)
            {
                if (blockSize[j] == 0)
                {
                    blockSize[j] = processId;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(blockSize));

    }
    static int firstFitDelete(int blockSize[], int processId)
    {
        int m = blockSize.length;
        int count=0;

        for (int j = 0; j < m; j++)
        {
            if (blockSize[j] == processId)
            {
                blockSize[j] = 0;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int arr[] = new int[10];
        for (int i = 0; i < arr.length; i++){
            arr[i] = 0;
        }
        int processId = 1;
        int freeBlocks =10;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the command from following - create,delete,exit");
        String command = sc.next();
        while(!command.equalsIgnoreCase("exit")){
            if(command.equalsIgnoreCase("create")){
                Random random = new Random();
                int randomMemory = random.nextInt(4)+1;
                System.out.println("Random memory allocated to processId"+processId+"="+randomMemory);
                if(freeBlocks<randomMemory){
                    System.out.println("Error allocating memory - not enough memory available");
                }else{
                    firstFitCreate(arr, randomMemory,processId++);
                    freeBlocks-=randomMemory;
                }

            }else if(command.equalsIgnoreCase("delete")){
                sc = new Scanner(System.in);
                System.out.println("Please enter the processId");
                String pId = sc.next();
                int count = firstFitDelete(arr, Integer.parseInt(pId));
                if(count > 0 ) {
                    System.out.println(Arrays.toString(arr));
                    freeBlocks+=count;
                }
                else
                    System.out.println("Error deleting processId - processId doesn't exist");
            }
            sc = new Scanner(System.in);
            System.out.println("Enter the command from following - create,delete,exit");
            command = sc.next();
        }

    }

}