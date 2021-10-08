package ro.uvt.sabloane;

public class Table {
    private String title_;

    public Table(String title)
    {
        title_ = title;
    }

    public Table(Table table)
    {
        title_ = table.title_;
    }

    public String getTitle()
    {
        return title_;
    }

    public void print() { System.out.print(title_); }

    @Override
    public boolean equals(Object table)
    {
        if (table == this)
            return true;

        if (!(table instanceof Table))
            return false;

        return title_.equalsIgnoreCase(((Table)table).title_);
    }

    @Override
    public String toString()
    {
        return title_;
    }
}
