package kodlamaio.northwind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2 //Swagger'i baslatan annotation
public class NorthwindApplication {

	public static void main(String[] args) {
		SpringApplication.run(NorthwindApplication.class, args);
	
	
	}

	//Bean: class demektir, genelde configuration amacli kullanilir
	//uygulama basladigi anda bean goruldugunde bellege yerlestirir, 
	//o da docket denilen nesne ile controller'lardaki requestHandler'leri bulur
	//dokumantasyon haline getiriyor
	//butun apileri bulup tarar, onlari yayinlanabilir bir hale getirir
	@Bean 					
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("kodlamaio.northwind"))
          .build();                                           
    }
}
