package net.cominfo.digiagent.captcha.iface;

import java.awt.image.BufferedImage;

/**
 * The interface is for background
 * 
 * @author Porkin
 * 
 */
public interface IBackgroundProducer<T> {
	public BufferedImage addBackground(BufferedImage image);

	/**
	 * BackGroundProducer specific properties like 'color', 'size' etc'
	 * 
	 * @param props
	 */
	public void setProperties(java.util.Properties props);
}
