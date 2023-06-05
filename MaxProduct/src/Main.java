import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
     static long getMaxPair(int[] a)
    {
        int n = a.length;
        long max1 = 0;
        long max2=0;
        int k =0;
        for(int i = 0 ; i<n ; i++)
        {
            if(a[i]>max1)
            {
                max1=a[i];
                k = i;
            }
        }
        for(int j = 0 ; j<n ; j++)
        {
            if(a[j]>max2 && j!=k)
            {
                max2=a[j];
            }
        }
        return max1*max2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a =new int[n];
        for(int i=0;i<n;i++)
        {
              a[i] = in.nextInt();
        }
        System.out.println(getMaxPair(a));

    }
}