package com.Books;

import com.Books.entity.pojo.SpBook;
import com.Books.mapper.SpBookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BooksTest {
    @Autowired
    private SpBookMapper spBookMapper;

    @Test
    public void test() {
        SpBook spBook = spBookMapper.selectById(1L);
        System.out.println(spBook);
    }
    @Test
    void addBook(){
        SpBook spBook = new SpBook();
        spBook.setName("java");
        spBook.setType("java");
        spBook.setDescription("java");
        spBookMapper.insert(spBook);
    }
    @Test
    void updateBook(){
        SpBook spBook = new SpBook();
        spBook.setName("java");
        spBook.setType("java");
        spBook.setDescription("java");
        spBook.setId(1);
        spBookMapper.updateById(spBook);
    }

}
