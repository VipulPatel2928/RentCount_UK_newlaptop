package com.automation.utility;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import com.sun.net.httpserver.Authenticator.Retry;

public class RentCount_AnnotationTransformer implements IAnnotationTransformer {
	
	@Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		
		// Vipul update for the retry for the failed test cases
		 IRetryAnalyzer retry = annotation.getRetryAnalyzer();
		 
		 if (retry == null) {
		 annotation.setRetryAnalyzer(Retry.class);
		 }
		
       // annotation.setRetryAnalyzer(Retry.class);
    }	
}
