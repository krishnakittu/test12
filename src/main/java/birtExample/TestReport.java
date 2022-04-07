package birtExample;

import java.io.IOException;
import java.net.URL;

import org.eclipse.birt.core.exception.BirtException;
import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.IRenderOption;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.PDFRenderOption;
import org.eclipse.birt.report.model.api.MasterPageHandle;
import org.eclipse.birt.report.model.api.SlotHandle;
import org.eclipse.birt.report.model.api.elements.DesignChoiceConstants;
public class TestReport {

	public static void main(String[] args) throws BirtException, IOException {
		// TODO Auto-generated method stub
		EngineConfig config = new EngineConfig();
		Platform.startup();
		IReportEngineFactory factory = (IReportEngineFactory) Platform.
				createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
		IReportEngine engine = factory.createReportEngine(config);
		URL url = TestReport.class.getClassLoader().getResource("landscape.rptdesign");
		IReportRunnable design = engine.openReportDesign(url.openStream());
		SlotHandle sd = design.getDesignHandle().getModuleHandle().getMasterPages();
		MasterPageHandle h =  design.getDesignHandle().getModuleHandle().findMasterPage(sd.get(0).getFullName());
		h.setOrientation(DesignChoiceConstants.PAGE_ORIENTATION_PORTRAIT);
		IRunAndRenderTask task = engine.createRunAndRenderTask(design);
		PDFRenderOption renderOptions = new PDFRenderOption();
		renderOptions.setOutputFormat(IRenderOption.OUTPUT_FORMAT_PDF);
		String outPutFileName = "D:\\"+ h.getOrientation() + "." + IRenderOption.OUTPUT_FORMAT_PDF;
		renderOptions.setOutputFileName(outPutFileName);
		task.setRenderOption(renderOptions);
		task.run();
		task.close();
	}

}
