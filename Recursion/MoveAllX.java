public class MoveAllX {
    public static void moveToEnd(String x, String y, int idx, int count) {
        if (idx == x.length()) {
            for (int i = 0; i < count; i++) {
                y += "x";
            }
            System.out.println(y);
            return;
        }
        if (x.charAt(idx) == 'x') {
            count++;
            // moveToEnd(x, y, ++idx, count);
        } else {
            y += x.charAt(idx);
        }
        moveToEnd(x, y, ++idx, count);
    }

    public static void main(String[] args) {
        String x = "axbcxxd";
        String y = "";
        moveToEnd(x, y, 0, 0);
    }
}