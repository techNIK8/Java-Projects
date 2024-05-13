import java.util.Scanner;
import java.io.File;
public class RunMergeSort{
public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};
        Scanner s = new Scanner(new File("integers.txt"));
int[] array = new int[s.nextInt()];
for (int i = 0; i < array.length; i++)
    array[i] = s.nextInt();
for (int i = 0; i < array.length; i++)
    array[i] = s.nextInt();
        System.out.println("Given Array");
        printArray(array);
 
        MergeSort ob = new MergeSort();
        ob.sort(array, 0, arr.length-1);
 
        System.out.println("\nSorted array");
        printArray(array);
       
    }
    static void printArray(int arr[])
    {
        int n = array.length;
        for (int i=0; i<n; ++i)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}