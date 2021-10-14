package ro.uvt.sabloane;

public class Paragraph implements Element{
    private String text_;

    public Paragraph(String text) { text_ = text; }

    public Paragraph(Paragraph paragraph) { text_ = paragraph.text_; }

    public String getText() { return text_; }

    @Override
    public boolean compareElements(Element object)
    {
        return text_.equalsIgnoreCase(((Paragraph)object).text_);
    }

    @Override
    public boolean equals(Object paragraph)
    {
        if (paragraph == this)
            return true;

        if (!(paragraph instanceof Paragraph))
            return false;

        return text_.equalsIgnoreCase(((Paragraph)paragraph).text_);
    }

    @Override
    public String toString()
    {
        return text_;
    }

    @Override
    public void print() { System.out.print(this.toString()); }
}
