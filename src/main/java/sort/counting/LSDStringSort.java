package sort.counting;

import util.FileUtil;
import util.Utilities;

import java.io.FileNotFoundException;

public class LSDStringSort {

    private final int UNICODE_RANGE = 65535;

    /**
     * findMaxLength method returns maximum length of all available strings in an array
     *
     * @param strArr It contains an array of String from which maximum length needs to be found
     * @return int Returns maximum length value
     */
    private int findMaxLength(String[] strArr) {
        int maxLength = Utilities.getPinyinString(strArr[0]).length();
        for (String str : strArr)
            maxLength = Math.max(maxLength, Utilities.getPinyinString(str).length());
        return maxLength;
    }

    /**
     * charAsciiVal method returns ASCII value of particular character in a String.
     *
     * @param str          String input for which ASCII Value need to be found
     * @param charPosition Character position of which ASCII value needs to be found. If character
     *                     doesn't exist then ASCII value of null i.e. 0 is returned
     * @return int Returns ASCII value
     */
    private int charAsciiVal(String str, int charPosition) {
        str = Utilities.getPinyinString(str);
        if (charPosition >= str.length()) {
            return 0;
        }
        return str.charAt(charPosition);
    }

    /**
     * charSort method is implementation of LSD sort algorithm at particular character.
     *
     * @param strArr       It contains an array of String on which LSD char sort needs to be performed
     * @param charPosition This is the character position on which sort would be performed
     * @param from         This is the starting index from which sorting operation will begin
     * @param to           This is the ending index up until which sorting operation will be continued
     */
    private void charSort(String[] strArr, int charPosition, int from, int to) {
        int[] count = new int[UNICODE_RANGE + 2];
        String[] result = new String[strArr.length];

        for (int i = from; i <= to; i++) {
            int c = charAsciiVal(strArr[i], charPosition);
            count[c + 2]++;
        }

        // transform counts to indices
        for (int r = 1; r < UNICODE_RANGE + 2; r++)
            count[r] += count[r - 1];

        // distribute
        for (int i = from; i <= to; i++) {
            int c = charAsciiVal(strArr[i], charPosition);
            result[count[c + 1]++] = strArr[i];
        }

        // copy back
        if (to + 1 - from >= 0) System.arraycopy(result, 0, strArr, from, to + 1 - from);
    }

    /**
     * sort method is implementation of LSD String sort algorithm.
     *
     * @param strArr It contains an array of String on which LSD sort needs to be performed
     * @param from   This is the starting index from which sorting operation will begin
     * @param to     This is the ending index up until which sorting operation will be continued
     */
    public void sort(String[] strArr, int from, int to) {
        int maxLength = findMaxLength(strArr);
        for (int i = maxLength - 1; i >= 0; i--)
            charSort(strArr, i, from, to);
    }

    /**
     * sort method is implementation of LSD String sort algorithm.
     *
     * @param strArr It contains an array of String on which LSD sort needs to be performed
     */
    public void sort(String[] strArr) {
        sort(strArr, 0, strArr.length - 1);
    }

    public static void main(String[] args) {
        String[] s = {"ded", "red", "aed", "eed", "beeee", "cat", "a", "superman"};
        try {
            s = FileUtil.getWordArray();
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }
        LSDStringSort lsd = new LSDStringSort();
        lsd.sort(s);
        System.out.println(s[0]);
        System.out.println(s[1]);
        System.out.println(s[2]);
        System.out.println(s[3]);
        System.out.println(s[4]);
    }
}
