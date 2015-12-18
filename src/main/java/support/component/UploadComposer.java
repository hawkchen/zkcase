package support.component;


import java.io.*;

import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Label;

public class UploadComposer extends GenericForwardComposer {

	Label status;
	
	public void onUpload$attachBtn(UploadEvent event) {
  		Media media = event.getMedia();
		String currentFolder = Sessions.getCurrent().getWebApp().getRealPath("/")+"/";
		byte[] buffer = new byte[1024];
  		InputStream inputStream  = media.getStreamData();
  		System.out.println(inputStream);
  		int size = 0;
  		int read = 0;
  		try{
	  		OutputStream outputStream = new FileOutputStream(new File(currentFolder+media.getName()));
	  		while ((read = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, read);
				size += read;
			}
	  		status.setValue("uploaded "+media.getName()+", size:"+(size/1024)+" k bytes");
	  		outputStream.close();
  		}catch(Exception e){
  			//handle exception
  			e.printStackTrace();
  		}
  		
	}
	
}
