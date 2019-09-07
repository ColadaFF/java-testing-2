package co.com.ias.bootcamp.javatesting2.controllers;

import co.com.ias.bootcamp.javatesting2.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class BookController {

    private final BookRepository repository;

    @Autowired
    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/books")
    public List<Map<String, String>> findAllBooks() {
        return repository.findAllBooks();
    }
}
