package com.springmybatis.noweb;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import com.springmybatis.noweb.mapper.CertMapper;
import com.springmybatis.noweb.service.CertService;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

/**
 * Hello world!
 *
 */
@Command(name = "checksum", description = "Prints the checksum (MD5 by default) of a file to STDOUT.")
public class App implements Callable<Void> {
	
	
    @Parameters(index = "0", description = "The file whose checksum to calculate.")
    private File file;

    @Option(names = {"-a", "--algorithm"}, description = "MD5, SHA-1, SHA-256, ...")
    private String algorithm = "MD5";

    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
    private boolean helpRequested;
    
    private static CertService certService;
	static void init() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
    	certService =ctx.getBean(CertService.class);
	}
	

    public static CertService getCertService() {
		return certService;
	}



	public static void setCertService(CertService certService) {
		App.certService = certService;
	}



	public static void main(String[] args) throws Exception {
		try {
//			CommandLine.call(new App(), System.err, args);
			init();
	    	MyTest test = new MyTest();
	    	test.test();

		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		

        // CheckSum implements Callable, so parsing, error handling and handling user
        // requests for usage help or version help can be done with one line of code.
       // CommandLine.call(new App(), System.err, args);
    }
 
    
    @Override
    public Void call() throws Exception {
    	init();
    	MyTest test = new MyTest();
    	test.test();
		return null;
    	
        // your business logic goes here...
//        byte[] fileContents = Files.readAllBytes(file.toPath());
//        byte[] digest = MessageDigest.getInstance(algorithm).digest(fileContents);
//        System.out.println(javax.xml.bind.DatatypeConverter.printHexBinary(digest));
//        return null;
    }
}
