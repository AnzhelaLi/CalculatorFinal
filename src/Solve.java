

class Solve extends ReadString {
    int result;
    String romanFirst;
    String romanSecond;
    String numberFirst;
    String numberSecond;

    boolean isRomanOne() {
         /*проверка первого числа на соответствие римским цифрам
    (в данной программе берётся диапазон от 1 до 100 включительно*/

        RomanNumeral[] allRoman = RomanNumeral.values();
        for (RomanNumeral r : allRoman) {
            if (r.toString().equals(e.toUpperCase())) {
                romanFirst = e;
                return true;
            }
        }
        return false;
    }

    boolean isRomanTwo() {
   /*проверка второго числа на соответствие римским цифрам
    (в данной программе берётся диапазон от 1 до 100 включительно*/

        RomanNumeral[] allRoman = RomanNumeral.values();
        for (RomanNumeral r : allRoman) {
            if (r.toString().equals(w.toUpperCase())) {
                romanSecond = w;
                return true;
            }
        }
        return false;
    }

    boolean isInt() throws WrongInputException {
        if (e.matches("\\d+") && w.matches("\\d+")) {
            numberFirst = e;
            numberSecond = w;
            return true;
        } else if (!isRomanOne() || !isRomanTwo()) /*если введенные строки
         не римские и не арабские цифры, то выбрасываем исключение*/
            throw new WrongInputException("Wrong number input");
        return false;
    }

    void catchRoman() throws WrongInputException {
        //конвертация римских цифр в арабские

        if (!(romanFirst.matches("I|II|III|IV|V|VI|VII|VIII|IX|X")) ||
                !(romanSecond.matches("I|II|III|IV|V|VI|VII|VIII|IX|X"))) {

            throw new WrongInputException("Wrong roman");

        } else if (romanFirst.matches("I|II|III|IV|V|VI|VII|VIII|IX|X") &&
                romanSecond.matches("I|II|III|IV|V|VI|VII|VIII|IX|X")) {
            try {
                a = RomanNumeral.romanToArabic(romanFirst);
            } catch (WrongInputException wrongInputException) {
                wrongInputException.printStackTrace();
            }
            try {
                b = RomanNumeral.romanToArabic(romanSecond);
            } catch (WrongInputException wrongInputException) {
                wrongInputException.printStackTrace();
            }
        }
    }

    void catchInt() throws WrongInputException {
//конвертация строк в арабские цифры

        if (!(numberFirst.matches("1|2|3|4|5|6|7|8|9|10")) ||
                !(numberSecond.matches("1|2|3|4|5|6|7|8|9|10"))) {
            throw new WrongInputException("Wrong arabic");

        } else if (numberFirst.matches("1|2|3|4|5|6|7|8|9|10") |
                numberSecond.matches("1|2|3|4|5|6|7|8|9|10")) {
            a = Integer.parseInt(numberFirst);
            b = Integer.parseInt(numberSecond);
        }
    }

    void printRoman() {
        System.out.print(RomanNumeral.arabicToRoman(result));
        /*конвертация результата вычисления в римские цифры
        и вывод в консоль */
    }

    void printArabic() {
//вывод в консоль результата арабскими цифрами
        System.out.print(result);

    }

    public void getResult() throws IllegalStateException {

        switch (symbol) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + symbol);
        }
    }

    public static void main(String[] args) throws WrongInputException {
        Solve solve = new Solve();
        System.out.println("");
        if (solve.isRomanOne() &&
                solve.isRomanTwo()) {
            solve.catchRoman();
            solve.getResult();
            solve.printRoman();
        } else if (solve.isInt()) {
            solve.catchInt();
            solve.getResult();
            solve.printArabic();
        }
    }

}



