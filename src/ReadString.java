
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ReadString {
    public int a;
    public int b;
    public char symbol;
    public String e;
    public String w;


    ReadString() {

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        try {
            input = sc.readLine();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
String noSpaceInput = input.replaceAll(" ", "");
        List<String> nums = Arrays.asList(noSpaceInput.split("[+\\-*/]"));
        String[] toNums = nums.toArray(new String[0]);
        //создаем массив с двумя числами

        Matcher ofSings = Pattern.compile("[+\\-*/]").matcher(noSpaceInput);
        //разделяем строку арифметическим знаком
        List<String> sings = new ArrayList<>();
        while (ofSings.find()) {
            sings.add(ofSings.group());
        }
        String[] toChar = sings.toArray(new String[0]);
        //создаем массив с одним арифметическим знаком
        String[] arrowOfSymbols = {"-", "+", "*", "/"};
        for (String arrowOfSymbol : arrowOfSymbols) {
            if (toChar[0].contains(arrowOfSymbol)) {
                symbol = toChar[0].charAt(0); //преобразуем символ в char
                break;
            }
        }

        e = toNums[0];
        w = toNums[1];
    }

}





































