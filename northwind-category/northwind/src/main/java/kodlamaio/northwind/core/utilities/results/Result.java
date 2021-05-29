package kodlamaio.northwind.core.utilities.results;

//Gelen datanin basarili ya da hatali olduguyla ilgili bilgi verilmeli
//Datayla birlikte basari bilgisi ve ne oldugu
//ya da neden basarisiz oldugu bilgisini vermemiz gerekir

//Data zorunlu degil ama "islem sonucu" ve "mesaj bilgisi" zorunludur

public class Result { //super type- soyut gorev gorur
	//super type oldugu icin ciplak kalmis
	//interface gibi gorev gorur fakat kendi basina da anlami var

	private boolean success;
	private String message;
	
	
	//mesaj dondurmek istemeyebiliriz
	public Result(boolean success) {
		this.success = success;	
	}
	
	
	public Result(boolean success, String message) {
		this(success); //this demek, su anki mevcut class demek
		//Tek parametreli olan constructor'i cagirmis oluruz
		this.message = message;
	}
	
	//GETTERS
	public boolean isSucces() {
		return this.success;
	}
	
	
	public String getMessage() {
		return this.message;
	}
	
}
