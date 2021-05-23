package kodlamaio.northwind.core.utilities.results;


//Islem icin basari ve mesaj bilgileri disinda
	//bir de datanin gonderilmek istendigi result cesidi

public class DataResult<T> extends Result{

	private T data;
	
	public DataResult(T data, boolean success, String message) {
		super(success, message);
		//super, base sınıfın constructor'larını çalıştırmaya yarar	
		this.data = data;
	}

	
	public DataResult(T data, boolean success) {
		super(success);
		this.data = data;
	}

	//GETTER
	public T getData() {
		return this.data;
	}

	
	


	
	
}
