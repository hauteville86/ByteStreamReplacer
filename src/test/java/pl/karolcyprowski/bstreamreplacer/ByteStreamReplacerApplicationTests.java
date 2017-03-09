package pl.karolcyprowski.bstreamreplacer;

import java.io.File;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pl.karolcyprowski.bstreamreplacer.core.InfoObject;
import pl.karolcyprowski.bstreamreplacer.core.OperationHandler;
import pl.karolcyprowski.bstreamreplacer.core.OperationHandlerImplByHand;
import pl.karolcyprowski.bstreamreplacer.core.OperationHandlerImplFromFile;
import pl.karolcyprowski.bstreamreplacer.core.OperationProxyObject;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ByteStreamReplacerApplicationTests {

	@Test
	public void contextLoads() 
	{
		
	}
	
	@Test
	public void checkPath()
	{
		OperationProxyObject proxyObject = new OperationProxyObject();
		proxyObject.setPath("/home/karol/testy");
		File fileFromPath = new File(proxyObject.getPath());
		String[] children = fileFromPath.list();
		assertEquals(children.length, 2);
		boolean bstreamReplacerDirectoryFound = false;
		for(int i = 0; i < children.length; i++)
		{
			String child = children[i];
			if(child.equals("bstream-replacer"))
			{
				bstreamReplacerDirectoryFound = true;
				i = children.length;
			}
		}
		assertEquals(bstreamReplacerDirectoryFound, true);
	}
	
	@Test
	public void checkReplaceOperation()
	{
//		String sourcePath = "/home/karol/testy/bstream-replacer/source.txt";
//		String aPath = "/home/karol/testy/bstream-replacer/a";
//		String bPath = "/home/karol/testy/bstream-replacer/b";
//		OperationProxyObject proxyObject = new OperationProxyObject();
//		proxyObject.setPath(sourcePath);
//		proxyObject.setFileA(aPath);
//		proxyObject.setFileB(bPath);
//		proxyObject.setInputByHandA("nananano");
//		proxyObject.setInputByHandB("dxfvxc");
//		OperationHandler handler = new OperationHandlerImplFromFile(proxyObject);
//		OperationHandler handlerByHand = new OperationHandlerImplByHand(proxyObject);
//		handler.runMainOperation();
//		List<InfoObject> results = handler.getResults();
//		if(!results.isEmpty())
//		{
//			int counter = handler.getResults().get(0).getCounter();
//		}
//		handlerByHand.runMainOperation();
//		List<InfoObject> resultsByHand = handlerByHand.getResults();
//		if(!resultsByHand.isEmpty())
//		{
//			int counterByHand = handlerByHand.getResults().get(0).getCounter();
//			assertEquals(3, counterByHand);
//		}
		
//		assertEquals(1, counter);
		
	}

}
