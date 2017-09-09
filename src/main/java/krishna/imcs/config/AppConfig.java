package krishna.imcs.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.annotation.MultipartConfig;

//import javax.servlet.MultipartConfigElement;
//import javax.servlet.annotation.MultipartConfig;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
//import org.springframework.boot.context.embedded.MultipartConfigFactory;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import krishna.imcs.Config.DBConfig;

@Configuration
@SpringBootApplication
@ComponentScan (basePackages = {"krishna.imcs"})
@EnableWebMvc
@EnableAutoConfiguration(exclude={SecurityAutoConfiguration.class})
@Import(DBConfig.class)
@MultipartConfig
public class AppConfig {

	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory multipartConfigFactory = new MultipartConfigFactory();
		multipartConfigFactory.setMaxFileSize("128KB");
		multipartConfigFactory.setMaxRequestSize("128KB");
		return multipartConfigFactory.createMultipartConfig();
	}
}
