package AEM_Training.AEM.core.service.impl;

import java.util.Map;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.PropertyUnbounded;
import org.apache.felix.scr.annotations.Service;
import org.apache.felix.scr.impl.helper.Logger;
import org.apache.jackrabbit.oak.commons.PropertiesUtil;
import org.slf4j.LoggerFactory;

import AEM_Training.AEM.core.service.ConfigurationService;

@Component(immediate = true, metatype = true, label = "Example config service")
@Service(ConfigurationService.class)

public class ConfigurationServiceImpl implements ConfigurationService {

	private static final Logger LOG = (Logger) LoggerFactory.getLogger(ConfigurationService.class);
	private static final String CLASS_NAME = "[ConfigurationService]:";

	@Property(unbounded = PropertyUnbounded.ARRAY, label = "multi String", description = "ex of multi field config")
	private static final String MULTI_FIELD = "multifield";

	@Property(unbounded = PropertyUnbounded.DEFAULT, label = "simple String", description = "ex of simple field config")
	private static final String SIMPLE_FIELD = "simplefield";

	private String[] multistring;
	private String simpleString;
	

	public String[] getMultiString() {
		// TODO Auto-generated method stub
		return this.multistring;
	}

	public String getSimpleString() {
		// TODO Auto-generated method stub
		return this.simpleString;
	}

	@Activate

	public void activate(Map<String, Object> properties) {
		((org.slf4j.Logger) LOG).info("[****AEM ConfigurationService]: Actiavting Configuration Service");
		readProperties(properties);

	}

	protected void readProperties(Map<String, Object> properties) {

		((org.slf4j.Logger) LOG).info(properties.toString());
		this.multistring = PropertiesUtil.toStringArray(properties.get("multifield"));
		((org.slf4j.Logger) LOG).info("multi string size:" + this.multistring.length);
		this.simpleString = PropertiesUtil.toString(properties.get("simplefield"), "default");
		((org.slf4j.Logger) LOG).info("Simple STring : " + this.simpleString);

	}

}
