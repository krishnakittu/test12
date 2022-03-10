package fileupload;



import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named
@RequestScoped
public class FileBean {
	private StreamedContent file;

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

}
