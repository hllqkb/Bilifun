package com.Books.service;


import com.Books.entity.pojo.SpBook;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 书籍表 服务类
 * </p>
 *
 * @author hllqk
 * @since 2024-11-30
 */
public interface ISpBookService extends IService<SpBook> {

    void updateType(Integer id, String type);
}
