package ro.uvt.sabloane;

public interface Element {
    public void print();

    public boolean compareElements(Element object);

    @Override
    public boolean equals(Object table);

    @Override
    public String toString();
}
