package tasks.second;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LastMoreUsedHashesTest {
    private static final List<String> listTest = new ArrayList<>();
    private static final List<Tag> resultListTest = new ArrayList<>();

    static {
        Collections.addAll(listTest,
                ("sdfsd #123 sdf qqe #456 #123"),
                ("sdfsd #321 sdf qqe #213 #05321"),
                ("sdfsd #427 sdf qqe #976 #123"),
                ("sdfsd #455 sdf qqe #976 #976"),
                ("asd #123 asdasd #456"),
                ("asd #123 asdasd #456"),
                ("asd #123 asdasd #456")
        );

        Collections.addAll(resultListTest,
                new Tag("#123", 5),
                new Tag("#456", 4),
                new Tag("#976", 2),
                new Tag("#213", 1),
                new Tag("#455", 1)
        );
    }

    @Test
    void findThreeHashes() {
        Assertions.assertArrayEquals(resultListTest.toArray(), LastMoreUsedHashes.getLastMoreUsedHashes(listTest).toArray());
    }

    @Test
    void nullTest() {
        Assertions.assertNotNull(LastMoreUsedHashes.getLastMoreUsedHashes(null));
    }
}
