import java.util.Collections;
public class Test2 {
    public static void main(String[] args)
    {
        List<String> c = new ArrayList<String>();
        c.add("luqmaan");
        c.add("saleem");
        c.add("aamina");
        c.add("tabassum");    
    Comparator com = new Define();
    Collections.sort(c,com);
    for(Object i:c)
    {
        System.out.println(i);
    }
    }
    
}
