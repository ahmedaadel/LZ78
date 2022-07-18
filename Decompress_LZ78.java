import java.util.ArrayList;
import java.util.Scanner;

public class Decompress_LZ78 {
    public static void main(String[] args) {
        int NumOfTags;
        System.out.print("Enter numbers of tags: ");
        Scanner input = new Scanner(System.in);
        NumOfTags = input.nextInt();

        ArrayList<Integer> position = new ArrayList<Integer>();
        ArrayList<Character> NextSymbol = new ArrayList<Character>();
        char InputSymbol;
        int Inputposition;
        System.out.println("Enter < index , syembol >");
        for (int i = 0; i < NumOfTags; ++i) {
            Inputposition = input.nextInt();
            InputSymbol = input.next().charAt(0);
            position.add(Inputposition);
            NextSymbol.add(InputSymbol);
            System.out.println("Enter < index , syembol >");
        }
        
        String Decompression = "";
        ArrayList<String> Dictionary = new ArrayList<String>();
        Dictionary.add("");// to starting counting from 1 in dictionary

        for (int i = 0; i < position.size(); i++) {

            if (position.get(i) == 0) {
                Decompression = Decompression + NextSymbol.get(i);
                Dictionary.add(String.valueOf(NextSymbol.get(i)));
            } else {
                Decompression = Decompression + Dictionary.get(position.get(i)) + NextSymbol.get(i);
                String temp2 = Dictionary.get(position.get(i)) + NextSymbol.get(i);

                if (!Dictionary.contains(temp2))
                    Dictionary.add(temp2);
            }

        }
        System.out.print(Decompression.replace("null", ""));

    }
}
