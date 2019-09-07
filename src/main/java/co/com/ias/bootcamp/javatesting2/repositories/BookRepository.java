package co.com.ias.bootcamp.javatesting2.repositories;

import co.com.ias.bootcamp.javatesting2.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookRepository {


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> findAllBooks() {
        return jdbcTemplate.query("SELECT * FROM books", new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet resultSet, int i) throws SQLException {
                String isbn = resultSet.getString("isbn");
                String name = resultSet.getString("name");

                return new Book.Builder(isbn, name).build();
            }
        });
    }
}
