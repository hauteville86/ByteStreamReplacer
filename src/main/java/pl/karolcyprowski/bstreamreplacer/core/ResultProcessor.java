package pl.karolcyprowski.bstreamreplacer.core;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ResultProcessor {

	private List<InfoObject> changedFiles;
	
	private List<InfoObject> unreadableFiles;
	
	public ResultProcessor(List<InfoObject> items)
	{
		changedFiles = new LinkedList<InfoObject>();
		unreadableFiles = new LinkedList<InfoObject>();
		Iterator<InfoObject> itemsIterator = items.iterator();
		while(itemsIterator.hasNext())
		{
			InfoObject fileInfo = itemsIterator.next();
			if(fileInfo.isProcessed())
			{
				changedFiles.add(fileInfo);
			}
			else
			{
				unreadableFiles.add(fileInfo);
			}
		}
	}

	public List<InfoObject> getChangedFiles() {
		return changedFiles;
	}

	public void setChangedFiles(List<InfoObject> changedFiles) {
		this.changedFiles = changedFiles;
	}

	public List<InfoObject> getUnreadableFiles() {
		return unreadableFiles;
	}

	public void setUnreadableFiles(List<InfoObject> unreadableFiles) {
		this.unreadableFiles = unreadableFiles;
	}
}
