package com.example.plugins.service.impl;

import com.example.plugins.service.base.EmployeeServiceBaseImpl;

/**
 * The implementation of the employee remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.example.plugins.service.EmployeeService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.example.plugins.service.base.EmployeeServiceBaseImpl
 * @see com.example.plugins.service.EmployeeServiceUtil
 */
public class EmployeeServiceImpl extends EmployeeServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.example.plugins.service.EmployeeServiceUtil} to access the employee remote service.
     */
}
