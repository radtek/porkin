package net.cominfo.digiagent.captcha.render;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

import net.cominfo.digiagent.captcha.iface.IBackgroundProducer;
import net.cominfo.digiagent.captcha.impl.BackgroundImageAssembler;
import net.cominfo.digiagent.captcha.impl.BoxedbackgroundProducer;
import net.cominfo.digiagent.captcha.impl.FactoryLanguageImpl;
import net.cominfo.digiagent.captcha.impl.GridBackgroundProducer;

public class Driver {

	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		String ext = "png";
		props.put("format", ext);
		props.put("font", "Helvetica");
		props.put("fontsize", "28");
		props.put("min-width", "180");
		props.put("padding-x", "25");
		props.put("padding-y", "25");
		props.put("curve", "false");

		// Set the default locale to custom locale
		// Locale locale = new Locale("ru","RU");
		// Locale.setDefault(locale);
		for (int i = 0; i < 1; i++) {
			long ts = System.currentTimeMillis();
			String filename = i + "_img_test." + ext;
			OutputStream os = new FileOutputStream("c:/captcha/" + filename);
			/*
			 * FactoryRandomImplinst=(FactoryRandomImpl)Producer.forName(
			 * "org.smx.captcha.impl.FactoryRandomImpl"); inst.setSize(8);
			 */

			FactoryLanguageImpl inst = (FactoryLanguageImpl) Producer
					.forName("org.smx.captcha.impl.FactoryLanguageImpl");
			inst.setLanguageDirectory("C:\\captcha\\lang");
			inst.setLanguage("EN");
			inst.setRange(5, 10);

			// back = new CleanbackgroundProducer();
			/*
			 * back = new BoxedbackgroundProducer();
			 * backProp.put("background","E3F1FD");
			 * backProp.put("border-color","FF0080");
			 * backProp.put("intersect","true"); backProp.put("maxboxes","20");
			 * backProp.put("minboxes","5");
			 */

			IBackgroundProducer backGrid = new GridBackgroundProducer();
			Properties backProp = new Properties();
			backProp.put("background", "E3F1FD");
			backProp.put("frequency", "20");

			backGrid.setProperties(backProp);

			IBackgroundProducer backBoxed = new BoxedbackgroundProducer();
			backProp.put("background", "E3F1FD");
			backProp.put("border-color", "FF0080");
			backProp.put("intersect", "true");
			backProp.put("maxboxes", "20");
			backProp.put("minboxes", "7");

			BackgroundImageAssembler backgroundAssembler = new BackgroundImageAssembler();
			backgroundAssembler.registerBackgroundProducer(backBoxed);
			backgroundAssembler.registerBackgroundProducer(backGrid);

			inst.setBackGroundImageProducer(backGrid);

			Producer.render(os, inst, props);

			System.out.println("inst hash=" + inst.getHashCode());
			System.out.println("inst word=" + inst.getLastWord());
			System.out.println("Solved ="
					+ inst.getHashCode(inst.getLastWord()));

			long te = System.currentTimeMillis() - ts;
			System.out.println("time = " + te);
		}
	}
}
