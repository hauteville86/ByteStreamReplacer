package pl.karolcyprowski.bstreamreplacer.core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class OperationHandlerImplFromFile extends OperationHandlerImpl {

	public OperationHandlerImplFromFile(OperationProxyObject proxyObject) {
		super(proxyObject);
	}
	
	@Override
	protected void loadSearchAndReplaceByteArrays()
	{
		if(getA() == null && getB() == null)
		{
			RandomAccessFile sourceForArrayA;
			RandomAccessFile sourceForArrayB;
			try {
				sourceForArrayA = new RandomAccessFile(getProxyObject().getFileA(), "r");
				byte[] a = new byte[(int)sourceForArrayA.length()];
				sourceForArrayA.readFully(a);
				setA(a);
				sourceForArrayB = new RandomAccessFile(getProxyObject().getFileB(), "r");
				byte[] b = new byte[(int)sourceForArrayB.length()];
				sourceForArrayB.readFully(b);
				setB(b);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				setA(new byte[0]);
				setB(new byte[0]);
			} catch (IOException e) {
				e.printStackTrace();
				setA(new byte[0]);
				setB(new byte[0]);
			}
		}		
	}

}
