package cn.org.javaweb.iast;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.util.Base64;

/**
 * @author iiusky - 03sec.com
 */
public class Agent {

  public static void premain(String agentArgs, Instrumentation inst)
      throws UnmodifiableClassException {
    inst.addTransformer(new AgentTransform(), true);
    inst.retransformClasses(Runtime.class);
    inst.retransformClasses(Base64.class);
  }
}
