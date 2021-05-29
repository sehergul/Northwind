package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
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


	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product>
			(this.productDao.getByProductName(productName), "Data listelendi!");
	}


	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<Product>
			(this.productDao.getByProductNameAndCategory_CategoryId(productName, categoryId), "Data listelendi!");
	}


	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>
			(this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId), "Data listelendi!");
	}


	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>
			(this.productDao.getByCategory_CategoryIdIn(categories), "Data listelendi!");
	}


	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>
			(this.productDao.getByProductNameContains(productName), "Data listelendi!");
	}


	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>
			(this.productDao.getByProductNameStartsWith(productName), "Data listelendi!");
	}


	@Override
	public DataResult<List<Product>> getByNameAndCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>
			(this.productDao.getByNameAndCategory_CategoryId(productName, categoryId), "Data listelendi!");
	}


	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		
		return new SuccessDataResult<List<Product>>
			(this.productDao.findAll(pageable).getContent());
	}

	
	//ASC: Kucukten buyuge
	//DESC: Buyukten kucuge
	@Override
	public DataResult<List<Product>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC, "productName");
				
		return new SuccessDataResult<List<Product>>
			(this.productDao.findAll(sort));
	}
	
	
	
	
	//Is kurallari buraya yazilir
	//DataAccess'e yazilmamasinin sebebi
	
	
	

}
