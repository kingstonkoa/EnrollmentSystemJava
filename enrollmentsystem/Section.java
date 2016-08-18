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
public class Section
{
    private String code;
    private String section;
    private String capacity;
    private String day;
    private String startHour;
    private String startMinute;
    private String endHour;
    private String endMinute;
    private String enrolledCount;

    public Section(String code, String section, String capacity, String day, String startHour, String startMinute, String endHour, String endMinute, String enrolledCount)
    {
        this.code = code;
        this.section = section;
        this.capacity = capacity;
        this.day = day;
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.endHour = endHour;
        this.endMinute = endMinute;
        this.enrolledCount = enrolledCount;
    }

    public String getEnrolledCount()
    {
        return enrolledCount;
    }

    public void setEnrolledCount(String enrolledCount)
    {
        this.enrolledCount = enrolledCount;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getSection()
    {
        return section;
    }

    public void setSection(String section)
    {
        this.section = section;
    }

    public String getCapacity()
    {
        return capacity;
    }

    public void setCapacity(String capacity)
    {
        this.capacity = capacity;
    }

    public String getDay()
    {
        return day;
    }

    public void setDay(String day)
    {
        this.day = day;
    }

    public String getStartHour()
    {
        return startHour;
    }

    public void setStartHour(String startHour)
    {
        this.startHour = startHour;
    }

    public String getStartMinute()
    {
        return startMinute;
    }

    public void setStartMinute(String startMinute)
    {
        this.startMinute = startMinute;
    }

    public String getEndHour()
    {
        return endHour;
    }

    public void setEndHour(String endHour)
    {
        this.endHour = endHour;
    }

    public String getEndMinute()
    {
        return endMinute;
    }

    public void setEndMinute(String endMinute)
    {
        this.endMinute = endMinute;
    }
    
    
    
}
