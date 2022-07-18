import java.util.ArrayList;
import java.util.Scanner;

public class Compress_LZ78 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Text do you need compress");
        String Text = input.nextLine();

        ArrayList<Integer> position = new ArrayList<Integer>();
        ArrayList<Character> NextSymbol = new ArrayList<Character>();
        ArrayList<String> DICTIONARY = new ArrayList<String>();

        DICTIONARY.add("");// because we staring dictionary from 1 look doctor in lecture
        String temp = "";
        for (int i = 0; i < Text.length(); i++) {
            temp = Text.substring(i, i + 1);
            int counter = i;
            for (int j = 0; j <= i; j++) {
                if (DICTIONARY.contains(temp)) {
                    if (counter + 1 < Text.length()) {
                        counter++;
                        temp = temp + Text.substring(counter, counter + 1);
                        continue;
                    }
                }
                if (DICTIONARY.contains(temp)) {

                    position.add(DICTIONARY.indexOf(temp));
                    NextSymbol.add(null);

                    break;
                } else if (j == 0) {
                    position.add(j);
                    NextSymbol.add(temp.charAt(j));
                    DICTIONARY.add(temp);
                    break;
                } else {
                    position.add(DICTIONARY.indexOf(temp.substring(0, counter - i)));
                    NextSymbol.add(temp.charAt(j));
                    DICTIONARY.add(temp);
                    break;
                }
            }
            i = counter;
        }
        input.close();
        for (int i = 0; i < position.size(); i++)
            System.out.println("<" + position.get(i) + "," + NextSymbol.get(i) + ">");

    }
}