package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import guru.springframework.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author jk = new Author();
        jk.setFirstName("JK");
        jk.setLastName("Rowling");

        Book hp = new Book();
        hp.setTitle("Harry Potter");
        hp.setIsbn("12341");

        Author jkSaved = authorRepository.save(jk);
        Book hpSaved = bookRepository.save(hp);

        Author rr = new Author();
        jk.setFirstName("Rick");
        jk.setLastName("Riordan");

        Book pj = new Book();
        hp.setTitle("Percy Jackson");
        hp.setIsbn("12342");

        Author rrSaved = authorRepository.save(rr);
        Book pjSaved = bookRepository.save(pj);

        jkSaved.getBooks().add(hp);
        rrSaved.getBooks().add(pj);

        authorRepository.save(jkSaved);
        authorRepository.save(rrSaved);

        Publisher penguin = new Publisher();
        penguin.setPublisherName("Penguin");
        penguin.setAddress("Sector-1");
        penguin.setCity("Lucknow");
        penguin.setState("UP");
        penguin.setZip("226002");

        publisherRepository.save(penguin);

        System.out.println("In Bootstrap...");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count : " + bookRepository.count());
        System.out.println("Publisher count : " + publisherRepository.count());
    }
}
