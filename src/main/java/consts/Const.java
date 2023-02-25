package consts;

import java.util.HashMap;

public class Const {

    public static HashMap<String, String> options = new HashMap<>();

    static {
        options.put("1" , "ENCRYPT");
        options.put("2" , "DECRYPT");
        options.put("3" , "QUIT");
    }
}