package cn.tgq007.seckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.tgq007.seckill.mapper")
@SpringBootApplication
public class KaliSeckillApplication {

    public static void main(String[] args) {
        SpringApplication.run(KaliSeckillApplication.class, args);
    }

}
