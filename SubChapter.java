package ro.uvt.sabloane;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class SubChapter {
    private String name_;
    private Collection<Element> content_ = new LinkedList<>();
    //private Collection<Image> images_ = new LinkedList<>();
    //private Collection<Paragraph> paragraphs_ = new LinkedList<>();
    //private Collection<Table> tables_ = new LinkedList<>();

    public SubChapter(String name) { name_ = name; }

    public SubChapter(SubChapter subChapter)
    {
        name_ = subChapter.name_;
        //images_ = new LinkedList<>(subChapter.images_);
        //paragraphs_ = new LinkedList<>(subChapter.paragraphs_);
        //tables_ = new LinkedList<>(subChapter.tables_);
        content_ = new LinkedList<>(subChapter.content_);
    }

    // Add / Remove image
    public boolean createNewImage(String imageName)
    {
        return content_.add(new Image(imageName));
    }

    public boolean createNewImage(Image image)
    {
        return content_.add(new Image(image));
    }

    public boolean removeImage(String imageName)
    {
        for (Element image : content_)
        {
            if (image instanceof Image && ((Image)image).getImageName().equalsIgnoreCase(imageName))
            {
                return content_.remove(image);
            }
        }

        return false;
    }

    public boolean removeImage(Image image)
    {
        for (Element imageTmp : content_)
        {
            if (imageTmp instanceof Image && image.equals(imageTmp))
            {
                return content_.remove(imageTmp);
            }
        }

        return false;
    }

    // Add / Remove paragraph
    public boolean createNewParagraph(String paragraphName)
    {
        return content_.add(new Paragraph(paragraphName));
    }

    public boolean createNewParagraph(Paragraph paragraph)
    {
        return content_.add(new Paragraph(paragraph));
    }

    public boolean removeParagraph(String paragraphName)
    {
        for (Element paragraph : content_)
        {
            if (paragraph instanceof Paragraph && ((Paragraph)paragraph).getText().equalsIgnoreCase(paragraphName))
            {
                return content_.remove(paragraph);
            }
        }

        return false;
    }

    public boolean removeParagraph(Paragraph paragraph)
    {
        for (Element paragraphTmp : content_)
        {
            if (paragraphTmp instanceof Paragraph && paragraph.equals(paragraphTmp))
            {
                return content_.remove(paragraphTmp);
            }
        }

        return false;
    }

    // Add / Remove table
    public boolean createNewTable(String tableName)
    {
        return content_.add(new Table(tableName));
    }

    public boolean createNewTable(Table table)
    {
        return content_.add(new Table(table));
    }

    public boolean removeTable(String tableName)
    {
        for (Element table : content_)
        {
            if (table instanceof Table && ((Table)table).getTitle().equalsIgnoreCase(tableName))
            {
                return content_.remove(table);
            }
        }

        return false;
    }

    public boolean removeTable(Table table)
    {
        for (Element tableTmp : content_)
        {
            if (tableTmp instanceof Table && table.equals(tableTmp))
            {
                return content_.remove(tableTmp);
            }
        }

        return false;
    }

    public String getSubChapterName() { return name_; }

    public Collection<Image> getImages()
    {
        Collection<Image> images = new LinkedList<>();

        for (Element element : content_)
        {
            if (element instanceof Image)
            {
                images.add((Image)element);
            }
        }

        return Collections.unmodifiableCollection(images);
    }

    public Collection<Paragraph> getParagraphs()
    {
        Collection<Paragraph> paragraphs = new LinkedList<>();

        for (Element element : content_)
        {
            if (element instanceof Paragraph)
            {
                paragraphs.add((Paragraph)element);
            }
        }

        return Collections.unmodifiableCollection(paragraphs);
    }

    public Collection<Table> getTables()
    {
        Collection<Table> tables = new LinkedList<>();

        for (Element element : content_)
        {
            if (element instanceof Table)
            {
                tables.add((Table)element);
            }
        }

        return Collections.unmodifiableCollection(tables);
    }

    public void print()
    {
        System.out.print(this);
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

        return name_.equalsIgnoreCase(((SubChapter)subChapter).name_) && compareList(content_, ((SubChapter)subChapter).content_);
                //compareList(tables_, ((SubChapter)subChapter).tables_) && compareList(paragraphs_, ((SubChapter)subChapter).paragraphs_);
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
        for (Element element : content_)
        {
            tmp = counter + ". " + element.toString() + '\n';
            content.append(tmp);
            counter++;
        }

        if (content_.size() != 0)
            content.append('\n');

        return content.toString();
    }
}
