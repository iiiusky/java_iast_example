package cn.org.javaweb.iast.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author iiusky - 03sec.com
 */
public class IASTServletRequest {

	private Object request;

	private Class requestClass;

	public IASTServletRequest(Object request) {
		this.request = request;
		this.requestClass = request.getClass();
	}

	public Class getRequestClass() {
		return requestClass;
	}

	public String getHeader(String name) {
		try {
			Method method = requestClass.getMethod("getHeader", String.class);
			method.setAccessible(true);
			return (String) method.invoke(request, name);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Enumeration<String> getHeaders(String name) {
		try {
			Method method = requestClass.getMethod("getHeaders", String.class);
			method.setAccessible(true);
			return (Enumeration) method.invoke(request, name);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Enumeration<String> getHeaderNames() {
		try {
			Method method = requestClass.getMethod("getHeaderNames");
			method.setAccessible(true);
			return (Enumeration) method.invoke(request);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getMethod() {
		try {
			Method method = requestClass.getMethod("getMethod");
			method.setAccessible(true);
			return (String) method.invoke(request);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getContextPath() {
		try {
			Method method = requestClass.getMethod("getContextPath");
			method.setAccessible(true);
			return (String) method.invoke(request);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getQueryString() {
		try {
			Method method = requestClass.getMethod("getQueryString");
			method.setAccessible(true);
			return (String) method.invoke(request);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getRequestedSessionId() {
		try {
			Method method = requestClass.getMethod("getRequestedSessionId");
			method.setAccessible(true);
			return (String) method.invoke(request);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getRequestURI() {
		try {
			Method method = requestClass.getMethod("getRequestURI");
			method.setAccessible(true);
			return (String) method.invoke(request);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public StringBuffer getRequestURL() {
		try {
			Method method = requestClass.getMethod("getRequestURL");
			method.setAccessible(true);
			return (StringBuffer) method.invoke(request);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getServletPath() {
		try {
			Method method = requestClass.getMethod("getServletPath");
			method.setAccessible(true);
			return (String) method.invoke(request);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getCharacterEncoding() {
		try {
			Method method = requestClass.getMethod("getCharacterEncoding");
			method.setAccessible(true);
			return (String) method.invoke(request);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void setCharacterEncoding(String env) throws UnsupportedEncodingException {
		try {
			Method method = requestClass.getMethod("setCharacterEncoding", String.class);
			method.setAccessible(true);
			method.invoke(request, env);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getContentLength() {
		try {
			Method method = requestClass.getMethod("getContentLength");
			method.setAccessible(true);
			return (Integer) method.invoke(request);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public String getContentType() {
		try {
			Method method = requestClass.getMethod("getContentType");
			method.setAccessible(true);
			return (String) method.invoke(request);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getParameter(String name) {
		try {
			Method method = requestClass.getMethod("getParameter", String.class);
			method.setAccessible(true);
			return (String) method.invoke(request, name);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Enumeration<String> getParameterNames() {
		try {
			Method method = requestClass.getMethod("getParameterNames");
			method.setAccessible(true);
			return (Enumeration) method.invoke(request);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String[] getParameterValues(String name) {
		try {
			Method method = requestClass.getMethod("getParameterValues", String.class);
			method.setAccessible(true);
			return (String[]) method.invoke(request, name);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Map<String, String[]> getParameterMap() {
		try {
			Method method = requestClass.getMethod("getParameterMap");
			method.setAccessible(true);
			return (Map) method.invoke(request);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getProtocol() {
		try {
			Method method = requestClass.getMethod("getProtocol");
			method.setAccessible(true);
			return (String) method.invoke(request);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getScheme() {
		try {
			Method method = requestClass.getMethod("getScheme");
			method.setAccessible(true);
			return (String) method.invoke(request);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getServerName() {
		try {
			Method method = requestClass.getMethod("getServerName");
			method.setAccessible(true);
			return (String) method.invoke(request);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int getServerPort() {
		try {
			Method method = requestClass.getMethod("getServerPort");
			method.setAccessible(true);
			return (Integer) method.invoke(request);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public BufferedReader getReader() throws IOException {
		try {
			Method method = requestClass.getMethod("getReader");
			method.setAccessible(true);
			return (BufferedReader) method.invoke(request);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getRemoteAddr() {
		try {
			Method method = requestClass.getMethod("getRemoteAddr");
			method.setAccessible(true);
			return (String) method.invoke(request);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getRemoteHost() {
		try {
			Method method = requestClass.getMethod("getRemoteHost");
			method.setAccessible(true);
			return (String) method.invoke(request);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getRealPath(String path) {
		try {
			Method method = requestClass.getMethod("getRealPath", String.class);
			method.setAccessible(true);
			return (String) method.invoke(request, path);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int getRemotePort() {
		try {
			Method method = requestClass.getMethod("getRemotePort");
			method.setAccessible(true);
			return (Integer) method.invoke(request);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public String getLocalName() {
		try {
			Method method = requestClass.getMethod("getLocalName");
			method.setAccessible(true);
			return (String) method.invoke(request);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getLocalAddr() {
		try {
			Method method = requestClass.getMethod("getLocalAddr");
			method.setAccessible(true);
			return (String) method.invoke(request);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int getLocalPort() {
		try {
			Method method = requestClass.getMethod("getLocalPort");
			method.setAccessible(true);
			return (Integer) method.invoke(request);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
