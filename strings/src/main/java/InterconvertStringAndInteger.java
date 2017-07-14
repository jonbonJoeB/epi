public class InterconvertStringAndInteger {

    /*
    6.1
    */

    public static Integer stringToInt(String number) {
        if (number == null || number.length() == 0) {
            return 0;
        }
        boolean negative = false;
        if (number.charAt(0) == '-') {
            negative = true;
            number = number.substring(1);
        }

        int res = 0;
        for (int i = 0; i < number.length(); i++) {
            char digit = number.charAt(i);
            res = res * 10 + (digit - '0');
        }

        return negative ? -res : res;
    }

    public static String intToString(Integer number) {
        if (number == 0) {
            return "0";
        }
        boolean negative = number < 0;
        number = Math.abs(number);

        final StringBuilder sb = new StringBuilder();
        while (number > 0) {
            sb.append(number % 10);
            number /= 10;
        }

        if (negative) {
            sb.append("-");
        }

        return sb.reverse().toString();
    }

}
