package net.kadirderer.translator.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import net.kadirderer.translator.client.TranslatorServiceClient;

@Configuration
@ComponentScan(basePackages = { "net.kadirderer.translator.service" })
@PropertySource("classpath:app-config.properties")
public class ServiceConfig {
	
	@Value("${microsoft.translate.accesstoken.endpoint}")
	private String accessTokenEndPoint;
	
	@Value("${microsoft.translate.service.endpoint}")
	private String serviceEndPoint;
	
	@Value("${chinese.pinyin.service.endpoint}")
	private String pinyinServiceEndPoint;	
	
	@Bean
	public TranslatorServiceClient accessTokenClient() {
		return new TranslatorServiceClient(accessTokenEndPoint);
	}
	
	@Bean
	public TranslatorServiceClient serviceClient() {
		return new TranslatorServiceClient(serviceEndPoint);
	}
	
	@Bean
	public TranslatorServiceClient pinyinServiceClient() {
		return new TranslatorServiceClient(pinyinServiceEndPoint);
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
