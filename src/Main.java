public class Main {

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                if (count == 0) {
                    return false;
                }
                count--;
            }
        }
        return count == 0;
    }

    // 2. reverseInteger
    public static int reverseInteger(int x) {
        int reverse = 0;
        while (x != 0) {
            int digit = x % 10;
            reverse = reverse * 10 + digit;
            x /= 10;
        }
        return reverse;
    }

    // 3. encryptThis
    public static String encryptThis(String str) {
        StringBuilder resultBuilder = new StringBuilder();
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char[] charArray = word.toCharArray();

            if (charArray.length > 1) {
                char temp = charArray[1];
                charArray[1] = charArray[charArray.length - 1];
                charArray[charArray.length - 1] = temp;
            }
            charArray[0] = (char) word.codePointAt(0);
            resultBuilder.append(charArray);
            if (i < words.length - 1) {
                resultBuilder.append(" ");
            }
        }
        return resultBuilder.toString();
    }

    // 4. decipherThis
    public static String decipherThis(String str) {
        String[] words = str.split(" ");
        String result = "";
        for (String word : words) {
            int x = 0;
            for (int i = 0; i < word.length(); i++) {
                if (!Character.isDigit(word.charAt(i))) {
                    x = i;
                    break;
                }
            }
            int firstCharCode = Integer.parseInt(word.substring(0, x));
            char[] charArray = word.substring(x).toCharArray();

            if (charArray.length > 1) {
                char temp = charArray[0];
                charArray[0] = charArray[charArray.length - 1];
                charArray[charArray.length - 1] = temp;
            }

            String decipheredWord = (char) firstCharCode + new String(charArray);
            result += decipheredWord + " ";
        }
        return result.trim();
    }
}

