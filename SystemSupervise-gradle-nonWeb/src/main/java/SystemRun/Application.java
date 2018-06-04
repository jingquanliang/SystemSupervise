package SystemRun;

import dao.bean.User;
import dao.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
//import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("dao.*")
@ComponentScan(basePackages={"controller","Interceptor"})
//@ComponentScan(basePackages={"cn.kfit","org.kfit"})
public class Application   implements CommandLineRunner {

    private final static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder builder) {
//        return builder.build();
//    }

    @Autowired
    private UserMapper userMapper;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作<<<<<<<<<<<<<");
        logger.info("+++==+++++++++++++++++++++userMapper:"+userMapper);
        User user = new User("test",28);
        Integer flag = userMapper.addUser(user);
        logger.info("flag:"+flag);
    }
}