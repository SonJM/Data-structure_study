import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 1;

        for(int i=0; i<num; i++){
            for(int k=0; k<num-i-1; k++)
                System.out.print(" ");
            for(int j=0; j<count; j++){
                System.out.print('*');
            }
            count+=2;
            System.out.println();
        }
        count-=2;
        for(int i=num-1; i>0; i--){
            count-=2;
            for(int k=0; k<num-i; k++)
                System.out.print(" ");
            for(int j=0; j<count; j++){
                System.out.print('*');
            }
            System.out.println();
        }


    }
}
