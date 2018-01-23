package com.springmybatis.noweb;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;



/**
 * 去解密配置文件的关键字段
 * @author liaoxiaohua
 *
 */
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	
	private static final String DB_USERNAME = "jdbc_username";
	private static final String DB_USERPASSWORD = "jdbc_password";
	@Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props)
        throws BeansException {
    	
    	try {
        	String userName = props.getProperty(DB_USERNAME);
        	String userPassword = props.getProperty(DB_USERPASSWORD);
        	if(userName!=null) {
        		props.setProperty(DB_USERNAME, MySecureUtil.decryptHexStr(userName));
        	}
        	if(userPassword!=null) {
        		props.setProperty(DB_USERPASSWORD, MySecureUtil.decryptHexStr(userPassword));
        	}
        	super.processProperties(beanFactory, props);
    	}catch (Exception e) {
          e.printStackTrace();
          throw new BeanInitializationException(e.getMessage());
      }

    }
            
}