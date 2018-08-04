import java.util.List;

public class Ladder {
    private List<String> path;
    private String lastWord;
    private int length;

    public Ladder(List<String> path) {
        this.path=path;
    }

    public Ladder(List<String> path, int length, String lastWord) {
        this.path=path;
        this.length=length;
        this.lastWord=lastWord;
    }
    public List<String> getPath() {
        return path;
    }
    public int getLength() {
        return length;
    }
    public String getLastWord() {
        return lastWord;
    }

    public void setPath(List<String> path) {
        this.path = path;
    }

    public void setLength(int length) {
        this.length = length;
    }
}

//        Queue<String> q = new LinkedList<>();
//        q.add(s1);
//        int length=0;
//        boolean done = false;
//        while(q.size()!=0 && !done)
//        {
//            String temp = q.remove();
//            hs.add(temp);
//            ArrayList<String> oneDistanceWords = getOneDistantWords(temp);
//            System.out.println(temp);
//            length++;
//            for(String s:oneDistanceWords)
//            {
//                if(!hs.contains(s))
//                {
//                    q.add(s);
//                    if(s.equals(s2)){
//                        System.out.println(s+" "+length);
//                        done = true;
//                    }
//                }
//
//            }
//        }
