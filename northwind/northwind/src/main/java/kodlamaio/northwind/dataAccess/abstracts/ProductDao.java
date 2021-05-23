package kodlamaio.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.concretes.Product;

//interface, interface'i extend eder
//JpaRepository <'Entity' annotation ile suslenmis nesne icin, primary veri turu>
//JpaRepository<Hangi tablo için çalışacak, oradaki primary veri türü nedir> 
public interface ProductDao extends JpaRepository<Product,Integer >{
	//CRUD - veritabanindan veri cekme islemleri yapmayi saglar
	
}
