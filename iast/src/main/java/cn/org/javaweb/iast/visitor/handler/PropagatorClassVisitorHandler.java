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
public class PropagatorClassVisitorHandler implements Handler {

	private static final String METHOD_DESC = "(Ljava/lang/String;)[B";

	private static final String CLASS_NAME = "java.lang.Runtime";

	@Override
	public MethodVisitor ClassVisitorHandler(MethodVisitor mv, final String className, int access,
	                                         final String name, final String desc, String signature, String[] exceptions) {
		if ((name.contains("decode") && METHOD_DESC.equals(desc)) || CLASS_NAME.equals(className)) {
			final boolean isStatic = Modifier.isStatic(access);
			final Type    argsType = Type.getType(Object[].class);

			if (((access & Opcodes.ACC_NATIVE) == Opcodes.ACC_NATIVE) || className
					.contains("cn.org.javaweb.iast")) {
				System.out.println(
						"Propagator Process Skip  类名:" + className + ",方法名: " + name + "方法的描述符是：" + desc);
			} else {
				System.out
						.println("Propagator Process 类名:" + className + ",方法名: " + name + "方法的描述符是：" + desc);
				return new AdviceAdapter(Opcodes.ASM5, mv, access, name, desc) {
					@Override
					protected void onMethodEnter() {
						loadArgArray();
						int argsIndex = newLocal(argsType);
						storeLocal(argsIndex, argsType);
						loadLocal(argsIndex);
						push(className);
						push(name);
						push(desc);
						push(isStatic);

						mv.visitMethodInsn(INVOKESTATIC, "cn/org/javaweb/iast/core/Propagator",
								"enterPropagator",
								"([Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V",
								false);
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
						mv.visitMethodInsn(INVOKESTATIC, "cn/org/javaweb/iast/core/Propagator",
								"leavePropagator",
								"(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V",
								false);
						super.onMethodExit(opcode);
					}
				};
			}
		}
		return mv;
	}
}


