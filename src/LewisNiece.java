import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LewisNiece {

    public static HashMap<Integer, ArrayList<String>> hashMap = new HashMap<>();
    public static HashSet<String> hs=new HashSet<>();
    public static void main(String[] args) throws IOException {
        readFromFile();
        printPath("CLAY","GOLD");
    }

    private static void printPath(String s1, String s2) {

        Queue<String> q = new LinkedList<>();
        q.add(s1);
        boolean done = false;
        while(q.size()!=0 && !done)
        {
            String temp = q.remove();
            ArrayList<String> oneDistanceWords = getOneDistantWords(temp);
          //  System.out.println(temp);
            for(String s:oneDistanceWords)
            {
                if(!hs.contains(s) )
                {
                    q.add(s);
                }
                if(s.equals(s2)){
                    System.out.println(s+" ");
                    done = true;
                }
            }
        }
    }

        public static ArrayList<String> getOneDistantWords(String startWord) {
            ArrayList<String> similarWords = hashMap.get(startWord.length());
            ArrayList<String> oneDistantWords = new ArrayList<>();
            for (String i : similarWords) {
                if (compare(startWord, i) && !(startWord.equals(i))) {
                    oneDistantWords.add(i);
                }
            }
            return oneDistantWords;
        }

        public static boolean compare(String one, String two) {
            int count = 0;
            for (int i = 0; i < one.length(); i++) {
                if (one.charAt(i) != two.charAt(i))
                    count++;
            }
            if (count > 1)
                return false;
            return true;
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
