package carrillo.uriel.contactsselectionapplication;

import java.io.Serializable;

/**
 * Created by uriel on 29/11/15.
 */
public class ContactObject implements Serializable  {
    private static final long serialVersionUID=1L;
    private String name;
    private String phone;
    private String website;

    public ContactObject(String name, String phone, String website)
    {
        super();
        this.name=name;
        this.phone=phone;
        this.website=website;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name=name;
    }

    public String getPhone()
    {
        return  this.phone;
    }

    public void setPhone(String phone)
    {
        this.phone=phone;
    }

    public String getWebsite()
    {
        return  this.website;
    }

    public void setWebsite(String website)
    {
        this.website=website;
    }

}
