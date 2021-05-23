package kodlamaio.northwind.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;

//Controller, dış dünya ile sistemin iletişim kurduğu yer
//birden fazla controller olabilir

@RestController 					//Java olmayanlar da tanısın diye
@RequestMapping("/api/products")	//domain
public class ProductsController {
	
	private ProductService productService;
	
	@Autowired	//dependency injection yapilir
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	//autowired kullanmasaydık newlemek zorunda kalacaktık

	@GetMapping("/getall")
	public DataResult<List<Product>> getAll(){
		return this.productService.getAll();
	}
	
	//Veriyi ekleme
	//Post islemlerinde parametre alinirsa @RequestBody eklenir
	//Requestbody: hem istek yapar hem datayi verir
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);
	}


//Endpoint: istek yapilan yer
}
