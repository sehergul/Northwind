package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;

@Service //business gorevini gorecek katman icin kullanilir
public class ProductManager implements ProductService {

	/*  @Autowired bunun ustune de yazilabilirdi
	fakat birden fazla dependency injection olabilecegi icin
	constructor icine yazilir */	
	private ProductDao productDao;
	
	//autowired: injection yapar- karşılığı olan sınıfı bulup enjekte ediyor
	@Autowired 
	public ProductManager(ProductDao productDao) { //Constructor injection
		super();
		this.productDao = productDao;
		
		//interface'ler newlenemez
		//ama autowired gidiyor, ProductDao'nun somut sinifini arayip buluyor
		//ve onu newleyip bize veriyor
	}

	
	@Override
	public DataResult<List<Product>> getAll() {
		return new SuccessDataResult<List<Product>>
			(this.productDao.findAll(), "Data listelendi!");
		//SuccessDataResult- bir entity'nin donusunu anlatir
		//Entity'nin newlenmesinde bir sakinca yoktur

	}


	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessDataResult("Ürün eklendi");
	}
	
	
}
