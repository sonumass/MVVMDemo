package com.peoplestrong.mylibrary.FieldElements.NameElements;

import android.database.Cursor;
import android.provider.ContactsContract;

import com.google.gson.annotations.Expose;

import com.peoplestrong.Abstracts.ElementParent;
import com.peoplestrong.mylibrary.Utilities.Utilities;

public class LastNameElement extends ElementParent
{
    @Expose
    private String lastName = "";
    @Expose
    private final String elementType;
    public static final String column = ContactsContract.CommonDataKinds.StructuredName.FAMILY_NAME;
    public static final String mime = ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE;

    public LastNameElement(Cursor cursor)
    {
        elementType = getClass().getSimpleName();
        setValue(cursor);
    }

    @Override
    public String getElementType()
    {
        return elementType;
    }
    @Override
    public String getValue() {

        if (lastName==null)
        {
            lastName="";
        }
        return lastName;
    }
    @Override
    public void setValue(Cursor cursor)
    {
        if (cursor==null)
        {
            return;
        }

        lastName = Utilities.getColumnIndex(cursor, column);

        if (lastName == null)
        {
            lastName = "";
        }
    }

    public interface ILastNameElement
    {
        String getLastName();
    }

}