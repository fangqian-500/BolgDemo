package org.example.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("org.example.**.mapper")
//** 表示匹配该层目录以及子目录下的所有目录
@SpringBootApplication(scanBasePackages = {"org.example.**"})
public class BlogApplication {
    public static void main(String[] args)
    {
        SpringApplication.run(BlogApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  博客启动成功   ლ(´ڡ`ლ)ﾞ  \n"
                +"   /  /             |----|        _______  __|__     !!!! \n" +
                "  /  /------/       |----|         / \\    ___|_/_   !!!!!!\n" +
                " /| /   |  /        |----|        /  /|/   /____     !!!! \n" +
                "/ |     |        ------------      / /|\\  /|    |     !!  \n" +
                "  |   / | \\        | \\ |---       / / | \\  |----|         \n" +
                "  |  / .|  \\      /   \\______      / \\|    |____|     **  \n" +
                "                                                          \n" +
                "You're a pig!  [Here's one to send to your close friends.]"
        );
    }
}
