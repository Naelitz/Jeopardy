package sample;

public class Controller
{
    String[][] questions;
    int rows = 1;
    int columns = 1;

    Controller()
    {
        questions = new String[rows][columns];

    }

    void setRows(int r)
    {
        this.rows = r;
    }

    void setColumns(int c)
    {
        this.columns = c;
    }

    void update(int rows, int columns)
    {
        questions = new String[rows][columns];
    }


}
