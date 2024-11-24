//      За дадена низа од случајни броеви кои се внесуваат од стандарден влез, да се направи преместување на сите нули на почеток на низата. На стандарден излез да се испечати трансформираната низа.
//
//      For example:
//
//      Input:
//      12
//      1 9 8 4 0 0 2 7 0 6 0 9
//
//      Result:
//      Transformiranata niza e:
//      0 0 0 0 1 9 8 4 2 7 6 9



import java.util.Scanner;

public class Main {
    static void pushZerosToBeginning(int arr[], int n)
    {
        int k = 0;
        int ans[] = new int[n];

        for(int i = 0; i < n; i++)
            if(arr[i] == 0){
                ans[k] = arr[i];
                k++;
            }

        for(int i = 0; i < n; i++)
            if(arr[i] != 0){
                ans[k] = arr[i];
                k++;
            }

        System.out.println("Transformiranata niza e:");
        for(int i = 0; i < n; i++)
            System.out.print(ans[i] + " ");
    }

    public static void main (String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int arr[] = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = input.nextInt();

        pushZerosToBeginning(arr, n);
    }
}