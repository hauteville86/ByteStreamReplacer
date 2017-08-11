package pl.karolcyprowski.bstreamreplacer.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.karolcyprowski.bstreamreplacer.core.ByteStreamReplacerConstants;
import pl.karolcyprowski.bstreamreplacer.core.InfoObject;
import pl.karolcyprowski.bstreamreplacer.core.OperationHandler;
import pl.karolcyprowski.bstreamreplacer.core.OperationHandlerImplByHand;
import pl.karolcyprowski.bstreamreplacer.core.OperationHandlerImplFromFile;
import pl.karolcyprowski.bstreamreplacer.core.OperationHandlerImplNoInput;
import pl.karolcyprowski.bstreamreplacer.core.OperationHandlerImplNumeric;
import pl.karolcyprowski.bstreamreplacer.core.OperationProxyObject;
import pl.karolcyprowski.bstreamreplacer.core.ResultProcessor;

@Controller
@RequestMapping("/")
public class ByteStreamController{
	
	@RequestMapping("/")
	public String renderStart(Model model)
	{
		return renderMain(model);
	}
	
	@RequestMapping("/return")
	public String goBackToMainPage(Model model)
	{
		return renderMain(model);
	}
	
	@RequestMapping("/main")
	public String renderMain(Model model){
		model.addAttribute("path", ByteStreamReplacerConstants.FILES_PATH_PL);
		model.addAttribute("extension", ByteStreamReplacerConstants.EXTENSION_PL);
		model.addAttribute("streamAName", ByteStreamReplacerConstants.BYTE_STREAM_A_PL);
		model.addAttribute("streamBName", ByteStreamReplacerConstants.BYTE_STREAM_B_PL);
		model.addAttribute("replace", ByteStreamReplacerConstants.REPLACE_PL);
		model.addAttribute("howToInput", ByteStreamReplacerConstants.HOW_TO_INPUT_PL);
		model.addAttribute("byHand", ByteStreamReplacerConstants.BY_HAND_PL);
		model.addAttribute("fromFile", ByteStreamReplacerConstants.FROM_FILE_PL);
		model.addAttribute("numeric", ByteStreamReplacerConstants.NUMERIC_PL);
		model.addAttribute("submit", ByteStreamReplacerConstants.SUBMIT_PL);
		model.addAttribute("operationProxyObject", new OperationProxyObject());
		return "main";
	}
	
	@RequestMapping("/startReplaceOperation")
	public String startOperation(OperationProxyObject operationProxyObject, Model model){
		OperationHandler operationHandler = initializeHandler(operationProxyObject);
		if(!(operationHandler instanceof OperationHandlerImplNoInput))
		{
			operationHandler.runMainOperation();
			List<InfoObject> results = operationHandler.getResults();
			if(!results.isEmpty())
			{
				ResultProcessor resultProcessor = new ResultProcessor(results);
				model.addAttribute("changes", resultProcessor.getChangedFiles());
				model.addAttribute("unreadables", resultProcessor.getUnreadableFiles());
				return "result";
			}
			else
			{
				return "emptyResult";
			}
			
		}
		else
		{
			return "falseInput";
		}
	}
	
	private OperationHandler initializeHandler(OperationProxyObject operationProxyObject)
	{
		OperationHandler operationHandler;
		if(operationProxyObject.isInputFromFile())
		{
			operationHandler = new OperationHandlerImplFromFile(operationProxyObject);
		}
		else if(operationProxyObject.isInputByHand())
		{
			operationHandler = new OperationHandlerImplByHand(operationProxyObject);
		}
		else if(operationProxyObject.isNumericInput())
		{
			operationHandler = new OperationHandlerImplNumeric(operationProxyObject);
		}
		else
		{
			operationHandler = new OperationHandlerImplNoInput(operationProxyObject);
		}
		return operationHandler;
	}

}
