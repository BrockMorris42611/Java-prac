public class Variable
{
    private String name;
    private double value;

    public Variable(String s, double val)
    {
        this.name = s;
        this.value = val;
    }

    public String getName()
    {
        return this.name;
    }

    public double getValue()
    {
        return this.value;
    }

    public void setValue(double v)
    {
        this.value = v;
    }

    public String toString()
    {
        return "Key " + this.name + ":Value " + this.value;
    }
}
