package pl.karolcyprowski.bstreamreplacer.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class OperationHandlerImpl implements OperationHandler {

	private OperationProxyObject proxyObject;

	private byte[] a;

	private byte[] b;

	private List<InfoObject> results;

	public OperationHandlerImpl(OperationProxyObject proxyObject) {
		setProxyObject(proxyObject);
		results = new LinkedList<InfoObject>();
	}

	public void runMainOperation() {
		File pathTarget = createBaseFile();
		runGlobalReplaceOperation(pathTarget);
	}

	private File createBaseFile() {
		String path = proxyObject.getPath();
		if (path == "") {
			path = "/";
		}
		File baseFile = new File(path);
		return baseFile;
	}

	private void runGlobalReplaceOperation(File baseFile) {
		if (baseFile.exists() && baseFile.canRead()) {
			String parentPath = baseFile.getAbsolutePath();
			if (baseFile.isDirectory()) {
				String[] fileList = baseFile.list();
				for (int i = 0; i < fileList.length; i++) {
					File fileFromList = new File(parentPath + "/" + fileList[i]);
					runGlobalReplaceOperation(fileFromList);
				}
			} else {
				String fileExtension = getFileExtension(baseFile);
				if (fileExtension.equals(proxyObject.getExtension())) {
					loadSearchAndReplaceByteArrays();
					if(getA().length > 0 && getB().length > 0)
					{
						int counter = runSearchAndReplaceOperation(baseFile);
						if (counter > 0) {
							InfoObject infoObject = new InfoObject(counter, parentPath, true);
							results.add(infoObject);
						}
					}					
				}
			}
		}
		else
		{
			InfoObject infoObject = new InfoObject(0, baseFile.getAbsolutePath(), false);
			results.add(infoObject);
		}
	}

	protected void loadSearchAndReplaceByteArrays() {
		// method overwritten by children classes
	}

	private int runSearchAndReplaceOperation(File source) {
		try {
			String sourcePath = source.getAbsolutePath();
			source.renameTo(new File(sourcePath + ".tmp"));
			source = new File(sourcePath + ".tmp");
			FileInputStream inputStream = new FileInputStream(source);
//			File newFile = new File(source.getAbsolutePath() + ".tmp");
			File newFile = new File(sourcePath);
			FileOutputStream outputStream = new FileOutputStream(newFile);
			int counter = 0;
			int nextInt = 0;
			int indexOfA = 0;
			int dynamicIndexForArrayOfBytesEqualToA = 0;
			int dynamicIndexOfA = 0;
			int lengthOfA = getA().length;
			byte[] arrayOfBytesEqualToA = new byte[0];
			while ((nextInt = inputStream.read()) != -1) {
				byte nextByte = (byte) nextInt;
				if (dynamicIndexOfA != indexOfA) {
					if (nextByte == getA()[dynamicIndexOfA]) {
						dynamicIndexOfA++;
						if (dynamicIndexForArrayOfBytesEqualToA == 0) {
							dynamicIndexForArrayOfBytesEqualToA = indexOfA;
						}
					} else {
						dynamicIndexOfA = 0;
					}
				}
				if (nextByte == getA()[indexOfA]) {
					indexOfA++;
					byte[] oldArrayOfBytesEqualToA = arrayOfBytesEqualToA;
					arrayOfBytesEqualToA = new byte[indexOfA];
					for (int i = 0; i < oldArrayOfBytesEqualToA.length; i++) {
						arrayOfBytesEqualToA[i] = oldArrayOfBytesEqualToA[i];
					}
					arrayOfBytesEqualToA[oldArrayOfBytesEqualToA.length] = nextByte;
					if (indexOfA == lengthOfA) {
						indexOfA = 0;
						outputStream.write(getB());
						arrayOfBytesEqualToA = new byte[0];
						dynamicIndexForArrayOfBytesEqualToA = 0;
						dynamicIndexOfA = 0;
						counter++;
					}
				} else {
					if (arrayOfBytesEqualToA.length != 0 && dynamicIndexForArrayOfBytesEqualToA != 0
							&& dynamicIndexOfA != 0) {
						byte[] outputArray = new byte[dynamicIndexForArrayOfBytesEqualToA];
						for (int i = 0; i < dynamicIndexForArrayOfBytesEqualToA; i++) {
							outputArray[i] = arrayOfBytesEqualToA[i];
						}
						outputStream.write(outputArray);
						byte[] oldArrayOfBytesEqualToA = arrayOfBytesEqualToA;
						arrayOfBytesEqualToA = new byte[dynamicIndexOfA];
						int j = 0;
						for (int i = dynamicIndexForArrayOfBytesEqualToA; i < dynamicIndexForArrayOfBytesEqualToA
								+ dynamicIndexOfA - 1; i++) {
							arrayOfBytesEqualToA[j] = oldArrayOfBytesEqualToA[i];
							j++;
						}
						arrayOfBytesEqualToA[j] = nextByte;
						indexOfA = arrayOfBytesEqualToA.length;
						dynamicIndexOfA = indexOfA - dynamicIndexForArrayOfBytesEqualToA;
					} else if (arrayOfBytesEqualToA.length != 0) {
						outputStream.write(arrayOfBytesEqualToA);
						outputStream.write(nextInt);
						arrayOfBytesEqualToA = new byte[0];
						indexOfA = 0;
					} else {
						outputStream.write(nextInt);
					}
				}
			}
			inputStream.close();
			outputStream.close();
			source.delete();
			return counter;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return -1;
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		}
	}

	private String getFileExtension(File file) {
		String name = file.getName();
		try {
			return name.substring(name.lastIndexOf(".") + 1);
		} catch (Exception e) {
			return "";
		}
	}

	public OperationProxyObject getProxyObject() {
		return proxyObject;
	}

	public void setProxyObject(OperationProxyObject proxyObject) {
		this.proxyObject = proxyObject;
	}

	public byte[] getA() {
		return a;
	}

	public void setA(byte[] a) {
		this.a = a;
	}

	public byte[] getB() {
		return b;
	}

	public void setB(byte[] b) {
		this.b = b;
	}

	public List<InfoObject> getResults() {
		return results;
	}

	public void setResults(List<InfoObject> results) {
		this.results = results;
	}

}