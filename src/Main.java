import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println("Input string: " + s);
        //System.out.println(checkString(s));
        //System.out.println(s.split(" ").length==1);
        if(checkString(s)){
            Tree tree = new Tree(s);
            System.out.println("Output string: " + tree.unpackTree());
        }else {
            System.out.println("Incorrect string");
        }
    }

    public static boolean checkString(String s){
        if(s.matches("[0-9\\[\\]a-zA-Z]+")){
            int flag=0;
            for(int i =0; i<s.length(); i++){
                char c = s.charAt(i);
                if('['==c){
                    flag++;
                }else if(']'==c){
                    flag--;
                }
                if(flag<0){
                    return false;
                }
            }
            if(flag!=0){
                return false;
            }
            if(Character.isDigit(s.charAt(s.length()-1))){
                return false;
            }
            for(int i =0; i<s.length()-1; i++){
                char c = s.charAt(i);
                char c1 = s.charAt(i+1);
                if(Character.isDigit(c)){
                    if(!(Character.isDigit(c1) || c1=='[')){
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
