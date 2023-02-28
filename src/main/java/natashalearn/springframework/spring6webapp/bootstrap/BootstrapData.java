package natashalearn.springframework.spring6webapp.bootstrap;

import natashalearn.springframework.spring6webapp.domain.Author;
import natashalearn.springframework.spring6webapp.domain.Book;
import natashalearn.springframework.spring6webapp.domain.Publisher;
import natashalearn.springframework.spring6webapp.repositories.AuthorRepository;
import natashalearn.springframework.spring6webapp.repositories.BookRepository;
import natashalearn.springframework.spring6webapp.repositories.PublisherRepository;
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
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Eric");
        rod.setLastName("Evans");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("56757585");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());

        Publisher publisher = new Publisher();
        publisher.setPublisherName("Publisher Name");
        publisher.setAddress("Jl. MH Thamrin");
        publisher.setCity("Jakarta");
        publisher.setState("DKI Jakarta");
        publisher.setZip("15001");

        Publisher publisherSaved = publisherRepository.save(publisher);
        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}
