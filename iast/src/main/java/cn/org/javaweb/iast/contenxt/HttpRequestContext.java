package cn.org.javaweb.iast.contenxt;

import cn.org.javaweb.iast.http.IASTServletRequest;
import cn.org.javaweb.iast.http.IASTServletResponse;

import java.util.LinkedList;

/**
 * @author iiusky - 03sec.com
 */
public class HttpRequestContext {

	private final IASTServletRequest servletRequest;

	private final IASTServletResponse servletResponse;

	private LinkedList<CallChain> callChain;

	public HttpRequestContext(IASTServletRequest servletRequest, IASTServletResponse servletResponse) {
		this.servletRequest = servletRequest;
		this.servletResponse = servletResponse;
		this.callChain = new LinkedList<>();
	}


	public IASTServletRequest getServletRequest() {
		return servletRequest;
	}

	public LinkedList<CallChain> getCallChain() {
		return callChain;
	}

	public void addCallChain(CallChain callChain) {
		this.callChain.add(callChain);
	}

}
