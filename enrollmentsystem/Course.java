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
public class Course
{
    private String code;
    private String name;
    private String units;

    public Course(String code, String name, String units)
    {
        this.code = code;
        this.name = name;
        this.units = units;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getUnits()
    {
        return units;
    }

    public void setUnits(String units)
    {
        this.units = units;
    }
    
    
}
