package com.example.plugins.model.impl;

import com.example.plugins.model.Employee;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Employee in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Employee
 * @generated
 */
public class EmployeeCacheModel implements CacheModel<Employee>, Externalizable {
    public int eid;
    public String name;
    public String address;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{eid=");
        sb.append(eid);
        sb.append(", name=");
        sb.append(name);
        sb.append(", address=");
        sb.append(address);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Employee toEntityModel() {
        EmployeeImpl employeeImpl = new EmployeeImpl();

        employeeImpl.setEid(eid);

        if (name == null) {
            employeeImpl.setName(StringPool.BLANK);
        } else {
            employeeImpl.setName(name);
        }

        if (address == null) {
            employeeImpl.setAddress(StringPool.BLANK);
        } else {
            employeeImpl.setAddress(address);
        }

        employeeImpl.resetOriginalValues();

        return employeeImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        eid = objectInput.readInt();
        name = objectInput.readUTF();
        address = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeInt(eid);

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        if (address == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(address);
        }
    }
}
