package kodlamaio.northwind.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T>{

	public SuccessDataResult(T data, String message) {
		super(data, true, message);
	}

	//mesaj dondurmek istemedigimizde
	public SuccessDataResult(T data) {
		super(data, true);
	}
	
	//data dondurmek istemedigimizde
	public SuccessDataResult(String message) {
		super(null, true, message);
	}

	
	//data ve mesaj vermeden
	public SuccessDataResult() {
		super(null, true);
	}

	
	
	

	
}
