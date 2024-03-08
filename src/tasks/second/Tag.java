package tasks.second;

import java.util.Objects;

public class Tag {
    private final String name;
    private final int count;

    public Tag(String name, int count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Tag {" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return count == (tag.count) && name.equals(tag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, count);
    }
}
