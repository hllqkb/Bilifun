package com.test.service.impl;

import com.test.domain.dto.Address;
import com.test.mapper.AddressMapper;
import com.test.service.IAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hllqk
 * @since 2024-12-01
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements IAddressService {

}
