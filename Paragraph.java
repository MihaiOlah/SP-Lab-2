package ro.uvt.sabloane;

public class Paragraph {
    private String text_;

    public Paragraph(String text) { text_ = text; }

    public Paragraph(Paragraph paragraph) { text_ = paragraph.text_; }

    public String getText() { return text_; }

    public void print() { System.out.print(text_); }

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
}
