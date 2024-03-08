package tasks.third;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Sorted3DFiguresTest {
    public static final List<Shape> actualList = new ArrayList<>();
    public static final List<Shape> resultList = new ArrayList<>();

    static {
        actualList.add(new Cube(7));
        actualList.add(new Sphere(4));
        actualList.add(new Cube(5));
        actualList.add(new Sphere(3));
        actualList.add(new Cylinder(3,3));
        actualList.add(new Cylinder(2,2));
    }

    @Test
    void testNull() {
        Assertions.assertNotNull(Sorted3DFigures.getSortedFiguresByVolume(null));
    }

    @Test
    void testGetSortedFiguresByVolume() {
        boolean isEqual = true;
        List<Shape> testList1 = Sorted3DFigures.getSortedFiguresByVolume(actualList);

        resultList.add(new Cylinder(3,3));
        resultList.add(new Cube(5));
        resultList.add(new Cylinder(2,2));
        resultList.add(new Sphere(4));
        resultList.add(new Cube(7));
        resultList.add(new Sphere(3));

        if (testList1.size() == resultList.size()) {
            for (int i = 0; i < testList1.size(); i++) {
                Shape actualElem = testList1.get(i);
                Shape resultElem = resultList.get(i);

                if (!(actualElem.getClass().equals(resultElem.getClass())) || actualElem.getVolume() != resultElem.getVolume()) {
                    isEqual = false;
                    break;
                }
            }
        } else {
            isEqual = false;
        }

        Assertions.assertTrue(isEqual);
    }
}
