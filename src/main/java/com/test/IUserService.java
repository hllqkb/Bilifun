package com.test;

import com.baomidou.mybatisplus.extension.service.IService;
import com.test.domain.dto.PageDto;
import com.test.domain.dto.UserVO;
import com.test.query.UserQuery;

public interface IUserService extends IService<User>{
    void deductBalance(Long id, Integer money);

    UserVO queryUserAndAddressById(Long userId);

    PageDto<UserVO> queryUsersPage(UserQuery userQuery);
}