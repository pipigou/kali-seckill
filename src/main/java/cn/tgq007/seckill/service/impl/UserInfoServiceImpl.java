package cn.tgq007.seckill.service.impl;

import cn.tgq007.seckill.entity.ServiceCode;
import cn.tgq007.seckill.entity.UserInfo;
import cn.tgq007.seckill.entity.UserPassword;
import cn.tgq007.seckill.exception.ExceptionCast;
import cn.tgq007.seckill.mapper.UserInfoMapper;
import cn.tgq007.seckill.model.UserModel;
import cn.tgq007.seckill.service.UserInfoService;
import cn.tgq007.seckill.service.UserPasswordService;
import cn.tgq007.seckill.utils.MD5Util;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Value("${salt.length}")
    private Integer saltLength;

    private static final int DEFAULT_SALT_LENGTH = 6;

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

    @Transactional
    @Override
    public boolean registerUser(UserModel userModel, String code) {
        if (!StringUtils.equals(userModel.getOtpCode(), code))
            ExceptionCast.cast(ServiceCode.VERIFICATION_CODE_ERROR);
        if (isUserNameOrTelephoneHasBeenRegister(userModel.getUserName(), userModel.getTelephone()))
            ExceptionCast.cast(ServiceCode.HAS_BEEN_REGISTER);
        UserInfo userInfo = new UserInfo();
        UserPassword userPassword = new UserPassword();
        BeanUtils.copyProperties(userModel, userInfo);
        userInfoMapper.insert(userInfo);
        String salt = MD5Util.getSalt(saltLength < DEFAULT_SALT_LENGTH ? DEFAULT_SALT_LENGTH : saltLength);
        String password = MD5Util.encoderPassword(userModel.getEncrptPassword(), salt);
        userPassword.setUserId(userInfo.getId());
        userPassword.setSalt(salt);
        userPassword.setEncrptPassword(password);
        userPasswordService.save(userPassword);
        return true;
    }

    private boolean isUserNameOrTelephoneHasBeenRegister(String userName, String telephone) {
        Integer status = userInfoMapper.selectUserInfoCountByUserNameAndTelephone(userName, telephone);
        return status != null;
    }

}
