package co.com.ias.bootcamp.javatesting2.domain;

import org.apache.commons.lang3.Validate;

import java.time.LocalDateTime;

public class Book {
    public static class Builder {
        private final String isbn;
        private final String name;
        private LocalDateTime lastOrderDate;

        public Builder(String isbn, String name) {
            this.isbn = isbn;
            this.name = name;
        }

        public Builder withLastOrderDate(LocalDateTime lastOrderDate) {
            this.lastOrderDate = Validate.notNull(lastOrderDate);
            return this;
        }


        public Book build() {
            return new Book(isbn, name, lastOrderDate);
        }
    }


    private final String isbn;
    private final String name;
    private final LocalDateTime lastOrderDate;

    private Book(String isbn, String name, LocalDateTime lastOrderDate) {
        this.isbn = Validate.notNull(isbn);
        this.name = Validate.notNull(name);
        this.lastOrderDate = lastOrderDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getLastOrderDate() {
        return lastOrderDate;
    }
}
