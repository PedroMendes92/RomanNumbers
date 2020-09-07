import java.util.HashMap;
import java.util.Map;

public class CharactersMap {
    private Map<Integer, String> romanCharacters;
    public CharactersMap(){
        romanCharacters = new HashMap<Integer, String>();
        romanCharacters.put(1,"I");
        romanCharacters.put(5,"V");
        romanCharacters.put(10,"X");
        romanCharacters.put(50,"L");
        romanCharacters.put(100,"C");
        romanCharacters.put(500,"D");
        romanCharacters.put(1000,"M");
    }

    public String get(int arabicNumber) {
        return this.romanCharacters.get(arabicNumber);
    }
}
