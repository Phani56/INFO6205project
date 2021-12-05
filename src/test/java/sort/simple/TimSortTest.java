package sort.simple;

import junit.framework.TestCase;
import org.junit.Test;
import sort.counting.LSDStringSort;

public class TimSortTest extends TestCase {

    @Test
    public void testRandomElementsSort() throws Exception{
        String[] unsortedArray = { "సాదా", "అమ్మాయి", "సాధారణ", "యువ", "సిద్ధంగా", "పైన","ఎప్పుడూ","ఎరుపు","జాబితా","అయితే"};
        String[] sortedArray = {"అమ్మాయి", "అయితే", "ఎప్పుడూ", "ఎరుపు", "జాబితా", "పైన", "యువ", "సాదా", "సాధారణ", "సిద్ధంగా"};

        TimSort tim = new TimSort();
        tim.sort(unsortedArray);
        for(int i = 0; i<unsortedArray.length;i++)
            assertTrue("Mismatch",unsortedArray[i].equals(sortedArray[i]));

    }

    @Test
    public void testSortedElementsSort() throws Exception{
        String[] unsortedArray = { "అమ్మాయి", "అయితే", "ఎప్పుడూ", "ఎరుపు", "జాబితా", "పైన", "యువ", "సాదా", "సాధారణ", "సిద్ధంగా"};
        String[] sortedArray = {"అమ్మాయి", "అయితే", "ఎప్పుడూ", "ఎరుపు", "జాబితా", "పైన", "యువ", "సాదా", "సాధారణ", "సిద్ధంగా"};

        TimSort tim = new TimSort();
        tim.sort(unsortedArray);
        for(int i = 0; i<unsortedArray.length;i++)
            assertTrue("Mismatch",unsortedArray[i].equals(sortedArray[i]));

    }

    @Test
    public void testPartialSortedElementsSort() throws Exception{
        String[] unsortedArray = { "అమ్మాయి", "అయితే", "ఎప్పుడూ", "ఎరుపు", "జాబితా", "సిద్ధంగా", "యువ",  "పైన", "సాధారణ","సాదా"};
        String[] sortedArray = {"అమ్మాయి", "అయితే", "ఎప్పుడూ", "ఎరుపు", "జాబితా", "పైన", "యువ", "సాదా", "సాధారణ", "సిద్ధంగా"};

        TimSort tim = new TimSort();
        tim.sort(unsortedArray);
        for(int i = 0; i<unsortedArray.length;i++)
            assertTrue("Mismatch",unsortedArray[i].equals(sortedArray[i]));

    }

    @Test
    public void testReverseSortedElementsSort() throws Exception{
        String[] unsortedArray = { "సిద్ధంగా", "సాధారణ", "సాదా", "యువ", "పైన", "జాబితా", "ఎరుపు",  "ఎప్పుడూ", "అయితే","అమ్మాయి"};
        String[] sortedArray = {"అమ్మాయి", "అయితే", "ఎప్పుడూ", "ఎరుపు", "జాబితా", "పైన", "యువ", "సాదా", "సాధారణ", "సిద్ధంగా"};

        TimSort tim = new TimSort();
        tim.sort(unsortedArray);
        for(int i = 0; i<unsortedArray.length;i++)
            assertTrue("Mismatch",unsortedArray[i].equals(sortedArray[i]));

    }

    @Test
    public void testSortedElementsChineseSort() throws Exception{
        String[] unsortedArray = { "阿安", "阿斌", "阿滨", "阿彬", "阿冰", "阿兵", "阿冰冰", "阿婵", "阿超", "阿朝"};
        String[] sortedArray = {"阿安", "阿斌", "阿滨", "阿彬", "阿冰", "阿兵", "阿冰冰", "阿婵", "阿超", "阿朝"};

        TimSort tim = new TimSort();
        tim.sort(unsortedArray);
        for(int i = 0; i<unsortedArray.length;i++)
            assertTrue("Mismatch",unsortedArray[i].equals(sortedArray[i]));

    }

    @Test
    public void testReverseSortedElementsChineseSort() throws Exception{
        String[] unsortedArray = { "阿朝", "阿超", "阿婵", "阿冰冰", "阿兵", "阿冰", "阿彬", "阿滨", "阿斌", "阿安"};
        String[] sortedArray = {"阿安", "阿斌", "阿滨", "阿彬", "阿冰", "阿兵", "阿冰冰", "阿婵", "阿超", "阿朝"};

        TimSort tim = new TimSort();
        tim.sort(unsortedArray);
        for(int i = 0; i<unsortedArray.length;i++)
            assertTrue("Mismatch",unsortedArray[i].equals(sortedArray[i]));

    }

    @Test
    public void testPartialSortedElementsChineseSort() throws Exception{
        String[] unsortedArray = { "阿安", "阿斌", "阿滨", "阿彬", "阿冰", "阿朝", "阿超", "阿婵", "阿冰冰", "阿兵"};
        String[] sortedArray = {"阿安", "阿斌", "阿滨", "阿彬", "阿冰", "阿兵", "阿冰冰", "阿婵", "阿超", "阿朝"};

        TimSort tim = new TimSort();
        tim.sort(unsortedArray);
        for(int i = 0; i<unsortedArray.length;i++)
            assertTrue("Mismatch",unsortedArray[i].equals(sortedArray[i]));

    }

    @Test
    public void testRandomSortedElementsChineseSort() throws Exception{
        String[] unsortedArray = { "阿斌", "阿安", "阿彬", "阿滨", "阿冰", "阿朝", "阿超", "阿婵", "阿冰冰", "阿兵"};
        String[] sortedArray = {"阿安", "阿斌", "阿滨", "阿彬", "阿冰", "阿兵", "阿冰冰", "阿婵", "阿超", "阿朝"};

        TimSort tim = new TimSort();
        tim.sort(unsortedArray);
        for(int i = 0; i<unsortedArray.length;i++)
            assertTrue("Mismatch",unsortedArray[i].equals(sortedArray[i]));

    }

}