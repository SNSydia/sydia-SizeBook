package ca.ualberta.cs.sizebook;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by juice on 04/02/17.
 */

public class Person implements Serializable {

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    private String personName;
    private Date dateInput;
    private long neckCircumference;
    private long bustCircumference;
    private long chestCircumference;
    private long waistCircumference;
    private long hipCircumference;
    private long inseamLength;
    private String personComment;

    public Person() {
        this.personName = "Shawn";
    }

    public String getPersonName(){
        return personName;
    }



    public String toString(){
        return personName + "\n" + dateInput;
    }
}
