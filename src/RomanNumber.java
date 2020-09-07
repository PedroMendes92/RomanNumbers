
public class RomanNumber {
    private int arabicNumber;
    private CharactersMap romanCharacters;

    public RomanNumber(int arabicNumber) {
        if(arabicNumber < 1 || arabicNumber > 3999){
            throw new InvalidNumber();
        }
        this.arabicNumber = arabicNumber;
        this.romanCharacters = new CharactersMap();
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        if(romanCharacters.get(this.arabicNumber) != null){
            return romanCharacters.get(this.arabicNumber);
        }

        int thousands = getAmount(10000, 1000);
        int hundreds = getAmount(1000, 100);
        int tens = getAmount(100, 10);
        int units = getAmount(10, 1);


        result.append( generateThousands(thousands) )
                .append( appendUnits( hundreds , 100,500,1000) )
                .append( appendUnits( tens, 10,50,100) )
                .append( appendUnits( units, 1,5,10) );

        return result.toString();
    }

    private String generateThousands(int thousands) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= thousands; i++) {
            result.append(romanCharacters.get(1000));
        }
        return result.toString();
    }

    private int getAmount(int i, int i2) {
        return (this.arabicNumber % i) / i2;
    }

    private String appendUnits(int amount, int low, int mid, int high) {
        StringBuilder result = new StringBuilder();
        if(amount < 4) {
            for (int i = 0; i < amount; i++) {
                result.append(romanCharacters.get(low));
            }
        }else if(amount == 4){
            result.append(romanCharacters.get(low)).append(romanCharacters.get(mid));
        }else if(amount == 9){
            result.append(romanCharacters.get(low)).append(romanCharacters.get(high));
        }else {
            result.append(romanCharacters.get(mid));
            for (int i = 0; i < amount - 5; i++) {
                result.append(romanCharacters.get(low));
            }
        }
        return result.toString();
    }

    public class InvalidNumber extends RuntimeException {}
}
