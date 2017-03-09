package pl.karolcyprowski.bstreamreplacer.core;

public class OperationHandlerImplByHand extends OperationHandlerImpl {

	public OperationHandlerImplByHand(OperationProxyObject proxyObject) {
		super(proxyObject);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void loadSearchAndReplaceByteArrays()
	{
		String sourceForArrayA = getProxyObject().getInputByHandA();
		setA(sourceForArrayA.getBytes());
		String sourceForArrayB = getProxyObject().getInputByHandB();
		if(sourceForArrayB != null)
		{
			setB(sourceForArrayB.getBytes());	
		}
		else
		{
			setB(new byte[0]);
		}
		
	}
	
	

}
