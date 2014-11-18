package support.component;


import java.text.DecimalFormat;

import org.zkoss.zk.ui.event.*;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.*;

public class UploadComposer extends SelectorComposer<Window> {

	@Wire
	Button uploadBtn;
	@Wire
	Image image;
	
	
	@Listen("onCreate=div")
	public void onCreate() {
		uploadBtn.addEventListener(Events.ON_UPLOAD, new UploadEventListener());
	}
	class UploadEventListener implements org.zkoss.zk.ui.event.EventListener {

		int maxHeadShotSizeBytes = 20000;
		@Override
		public void onEvent(Event event) throws Exception {
			System.out.println("UploadEventListener.onEvent - start");

			UploadEvent uploadEvent = (UploadEvent) event;
			org.zkoss.util.media.Media media = uploadEvent.getMedia();

			if (media instanceof org.zkoss.image.Image) {
				if (media.getByteData().length > maxHeadShotSizeBytes) {
					DecimalFormat df = new DecimalFormat("0.##");
					Messagebox.show("File size limit of " + df.format(maxHeadShotSizeBytes )
							+ "bytes has been exceeded, please rectify and upload again.",
							"Error", Messagebox.OK, Messagebox.ERROR);
				} else {
					org.zkoss.image.Image image = (org.zkoss.image.Image) media;
//					headshotImage.setContent(image);
//					person.setImageFile("new." + image.getFormat());
				}
			} else {
				Messagebox.show("Not an image: " + media, "Error", Messagebox.OK, Messagebox.ERROR);
			}

			System.out.println("UploadEventListener.onEvent - end");
		}
	}
	
	@Listen("onClick = #uploadBtn2")
	public void upload(){
		Fileupload.get(new EventListener(){
            public void onEvent(Event event) {
            	UploadEvent uploadEvent = (UploadEvent) event;
                org.zkoss.util.media.Media media = uploadEvent.getMedia();
                if (media instanceof org.zkoss.image.Image) {
                    org.zkoss.image.Image img = (org.zkoss.image.Image) media;
                    if (img.getWidth() > img.getHeight()){
                        if (img.getHeight() > 300) {
//                            pics.setHeight("300px");
//                            pics.setWidth(img.getWidth() * 300 / img.getHeight() + "px");
                        }
                    }
                    if (img.getHeight() > img.getWidth()){
                        if (img.getWidth() > 400) {
//                            pics.setWidth("400px");
//                            pics.setHeight(img.getHeight() * 400 / img.getWidth() + "px");
                        }
                    }
                    image.setContent(img);
                } else {
                    Messagebox.show("Not an image: "+media, "Error", Messagebox.OK, Messagebox.ERROR);
                }
            }
        });
	}

}
