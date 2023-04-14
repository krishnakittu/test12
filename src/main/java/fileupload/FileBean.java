package fileupload;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.file.UploadedFile;

@Named
@RequestScoped
public class FileBean {
	/**
	 * 
	 */
	private StreamedContent file;
	private UploadedFile files;


	public UploadedFile getFiles() {
		return files;
	}

	public void setFiles(UploadedFile files) {
		this.files = files;
	}

	public FileBean() {
    	file = DefaultStreamedContent.builder()
                .name("downloaded_boromir.png")
                .contentType("image/png")
                .stream(() -> FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/test.png"))
                .build();
    }

    public StreamedContent getFile() {
        return file;
    }
    
    public void handleFileUpload(FileUploadEvent event) {
       System.out.println(event.getFile().getFileName());
       System.out.println("This is for debug purpose ");
    }

}
