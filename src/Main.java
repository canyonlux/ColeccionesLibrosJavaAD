import java.util.*;

public class Main {
    public static void main(String[] args) {
        BookCollection miLista = new BookCollection();
        List<Book> bookList = new ArrayList<>();
        miLista.addBook(new Book("9788422616337", "El Señor de los Anillos", "J.R.R. Tolkien", 800));
        miLista.addBook(new Book("9788445077528", "El Hobbit", "J.R.R. Tolkien", 350));
        miLista.addBook(new Book("9788466316781", "Cabo Trafalgar", "Arturo Pérez Reverte", 320));
        miLista.addBook(new Book("9788493975074", "El corazón de la piedra", "José María García López", 560));
        miLista.addBook(new Book("9788493291488", "Salmos de vísperas", "Esteban Hernández Castelló", 95));
        miLista.addBook(new Book("9788420685625", "La música en las catedrales españolas del Siglo de Oro", "Robert Stevenson", 600));
        miLista.addBook(new Book("9788423913077", "Luces de bohemia", "Ramón del Valle-Inclán", 296));
        miLista.addBook(new Book("9788448031121", "Contando atardeceres", "La vecina rubia", 528));
        miLista.addBook(new Book("9781529342079", "The Master: The Brilliant Career of Roger Federer", "Christopher Clarey", 456));
        miLista.addBook(new Book("9788408264385", "La teoría de los archipiélagos", "Alice Kellen", 300));
        miLista.addBook(new Book("9788423362479", "Esperando al diluvio", "Dolores Redondo", 576));
        miLista.addBook(new Book("9788466367349", "El italiano", "Arturo Pérez Reverte", 400));
        miLista.addBook(new Book("9788466359290", "Línea de fuego", "Arturo Pérez Reverte", 688));

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. Ordena los libros");
            System.out.println("2. Obtener cantidad de libros con más de 500 páginas");
            System.out.println("3. Obtener cantidad de libros con menos de 300 páginas");
            System.out.println("4. Obtener títulos de libros con más de 500 páginas");
            System.out.println("5. Obtener títulos de los tres libros con más páginas");
            System.out.println("6. Obtener suma total de páginas de todos los libros");
            System.out.println("7. Obtener autores sin repetir");
            System.out.println("8. Obtener autores con más de un libro");
            System.out.println("9. Obtener libro con más páginas");
            System.out.println("10. Obtener todos los títulos de los libros");
            System.out.println("0. Salir");

            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Ordena la colección de libros por título.
                    Collections.sort(miLista.getBooks());

                    // Imprime la lista ordenada.
                    for (Book book : miLista.getBooks()) {
                        System.out.println(book.getTitle());
                    }
                    break;
                case 2:
                    // Obtener cantidad de libros con más de 500 páginas
                    int cantidadLibrosMas500Paginas = miLista.countBooksGreaterThan500Pages();
                    System.out.println("Cantidad de libros con más de 500 páginas: " + cantidadLibrosMas500Paginas);
                    break;
                case 3:
                    // Obtener cantidad de libros con menos de 300 páginas
                    int cantidadLibrosMenos300Paginas = miLista.countBooksLessThan300Pages();
                    System.out.println("Cantidad de libros con menos de 300 páginas: " + cantidadLibrosMenos300Paginas);
                    break;
                case 4:
                    // Obtener títulos de libros con más de 500 páginas
                    List<String> titulosLibrosMas500Paginas = miLista.getTitlesOfBooksGreaterThan500Pages();
                    System.out.println("Títulos de libros con más de 500 páginas:");
                    for (String titulo : titulosLibrosMas500Paginas) {
                        System.out.println(titulo);
                    }
                    break;
                case 5:
                    List<String> titulosTop3LibrosPorPaginas = miLista.getTitlesOfTop3BooksByPages();

                    // Imprime los títulos
                    for (String titulo : titulosTop3LibrosPorPaginas) {
                        System.out.println("Título: " + titulo);
                    }
                    break;
                case 6:
                    // Obtener suma total de páginas de todos los libros
                    int sumaTotalPaginas = miLista.getTotalPages();
                    System.out.println("Suma total de páginas de todos los libros: " + sumaTotalPaginas);
                    break;
                case 7:
                    Set<String> autoresUnicos = miLista.getUniqueAuthors();

                    // Imprime los autores únicos
                    for (String autor : autoresUnicos) {
                        System.out.println("Autor: " + autor);
                    }
                    break;
                case 8:
                    List<String> autoresConMultiplesLibros = miLista.getAuthorsWithMultipleBooks();

                    // Imprime los autores con más de un libro
                    for (String autor : autoresConMultiplesLibros) {
                        System.out.println("Autor con múltiples libros: " + autor);
                    }
                    break;
                case 9:
                    // Obtener libro con más páginas
                    Book libroConMasPaginas = miLista.getBookWithMostPages();
                    if (libroConMasPaginas != null) {
                        System.out.println("Libro con más páginas: " + libroConMasPaginas.getTitle());
                    } else {
                        System.out.println("No hay libros en la colección.");
                    }
                    break;
                case 10:
                    // Obtener todos los títulos de los libros
                    List<String> todosLosTitulos = miLista.getAllTitles();
                    System.out.println("Todos los títulos de los libros:");
                    for (String titulo : todosLosTitulos) {
                        System.out.println(titulo);
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }

        } while (opcion != 0);

        scanner.close();
    }
}
