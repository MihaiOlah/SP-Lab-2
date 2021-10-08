package ro.uvt.sabloane;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class SubChapter {
    private String name_;
    private Collection<Image> images_ = new LinkedList<>();
    private Collection<Paragraph> paragraphs_ = new LinkedList<>();
    private Collection<Table> tables_ = new LinkedList<>();

    public SubChapter(String name) { name_ = name; }

    public SubChapter(SubChapter subChapter)
    {
        name_ = subChapter.name_;
        images_ = new LinkedList<>(subChapter.images_);
        paragraphs_ = new LinkedList<>(subChapter.paragraphs_);
        tables_ = new LinkedList<>(subChapter.tables_);
    }

    // Add / Remove image
    public boolean createNewImage(String imageName)
    {
        return images_.add(new Image(imageName));
    }

    public boolean createNewImage(Image image)
    {
        return images_.add(new Image(image));
    }

    public boolean removeImage(String imageName)
    {
        for (Image image : images_)
        {
            if (image.getImageName().equalsIgnoreCase(imageName))
            {
                return images_.remove(image);
            }
        }

        return false;
    }

    public boolean removeImage(Image image)
    {
        for (Image imageTmp : images_)
        {
            if (image.equals(imageTmp))
            {
                return images_.remove(imageTmp);
            }
        }

        return false;
    }

    // Add / Remove paragraph
    public boolean createNewParagraph(String paragraphName)
    {
        return paragraphs_.add(new Paragraph(paragraphName));
    }

    public boolean createNewParagraph(Paragraph paragraph)
    {
        return paragraphs_.add(new Paragraph(paragraph));
    }

    public boolean removeParagraph(String paragraphName)
    {
        for (Paragraph paragraph : paragraphs_)
        {
            if (paragraph.getText().equalsIgnoreCase(paragraphName))
            {
                return paragraphs_.remove(paragraph);
            }
        }

        return false;
    }

    public boolean removeParagraph(Paragraph paragraph)
    {
        for (Paragraph paragraphTmp : paragraphs_)
        {
            if (paragraph.equals(paragraphTmp))
            {
                return paragraphs_.remove(paragraphTmp);
            }
        }

        return false;
    }

    // Add / Remove table
    public boolean createNewTable(String tableName)
    {
        return tables_.add(new Table(tableName));
    }

    public boolean createNewTable(Table table)
    {
        return tables_.add(new Table(table));
    }

    public boolean removeTable(String tableName)
    {
        for (Table table : tables_)
        {
            if (table.getTitle().equalsIgnoreCase(tableName))
            {
                return tables_.remove(table);
            }
        }

        return false;
    }

    public boolean removeTable(Table table)
    {
        for (Table tableTmp : tables_)
        {
            if (table.equals(tableTmp))
            {
                return tables_.remove(tableTmp);
            }
        }

        return false;
    }

    public String getSubChapterName() { return name_; }

    public Collection<Image> getImages() { return Collections.unmodifiableCollection(images_); }

    public Collection<Paragraph> getParagraphs() { return Collections.unmodifiableCollection(paragraphs_); }

    public Collection<Table> getTables() { return Collections.unmodifiableCollection(tables_); }

    public void print()
    {
        String tmp;
        int counter;

        System.out.print(name_ + '\n');

        // Add images
        System.out.print("Images:\n");
        counter = 1;
        for (Image image : images_)
        {
            System.out.print(counter + ". " + image.toString() + '\n');
            counter++;
        }

        if (images_.size() != 0)
            System.out.print('\n');

        // Add paragraphs
        counter = 1;
        System.out.print("Paragraphs:\n");
        for (Paragraph paragraph : paragraphs_)
        {
            System.out.print(counter + ". " + paragraph.toString() + '\n');
            counter++;
        }

        if (paragraphs_.size() != 0)
            System.out.print('\n');

        // Add tables
        counter = 1;
        System.out.print("Tables:\n");
        for (Table table : tables_)
        {
            System.out.print(counter + ". " + table.toString() + '\n');
            counter++;
        }

        if (tables_.size() != 0)
            System.out.print('\n');
    }

    private <T> boolean containsObject(Collection<T> list, T object)
    {
        for (T iterator : list)
        {
            if (object.equals(iterator))
                return true;
        }

        return false;
    }

    private <T> boolean checkCollectionSubsetOfAnother(Collection<T> collection_1, Collection<T> collection_2)
    {
        for (T obj : collection_1)
        {
            if (!containsObject(collection_2, obj))
            {
                return false;
            }
        }

        return true;
    }

    // Compare the contents of two collections
    private <T> boolean compareList(Collection<T> collection_1, Collection<T> collection_2)
    {
        return collection_1.size() == collection_2.size() && checkCollectionSubsetOfAnother(collection_1, collection_2)
                && checkCollectionSubsetOfAnother(collection_2, collection_1);
    }

    @Override
    public boolean equals(Object subChapter)
    {
        if (subChapter == this)
            return true;

        if (!(subChapter instanceof SubChapter))
            return false;

        return name_.equalsIgnoreCase(((SubChapter)subChapter).name_) && compareList(images_, ((SubChapter)subChapter).images_) &&
                compareList(tables_, ((SubChapter)subChapter).tables_) && compareList(paragraphs_, ((SubChapter)subChapter).paragraphs_);
    }

    @Override
    public String toString()
    {
        StringBuilder content = new StringBuilder();
        String tmp;
        int counter;

        tmp = name_ + '\n';
        content.append(tmp);

        // Add images
        counter = 1;
        content.append("Images:\n");
        for (Image image : images_)
        {
            tmp = counter + ". " + image.toString() + '\n';
            content.append(tmp);
            counter++;
        }

        if (images_.size() != 0)
            content.append('\n');

        // Add paragraphs
        counter = 1;
        content.append("Paragraphs:\n");
        for (Paragraph paragraph : paragraphs_)
        {
            tmp = counter + ". " + paragraph.toString() + '\n';
            content.append(tmp);
            counter++;
        }

        if (paragraphs_.size() != 0)
            content.append('\n');

        // Add tables
        counter = 1;
        content.append("Tables:\n");
        for (Table table : tables_)
        {
            tmp = counter + ". " + table.toString() + '\n';
            content.append(tmp);
            counter++;
        }

        if (tables_.size() != 0)
            content.append('\n');

        return content.toString();
    }
}
