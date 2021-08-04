package strings.stringprograms;


public class ReverseByIndex {
    public static void reversebyindex(String str, int index1, int index2) {

        String indexstring = "";
        for (int i = index1; i < index2; i++) {
            indexstring = indexstring + str.charAt(i);
        }
        String reverseindexstring = SimpleReverse.simplereverse(indexstring);
        String reversestring = str.replaceAll(indexstring, reverseindexstring);

        System.out.println(reversestring);

    }


}