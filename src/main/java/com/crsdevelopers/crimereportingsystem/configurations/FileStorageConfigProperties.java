package com.crsdevelopers.crimereportingsystem.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
@Configuration
@ConfigurationProperties(prefix =ApiConstants.FILE_PROPERTIES_PREFIX)
@Data
public class FileStorageConfigProperties {

	private String uploadDir;
	
}
