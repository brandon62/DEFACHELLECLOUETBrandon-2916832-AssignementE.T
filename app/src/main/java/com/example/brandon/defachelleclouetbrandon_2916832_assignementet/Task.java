package com.example.brandon.defachelleclouetbrandon_2916832_assignementet;

/**
 * Created by english on 09/03/2016.
 */
public class Task
{
    private String name;
    private boolean terminated;
    public Task(String name)
    {
        name = this.name;
        terminated = false;
    }

    public String getName()
    {
        return name;
    }
    public boolean IsTerminated()
    {
        return terminated;
    }


    public void setName(String name)
    {
        this.name = name;
    }
    public void setState(boolean terminated)
    {
        this.terminated = terminated;
    }

}
