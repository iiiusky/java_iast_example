package cn.org.javaweb.iast.visitor;

import org.objectweb.asm.MethodVisitor;

/**
 * @author iiusky - 03sec.com
 */
public interface Handler {

	MethodVisitor ClassVisitorHandler(MethodVisitor mv, final String className, int access, String name, String desc, String signature, String[] exceptions);
}
