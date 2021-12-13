/*
 * Copyright yz 2016-05-25 Email:admin@javaweb.org.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.org.javaweb.test.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yz on 2016-05-25.
 */
public class TestAction extends ActionSupport {

	private ActionContext context = ActionContext.getContext();

	private HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);


	@Override
	public String execute() {
		System.out.println(request.getParameter("id"));
		return SUCCESS;
	}

}
