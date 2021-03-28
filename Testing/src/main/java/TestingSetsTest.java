

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

public class TestingSetsTest {

    //Interface based domain
    @Test
    public void bothAreNeitherEmptyOrNull(){
        //C1=T,C2=T,C3=T,C4=T
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        set1.add(1);
        set2.add(3);
        TestingSets.setDifference(set1,set2);
    }
    @Test
    public void setTwoIsEmpty(){
        //C1=T,C2=T,C3=T,C4=F
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        set1.add(1);
        TestingSets.setDifference(set1,set2);
    }
    @Test(expected = NullPointerException.class)
    public void setTwoIsNull(){
        //C1=T,C2=T,C3=F,C4=F
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = null;
        set1.add(1);
        TestingSets.setDifference(set1,set2);
    }
    @Test(expected = NullPointerException.class)
    public void setOneIsNull(){
        //C1=F,C2=F,C3=T,C4=T
        Set<Integer> set1 = null;
        Set<Integer> set2 = new HashSet<Integer>();
        set2.add(1);
        TestingSets.setDifference(set1,set2);
    }
    @Test(expected = NullPointerException.class)
    public void bothSetsAreNull(){
        //C1=F,C2=F,C3=F,C4=F
        Set<Integer> set1 = null;
        Set<Integer> set2 = null;
        TestingSets.setDifference(set1,set2);
    }
    //Functionality based domain

    @Test
    public void bothAreDifferent(){
        //C5=T,C6=F,C7=F
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        set1.add(1);
        set2.add(3);
        set2.add(6);
        Set<Integer> expectedSet = new HashSet<Integer>();
        expectedSet.add(1);
        assertEquals(expectedSet,TestingSets.setDifference(set1,set2));
    }
    @Test(expected = NullPointerException.class)
    public void completelyDifferent(){
        //C5=F,C6=F,C7=F
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = null;
        set1.add(4);
        TestingSets.setDifference(set1,set2);
    }
    @Test(expected = NullPointerException.class)
    public void bothSetsAreEquivalent(){
        //C5=F,C6=T,C7=F
        Set<Integer> set1 = null;
        Set<Integer> set2 = null;
        Set<Integer> expectedSet = null;
        assertEquals(expectedSet,TestingSets.setDifference(set1,set2));
    }
    @Test
    public void sameLengthButNotEquivalent(){
        //C5=T,C6=F,C7=T
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        set1.add(1);
        set1.add(4);
        set2.add(3);
        set2.add(6);
        Set<Integer> expectedSet = new HashSet<Integer>();
        expectedSet.add(1);
        expectedSet.add(4);
        assertEquals(expectedSet,TestingSets.setDifference(set1,set2));
    }

}
