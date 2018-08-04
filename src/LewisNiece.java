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
        Ladder result = printPath("CLAY","GOLD");
        if(result!=null){
            System.out.println("Length is "+result.getLength() + " and path is :"+ result.getPath());
        }else{
            System.out.println("No Path Found");
        }
    }

    private static Ladder printPath(String s1, String s2) {
        ArrayList<String> dictionary = hashMap.get(4);
        List<String> path = new LinkedList<String>();
        path.add(s1);
        Queue<Ladder> queue = new LinkedList<Ladder>();
        queue.add(new Ladder(path, 1, s1));
        dictionary.remove(s1);
        while(!queue.isEmpty() && !queue.peek().equals(s2)){
            Ladder ladder = queue.remove();

            if(s2.equals(ladder.getLastWord())){
                return ladder;
            }

            Iterator<String> i = dictionary.iterator();
            while (i.hasNext()) {
                String string = i.next();

                if(differByOne(string, ladder.getLastWord())){

                    List<String> list = new LinkedList<String>(ladder.getPath());
                    list.add(string);
                    queue.add(new Ladder(list, ladder.getLength()+1, string));
                    i.remove();
                }
            }
        }
        if(!queue.isEmpty()){
            return queue.peek();
        }
        return null;
    }


    private static boolean differByOne(String word1, String word2){
        if (word1.length() != word2.length()) {
            return false;
        }

        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
            }
        }
        return (diffCount == 1);
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
