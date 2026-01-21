public class Permutations {
    public static void main(String[] args) {
        permutations("","abc");
    }

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
}
