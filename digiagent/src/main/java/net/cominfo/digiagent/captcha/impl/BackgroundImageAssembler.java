package net.cominfo.digiagent.captcha.impl;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import net.cominfo.digiagent.captcha.iface.IBackgroundProducer;
import net.cominfo.digiagent.captcha.iface.IImageAssembler;
import net.cominfo.digiagent.utils.ImageHelper;

/**
 * Assemble Multiple backgrounds into one
 * 
 * @author Porkin
 * 
 */
public class BackgroundImageAssembler implements IImageAssembler {

	@SuppressWarnings("unused")
	private Properties props;

	@SuppressWarnings("unchecked")
	private List<IBackgroundProducer> producers;

	@SuppressWarnings("unchecked")
	public BackgroundImageAssembler() {
		producers = new ArrayList<IBackgroundProducer>();
		props = new Properties();
	}

	@SuppressWarnings("unchecked")
	public void registerBackgroundProducer(
			IBackgroundProducer<IBackgroundProducer> producer) {
		producers.add(producer);
	}

	@SuppressWarnings("unchecked")
	public BufferedImage addBackground(BufferedImage image) {
		BufferedImage mergedImage = ImageHelper.createCompatibleImage(image);
		Graphics2D g2 = mergedImage.createGraphics();
		g2.setComposite(AlphaComposite.DstOver);
		// Set best alpha interpolation quality
		g2.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
				RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		for (IBackgroundProducer emiter : producers) {
			g2.drawImage(emiter.addBackground(image), 0, 0, null);
		}

		return mergedImage;
	}

	public void setProperties(Properties props) {
		this.props = props;
	}

}
