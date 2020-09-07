public class main {
    public static void main(String[] args) {
        for (int i = 1; i < 4000; i++) {
            RomanNumber romanNumber = new RomanNumber(i);
            System.out.println(i + ": " +romanNumber.toString());
        }
    }
}
