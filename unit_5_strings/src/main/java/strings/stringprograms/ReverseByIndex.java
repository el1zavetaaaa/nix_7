package strings.stringprograms;


public class ReverseByIndex {
    public static void reversebyindex(String str, int firstindex, int lastindex) {

        String indexstring = "";
        for (int i = firstindex; i <lastindex; i++) {
            indexstring = indexstring + str.charAt(i);
        }
        String reverseindexstring = SimpleReverse.simplereverse(indexstring);
        String reversestring = str.replaceAll(indexstring, reverseindexstring);

        System.out.println(reversestring);

    }


}