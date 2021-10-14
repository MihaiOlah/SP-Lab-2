package ro.uvt.sabloane;

public class Image implements Element{
    private String imageName_;

    public Image(String imageName)
    {
        imageName_ = imageName;
    }

    public Image(Image image)
    {
        imageName_ = image.imageName_;
    }

    public String getImageName() {
        return imageName_;
    }

    @Override
    public boolean compareElements(Element object)
    {
        return imageName_.equalsIgnoreCase(((Image)object).imageName_);
    }

    @Override
    public void print() { System.out.print(this.toString()); }

    @Override
    public boolean equals(Object image)
    {
        if (image == this)
            return true;

        if (!(image instanceof Image))
            return false;

        return imageName_.equalsIgnoreCase(((Image)image).imageName_);
    }

    @Override
    public String toString()
    {
        return imageName_;
    }
}
