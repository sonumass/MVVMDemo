package com.peoplestrong.mylibrary.ContactFields;

import android.database.Cursor;
import android.provider.ContactsContract;

import com.google.gson.annotations.Expose;

import java.util.HashSet;
import java.util.Set;

import com.peoplestrong.Abstracts.FieldParent;
import com.peoplestrong.mylibrary.FieldElements.NameElements.DisplaydNameElement;
import com.peoplestrong.mylibrary.FieldElements.NameElements.FirstNameElement;
import com.peoplestrong.mylibrary.FieldElements.NameElements.LastNameElement;
import com.peoplestrong.mylibrary.Utilities.Utilities;

public class NameField extends FieldParent {
    public final String fieldMime = ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE;
    @Expose
    private DisplaydNameElement displaydName;
    @Expose
    private FirstNameElement firstName;
    @Expose
    private LastNameElement lastName;

    public NameField() {
    }

    @Override
    public void execute(String mime, Cursor cursor) {
        if (mime.equals(fieldMime))
        {
            displaydName = new DisplaydNameElement(cursor);
            firstName = new FirstNameElement(cursor);
            lastName = new LastNameElement(cursor);
        }
    }

    @Override
    public Set<String> registerElementsColumns() {
        Set<String> columns = new HashSet<>();
        columns.add(DisplaydNameElement.column);
        columns.add(FirstNameElement.column);
        columns.add(LastNameElement.column);
        return columns;
    }

    public String getDisplaydName()
    {
        String result = Utilities.elementValue(displaydName);
        return result;
    }

    public String getFirstName()
    {
        String result = Utilities.elementValue(firstName);
        return result;
    }

    public String getLastName()
    {
        String result = Utilities.elementValue(lastName);
        return result;
    }

    public interface INameField extends DisplaydNameElement.IDisplaydNameElement, FirstNameElement.IFirstNameElement, LastNameElement.ILastNameElement {

    }

}
