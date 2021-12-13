package cn.org.javaweb.iast;

import java.io.File;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.writeByteArrayToFile;

/**
 * @author iiusky - 03sec.com
 */
public class ClassUtils {

	public static void dumpClassFile(String path, String className, byte[] classfileBuffer, byte[] originalClassfileBuffer) {
		String filename;
		try {
			if (className.lastIndexOf('.') == -1) {
				filename = className;
			} else {
				filename = className.substring(className.lastIndexOf('.') + 1);
			}
			path = path + className.replace(filename, "").replace(".", "/").replace("$", "_");

			final File newClass      = new File(path + filename + ".class");
			final File originalClass = new File(path + filename + "-original.class");
			final File classPath     = new File(newClass.getParent());

			if (!classPath.mkdirs() && !classPath.exists()) {
				System.out.printf("create dump classpath=%s failed.\n", classPath);
			} else {
				writeByteArrayToFile(newClass, classfileBuffer);
				writeByteArrayToFile(originalClass, originalClassfileBuffer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}