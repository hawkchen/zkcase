package support.http;

import org.zkoss.zk.ui.select.SelectorComposer;

public class DownloadComposer extends SelectorComposer {
/*
	@Listen("onClick = #download")
	public void download() throws FileNotFoundException{
		HttpServletResponse response = (HttpServletResponse) Executions.getCurrent().getNativeResponse();
		response.setHeader("Pragma", "public");
		response.setHeader("Cache-Control", "public");

		Filedownload.save("/component/forie.doc", null);
	}
	
	@Listen("onClick = #downloadNoCache")
	public void downloadNoCache() throws FileNotFoundException{
		HttpServletResponse response = (HttpServletResponse) Executions.getCurrent().getNativeResponse();
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache,max-age=0,must-revalidate");

		Filedownload.save("/component/forie.doc", null);
	}
	*/
	
}
