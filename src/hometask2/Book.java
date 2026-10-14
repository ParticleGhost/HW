package hometask2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
    private String name;
    private String author;
    private Long datePublished;
    private Long pageCount;

    public Book() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Long datePublished) {
        this.datePublished = datePublished;
    }

    public Long getPageCount() {
        return pageCount;
    }

    public void setPageCount(Long pageCount) {
        this.pageCount = pageCount;
    }

    // Переопределение методов Objects для работы метода distinct()
    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Book book = (Book) object;
        return Objects.equals(name, book.name) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode () {
        return Objects.hash(name, author);
    }

    // Переопределение метода toString для красивого и простого вывода
    @Override
    public String toString () {
        return '"' + name + '"' + ", " + author + ", " + datePublished + "г., " + pageCount + " стр.";
    }
}
