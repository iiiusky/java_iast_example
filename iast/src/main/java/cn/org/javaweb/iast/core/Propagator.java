package cn.org.javaweb.iast.core;

import cn.org.javaweb.iast.contenxt.CallChain;
import cn.org.javaweb.iast.contenxt.RequestContext;

import static cn.org.javaweb.iast.core.Http.haveEnterHttp;

/**
 * @author iiusky - 03sec.com
 */
public class Propagator {

	/**
	 * 进入Propagator点
	 *
	 * @param argumentArray  参数数组
	 * @param javaClassName  类名
	 * @param javaMethodName 方法名
	 * @param javaMethodDesc 方法描述符
	 * @param isStatic       是否为静态方法
	 */
	public static void enterPropagator(Object[] argumentArray,
	                                   String javaClassName,
	                                   String javaMethodName,
	                                   String javaMethodDesc,
	                                   boolean isStatic) {
		if (haveEnterHttp()) {
			CallChain callChain = new CallChain();
			callChain.setChainType("enterPropagator");
			callChain.setArgumentArray(argumentArray);
			callChain.setJavaClassName(javaClassName);
			callChain.setJavaMethodName(javaMethodName);
			callChain.setJavaMethodDesc(javaMethodDesc);
			callChain.setStatic(isStatic);

			RequestContext.getHttpRequestContextThreadLocal().addCallChain(callChain);
		}

	}

	/**
	 * 离开Propagator点
	 *
	 * @param returnObject   返回值对象
	 * @param javaClassName  类名
	 * @param javaMethodName 方法名
	 * @param javaMethodDesc 方法描述符
	 * @param isStatic       是否为静态方法
	 */
	public static void leavePropagator(Object returnObject,
	                                   String javaClassName,
	                                   String javaMethodName,
	                                   String javaMethodDesc,
	                                   boolean isStatic) {
		if (haveEnterHttp()) {

			CallChain callChain = new CallChain();
			callChain.setChainType("leavePropagator");
			callChain.setReturnObject(returnObject);
			callChain.setJavaClassName(javaClassName);
			callChain.setJavaMethodName(javaMethodName);
			callChain.setJavaMethodDesc(javaMethodDesc);
			callChain.setStatic(isStatic);
			RequestContext.getHttpRequestContextThreadLocal().addCallChain(callChain);

		}
	}
}
