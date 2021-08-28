package cn.tgq007.seckill.mapper;

import cn.tgq007.seckill.entity.UserPassword;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cloud
 * @since 2021-08-28
 */
@Mapper
public interface UserPasswordMapper extends BaseMapper<UserPassword> {

    UserPassword selectUserPasswordByUserId(@Param("userId") Integer userId);
}
