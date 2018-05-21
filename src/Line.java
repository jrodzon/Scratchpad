import java.util.Date;

public class Line
{
    private String line;
    private Date date;

    public Line(String line, Date date)
    {
        this.date = date;
        this.line = line;
    }

    public String getLine()
    {
        return line;
    }

    public Date getDate()
    {
        return date;
    }
}