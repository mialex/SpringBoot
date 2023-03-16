package com.spring.app.springapp1.botstrap;

import com.spring.app.springapp1.model.Author;
import com.spring.app.springapp1.model.Book;
import com.spring.app.springapp1.model.Publisher;
import com.spring.app.springapp1.repository.AuthorRepository;
import com.spring.app.springapp1.repository.BookRepository;
import com.spring.app.springapp1.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(
            AuthorRepository authorRepository,
            BookRepository bookRepository,
            PublisherRepository publisherRepository
    ) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // --- Create One --------------------------------

        Author authorOne = addAuthor("OneAuthor", "Evans");
        Book bookOne = addBook("OneBook Title", "123-321");
        Publisher publisherOne = addPublisher("OnePublisher", "Tampa");

        Author authorOneSaved = authorRepository.save(authorOne);
        Book bookOneSaved = bookRepository.save(bookOne);
        Publisher publisherOneSaved = publisherRepository.save(publisherOne);

        // --- Create Two --------------------------------

        Author authorTwo = addAuthor("TwoAuthor", "Johnson");
        Book bookTwo = addBook("TwoBook Title", "098-890");

        Author authorTwoSaved = authorRepository.save(authorTwo);
        Book bookTwoSaved = bookRepository.save(bookTwo);

        // --- Create Three --------------------------------

        Author authorThree = addAuthor("ThreeAuthor", "Cernel");
        Book bookThree = addBook("ThreeBook Title", "234-432");
        Publisher publisherThree = addPublisher("ThreePublisher", "Bradenton");

        Author authorThreeSaved = authorRepository.save(authorThree);
        Book bookThreeSaved = bookRepository.save(bookThree);
        Publisher publisherThreeSaved = publisherRepository.save(publisherThree);

        // --- Save --------------------------------

        authorOneSaved.getBooks().add(bookOneSaved);
        authorTwoSaved.getBooks().add(bookTwoSaved);
        authorThreeSaved.getBooks().add(bookThreeSaved);

        bookOneSaved.getAuthors().add(authorOneSaved);
        bookTwoSaved.getAuthors().add(authorTwoSaved);
        bookThreeSaved.getAuthors().add(authorThreeSaved);

        authorRepository.save(authorOneSaved);
        authorRepository.save(authorTwoSaved);
        authorRepository.save(authorThreeSaved);

        bookOneSaved.setPublisher(publisherOneSaved);
        bookTwoSaved.setPublisher(publisherOneSaved);
        bookThreeSaved.setPublisher(publisherThreeSaved);

        bookRepository.save(bookOneSaved);
        bookRepository.save(bookTwoSaved);
        bookRepository.save(bookThreeSaved);

        // =========


        // NOT WORKING!!!!
//        publisherThreeSaved.getBooks().add(bookThreeSaved);
//        publisherRepository.save(publisherThreeSaved);

        // --- Show details --------------------------------

        System.out.println("In Bootstrap");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
        System.out.println("Publisher count: " + publisherRepository.count());

        System.out.println("Publisher One books count: " + publisherOneSaved.getBooks().size());
        System.out.println("Publisher Two books count: " + publisherThreeSaved.getBooks().size());


    }

    private Author addAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        return author;
    }

    private Book addBook(String title, String isbn) {
        Book book = new Book();
        book.setTitle(title);
        book.setIsbn(isbn);

        return book;
    }

    private Publisher addPublisher(String name, String city) {
        Publisher publisher = new Publisher();
        publisher.setName(name);
        publisher.setCity(city);
        publisher.setAddress("How street 10");
        publisher.setState("Florida");
        publisher.setZip("34787");

        return publisher;
    }
}
