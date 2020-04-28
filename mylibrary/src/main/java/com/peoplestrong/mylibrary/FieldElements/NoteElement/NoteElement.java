package com.peoplestrong.mylibrary.FieldElements.NoteElement;

import android.database.Cursor;
import android.provider.ContactsContract;

import com.google.gson.annotations.Expose;

import com.peoplestrong.Abstracts.ElementParent;
import com.peoplestrong.mylibrary.Utilities.Utilities;

public class NoteElement extends ElementParent
{
    @Expose
    private String note = "";
    @Expose
    private final String elementType;
    public static final String column = ContactsContract.CommonDataKinds.Note.NOTE;
    public static final String mime = ContactsContract.CommonDataKinds.Note.CONTENT_ITEM_TYPE;

    public NoteElement(Cursor cursor)
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
        return note;
    }
    @Override
    public void setValue(Cursor cursor)
    {
        if (cursor==null)
        {
            return;
        }

        note = Utilities.getColumnIndex(cursor, column);

        if (note == null)
        {
            note = "";
        }
    }
}

