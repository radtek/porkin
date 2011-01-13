package net.cominfo.digiagent.captcha.iface;

/**
 * Silly interface refectory
 * 
 * @author Porkin
 * 
 */
@SuppressWarnings("unchecked")
public interface IImageAssembler extends IBackgroundProducer {
	public void registerBackgroundProducer(
			IBackgroundProducer<IBackgroundProducer> producer);
}
