package com.peoplestrong.mylibrary.FieldElements.NameElements;

import android.database.Cursor;
import android.provider.ContactsContract;

import com.google.gson.annotations.Expose;

import com.peoplestrong.mylibrary.Abstracts.ElementParent;
import com.peoplestrong.mylibrary.Utilities.Utilities;

public class FirstNameElement extends ElementParent
{
    @Expose
    private String firstName = "";
    @Expose
    private final String elementType;
    public static final String column = ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME;
    public static final String mime = ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE;

    public FirstNameElement(Cursor cursor) {
        elementType = getClass().getSimpleName();
        setValue(cursor);
    }

    @Override
    public String getElementType() {
        return elementType;
    }
    @Override
    public String getValue() { return firstName;  }
    @Override
    public void setValue(Cursor cursor)
    {
        if (cursor==null)
        {
            return;
        }

        firstName = Utilities.getColumnIndex(cursor, column);

        if (firstName == null)
        {
            firstName = "";
        }
    }

    public interface IFirstNameElement
    {
        String getFirstName();
    }

}
