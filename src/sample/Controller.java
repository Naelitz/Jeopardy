package sample;

public class Controller
{
    String[][] questions;
    String[][] answers;
    String[][] points;

    int rows = 0;
    int columns = 0;
    String[] categories;

    Controller()
    {
        questions = new String[rows][columns];
        categories = new String[columns];
        answers = new String[rows][columns];
        points = new String[rows][columns];

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
        categories = new String[rows];
        answers = new String[rows][columns];
        points = new String[rows][columns];
    }



}
