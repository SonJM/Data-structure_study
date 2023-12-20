import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        for(int i=97; i<123; i++){
            int index = -1;
            char ch = (char)i;
            for(int j=0; j<str.length(); j++){
                if(ch == str.charAt(j)) {
                    index = j;
                    break;
                }
            }
            System.out.print(index);
            System.out.print(" ");
        }
    }
}
