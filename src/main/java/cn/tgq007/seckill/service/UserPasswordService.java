package cn.tgq007.seckill.service;

import cn.tgq007.seckill.entity.UserPassword;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cloud
 * @since 2021-08-28
 */
public interface UserPasswordService extends IService<UserPassword> {

    /* 根据用户名查询用户的密码信息 */
    UserPassword getUserPasswordByUserId(Integer userId);
}
