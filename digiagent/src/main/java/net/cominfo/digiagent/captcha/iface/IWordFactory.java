package net.cominfo.digiagent.captcha.iface;

import java.util.Properties;

/**
 * All Custom WordGenerators need to extend this Class
 * 
 * @author Porkin
 * 
 */
public abstract class IWordFactory {

	protected static IWordFactory instance;

	public String word;

	@SuppressWarnings("unchecked")
	protected IBackgroundProducer backgroundImageProducer;

	protected java.util.Properties props;

	public IWordFactory() {
	};

	public static IWordFactory getInstance() {
		return null;
	};

	/**
	 * 
	 * @return next world
	 */
	public String getWord() {
		return "";
	};

	/**
	 * 
	 * @return lastword generated
	 */
	public String getLastWord() {
		return word;
	};

	public void setProperties(java.util.Properties props) {
		this.props = props;
	}

	public Properties getProperties() {
		return this.props;
	}

	/**
	 * Custom Implementation of the hash code solver Most of the time this would
	 * be sufficient but with international characters and encodings we need to
	 * handle that ourself
	 * 
	 * @return
	 */
	public String getHashCode() {
		return "" + word.hashCode();
	};

	public String getHashCode(String str) {
		return "" + str.hashCode();
	};

	@SuppressWarnings("unchecked")
	public void setBackGroundImageProducer(IBackgroundProducer background) {
		this.backgroundImageProducer = background;
	}

	@SuppressWarnings("unchecked")
	public IBackgroundProducer getBackGroundImageProducer() {
		return this.backgroundImageProducer;
	}
}