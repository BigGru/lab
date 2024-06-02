
import java.util.List;
import java.util.Scanner;

public class Main {
    private static BookManager bookManager = new BookManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("[1] Add book");
            System.out.println("[2] Remove book");
            System.out.println("[3] Update book");
            System.out.println("[4] List books");
            System.out.println("[5] Exit");
            System.out.print("Wybierz opcje: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    removeBook(scanner);
                    break;
                case 3:
                    updateBook(scanner);
                    break;
                case 4:
                    listBooks();
                    break;
                case 5:
                    System.out.println("Wyłączanie...");
                    return;
                default:
                    System.out.println("Niepoprawne działanie, spróbuj jeszcze raz.");
            }
        }
    }

    private static void addBook(Scanner scanner) {
        System.out.print("Wprowadź tytuł: ");
        String title = scanner.nextLine();
        System.out.print("Wprowadź Autora: ");
        String author = scanner.nextLine();
        System.out.print("Wprowadź ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Wprowadź Rok wydania: ");
        int year = scanner.nextInt();
        scanner.nextLine(); 

        Book book = new Book(title, author, isbn, year);
        bookManager.addBook(book);
        System.out.println("Książka została dodana");
    }

    private static void removeBook(Scanner scanner) {
        System.out.print("Wprowadź tytuł książki do usunięcia: ");
        String title = scanner.nextLine();
        Book bookToRemove = findBookByTitle(title);
        if (bookToRemove != null) {
            bookManager.removeBook(bookToRemove);
            System.out.println("Książka została usunięta");
        } else {
            System.out.println("Nie znaleziono takiej książki.");
        }
    }

    private static void updateBook(Scanner scanner) {
        System.out.print("Wprowadź tytuł aktualizowanej książki: ");
        String title = scanner.nextLine();
        Book oldBook = findBookByTitle(title);
        if (oldBook != null) {
            System.out.print("Wprowadź nowy tytuł: ");
            String newTitle = scanner.nextLine();
            System.out.print("Wprowadź nowego autora: ");
            String newAuthor = scanner.nextLine();
            System.out.print("Wprowadź nowy ISBN: ");
            String newIsbn = scanner.nextLine();
            System.out.print("Wprowadź nowy rok wydania: ");
            int newYear = scanner.nextInt();
            scanner.nextLine(); 

            Book newBook = new Book(newTitle, newAuthor, newIsbn, newYear);
            bookManager.updateBook(oldBook, newBook);
            System.out.println("Książka została zaktualizowana");
        } else {
            System.out.println("Książki nie znaleziono.");
        }
    }

    private static void listBooks() {
        List<Book> books = bookManager.getBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private static Book findBookByTitle(String title) {
        for (Book book : bookManager.getBooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}
