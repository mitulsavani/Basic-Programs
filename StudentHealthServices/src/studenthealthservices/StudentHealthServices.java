/*
 Mitul Savani
 CSC 210.02
 Assignment 10
 12/09/2016

STUDENT HEALTH SERVICE CLASS

 */
package studenthealthservices;


public class StudentHealthServices {

    //MAIN CLASS
    public static void main(String[] args) 
    {
      //Patient counter at first
      System.out.println("Number of Patients: "+ EMR.getPatientCounter());
      
      //Creating array of 5 objects of class EMR
      EMR patient[]=new EMR[5];
      
      //Passing patient information to EMR class.  - "parameterized constructor"
      patient[0]=new EMR("Alvin", "12/06/1993", 102, 88, "Dizziness and Fatigue", "Fever", "Rest");
      patient[1]=new EMR("Mitul", "07/20/1996", 104, 74, "Spondylolisthesis", "Lower Back Pain", "Don't Lift");
      patient[2]=new EMR("Dex", "09/16/2002", 91, 66, "Lack of sleep", "Insomnia", "Cognitive Behavioral Therapy");
      patient[3]=new EMR("Laura", "1/1/1960", 99.5, 77, "Headaches", "Bad Diet", "Exercise and Better Diet");
      patient[4]=new EMR("Lawrence", "2/5/1981", 90.2, 66, "Pain in Foot", "Bruised Heel", "Light walking for 3 weeks");
      //Patient counter after creatig the five objects.
      System.out.println("Number of Patients: "+ EMR.getPatientCounter());
      System.out.println();
      
      //Running for loop to print information of 3 patients by calling getter class of DATA-FIELDS
      // 'i' as a loop variable
      for(int i=0; i < patient.length-2; i++)
      {
          System.out.println("**** Patient "+(1+i)+" *****");
          System.out.println();                         //Spacing
          System.out.println("Name                 : "+ patient[i].getName());
          System.out.println("DOB                  : "+ patient[i].getDateofbirth());
          System.out.println("Body Temp            : "+ patient[i].getBodytemperature());
          System.out.println("Heart Rate           : "+ patient[i].getHeartrate());
          System.out.println("Reason For Visit     : "+ patient[i].getReasonforvisit());
          System.out.println("Diagnosis            : "+ patient[i].getDiagnosis());
          System.out.println("Prescribed Medicine  : "+ patient[i].getPrescribedmedicine());
          System.out.println();                         //Spacing
          System.out.println();                         //Spacing
      }
      
      
    }
}
