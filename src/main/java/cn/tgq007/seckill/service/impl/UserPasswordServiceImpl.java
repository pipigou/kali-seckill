package cn.tgq007.seckill.service.impl;

import cn.tgq007.seckill.entity.UserPassword;
import cn.tgq007.seckill.mapper.UserPasswordMapper;
import cn.tgq007.seckill.service.UserPasswordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cloud
 * @since 2021-08-28
 */
@Service
public class UserPasswordServiceImpl extends ServiceImpl<UserPasswordMapper, UserPassword> implements UserPasswordService {

    @Autowired
    private UserPasswordMapper userPasswordMapper;

    @Override
    public UserPassword getUserPasswordByUserId(Integer userId) {
        return userPasswordMapper.selectUserPasswordByUserId(userId);
    }
}
