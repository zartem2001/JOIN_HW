package ru.netology.join_hw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final String query;

    public ProductRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        // Считываем содержимое файла query.sql
        this.query = read("query.sql");
    }

    public List<String> getProductName(String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        // Выполняем запрос и возвращаем список строк (product_name)
        return jdbcTemplate.queryForList(query, params, String.class);
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException("Не удалось прочитать файл: " + scriptFileName, e);
        }
    }
}
