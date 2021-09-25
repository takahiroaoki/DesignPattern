package iterator;

class ExecuteIterator {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf();
        bookShelf.appendBook(new Book("book_1"));
        bookShelf.appendBook(new Book("book_2"));
        bookShelf.appendBook(new Book("book_3"));
        bookShelf.appendBook(new Book("book_4"));
        bookShelf.appendBook(new Book("book_5"));

        Iterator it = bookShelf.iterator();
        while (it.hasNext()) {
            Book book = (Book) it.next();
            System.out.println(book.getName());
        }
    }
}