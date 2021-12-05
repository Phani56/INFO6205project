package util;


import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.function.Function;
import java.util.stream.Collectors;

import sort.counting.MSDStringSort;

public class FileUtil {

    final static LazyLogger logger = new LazyLogger(FileUtil.class);

    public enum SortLanguage {
        CHINESE,
        TELUGU
    }

    public static String[] getWordArray(){
        String filePath = ((FileUtil.getSortLanguage().equals(SortLanguage.CHINESE.toString())) ? "/shuffledChinese.txt" : "/shuffledTelugu.txt");
        return getWords(filePath, FileUtil::lineAsList);
    }

    static String[] getWords(final String resource, final Function<String, List<String>> stringListFunction) {
        Class<?> clazz = MSDStringSort.class;
        try {
            final File file = new File(Objects.requireNonNull(clazz.getResource(resource)).toURI());
            return getWordArray(file, stringListFunction, 2);
        } catch (final URISyntaxException | NullPointerException e) {
            logger.info("Cannot find resource: " + resource + "  relative to class: " + clazz);
            return new String[0];
        }
    }

    static String[] getWordArray(final File file, final Function<String, List<String>> stringListFunction, final int minLength) {
        try (final FileReader fr = new FileReader(file)) {
            return getWordList(fr, stringListFunction, minLength).toArray(new String[0]);
        } catch (final IOException e) {
            System.out.println("Cannot open file: " + file);
            return new String[0];
        }
    }

    private static List<String> getWordList(final FileReader fr, final Function<String, List<String>> stringListFunction, final int minLength) {
        final List<String> words = new ArrayList<>();
        for (final Object line : new BufferedReader(fr).lines().toArray())
            words.addAll(stringListFunction.apply((String) line));
        return words.stream().filter(s -> s.length() >= minLength).collect(Collectors.toList());
    }

    static List<String> lineAsList(final String line) {
        final List<String> words = new ArrayList<>();
        words.add(line);
        return words;
    }

    public static String getSortLanguage() {
        return getProperties().getProperty("language");
    }

    public static Properties getProperties() {
        Properties prop = new Properties();
        try {
            InputStream inputStream = FileUtil.class.getClassLoader().getResourceAsStream("config.properties");
            prop.load(inputStream);
        } catch (IOException e) {
            logger.error("Properties file not found");
        }
        return prop;
    }


}
