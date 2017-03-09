package pl.karolcyprowski.bstreamreplacer.core;

import java.util.List;

public interface OperationHandler {

	public OperationProxyObject getProxyObject();

	public void setProxyObject(OperationProxyObject proxyObject);
	
	public void runMainOperation();
	
	public List<InfoObject> getResults();

	public void setResults(List<InfoObject> results);
}
