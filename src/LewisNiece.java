import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class LewisNiece {

    public static HashMap<Integer, ArrayList<String>> hashMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        readFromFile();
        printPath("CLAY","GOLD");
    }

    private static void printPath(String s1, String s2) {

    }


    private static void readFromFile() throws IOException {
        String fileName = "src/sowpods.txt";
        String line;
        FileReader fileReader =
                new FileReader(fileName);
        BufferedReader bufferedReader =
                new BufferedReader(fileReader);
        while((line = bufferedReader.readLine()) != null) {
            if(hashMap.get(line.length()) == null){
                ArrayList arrayList = new ArrayList();
                arrayList.add(line);
                hashMap.put(line.length(),arrayList);
            }else {
                ArrayList arrayList = hashMap.get(line.length());
                arrayList.add(line);
                hashMap.put(line.length(),arrayList);
            }
        }
        bufferedReader.close();
    }
}
