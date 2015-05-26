package calc.jahnke.im.calc.ModelClasses;

import android.util.Log;

/**
 * Created by setup on 26.05.2015.
 */
public class NumberSystemConverter {

    private static final char[] chars = { '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
            'y', 'z' };

    public static long toDecimal(String input, int system) {
        char[] number = input.toLowerCase().toCharArray();
        long result = 0L;
        int counter = 0;
        for (int i = number.length - 1; i >= 0; i--) {
            result += (long) (getNumberValue(number[i]) * Math.pow(system, counter));
            counter++;
        }
        return result;
    }

    private static int getNumberValue(char ziffer) {
        for (int i = 0; i < chars.length; i++) {
            if (ziffer==chars[i]) {
                return i;
            }
        }
        return 0;
    }

    private static char getNumberCharacter(int zahl) {
        return chars[zahl];
    }

    private static String toTargetSystem(long zahl, int zielsystem) {
        String result = "";
        boolean run = true;
        while (run) {
            result = getNumberCharacter((int)(zahl%zielsystem)) + result;
            zahl = (long)zahl/zielsystem;
            if (zahl==0) {
                break;
            }
        }
        return result.toUpperCase();
    }

    public static String convert(String number, int currentSystem, int targetSystem){
        if(!valid(number, currentSystem)){
            return "Fehler!";
        }
        long decimal = toDecimal(number, currentSystem);
        Log.d("NumberConverter", "decimal: "+decimal);
        String result = toTargetSystem(decimal, targetSystem);
        Log.d("NumberConverter", "result: "+result);
        return result;
    }

    private static boolean valid(String input, int currentSystem) {
        for (int i=0; i<input.length(); i++){
            boolean isInCurrentSystem = false;
            for (int j=0; j<currentSystem; j++){
                if(input.charAt(i)==chars[j]){
                    isInCurrentSystem = true;
                }
            }
            if(!isInCurrentSystem){
                return false;
            }
        }
        return true;
    }

}
