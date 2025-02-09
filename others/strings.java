package others;
import java.util.*;

public class strings {
    public static boolean palindrome(String s) {
        boolean flag = true;

        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                flag = false;
                return false;
            }
            i++;
            j--;
        }
        return flag;
    }

    public static String getFrequencyString(String str) {
        int freq[] = new int[26];
        for (char ch : str.toCharArray()) {
            freq[ch - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        char ch = 'a';
        for (int i : freq) {
            sb.append(ch);
            sb.append(freq[i]);
            ch++;
        }
        return sb.toString();
    }

    public static void validAnagram(String[] str) {
        HashMap<String, ArrayList<String>> hp = new HashMap<>();
        for (String chars : str) {
            String frequencyString = getFrequencyString(chars);
            if (hp.containsKey(frequencyString)) {
                hp.get(frequencyString).add(chars);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(chars);
                hp.put(frequencyString, list);

            }
        }
    }

    public static void printing_3_last_element(String s) {
        int i = 0;
        int n = s.length() - 1;
        while (n >= 0) {
            char ch = s.charAt(n);

            if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u' && ch != 'A' && ch != 'E' && ch != 'I'
                    && ch != 'O' && ch != 'U') {
                i++;
                if (i == 3) {
                    System.out.print(ch);
                    return;
                }
            }
            n--;
        }
    }

    public static void collecting_candies(int arr[]) {
        int n = arr.length;
        int sum = 0;
        int res[] = new int[arr.length - 1];
        sum = arr[0] + arr[1];
        res[0] = sum;
        for (int i = 2; i < n; i++) {
            sum = sum + arr[i];
            res[i - 1] = sum;
        }
        int result = 0;
        for (int i = 0; i < res.length; i++) {
            result += res[i];
        }
        System.out.println(result);
    }

    public static void shortestpath(String s) {
        int i = 0;
        int x = 0;
        int y = 0;
        while (i != s.length()) {
            if (s.charAt(i) == 'n') {
                y++;
            } else if (s.charAt(i) == 's') {
                y--;
            } else if (s.charAt(i) == 'e') {
                x++;
            } else {
                x--;
            }
            i++;
        }
        System.out.println((int) Math.sqrt((y * y) + (x * x)));
    }

    public static void stringbuilder(String s) {
        StringBuilder sb = new StringBuilder(s);
        System.out.print("printing the sb");
        System.out.println(sb);
        // System.out.print(type(sb))
        for (int i = 0; i < sb.length(); i++) {
            System.out.println(sb.charAt(i));
        }
    }

    public static void uppercases(String s) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ' ' && i < s.length() - 1) {
                sb.append(s.charAt(i));
                i++;
                sb.append(Character.toUpperCase(s.charAt(i)));
            } else {
                sb.append(s.charAt(i));
            }

        }
        System.out.print(sb);
    }

    public static void get_i_element(int n, int i) {
        int bitmask = 1 << i;
        if ((n & bitmask) != 0) {
            System.out.print("result is 1");
        } else {
            System.out.print("result is 0");
        }
    }

    public static void stringcompression(String s) {
        // if (s.isEmpty()) {
        // return "";
        // }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int count = 1;
            int j = i;
            while (j < s.length() - 1 && s.charAt(j + 1) == ch) {
                count++;
                j++;
            }
            i = j;
            sb.append(ch);
            if (count > 1) {
                sb.append(count);
            }
        }
        System.out.print(sb);
    }

    public static void set_i_element(int n, int i) {
        int bitmask = 1 << i;
        System.out.print(n | bitmask);
    }

    public static void clear_i_element(int n, int i) {
        int bitmask = ~(1 << i);
        System.out.print(n & bitmask);
    }

    public static void main(String args[]) {
        String s;
        Scanner sc = new Scanner(System.in);
        // s =sc.nextLine();
        // System.out.print(palindrome(s));
        // shortestpath(s);
        // System.out.print(s.substring(0,4));
        // stringbuilder(s);
        // uppercases(s);
        // stringcompression(s);
        // get_i_element(10,1);
        set_i_element(10, 2);
    }
}