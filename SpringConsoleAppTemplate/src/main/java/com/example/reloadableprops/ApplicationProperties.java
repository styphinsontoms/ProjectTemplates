package com.example.reloadableprops;

import java.io.File;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.springframework.stereotype.Component;


@Component
public class ApplicationProperties {

	private PropertiesConfiguration configuration;
	private String homeDir = "";
	private String logDir = "";

	@PostConstruct
	private void init() {
		try {

			Map<String, String> env = System.getenv();
			logDir = env.get("HOMEDRIVE");
			homeDir = env.get("LOGDRIVE");
			for (String envName : env.keySet()) {
				System.out.format("%s=%s%n", envName, env.get(envName));

			}
			if (logDirHasLogFile()) {
				System.out.println("File loaded from "+logDir);
			} else if (homeDirHasLogFile()) {
				System.out.println("File loaded from "+homeDir);
			} else {
				System.out
						.println("No proper path defined for properties File");
				System.exit(0);
			}

			String fileName = PropertiesConstants.DEF_PROP_FILE_NAME;
			System.out.println("Loading the properties file: " + fileName);
			configuration = new PropertiesConfiguration(fileName);
			// Create new FileChangedReloadingStrategy to reload the properties
			// file based on the given time interval
			FileChangedReloadingStrategy fileChangedReloadingStrategy = new FileChangedReloadingStrategy();
			fileChangedReloadingStrategy
					.setRefreshDelay(PropertiesConstants.REFRESH_DELAY);
			configuration.setReloadingStrategy(fileChangedReloadingStrategy);
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}

	private boolean homeDirHasLogFile() {
		try {
			String filePath = homeDir + File.separator
					+ PropertiesConstants.DEF_PROP_FILE_NAME;
			File file = new File(filePath);
			if (!file.exists()) {
				return false;
			}
			System.out.println("Loading the properties file: " + filePath);
			configuration = new PropertiesConfiguration(filePath);
			return true;
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	private boolean logDirHasLogFile() {
		try {
			String filePath = logDir + File.separator
					+ PropertiesConstants.DEF_PROP_FILE_NAME;
			File file = new File(filePath);
			if (!file.exists()) {
				return false;
			}
			System.out.println("Loading the properties file: " + filePath);
			configuration = new PropertiesConfiguration(filePath);
			return true;
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public String getProperty(String key) {
		return (String) configuration.getProperty(key);
	}

	public void setProperty(String key, Object value) {
		configuration.setProperty(key, value);
	}

	public void save() {
		try {
			configuration.save();
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}

}
