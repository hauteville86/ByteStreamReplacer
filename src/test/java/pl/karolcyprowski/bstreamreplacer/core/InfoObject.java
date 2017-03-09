package pl.karolcyprowski.bstreamreplacer.core;

public class InfoObject {

	private int counter;

	private String path;
	
	private boolean processed;

	public InfoObject(int counter, String path, boolean processed){
		this.counter = counter;
		this.path = path;
		this.processed = processed;
	}

	public int getCounter(){
		return counter;
	}

	public void setCounter(int counter){
		this.counter = counter;
	}

	public String getPath(){
		return path;
	}

	public void setPath(String path){
		this.path = path;
	}
	
	public String getPolishNameForChanges()
	{
		if(counter == 1)
		{
			return "zmiana";
		}
		int restFromDivision = counter % 10;
		if(restFromDivision >= 2 && restFromDivision <= 4)
		{
			return "zmiany";
		}
		else
		{
			return "zmian";
		}
	}

	public boolean isProcessed() {
		return processed;
	}

	public void setProcessed(boolean processed) {
		this.processed = processed;
	}
	
}