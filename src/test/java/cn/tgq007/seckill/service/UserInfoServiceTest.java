package cn.tgq007.seckill.service;

import cn.tgq007.seckill.entity.UserInfo;
import cn.tgq007.seckill.model.UserModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoServiceTest {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    void selectAllUsers() {
        List<UserInfo> userInfoList = userInfoService.list();
        System.out.println(userInfoList);
    }

    @Test
    void getUserInfoByUserId() throws ExecutionException, InterruptedException {
        UserModel userInfoByUserId = userInfoService.getUserInfoByUserId(1);
        System.out.println(userInfoByUserId.getUserName());
    }
}