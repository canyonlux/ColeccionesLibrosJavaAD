import java.util.*;

public class BookCollection {
    private List<Book> books =new ArrayList<>();

    public BookCollection() {
        books = new ArrayList<>();
    }


    public List<Book> getBooks() {
        return books;
    }

    //METODO PARA AÑADIR LIBROS
    public void addBook(Book book) {
        books.add(book);
    }

    //METODO LIBROS +500PAGINAS
    public int countBooksGreaterThan500Pages() {
        int count = 0;

        for (Book book : books) {
            if (book.getPages() > 500) {
                count++;
            }
        }

        return count;
    }

    //METODO LIBROS CON MENOS DE 300 PAGINAS
    public int countBooksLessThan300Pages() {
        int count = 0;

        for (Book book : books) {
            if (book.getPages() < 300) {
                count++;
            }
        }

        return count;
    }

    //METODO titulo de todos los libros con mas de 500 paginas
    public List<String> getTitlesOfBooksGreaterThan500Pages() {
        List<String> titles = new ArrayList<>();

        for (Book book : books) {
            if (book.getPages() > 500) {
                titles.add(book.getTitle());
            }
        }

        return titles;
    }

    //METODO  titulo de los 3 libros con mas paginas
    public List<String> getTitlesOfTop3BooksByPages() {
        List<String> titles = new ArrayList<>();

        // Ordena la lista de libros por número de páginas en orden descendente
        books.sort(Comparator.comparingInt(Book::getPages).reversed());

        // Obtiene los títulos de los tres primeros libros
        for (int i = 0; i < Math.min(3, books.size()); i++) {
            titles.add(books.get(i).getTitle());
        }

        return titles;
    }

    //metodo para obtener los libros que superen el promedio en paginas
    public List<Book> getBooksAbovePageAverage() {
        List<Book> aboveAverageBooks = new ArrayList<>();

        if (books.isEmpty()) {
            return aboveAverageBooks; // Retorna una lista vacía si no hay libros en la colección.
        }

        // Calcula el promedio de páginas de todos los libros
        int totalPages = getTotalPages();
        double averagePages = (double) totalPages / books.size();

        // Encuentra los libros que superan el promedio de páginas
        for (Book book : books) {
            if (book.getPages() > averagePages) {
                aboveAverageBooks.add(book);
            }
        }

        return aboveAverageBooks;
    }

    int getTotalPages() {
        int total = 0;
        for (Book book : books) {
            total += book.getPages();
        }
        return total;
    }
    //metodo para obtener autores de libros sin repetir nombres de autorores

    public Set<String> getUniqueAuthors() {
        Set<String> uniqueAuthors = new HashSet<>();

        for (Book book : books) {
            uniqueAuthors.add(book.getAuthor());
        }

        return uniqueAuthors;
    }

    //metodo para obtener los autores con mas de un libro listado
    public List<String> getAuthorsWithMultipleBooks() {
        Map<String, Integer> authorCount = new HashMap<>();

        // Contar la cantidad de libros por autor
        for (Book book : books) {
            String author = book.getAuthor();
            authorCount.put(author, authorCount.getOrDefault(author, 0) + 1);
        }

        // Filtrar autores con más de un libro
        List<String> authorsWithMultipleBooks = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : authorCount.entrySet()) {
            if (entry.getValue() > 1) {
                authorsWithMultipleBooks.add(entry.getKey());
            }
        }

        return authorsWithMultipleBooks;
    }

    //metodo para obtener el libro con mas paginas
    public Book getBookWithMostPages() {
        if (books.isEmpty()) {
            return null; // Retorna null si no hay libros en la colección.
        }

        Book bookWithMostPages = books.get(0); // Inicializa con el primer libro

        for (Book book : books) {
            if (book.getPages() > bookWithMostPages.getPages()) {
                bookWithMostPages = book;
            }
        }

        return bookWithMostPages;
    }

    //metodo para obtener una coleccion con todos los titulos de los libros
    public List<String> getAllTitles() {
        List<String> titles = new ArrayList<>();

        for (Book book : books) {
            titles.add(book.getTitle());
        }

        return titles;
    }
}