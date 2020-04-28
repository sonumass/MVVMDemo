package com.peoplestrong.mylibrary.ElementContainers;

import android.database.Cursor;

import com.google.gson.annotations.Expose;

import java.util.HashSet;
import java.util.Set;

import com.peoplestrong.mylibrary.FieldElements.AddressElement.AddressElement;
import com.peoplestrong.mylibrary.FieldElements.AddressElement.AddressTypeElement;
import com.peoplestrong.mylibrary.Utilities.Utilities;

public class AddressContainer
{
    private transient Cursor cursor;
    @Expose
    private AddressElement address;
    @Expose
    private AddressTypeElement addressType;

    public AddressContainer(Cursor cursor)
    {
        this.cursor = cursor;
        address = new AddressElement(cursor);
        addressType = new AddressTypeElement(cursor);
    }

    public static Set<String> getFieldColumns()
    {
        Set<String> columns = new HashSet<>();
        columns.add(AddressElement.column);
        return columns;
    }

    public String getAddress() {
        String result = Utilities.elementValue(address);
        return result;
    }
    public String getAddressType()
    {
        String result = Utilities.elementValue(addressType);
        return result;
    }

}