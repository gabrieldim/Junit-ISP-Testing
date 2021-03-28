import java.util.Set;

public class TestingSets {

    public static Set setDifference(Set set1, Set set2){
        if(set1==null || set2==null) 
{
throw new NullPointerException();
}
        if(!set1.isEmpty()){
            set1.removeAll(set2);
            if(set1.isEmpty()) {
                return null;
            }
            return set1;
        }
        return null;
    }
}
