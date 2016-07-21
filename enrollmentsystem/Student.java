/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollmentsystem;

/**
 *
 * @author John
 */
public class Student
{
    private String idNumber;
    private String password;
    private String lastName;
    private String firstName;
    private int minUnits;
    private int maxUnits;

    public Student(String idNumber, String password, String lastName, String firstName, int minUnits, int maxUnits)
    {
        this.idNumber = idNumber;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.minUnits = minUnits;
        this.maxUnits = maxUnits;
    }

    public String getIdNumber()
    {
        return idNumber;
    }

    public void setIdNumber(String idNumber)
    {
        this.idNumber = idNumber;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public int getMinUnits()
    {
        return minUnits;
    }

    public void setMinUnits(int minUnits)
    {
        this.minUnits = minUnits;
    }

    public int getMaxUnits()
    {
        return maxUnits;
    }

    public void setMaxUnits(int maxUnits)
    {
        this.maxUnits = maxUnits;
    }

   
    
    
}
