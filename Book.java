package ro.uvt.sabloane;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Book {
    private final String title_;
    private Collection<Author> authors_ = new LinkedList<>();
    private Collection<Chapter> chapters_ = new LinkedList<>();

    public Book(String title)
    {
        title_ = title;
    }

    public boolean addAuthor(Author author)
    {
        return authors_.add(author);
    }

    public boolean removeAuthor(Author author) { return  authors_.remove(author); }

    public boolean addChapter(Chapter chapter)
    {
        return chapters_.add(chapter);
    }

    public int createChapter(String chapter_name)
    {
        chapters_.add(new Chapter(chapter_name));
        return chapters_.size() - 1;
    }

    public int removeChapter(String chapter_name)
    {
        int index = 0;

        for (Chapter chapter : chapters_)
        {
            if (chapter.getChapterName().equalsIgnoreCase(chapter_name.toLowerCase()))
            {
                chapters_.remove(chapter);
                return index;
            }

            index++;
        }

        return -1;
    }

    public Collection<Author> getAuthors() { return Collections.unmodifiableCollection(authors_); }

    public Collection<Chapter> getChapters() { return Collections.unmodifiableCollection(chapters_); }

    public Chapter getChapter(int index)
    {
        int tmp = 0;

        for (Chapter chapter : chapters_)
        {
            if (tmp == index)
                return new Chapter(chapter);

            tmp++;
        }

        return new Chapter("Index out of range, the chapter was not found");
    }

    public void print()
    {
        int counter;

        // Add title
        System.out.print("Title: " + title_ + '\n');
        System.out.print("Authors:\n");

        // Add authors
        counter = 1;
        for(Author author : authors_)
        {
            System.out.print(counter + ". " + author.toString() + '\n');
            counter++;
        }

        // Add chapters
        System.out.print("\nChapters:\n");

        for(Chapter chapter : chapters_)
        {
            System.out.print(chapter.toString() + '\n');
            counter++;
        }
    }

    @Override
    public String toString()
    {
        String tmp;
        StringBuilder content = new StringBuilder();
        int counter;

        // Add title
        tmp = "Title: " + title_ + '\n';
        content.append(tmp);
        content.append("Authors:\n");

        // Add authors
        counter = 1;
        for(Author author : authors_)
        {
            tmp = counter + ". " + author.toString() + '\n';
            content.append(tmp);
            counter++;
        }

        // Add chapters
        tmp = "\nChapters:\n";
        content.append(tmp);

        for(Chapter chapter : chapters_)
        {
            tmp =  chapter.toString() + '\n';
            content.append(tmp);
            counter++;
        }

        return content.toString();
    }
}
