package com.controller;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.example.plugins.model.Employee;
import com.example.plugins.model.impl.EmployeeImpl;
import com.example.plugins.service.EmployeeLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Portlet implementation class PruebaPortlet
 */
public class PruebaPortlet extends GenericPortlet {

	public void init() {
		viewTemplate = getInitParameter("view-template");
	}

	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		Employee employee = new EmployeeImpl();

		employee.setEid(1);

		employee.setName("Aditya");

		employee.setAddress("India");

		try {

			EmployeeLocalServiceUtil.addEmployee(employee);

		} catch (Exception e) {

			throw new PortletException("ERROR ON LOAD DATA");
		}

		include(viewTemplate, renderRequest, renderResponse);
	}

	protected void include(String path, RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		PortletRequestDispatcher portletRequestDispatcher = getPortletContext().getRequestDispatcher(path);

		if (portletRequestDispatcher == null) {
			_log.error(path + " is not a valid include");
		} else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
	}

	protected String viewTemplate;

	private static Log _log = LogFactoryUtil.getLog(PruebaPortlet.class);

}
