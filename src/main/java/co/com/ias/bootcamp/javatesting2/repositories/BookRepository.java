package co.com.ias.bootcamp.javatesting2.repositories;

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

    public List<Map<String, String>> findAllBooks() {
        return jdbcTemplate.query("SELECT * FROM books", new RowMapper<Map<String, String>>() {
            @Override
            public Map<String, String> mapRow(ResultSet resultSet, int i) throws SQLException {
                String isbn = resultSet.getString("isbn");
                String name = resultSet.getString("name");
                Map<String, String> map = new HashMap<>();
                map.put("isbn", isbn);
                map.put("name", name);
                return map;
            }
        });
    }
}
