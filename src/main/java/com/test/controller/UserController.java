package com.test.controller;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.IUserService;
import com.test.User;
import com.test.domain.dto.PageDto;
import com.test.domain.dto.UserFormDTO;
import com.test.domain.dto.UserInfo;
import com.test.domain.dto.UserVO;
import com.test.query.UserQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

     @Api(tags = "用户管理接口")
     @RequiredArgsConstructor
     @RestController
     @RequestMapping("users")
     public class UserController {

         private final IUserService userService;
         @PutMapping("{id}/deduction/{money}")
@ApiOperation("扣减用户余额")
public void deductBalance(@PathVariable("id") Long id, @PathVariable("money")Integer money){
    userService.deductBalance(id, money);
}

         @PostMapping
         @ApiOperation("新增用户")
         public void saveUser(@RequestBody UserFormDTO userFormDTO) {
             try {
                 // 1.转换DTO为PO
                 User user = new User();
                 BeanUtils.copyProperties(user, userFormDTO);
                 // 2.新增
                 userService.save(user);
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }

         @DeleteMapping("/{id}")
         @ApiOperation("删除用户")
         public void removeUserById(@PathVariable("id") Long userId) {
             userService.removeById(userId);
         }

         @GetMapping("/{id}")
         @ApiOperation("根据id查询用户")
         public UserVO queryUserById(@PathVariable("id") Long userId) {
             return userService.queryUserAndAddressById(userId);
         }

         @GetMapping
         @ApiOperation("根据id集合查询用户")
         public List<UserVO> queryUserByIds(@RequestParam("ids") List<Long> ids) {
             // 1.查询用户
             List<User> users = userService.listByIds(ids);
             // 2.处理vo
             List<UserVO> userVOS = new ArrayList<>();
             for (User user : users) {
                 UserVO userVO = new UserVO();
                 try {
                     BeanUtils.copyProperties(userVO, user);
                     userVOS.add(userVO);
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
             }
             return userVOS;
         }
         private User buildUser(int i) {
             User user = new User();
             user.setUsername("user" + i);
             user.setPassword("password" + i);
             user.setPhone("1234567890" + (i % 10));
                     user.setInfo(UserInfo.of(24, "英文老师", "female"));
 user.setBalance(100 + i);
             return user;
         }
           @GetMapping("/batch-insert-100k")
    @ApiOperation("批量插入10万条用户数据")
    public String batchInsertUsers() {
             long b=System.currentTimeMillis();
        List<User> users = new ArrayList<>(1001);
        for (int i = 1; i <= 100000; i++) {
           users.add(buildUser(i));            // 每 1000 条数据插入一次，防止内存溢出
            if ((i ) % 1000 == 0) {
                userService.saveBatch(users);
                users.clear();
            }
        }
        long e=System.currentTimeMillis();
        System.out.println("插入耗时："+(e-b));
        return "成功插入10万条用户数据";
    }
         @ApiOperation("根据分页查询用户")
         @GetMapping("/page")
         public PageDto<UserVO> queryUserByPage(UserQuery userQuery) {
             PageDto<UserVO> pageDto = new PageDto<>();

             try {
                 PageHelper.startPage(userQuery.getPageNo(), userQuery.getPageSize());
                 PageHelper.orderBy(userQuery.getOrderBy());

                 List<User> users = userService.list();
                 PageInfo<User> pageInfo = new PageInfo<>(users);

                 pageDto.setTotal(pageInfo.getTotal());
                 pageDto.setPages(pageInfo.getPages());

                 List<User> records = pageInfo.getList();
                 List<UserVO> userVOS = new ArrayList<>();

                 // 使用BeanUtil.copyProperties直接处理非空记录
                 if (!records.isEmpty()) {
                     userVOS = BeanUtil.copyToList(records, UserVO.class);
                 }

                 pageDto.setList(userVOS);

             } catch (Exception e) {
                 // 处理异常，并可以记录日志或抛出自定义异常
                 //e.printStackTrace();
                 pageDto.setList(Collections.emptyList());
                 pageDto.setTotal(0);
                 pageDto.setPages(0);
             }

             return pageDto;
         }

     }
     