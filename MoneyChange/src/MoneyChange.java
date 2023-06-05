import java.sql.SQLOutput;
import java.util.Scanner;


public class MoneyChange
{
    static int count=0;
    static int change(int a)
    {
        if(a>=10)
        {
            a=a-10;
            MoneyChange.count++;
            return change(a);
        } else if (a>=5) {
            a=a-5;
            MoneyChange.count++;
            return change(a);
        } else if (a>=1) {
            a=a-1;
            MoneyChange.count++;
            return change(a);
        } else
            return count;
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        change(a);
        System.out.println(MoneyChange.count);
    }
}