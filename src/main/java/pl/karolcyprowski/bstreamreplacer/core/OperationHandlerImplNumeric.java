package pl.karolcyprowski.bstreamreplacer.core;

public class OperationHandlerImplNumeric extends OperationHandlerImpl {

	public OperationHandlerImplNumeric(OperationProxyObject proxyObject) {
		super(proxyObject);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void loadSearchAndReplaceByteArrays()
	{
		if(getA() == null && getB() == null)
		{
			int[] sourceForArrayA = getProxyObject().getNumericA();
			byte[] bytesA = new byte[sourceForArrayA.length];
			for(int i = 0; i < sourceForArrayA.length; i++)
			{
				bytesA[i] = (byte)(sourceForArrayA[i]);
			}
			setA(bytesA);
			int[] sourceForArrayB = getProxyObject().getNumericB();
			byte[] bytesB = new byte[sourceForArrayB.length];
			for(int i = 0; i < sourceForArrayB.length; i++)
			{
				bytesB[i] = (byte)(sourceForArrayB[i]);
			}
			setB(bytesB);
		}		
	}

}
