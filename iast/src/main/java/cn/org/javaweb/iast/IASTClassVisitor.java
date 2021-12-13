package cn.org.javaweb.iast;

import cn.org.javaweb.iast.visitor.handler.HttpClassVisitorHandler;
import cn.org.javaweb.iast.visitor.handler.PropagatorClassVisitorHandler;
import cn.org.javaweb.iast.visitor.handler.SinkClassVisitorHandler;
import cn.org.javaweb.iast.visitor.handler.SourceClassVisitorHandler;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;


/**
 * @author iiusky - 03sec.com
 */
public class IASTClassVisitor extends ClassVisitor implements Opcodes {

	private final String className;

	public IASTClassVisitor(String className, ClassVisitor cv) {
		super(Opcodes.ASM5, cv);
		this.className = className;
	}

	@Override
	public MethodVisitor visitMethod(final int access, final String name, final String desc, final String signature, String[] exceptions) {
		MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);

		// 处理request、response相关的hook
		HttpClassVisitorHandler httpClassVisitorHandler = new HttpClassVisitorHandler();
		mv = httpClassVisitorHandler.ClassVisitorHandler(mv, className, access, name, desc, signature, exceptions);

		// 处理request中各种get相关的hook
		SourceClassVisitorHandler sourceClassVisitorHandler = new SourceClassVisitorHandler();
		mv = sourceClassVisitorHandler.ClassVisitorHandler(mv, className, access, name, desc, signature, exceptions);

		// 处理中间传播者相关hook
		PropagatorClassVisitorHandler propagatorClassVisitorHandler = new PropagatorClassVisitorHandler();
		mv = propagatorClassVisitorHandler.ClassVisitorHandler(mv, className, access, name, desc, signature, exceptions);

		// 处理最终sink点相关的hook
		SinkClassVisitorHandler sinkClassVisitorHandler = new SinkClassVisitorHandler();
		mv = sinkClassVisitorHandler.ClassVisitorHandler(mv, className, access, name, desc, signature, exceptions);

		return mv;
	}
}


