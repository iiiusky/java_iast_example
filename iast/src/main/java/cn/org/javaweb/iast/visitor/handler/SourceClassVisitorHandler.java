package cn.org.javaweb.iast.visitor.handler;

import cn.org.javaweb.iast.visitor.Handler;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.AdviceAdapter;

import java.lang.reflect.Modifier;


/**
 * @author iiusky - 03sec.com
 */
public class SourceClassVisitorHandler implements Handler {

	private static final String METHOD_DESC = "(Ljava/lang/String;)Ljava/lang/String;";

	public MethodVisitor ClassVisitorHandler(MethodVisitor mv, final String className, int access, final String name,
	                                         final String desc, String signature, String[] exceptions) {
		if (METHOD_DESC.equals(desc) && "getParameter".equals(name)) {
			final boolean isStatic = Modifier.isStatic(access);

			System.out.println("Source Process 类名是: " + className + ",方法名是: " + name + "方法的描述符是：" + desc + ",签名是:" + signature + ",exceptions:" + exceptions);
			return new AdviceAdapter(Opcodes.ASM5, mv, access, name, desc) {
				@Override
				protected void onMethodEnter() {
					loadArgArray();
					int argsIndex = newLocal(Type.getType(Object[].class));
					storeLocal(argsIndex, Type.getType(Object[].class));
					loadLocal(argsIndex);
					push(className);
					push(name);
					push(desc);
					push(isStatic);

					mv.visitMethodInsn(INVOKESTATIC, "cn/org/javaweb/iast/core/Source", "enterSource", "([Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", false);
					super.onMethodEnter();
				}

				@Override
				protected void onMethodExit(int opcode) {
					Type returnType = Type.getReturnType(desc);
					if (returnType == null || Type.VOID_TYPE.equals(returnType)) {
						push((Type) null);
					} else {
						mv.visitInsn(Opcodes.DUP);
					}
					push(className);
					push(name);
					push(desc);
					push(isStatic);
					mv.visitMethodInsn(INVOKESTATIC, "cn/org/javaweb/iast/core/Source", "leaveSource", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", false);
					super.onMethodExit(opcode);
				}
			};
		}
		return mv;
	}
}


