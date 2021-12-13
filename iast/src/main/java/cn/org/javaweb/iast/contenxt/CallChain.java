package cn.org.javaweb.iast.contenxt;

/**
 * @author iiusky - 03sec.com
 */
public class CallChain {

	/**
	 * 链路类型
	 */
	private String chainType;

	/**
	 * 返回结果对象
	 */
	private Object returnObject;

	/**
	 * 参数数组对象
	 */
	private Object[] argumentArray;

	/**
	 * java类名
	 */
	private String javaClassName;

	/**
	 * java方法名
	 */
	private String javaMethodName;

	/**
	 * java方法描述符
	 */
	private String javaMethodDesc;

	/**
	 * 方法是否为静态方法
	 */
	private boolean isStatic;

	//	调用堆栈 StackTrace
	public StackTraceElement[] StackTraceElement;

	public String getChainType() {
		return chainType;
	}

	public void setChainType(String chainType) {
		this.chainType = chainType;
	}

	public Object getReturnObject() {
		return returnObject;
	}

	public void setReturnObject(Object returnObject) {
		this.returnObject = returnObject;
	}

	public Object[] getArgumentArray() {
		return argumentArray;
	}

	public void setArgumentArray(Object[] argumentArray) {
		this.argumentArray = argumentArray;
	}

	public String getJavaClassName() {
		return javaClassName;
	}

	public void setJavaClassName(String javaClassName) {
		this.javaClassName = javaClassName;
	}

	public String getJavaMethodName() {
		return javaMethodName;
	}

	public void setJavaMethodName(String javaMethodName) {
		this.javaMethodName = javaMethodName;
	}

	public String getJavaMethodDesc() {
		return javaMethodDesc;
	}

	public void setJavaMethodDesc(String javaMethodDesc) {
		this.javaMethodDesc = javaMethodDesc;
	}

	public boolean isStatic() {
		return isStatic;
	}

	public void setStatic(boolean aStatic) {
		isStatic = aStatic;
	}

	public StackTraceElement[] getStackTraceElement() {
		return StackTraceElement;
	}

	public void setStackTraceElement(StackTraceElement[] setStackTraceElement) {
		this.StackTraceElement = setStackTraceElement;
	}
}
