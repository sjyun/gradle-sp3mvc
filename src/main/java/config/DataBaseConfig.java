package config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement

//@MapperScan(basePackages = "spring.examples.module", annotationClass = Mapper)
public class DataBaseConfig {

}
