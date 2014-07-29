package config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

public class MyBatisConfig {

    /**
     * myBatis의 {@link org.apache.ibatis.session.SqlSessionFactory}을 생성하는 팩토리빈을 등록한다.
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(
            DataSource dataSource, ApplicationContext applicationContext) throws IOException {

        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();

        // 마이바티스가 사용한 DataSource를 등록
        factoryBean.setDataSource(dataSource);

        // 마이바티스 설정파일 위치 설정
        factoryBean.setConfigLocation(applicationContext.getResource("classpath:META-INF/mybatis/configuration.xml"));

        // spring.examples.model 패키지 이하의 model 클래스 이름을 짧은 별칭으로 등록
        factoryBean.setTypeAliasesPackage("com.test.app.model");

        // META-INF/mybatis/mappers 패키지 이하의 모든 XML을 매퍼로 등록
        factoryBean.setMapperLocations(applicationContext.getResources("classpath:META-INF/mybatis/mappers/**/*.xml"));

        return factoryBean;
    }

    /**
     * 마이바티스 {@link org.apache.ibatis.session.SqlSession} 빈을 등록한다.
     *
     * SqlSessionTemplate은 SqlSession을 구현하고 코드에서 SqlSession를 대체하는 역할을 한다.
     * 쓰레드에 안전하게 작성되었기 때문에 여러 DAO나 매퍼에서 공유 할 수 있다.
     */
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
