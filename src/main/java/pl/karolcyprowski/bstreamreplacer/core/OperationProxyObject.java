package pl.karolcyprowski.bstreamreplacer.core;

import java.io.File;

public class OperationProxyObject {

	private String path;
	
	private File fileA;
	
	private File fileB;
	
	private String inputByHandA;
	
	private String inputByHandB;
	
	private int[] numericA;
	
	private int[] numericB;
	
	private String extension;
	
	public OperationProxyObject(){
		
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public File getFileA() {
		return fileA;
	}

	public void setFileA(String fileA) {
		this.fileA = new File(fileA);
	}

	public File getFileB() {
		return fileB;
	}

	public void setFileB(String fileB) {
		this.fileB = new File(fileB);
	}

	public String getInputByHandA() {
		return inputByHandA;
	}

	public void setInputByHandA(String inputByHandA) {
		this.inputByHandA = inputByHandA;
	}

	public String getInputByHandB() {
		return inputByHandB;
	}

	public void setInputByHandB(String inputByHandB) {
		this.inputByHandB = inputByHandB;
	}
	
	public boolean isInputFromFile()
	{
		return(fileA != null && fileB != null);

	}
	
	public boolean isInputByHand()
	{
		return (inputByHandA != null && inputByHandB != null);
	}
	
	public boolean isNumericInput()
	{
		return(numericA != null && numericB != null);
	}

	public int[] getNumericA() {
		return numericA;
	}

	public void setNumericA(String numericA) {
		
		String[] numericStrings = numericA.split(",");
		this.numericA = new int[numericStrings.length];
		for(int i = 0; i < numericStrings.length; i++)
		{
			try{
				int numericVal = Integer.parseInt(numericStrings[i]);
				if(numericVal < 256 && numericVal >= 0)
				{
					this.numericA[i] = numericVal;
				}
				else
				{
					this.numericA = null;
					i = numericStrings.length;
				}
			} catch (NumberFormatException e) {
				this.numericA = null;
				i = numericStrings.length;
			}	
			
		}
	}

	public int[] getNumericB() {
		return numericB;
	}

	public void setNumericB(String numericB) {
		String[] numericStrings = numericB.split(",");
		this.numericB = new int[numericStrings.length];
		for(int i = 0; i < numericStrings.length; i++)
		{
			try{
				int numericVal = Integer.parseInt(numericStrings[i]);
				if(numericVal < 256 && numericVal >= 0)
				{
					this.numericB[i] = numericVal;
				}
				else
				{
					this.numericB = null;
					i = numericStrings.length;
				}
			} catch (NumberFormatException e) {
				this.numericB = null;
				i = numericStrings.length;
			}			
		}
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}
	
}
