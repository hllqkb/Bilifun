package com.test.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.test.IUserService;
import com.test.User;
import com.test.domain.dto.Address;
import com.test.domain.dto.PageDto;
import com.test.domain.dto.UserVO;
import com.test.enums.UserStatus;
import com.test.mapper.UserMapper;
import com.test.query.UserQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Override
    public void deductBalance(Long id, Integer money) {
        // 1.查询用户
        User user = getById(id);
        // 2.判断用户状态
        if (user == null || user.getStatus() == UserStatus.FROZEN) {
            throw new RuntimeException("用户状态异常");
        }
        // 3.判断用户余额
        if (user.getBalance() < money) {
            throw new RuntimeException("用户余额不足");
        }
        // 4.扣减余额
        baseMapper.deductMoneyById(id, money);
    }

    @Override
    public UserVO queryUserAndAddressById(Long userId) {
        User user= getById(userId);
        if(user==null || user.getStatus()==UserStatus.FROZEN) throw new RuntimeException("账号不存在");
        List <Address> addresses= Db.lambdaQuery(Address.class).eq(Address::getUserId,userId).list();
        //封装地址VO
        UserVO userVO = BeanUtil.copyProperties(user, UserVO.class);
        if (addresses != null) {
            userVO.setAddressList(addresses);
        }
        return userVO;
    }
@Override
public PageDto<UserVO> queryUsersPage(UserQuery userQuery) {
    String name = userQuery.getName();
    Integer status = userQuery.getStatus();
    // 构建分页条件
    Page<User> pageDto = Page.of(userQuery.getPageNo(), userQuery.getPageSize());
    OrderItem orderItem = new OrderItem();
    orderItem.setColumn(userQuery.getOrderBy());
    orderItem.setAsc(userQuery.getOrder().equals("asc"));
    pageDto.addOrder(orderItem);
    // 查询条件
    Page<User> p = lambdaQuery()
            .like(name != null, User::getUsername, name)
            .eq(status != null, User::getStatus, status)
            .page(pageDto);
    // 分页查询
    // 封装VO
    PageDto<UserVO> pageDto1 = new PageDto<>();
    pageDto1.setTotal(p.getTotal());
    pageDto1.setPages(p.getPages());
    List<User> records = p.getRecords();
    if (records == null || records.isEmpty()) {
        pageDto1.setList(Collections.emptyList());
    } else {
        List<UserVO> userVOS = new ArrayList<>();
        for (User user : records) {
            UserVO userVO = BeanUtil.copyProperties(user, UserVO.class);
            userVOS.add(userVO);
        }
        pageDto1.setList(userVOS);
    }
    return pageDto1;
    // 返回
}

        //返回
    }


