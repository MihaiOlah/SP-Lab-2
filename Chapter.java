package ro.uvt.sabloane;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Chapter {
    private String name_;
    private Collection<SubChapter> subChapters_ = new LinkedList<>();

    public Chapter(String name)
    {
        name_ = name;
    }

    public Chapter(Chapter chapter)
    {
        name_ = chapter.name_;
    }

    public String getChapterName()
    {
        return name_;
    }

    public Collection<SubChapter> getSubChapters() { return Collections.unmodifiableCollection(subChapters_); }

    public boolean addSubChapter(String name) { return subChapters_.add(new SubChapter(name)); }

    public boolean addSubChapter(SubChapter subChapter) { return subChapters_.add(new SubChapter(subChapter)); }

    public int createSubChapter(String name)
    {
        if (subChapters_.add(new SubChapter(name)))
            return subChapters_.size() - 1;
        else
            return -1;
    }

    public int removeSubChapter(String name)
    {
        int index = 0;

        for (SubChapter subChapter : subChapters_)
        {
            if (subChapter.getSubChapterName().equalsIgnoreCase(name))
            {
                subChapters_.remove(subChapter);
                return index;
            }

            index++;
        }

        return -1;
    }

    public SubChapter getSubChapter(int index)
    {
        int tmp = 0;

        for (SubChapter subChapter : subChapters_)
        {
            if (tmp == index)
            {
                return subChapter;
            }

            tmp++;
        }

        return new SubChapter("Index out of range, the subchapter was not found");
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

    public void print()
    {
        int counter;

        System.out.print(name_ + '\n');

        System.out.print("Subchapters:\n");
        counter = 1;
        for (SubChapter subChapter : subChapters_)
        {
            System.out.print(counter + ". " + subChapter.toString());
            counter++;
        }
    }

    @Override
    public boolean equals(Object chapter)
    {
        if (chapter == this)
            return true;

        if (!(chapter instanceof Chapter))
            return false;

        return name_.equalsIgnoreCase(((Chapter)chapter).name_) && compareList(subChapters_, ((Chapter)chapter).subChapters_);
    }

    @Override
    public String toString()
    {
        StringBuilder content = new StringBuilder();
        String tmp;
        int counter;

        tmp = name_ + '\n';
        content.append(tmp);

        tmp = "Subchapters:\n";
        content.append(tmp);
        counter = 1;
        for (SubChapter subChapter : subChapters_)
        {
            tmp = counter + ". " + subChapter.toString();
            content.append(tmp);
            counter++;
        }

        return content.toString();
    }

}
