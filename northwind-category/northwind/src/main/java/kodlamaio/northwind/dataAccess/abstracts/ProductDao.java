package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Product;

//interface, interface'i extend eder
//JpaRepository <'Entity' annotation ile suslenmis nesne icin, primary veri turu>
//JpaRepository<Hangi tablo için çalışacak, oradaki primary veri türü nedir> 
public interface ProductDao extends JpaRepository<Product,Integer >{
	//CRUD - veritabanindan veri cekme islemleri yapmayi saglar
	
	//Yayina alindiginda yazilan metotlarin query'lerini olusturur
	
	Product getByProductName(String productName);
	//getBy goruldugu anda where kosulu olusturuyor
	
	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
	//and operatorlu where kosulu olusturur
	
	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
	//or operatorlu where kosulu olusturur

	List<Product> getByCategory_CategoryIdIn(List<Integer> categories);
	
	List<Product> getByProductNameContains(String productName);

	List<Product> getByProductNameStartsWith(String productName);

	//Query yazilirken veritabanina gore YAZILMAZ, Entity'ye göre yazilir
	//":" (bazi yerlerde "?") parametre demektir
	@Query("From Product where productName =: productName and category.categoryId =: categoryId")
	List<Product> getByNameAndCategory_CategoryId(String productName, int categoryId);

	//select * from products where product_name = 'defter' and category_id = 1 

	
	//select * from products where category_id in (1,2,3,4)
	

}
