package com.peoplestrong.mylibrary.Contact;

import android.database.Cursor;
import com.peoplestrong.mylibrary.ElementContainers.NoteContainer;
import com.peoplestrong.mylibrary.FieldContainer.FieldsContainer;
import com.peoplestrong.mylibrary.ElementContainers.AddressContainer;
import com.peoplestrong.mylibrary.ElementContainers.EmailContainer;
import com.peoplestrong.mylibrary.ElementContainers.EventContainer;
import com.peoplestrong.mylibrary.ElementContainers.NickNameContainer;
import com.peoplestrong.mylibrary.ElementContainers.NumberContainer;
import com.peoplestrong.mylibrary.ElementContainers.WebsiteContainer;
import com.google.gson.annotations.Expose;

import java.util.LinkedList;

public class Contact implements FieldsContainer.IFieldContainer
{
    @Expose
    private final long id;
    @Expose
    private String  photoUri;
    @Expose
    private FieldsContainer fields;

    public Contact(long id)
    {
        this.id = id;
    }

    public String getPhotoUri() {
        return photoUri;
    }

    public void setPhotoUri(String photoUri)
    {
        if (photoUri==null)
        {
            photoUri = "";
        }

        this.photoUri = photoUri;
    }

    public void execute(Cursor mime, String cursor)
    {
        if (fields==null)
        {
            fields = new FieldsContainer();
        }

        fields.execute(cursor, mime);
    }

    public long getId() {
        return id;
    }

    /** Contact Displayd Name
     *
     */
    @Override
    public String getDisplaydName()
    {
        if(fields==null){return "";}

        if (fields.getNameField()==null){return "";}

        if(fields.getNameField().getDisplaydName()==null){return "";}

        return fields.getNameField().getDisplaydName();
    }

    /** Contact First Name
     *
     */
    @Override
    public String getFirstName()
    {
        if(fields==null){return "";}

        if (fields.getNameField()==null){return "";}

        if(fields.getNameField().getFirstName()==null){return "";}

        return fields.getNameField().getFirstName();
    }

    /** Contact Last Name
     *
     */
    @Override
    public String getLastName()
    {
        if(fields==null){return "";}

        if (fields.getNameField()==null){return "";}

        if(fields.getNameField().getLastName()==null){return "";}

        return fields.getNameField().getLastName();
    }

    /** Contact Numbers
     *
     */
    @Override
    public LinkedList<NumberContainer> getNumbers()
    {
        return fields.getNumberField().getNumbers();
    }

    /** Contact Emails
     *
     */
    @Override
    public LinkedList<EmailContainer> getEmails() { return fields.getEmailField().getEmails(); }

    /** Contact Websites
     *
     */
    @Override
    public LinkedList<WebsiteContainer> getWebsites(){ return fields.getWebsiteField().getWebsites(); }

    /** Contact Addresses
     *
     */
    @Override
    public LinkedList<AddressContainer> getAddresses() { return fields.getAddressField().getAddresses(); }

    /** Contact Notes
     *
     */
    @Override
    public LinkedList<NoteContainer> getNotes() { return fields.getNoteField().getNotes(); }

    /** Contact Events
     *
     */
    @Override
    public LinkedList<EventContainer> getEvents() { return fields.getEventField().getEvents(); }

    /** Contact Nicknames
     *
     */
    @Override
    public LinkedList<NickNameContainer> getNickNames() { return fields.getNickNameField().getNickNames(); }



}
