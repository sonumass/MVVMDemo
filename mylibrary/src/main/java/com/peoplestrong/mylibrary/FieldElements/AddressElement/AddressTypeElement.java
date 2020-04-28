package com.peoplestrong.mylibrary.FieldElements.AddressElement;

import android.database.Cursor;
import android.provider.ContactsContract;

import com.google.gson.annotations.Expose;

import com.peoplestrong.Abstracts.ElementParent;
import com.peoplestrong.mylibrary.Utilities.Utilities;

public class AddressTypeElement extends ElementParent {
    @Expose
    private String addressType = "";
    @Expose
    private final String elementType;
    public static final String column = ContactsContract.CommonDataKinds.Phone.TYPE;
    public static final String mime = ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE;


    public AddressTypeElement(Cursor cursor) {
        elementType = this.getClass().getSimpleName();
        setValue(cursor);
    }

    @Override
    public String getValue() {
        return elementType;
    }

    @Override
    public void setValue(Cursor cursor) {
        if (cursor == null) {
            return;
        }

        addressType = Utilities.getAddressType(Utilities.getColumnIndex(cursor, column));

        if (addressType == null) {
            addressType = "OTHER";
        }
    }

    @Override
    public String getElementType()
    {
        return getClass().getSimpleName();
    }
}