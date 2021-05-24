package kodlamaio.northwind.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T> {
	public ErrorDataResult(T data, String message) {
		super(data, false, message);
	}

	//mesaj döndürmek istemediğimizde
	//error olmasına rağmen data gönderiyoruz
	public ErrorDataResult(T data) {
		super(data, false);
	}
	
	//data döndürmek istemediğimizde
	public ErrorDataResult(String message) {
		super(null, false, message);
	}

	
	//data ve mesaj vermeden
	public ErrorDataResult() {
		super(null, false);
	}
}
