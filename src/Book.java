
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public record Book(String isbn, String title, String author, int pages) implements Comparable<Book> {
    public int getPages() {
        return pages;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    @Override
    public int compareTo(Book other) {
        // Compara los títulos de los libros en orden alfabético.
        return this.title.compareTo(other.title);
    }


}