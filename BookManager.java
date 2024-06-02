
import java.util.ArrayList;
import java.util.List;

public class BookManager implements BookOperations {
    private List<Book> books;

    public BookManager() {
        this.books = new ArrayList<>();
              
        books.add(new Book("Władca Pierścieni", "J.R.R. Tolkien", "4587", 1954));
        books.add(new Book("Zabić Drozda", "Harper Lee", "6843", 1960));
        books.add(new Book("Rok 1984", "George Orwell", "4571", 1949));
        books.add(new Book("Duma i Uprzedzenie", "Jane Austen", "7517", 1813));
        books.add(new Book("Wielki Gatsby", "F. Scott Fitzgerald", "2568", 1925));
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void removeBook(Book book) {
        books.remove(book);
    }

    @Override
    public void updateBook(Book oldBook, Book newBook) {
        int index = books.indexOf(oldBook);
        if (index != -1) {
            books.set(index, newBook);
        }
    }

    @Override
    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }
}
