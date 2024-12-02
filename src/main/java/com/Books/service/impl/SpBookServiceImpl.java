package com.Books.service.impl;


import com.Books.entity.pojo.SpBook;
import com.Books.mapper.SpBookMapper;
import com.Books.service.ISpBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 书籍表 服务实现类
 * </p>
 *
 * @author hllqk
 * @since 2024-11-30
 */
@Service
public class SpBookServiceImpl extends ServiceImpl<SpBookMapper, SpBook> implements ISpBookService {

    @Override
    public void updateType(Integer id, String type) {
        SpBook spBook = this.getById(id);
        if (spBook != null) {

            spBook.setType(type);

        }
        else {
            throw new RuntimeException("书籍不存在");
        }
    }
}
