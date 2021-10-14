package ro.uvt.sabloane;

public class Table implements Element{
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

    @Override
    public boolean compareElements(Element object)
    {
        return title_.equalsIgnoreCase(((Table)object).title_);
    }

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

    @Override
    public void print() { System.out.print(this.toString()); }
}
