public class Tree {
    private MyNode root;

    Tree(String s){
        root=createTree(s);
    }

    public MyNode getRoot() {
        return root;
    }

    public static MyNode createTree(String s){
        MyNode current=new MyNode();
        //System.out.println(s);
        if(s.matches("[a-zA-Z]+")){
            current.data.append(s);
            current.leftChild=null;
            current.rightChild=null;
        }
        else {
            char c = s.charAt(0);
            char c1;
            if (c == '[') {
                current.data.append('1');
                current.leftChild = createTree(s.substring(1, unpack(s, 0) - 1));
                if(unpack(s, 0)==s.length()){
                    current.rightChild=null;
                }else {
                    current.rightChild = createTree(s.substring(unpack(s, 0)));
                }
            }
            if (Character.isDigit(c)) {
                current.data.append(c);
                int i = 1;
                while (Character.isDigit(c1 = s.charAt(i))) {
                    current.data.append(c1);
                    i++;
                }
                current.leftChild = createTree(s.substring(i + 1, unpack(s, i) - 1));
                //System.out.println(unpackege(s, i)+" "+s.length());
                if(unpack(s, i)==s.length()){
                    current.rightChild=null;
                }else {
                    current.rightChild = createTree(s.substring(unpack(s, i)));
                }
            }
            if (Character.isLetter(c)) {
                current.data.append(c);
                int i = 1;
                while (Character.isLetter(c1 = s.charAt(i))) {
                    current.data.append(c1);
                    i++;
                }
                current.leftChild = null;
                current.rightChild = createTree(s.substring(i));
            }
        }
        //System.out.println(current.data);
        return current;
    }

    public String unpackTree(){
        return unpackRoot(root);
    }

    public static String unpackRoot(MyNode current){
        StringBuilder sb = new StringBuilder();
        if(current.leftChild != null){
            String s1 = unpackRoot(current.leftChild);
            for(int i=0;i<Integer.parseInt(current.data.toString());i++){
                sb.append(s1);
            }
        }else {
            sb.append(current.data);
        }
        if(current.rightChild != null){
            String s2 = unpackRoot(current.rightChild);
            sb.append(s2);
        }
        return sb.toString();
    }


    private static int unpack(String s, int i){
        int flag=1;
        char c;
        i++;
        while(flag!=0){
            c= s.charAt(i);
            if('['==c){
                flag++;
            }else if(']'==c){
                flag--;
            }
            i++;
        }
        return i;
    }
}
