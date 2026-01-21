import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
        //permutations("","abc");
        ArrayList<String> res = permutationsList("", "abc");
        System.out.println(res);

        System.out.println(permutationsCount("", "abcd"));
    }

    //listing all the valid permutations
    static void permutations(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        for(int i=0;i <= p.length();i++){
            String first = p.substring(0,i);
            String second = p.substring(i,p.length());
            //then add the first, ch, and second
            //skip the character in the unprocessed string
            permutations(first + ch + second, up.substring(1));
        }
    }

    //Returning the Output as an ArrayList
    static ArrayList<String> permutationsList(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> res = new ArrayList<>();

        char ch = up.charAt(0);

        for(int i=0;i <= p.length();i++){
            String first = p.substring(0,i);
            String second = p.substring(i,p.length());
            res.addAll(permutationsList(first + ch + second, up.substring(1)));
        }

        return res;
    }

    //Permutations Count
    static int permutationsCount(String p, String up){
        if(up.isEmpty()){
            return 1;
        }

        int count = 0;
        char ch = up.charAt(0);
        for(int i=0;i <= p.length();i++){
            String first = p.substring(0,i);
            String second = p.substring(i, p.length());

            count = count + permutationsCount(first + ch + second, up.substring(1));
        }
        return count;
    }
}
