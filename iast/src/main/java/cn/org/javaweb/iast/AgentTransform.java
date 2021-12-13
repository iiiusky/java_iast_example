package cn.org.javaweb.iast;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.regex.Pattern;

/**
 * @author iiusky - 03sec.com
 */
public class AgentTransform implements ClassFileTransformer {

	/**
	 * @param loader
	 * @param className
	 * @param classBeingRedefined
	 * @param protectionDomain
	 * @param classfileBuffer
	 * @return
	 * @throws IllegalClassFormatException
	 */
	@Override
	public byte[] transform(ClassLoader loader, String className,
	                        Class<?> classBeingRedefined, ProtectionDomain protectionDomain,
	                        byte[] classfileBuffer) throws IllegalClassFormatException {

		className = className.replace("/", ".");
		if (className.contains("cn.org.javaweb.iast")) {
			System.out.println("Skip class: " + className);
			return classfileBuffer;
		}

		if (className.contains("java.lang.invoke")) {
			System.out.println("Skip class: " + className);
			return classfileBuffer;
		}
		byte[] originalClassfileBuffer = classfileBuffer;

		ClassReader  classReader  = new ClassReader(classfileBuffer);
		ClassWriter  classWriter  = new ClassWriter(classReader, ClassWriter.COMPUTE_MAXS);
		ClassVisitor classVisitor = new IASTClassVisitor(className, classWriter);

		classReader.accept(classVisitor, ClassReader.EXPAND_FRAMES);

		classfileBuffer = classWriter.toByteArray();
		className = className.replace("/", ".");


		String regexp = "(Decoder|Servlet|connector|Request|Parameters|Base64|Runtime|ProcessBuilder)";

		if (Pattern.compile(regexp).matcher(className).find()) {
			ClassUtils.dumpClassFile("/Users/sky/Data/code/A-Self/java/java_iast_example/class/", className, classfileBuffer, originalClassfileBuffer);
		}

		return classfileBuffer;
	}

}
