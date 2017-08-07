/*
MITUL SAVANI
CSC 210.02
ASSIGNMENT 10
12/09/2016

EMR CLASS 

*/

package studenthealthservices;

public class EMR 
{
    //Creating static variable 'PatientCounter' to keep track of how many patient visit.
    public static int PatientCounter;
    //Creating the private data-fields
    private String dateofbirth;
    private String Name;
    private String reasonforvisit;
    private double bodytemperature;    
    private double heartrate;
    private String diagnosis;
    private String prescribedmedicine;
    
    //NO ARGUMENT-CONSTRUCTOR
    EMR()
    {
        PatientCounter++;       //Incrementing the patient counter
    }
    
    //Constructor that accepts only name and dob
    EMR(String name, String dob)
    {
      Name=name;
      dateofbirth=dob;
      PatientCounter++;         //Incrementing the patient counter
    }
    
    //PARAMETERIZED CONSTRUCTOR
    EMR( String name, String dob,  double btemp, double hrate,String rvisit, String diag, String medicine)
    {
        Name = name;
        dateofbirth=dob;
        bodytemperature=btemp;
        heartrate=hrate;
        reasonforvisit=rvisit;
        diagnosis=diag;
        prescribedmedicine=medicine;
        PatientCounter++;       //Incrementing the patient counter
    }
    
    // Setters method of all DATA-FIELDS
    
    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setReasonfrovisit(String reasonfrovisit) {
        this.reasonforvisit = reasonfrovisit;
    }

    public void setBodytemperature(double bodytemperature) {
        this.bodytemperature = bodytemperature;
    }

    public void setHeartrate(double heartrate) {
        this.heartrate = heartrate;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setPrescribedmedicine(String prescribedmedicine) {
        this.prescribedmedicine = prescribedmedicine;
    }
    
    
    //    Getter method of all DATA-FIELDS.

    public String getDateofbirth() {
        return dateofbirth;
    }

    public String getName() {
        return Name;
    }

    public String getReasonforvisit() {
        return reasonforvisit;
    }

    public double getBodytemperature() {
        return bodytemperature;
    }

    public double getHeartrate() {
        return heartrate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getPrescribedmedicine() {
        return prescribedmedicine;
    }
    //Getter class of patient counter.
    public static int getPatientCounter() {
        return PatientCounter;
    }
    
    //creating redFlags method to check specific heart rate and bosy temperature.
    public boolean redFlags()
    {
        boolean result=false;    //creating and intializing the result of the method as false.
        //checking condition
        if(heartrate<60 || heartrate>100 || bodytemperature<97.3 || bodytemperature>99.1){
           result=true;
        }
        return result;          //returning result.
    }
    
    //toString method that will build a String of all the dataﬁelds of the EMR class
    public String toString() 
    {
        return "EMR{" + "dateofbirth=" + dateofbirth + ", Name=" + Name + ", reasonfrovisit=" + reasonforvisit + ", bodytemperature=" + bodytemperature + ", heartrate=" + heartrate + ", diagnosis=" + diagnosis + ", prescribedmedicine=" + prescribedmedicine + '}';
    }
}
    
