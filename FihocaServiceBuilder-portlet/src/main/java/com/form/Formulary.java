package com.form;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.example.plugins.model.Employee;
import com.example.plugins.model.impl.EmployeeImpl;
import com.example.plugins.service.EmployeeLocalServiceUtil;


/**
 * Portlet implementation class Formulary
 */
public class Formulary extends MVCPortlet {

    public void init() {
        viewTemplate = getInitParameter("view-template");
    }

    public void doView(
            RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {

        include(viewTemplate, renderRequest, renderResponse);
    }
    

    public void AddEmployee(ActionRequest request, ActionResponse response ) throws IOException, PortletException {
    	try {
    		Employee employee = new EmployeeImpl();
    		employee.setName((String) request.getParameter("name"));
    		employee.setAddress((String) request.getParameter("address"));
    		
				employee.setEid((int)CounterLocalServiceUtil.increment());
			
    		EmployeeLocalServiceUtil.addEmployee(employee);
    		System.out.println(employee.getAddress());
    	}catch (SystemException e) {
			
			e.printStackTrace(); 
		}
    		
    	
  
    	
}

    protected void include(
            String path, RenderRequest renderRequest,
            RenderResponse renderResponse)
        throws IOException, PortletException {

        PortletRequestDispatcher portletRequestDispatcher =
            getPortletContext().getRequestDispatcher(path);

        if (portletRequestDispatcher == null) {
            _log.error(path + " is not a valid include");
        }
        else {
            portletRequestDispatcher.include(renderRequest, renderResponse);
        }
    }
 
    protected String viewTemplate;

    private static Log _log = LogFactoryUtil.getLog(Formulary.class);

}
