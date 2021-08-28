package cn.tgq007.seckill.service.impl;

import cn.tgq007.seckill.entity.ServiceCode;
import cn.tgq007.seckill.entity.UserInfo;
import cn.tgq007.seckill.entity.UserPassword;
import cn.tgq007.seckill.exception.ExceptionCast;
import cn.tgq007.seckill.mapper.UserInfoMapper;
import cn.tgq007.seckill.model.UserModel;
import cn.tgq007.seckill.service.UserInfoService;
import cn.tgq007.seckill.service.UserPasswordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cloud
 * @since 2021-08-28
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserPasswordService userPasswordService;

    public UserModel getUserInfoByUserId(Integer userId) throws ExecutionException, InterruptedException {
        CompletableFuture<Object> future = CompletableFuture.supplyAsync(() -> {
            UserInfo userInfo = userInfoMapper.selectById(userId);
            if (userInfo == null)
                ExceptionCast.cast(ServiceCode.SERVER_ERROR);
            return userInfo;
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            UserPassword userPassword = userPasswordService.getUserPasswordByUserId(userId);
            if (userPassword == null)
                ExceptionCast.cast(ServiceCode.SERVER_ERROR);
            return userPassword;
        }), (user, password) -> {
            UserModel userModel = new UserModel();
            BeanUtils.copyProperties(user, userModel);
            userModel.setEncrptPassword(password.getEncrptPassword());
            return userModel;
        });
        return (UserModel) future.get();
    }

}
