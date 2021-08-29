package cn.tgq007.seckill.service;

import cn.tgq007.seckill.entity.UserInfo;
import cn.tgq007.seckill.model.UserModel;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.concurrent.ExecutionException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cloud
 * @since 2021-08-28
 */
public interface UserInfoService extends IService<UserInfo> {

    UserModel getUserInfoByUserId(Integer userId)  throws ExecutionException, InterruptedException;

    boolean registerUser(UserModel userModel, String code);
}
