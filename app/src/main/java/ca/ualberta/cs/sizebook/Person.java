package ca.ualberta.cs.sizebook;

import java.io.Serializable;

/**
 * Created by juice on 04/02/17.
 */

public class Person implements Serializable {


    private String personName;
    private String dateInput;
    private String neckCircumference;
    private String bustCircumference;
    private String chestCircumference;
    private String waistCircumference;
    private String hipCircumference;
    private String inseamLength;
    private String personComment;

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getDateInput() {
        return dateInput;
    }

    public void setDateInput(String dateInput) {
        this.dateInput = dateInput;
    }

    public String getNeckCircumference() {
        return neckCircumference;
    }

    public void setNeckCircumference(String neckCircumference) {
        this.neckCircumference = neckCircumference;
    }

    public String getBustCircumference() {
        return bustCircumference;
    }

    public void setBustCircumference(String bustCircumference) {
        this.bustCircumference = bustCircumference;
    }

    public String getChestCircumference() {
        return chestCircumference;
    }

    public void setChestCircumference(String chestCircumference) {
        this.chestCircumference = chestCircumference;
    }

    public String getWaistCircumference() {
        return waistCircumference;
    }

    public void setWaistCircumference(String waistCircumference) {
        this.waistCircumference = waistCircumference;
    }

    public String getHipCircumference() {
        return hipCircumference;
    }

    public void setHipCircumference(String hipCircumference) {
        this.hipCircumference = hipCircumference;
    }

    public String getInseamLength() {
        return inseamLength;
    }

    public void setInseamLength(String inseamLength) {
        this.inseamLength = inseamLength;
    }

    public String getPersonComment() {
        return personComment;
    }

    public void setPersonComment(String personComment) {
        this.personComment = personComment;
    }

    public Person() {
    }

    public String toString(){
        return "Name: " + personName + "\nDate: " + dateInput;
    }
}
