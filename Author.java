package ro.uvt.sabloane;

public class Author {
    private final String name_;

    public Author(String name)
    {
        name_ = name;
    }

    @Override
    public String toString()
    {
        return name_;
    }

}
