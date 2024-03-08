package tasks.second;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LastMoreUsedHashes {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("sdfsd #123 sdf qqe #456 #123");
        list.add("sdfsd #321 sdf qqe #213 #05321");
        list.add("sdfsd #427 sdf qqe #976 #123");
        list.add("sdfsd #455 sdf qqe #976 #976");
        list.add("asd #123 asdasd #456");
        list.add("asd #123 asdasd #456");
        list.add("asd #123 asdasd #456");

        System.out.println(getLastMoreUsedHashes(list).toArray());
    }
    public static List<Tag> getLastMoreUsedHashes (List<String> list) {
        if (list == null) {
            return new ArrayList<>();
        }

        List<Tag> tags = new ArrayList<>();

        HashMap<String, Integer> hastTagsFromList = getHastTagsFromStrings(list);
        sortHashMapWithInt(hastTagsFromList)
                .subList(0, 5)
                .forEach((pair) -> tags.add(new Tag(pair.getKey(), pair.getValue())));

        return tags;
    }

    private static List<Map.Entry<String, Integer>> sortHashMapWithInt(HashMap<String, Integer> hashMap) {
        // Comparator to sort the HashMap
        Comparator<Map.Entry<String, Integer>> valueComparator =
                (entry1, entry2) -> Integer.compare(entry2.getValue(), entry1.getValue());

        // Sort the HashMap
        List<Map.Entry<String, Integer>> sortedHashList = new ArrayList<>(hashMap.entrySet());
        sortedHashList.sort(valueComparator);

        return sortedHashList;
    }

    private static HashMap<String, Integer> getHastTagsFromStrings(List<String> strings) {
        // Create regex to find substring what starts from # and end if it is space symbol
        Pattern compiledRegex = Pattern.compile("#+[a-zA-Z0-9(_)]+");

        // Create HashMap to set name of hash as a key and count of use as a value
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String str : strings) {
            Matcher matcher = compiledRegex.matcher(str);
            Set<String> hashNames = new HashSet<>();

            while (matcher.find()) {
                String substring = matcher.group();

                hashNames.add(substring.trim());
            }

            hashNames.forEach((key) -> {
                int newValue = hashMap.getOrDefault(key, 0) + 1;

                hashMap.put(key, newValue);
            });
        }

        return hashMap;
    }
}
