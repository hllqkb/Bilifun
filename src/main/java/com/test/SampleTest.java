package com.test;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.test.domain.dto.UserInfo;
import com.test.mapper.AddressMapper;
import com.test.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AddressMapper addressMapper;

    @Test
    void testInsert() {
        User user = new User();
        user.setId(5L);
        user.setUsername("Lucy");
        user.setPassword("123");
        user.setPhone("18688990011");
        user.setBalance(200);
        user.setInfo(UserInfo.of(24, "英文老师", "female"));
        // user.setInfo("{\"age\": 24, \"intro\": \"英文老师\", \"gender\": \"female\"}");
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.insert(user);
    }

    @Test
    void testSelectById() {
        User user = userMapper.selectById(5L);
        System.out.println("user = " + user);
    }

    @Test
    void testSelectByIds() {

        List<User> users = userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L, 4L, 5L));
        users.forEach(System.out::println);
    }

    @Test
    void testUpdateById() {
        User user = new User();
        user.setId(5L);
        user.setBalance(20000);
        userMapper.updateById(user);
    }

    @Test
    void testDelete() {
        userMapper.deleteById(5L);
    }
    @Test
    void pageQuery() {

    }
    @Test
       void testpage() {
           int pageno = 0, pagesize = 5;
           Page<User> page = Page.of(pageno, pagesize);
           OrderItem orderItem = new OrderItem();
           orderItem.setColumn("balance");
           orderItem.setAsc(false); // 设置为降序
           page.addOrder(orderItem);
           OrderItem orderItem2 = new OrderItem();
           orderItem2.setColumn("id");
           orderItem2.setAsc(true);
           page.addOrder(orderItem2);
           Page<User> p=userMapper.selectPage(page,null);
           long total = p.getTotal();
           System.out.println("总记录数：" + total);
           long ps=p.getPages();
           System.out.println("总页数："+ps);
           List<User> records=p.getRecords();
            for (User record : records) {
               System.out.println(record);
           }
       }
}