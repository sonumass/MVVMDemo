package com.peoplestrong.mylibrary.FieldElements.EmailElements;

import android.database.Cursor;
import android.provider.ContactsContract;

import com.google.gson.annotations.Expose;

import com.peoplestrong.Abstracts.ElementParent;
import com.peoplestrong.mylibrary.Utilities.Utilities;

public class EmailElement extends ElementParent
{
    @Expose
    private String email = "";
    @Expose
    private final String elementType;
    public static final String column = ContactsContract.CommonDataKinds.Email.ADDRESS;
    public static final String mime = ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE;

    public EmailElement(Cursor cursor)
    {
        elementType = this.getClass().getSimpleName();
        setValue(cursor);
    }
    @Override
    public String getElementType()
    {
        return elementType;
    }
    @Override
    public String getValue() {
        return email;
    }
    @Override
    public void setValue(Cursor cursor)
    {
        if (cursor==null)
        {
            return;
        }

        email = Utilities.getColumnIndex(cursor, column);

        if (email == null)
        {
            email = "";
        }
    }

}