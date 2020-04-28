package com.peoplestrong.mylibrary.FieldElements.WebsiteElement;

import android.database.Cursor;
import android.provider.ContactsContract;
import com.peoplestrong.Abstracts.ElementParent;
import com.peoplestrong.mylibrary.Utilities.Utilities;
import com.google.gson.annotations.Expose;

public class WebsiteElement extends ElementParent
{
    @Expose
    private String website = "";
    @Expose
    private final String elementType;
    public static final String column = ContactsContract.CommonDataKinds.Website.URL;
    public static final String mime = ContactsContract.CommonDataKinds.Website.URL;

    public WebsiteElement(Cursor cursor)
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
        return website;
    }
    @Override
    public void setValue(Cursor cursor)
    {
        if (cursor==null)
        {
            return;
        }

        website = Utilities.getColumnIndex(cursor, column);

        if (website == null)
        {
            website = "";
        }
    }

}