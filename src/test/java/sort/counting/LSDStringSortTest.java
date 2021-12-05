package sort.counting;

import junit.framework.TestCase;
import org.junit.Test;
import util.FileUtil;

import static org.junit.Assert.assertTrue;

public class LSDStringSortTest extends TestCase {

    public static String language = FileUtil.getSortLanguage();

    @Test
    public void testRandomElementsSort () throws Exception {

        String[] unsortedArray = null;
        String[] sortedArray = null;
        if (language.equals("TELUGU")) {
            unsortedArray = new String[] {"సాదా", "అమ్మాయి", "సాధారణ", "యువ", "సిద్ధంగా", "పైన", "ఎప్పుడూ", "ఎరుపు", "జాబితా", "అయితే"};
            sortedArray = new String[] {"అమ్మాయి", "అయితే", "ఎప్పుడూ", "ఎరుపు", "జాబితా", "పైన", "యువ", "సాదా", "సాధారణ", "సిద్ధంగా"};
        }
        else{
            unsortedArray = new String[] { "阿斌", "阿安", "阿彬", "阿滨", "阿冰", "阿朝", "阿超", "阿婵", "阿冰冰", "阿兵"};
            sortedArray = new String[] {"阿安", "阿斌", "阿滨", "阿彬", "阿冰", "阿兵", "阿冰冰", "阿婵", "阿超", "阿朝"};

        }
        LSDStringSort lsd = new LSDStringSort();
        lsd.sort(unsortedArray);
        for (int i = 0; i < unsortedArray.length; i++)
            assertTrue("Mismatch", unsortedArray[i].equals(sortedArray[i]));

    }

    @Test
    public void testSortedElementsSort () throws Exception {

        String[] unsortedArray = null;
        String[] sortedArray = null;
        if (language.equals("TELUGU")) {
            unsortedArray = new String[] {"అమ్మాయి", "అయితే", "ఎప్పుడూ", "ఎరుపు", "జాబితా", "పైన", "యువ", "సాదా", "సాధారణ", "సిద్ధంగా"};
            sortedArray = new String[] {"అమ్మాయి", "అయితే", "ఎప్పుడూ", "ఎరుపు", "జాబితా", "పైన", "యువ", "సాదా", "సాధారణ", "సిద్ధంగా"};
        }
        else{
            unsortedArray = new String[] { "阿安", "阿斌", "阿滨", "阿彬", "阿冰", "阿兵", "阿冰冰", "阿婵", "阿超", "阿朝"};
            sortedArray = new String[] {"阿安", "阿斌", "阿滨", "阿彬", "阿冰", "阿兵", "阿冰冰", "阿婵", "阿超", "阿朝"};

        }

        LSDStringSort lsd = new LSDStringSort();
        lsd.sort(unsortedArray);
        for (int i = 0; i < unsortedArray.length; i++)
            assertTrue("Mismatch", unsortedArray[i].equals(sortedArray[i]));

    }

    @Test
    public void testPartialSortedElementsSort () throws Exception {

        String[] unsortedArray = null;
        String[] sortedArray = null;
        if (language.equals("TELUGU")) {
            unsortedArray = new String[] {"అమ్మాయి", "అయితే", "ఎప్పుడూ", "ఎరుపు", "జాబితా", "సిద్ధంగా", "యువ", "పైన", "సాధారణ", "సాదా"};
            sortedArray = new String[] {"అమ్మాయి", "అయితే", "ఎప్పుడూ", "ఎరుపు", "జాబితా", "పైన", "యువ", "సాదా", "సాధారణ", "సిద్ధంగా"};
        }
        else{
            unsortedArray = new String[] { "阿安", "阿斌", "阿滨", "阿彬", "阿冰", "阿朝", "阿超", "阿婵", "阿冰冰", "阿兵"};
            sortedArray = new String[] {"阿安", "阿斌", "阿滨", "阿彬", "阿冰", "阿兵", "阿冰冰", "阿婵", "阿超", "阿朝"};

        }

        LSDStringSort lsd = new LSDStringSort();
        lsd.sort(unsortedArray);
        for (int i = 0; i < unsortedArray.length; i++)
            assertTrue("Mismatch", unsortedArray[i].equals(sortedArray[i]));

    }

    @Test
    public void testReverseSortedElementsSort () throws Exception {

        String[] unsortedArray = null;
        String[] sortedArray = null;
        if (language.equals("TELUGU")) {
            unsortedArray = new String[] {"సిద్ధంగా", "సాధారణ", "సాదా", "యువ", "పైన", "జాబితా", "ఎరుపు", "ఎప్పుడూ", "అయితే", "అమ్మాయి"};
            sortedArray = new String[] {"అమ్మాయి", "అయితే", "ఎప్పుడూ", "ఎరుపు", "జాబితా", "పైన", "యువ", "సాదా", "సాధారణ", "సిద్ధంగా"};
        }
        else{
            unsortedArray = new String[] { "阿朝", "阿超", "阿婵", "阿冰冰", "阿兵", "阿冰", "阿彬", "阿滨", "阿斌", "阿安"};
            sortedArray = new String[] {"阿安", "阿斌", "阿滨", "阿彬", "阿冰", "阿兵", "阿冰冰", "阿婵", "阿超", "阿朝"};

        }

        LSDStringSort lsd = new LSDStringSort();
        lsd.sort(unsortedArray);
        for (int i = 0; i < unsortedArray.length; i++)
            assertTrue("Mismatch", unsortedArray[i].equals(sortedArray[i]));

    }

}