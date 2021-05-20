package global;

import java.io.File;

public class MyValidators {
    public static boolean stringValidation(String value) {
        return value != null && !value.isEmpty();
    }

    public static boolean intValidation(String value) {
        try {
            Integer.valueOf(value);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public static boolean doubleValidation(String value) {
        try {
            Double.valueOf(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean fileValidation(String value) {
        return new File(value).exists();
    }

}
