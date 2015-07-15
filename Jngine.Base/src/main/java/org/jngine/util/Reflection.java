package org.jngine.util;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;

public class Reflection {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static<T> Set<Class> getAnnoClasses(Class<? extends Annotation> anno){
		ClassLoader loader = Reflection.class.getClassLoader();
		ClassPath cp;
		Set<ClassInfo> rss = null;
		try {
			cp = ClassPath.from(loader);
			rss = cp.getAllClasses();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		Set<Class> classes = new HashSet<>();
		
		for(ClassInfo info: rss){
			String className = info.getName();
			if(className.startsWith("com.google")
					|| className.startsWith("com.sun")
					|| className.startsWith("java")
					|| className.startsWith("javax")
					|| className.startsWith("sun")
					|| className.startsWith("org.apache")
					|| className.startsWith("io.netty")
					)
				continue;
			Class<T> clazz;
			try {
				clazz = (Class<T>) loader.loadClass(info.getName());
				if(clazz.isAnnotationPresent(anno)){
					classes.add(clazz);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		return classes;
	}
}
