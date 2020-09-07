import org.junit.Test;

import static org.junit.Assert.*;

public class RomanNumberTest {
    @Test
    public void convertArabicToRoman() throws Exception{
        RomanNumber number = new RomanNumber(1);
        assertEquals( "I", number.toString());
    }

    @Test (expected = RomanNumber.InvalidNumber.class)
    public void willThrowInvalidNumber_WhenArabicNumberIsZero() throws Exception{
        RomanNumber romanNumber = new RomanNumber(0 );
    }

    @Test (expected = RomanNumber.InvalidNumber.class)
    public void willThrowInvalidNumber_WhenArabicNumberIsNegative() throws Exception{
        RomanNumber romanNumber = new RomanNumber(-2 );
    }

    @Test (expected = RomanNumber.InvalidNumber.class)
    public void willThrowInvalidNumber_WhenArabicNumberIsBiggerThanMaxNumber() throws Exception{
        RomanNumber romanNumber = new RomanNumber(4000 );
    }

    @Test
    public void checkAllSevenBaseSymbolsAreCorrect() throws Exception{
        RomanNumber one = new RomanNumber(1);
        assertEquals( "I", one.toString());
        RomanNumber five = new RomanNumber(5);
        assertEquals( "V", five.toString());
        RomanNumber ten = new RomanNumber(10);
        assertEquals( "X", ten.toString());
        RomanNumber fifty = new RomanNumber(50);
        assertEquals( "L", fifty.toString());
        RomanNumber hundred = new RomanNumber(100);
        assertEquals( "C", hundred.toString());
        RomanNumber fiveHundred = new RomanNumber(500);
        assertEquals( "D", fiveHundred.toString());
        RomanNumber thousand = new RomanNumber(1000);
        assertEquals( "M", thousand.toString());
    }

    @Test
    public void checkIfNumbersBelowTenAreWellRepresented(){
        RomanNumber two = new RomanNumber(2);
        RomanNumber six = new RomanNumber(6);
        assertEquals("II", two.toString());
        assertEquals("VI", six.toString());
    }

    @Test
    public void checkIfUnitsLessThan5ArePresentInTheEndOfString(){
        RomanNumber two = new RomanNumber(12);
        RomanNumber three = new RomanNumber(13);
        RomanNumber four = new RomanNumber(14);
        assertEquals("II",  two.toString().substring(two.toString().length() - 2));
        assertEquals("III",  three.toString().substring(three.toString().length() - 3));
        assertEquals("IV",  four.toString().substring(four.toString().length() - 2));

    }

    @Test
    public void checkIfUnitsBiggerThan5ArePresentInTheEndOfString(){
        RomanNumber six = new RomanNumber(326);
        RomanNumber eight = new RomanNumber(418);
        RomanNumber nine = new RomanNumber(569);
        assertEquals("VI",  six.toString().substring(six.toString().length() - 2));
        assertEquals("VIII",  eight.toString().substring(eight.toString().length() - 4));
        assertEquals("IX",  nine.toString().substring(nine.toString().length() - 2));
    }

    @Test
    public void checkIfTensLessThan5ArePresentBeforeUnits(){
        RomanNumber two = new RomanNumber(22);
        RomanNumber three = new RomanNumber(34);
        RomanNumber four = new RomanNumber(44);
        assertEquals("XX",  two.toString().substring(two.toString().length() - 4, two.toString().length() - 2));
        assertEquals("XXX",  three.toString().substring(three.toString().length() - 5,three.toString().length() - 2));
        assertEquals("XL",  four.toString().substring(four.toString().length() - 4,four.toString().length() - 2));
    }

    @Test
    public void checkIfThousandsAreAddedCorrectly(){
        RomanNumber threeThousand = new RomanNumber(3001);
        RomanNumber twoThousand = new RomanNumber(2673);
        assertEquals("MMMI", threeThousand.toString());
        assertEquals("MMDCLXXIII", twoThousand.toString());

    }

}