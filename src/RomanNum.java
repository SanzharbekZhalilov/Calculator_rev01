import java.util.HashMap;
import java.util.Map;

public class RomanNum {

    public static int romanToArabic(String roman) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);

        int result = 0;

        for (int i = 0; i < roman.length(); i++) {
            if (i > 0 && map.get(roman.charAt(i)) > map.get(roman.charAt(i - 1))) {
                result += map.get(roman.charAt(i)) - 2 * map.get(roman.charAt(i - 1));
            } else
                result += map.get(roman.charAt(i));
        }

        return result;
    }

    public static String arabicToRoman(int arabic) {
        int[] values = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanLiterals = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (arabic >= values[i]) {
                arabic -= values[i];
                roman.append(romanLiterals[i]);
            }
        }

        return roman.toString();
    }
}
