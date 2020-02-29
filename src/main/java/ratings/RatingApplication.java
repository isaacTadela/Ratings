package ratings;

import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class RatingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select().apis(RequestHandlerSelectors.basePackage("ratings"))
				.build().apiInfo(apiDettails());
	}
	
	private ApiInfo apiDettails() {
		return new ApiInfo(
				"Rating  API",
				"The Rating API...",
				"1.0",
				"I would like to receive your feedback",
				new springfox.documentation.service.Contact("Itzhak Tadela", "https://github.com/isaacTadela" , "iitzhakk@gmail.com"),
				"API License",
				"https://github.com/isaacTadela",
				Collections.emptyList()
				);
	}
	
}
