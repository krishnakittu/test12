package fileupload;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

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
