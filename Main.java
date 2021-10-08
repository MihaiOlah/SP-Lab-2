package ro.uvt.sabloane;

import java.util.Collection;

public class Main {
    public static void testSubChapters()
    {
        Paragraph paragraph_1 = new Paragraph("Paragraph 1");
        Paragraph paragraph_2 = new Paragraph("Paragraph 2");
        Paragraph paragraph_3 = new Paragraph("Paragraph 3");

        Image image_1 = new Image("Image 1");
        Image image_2 = new Image("Image 2");
        Image image_3 = new Image("Image 3");

        Table table_1 = new Table("Table 1");
        Table table_2 = new Table("Table 2");
        Table table_3 = new Table("Table 3");

        SubChapter subChapter_1 = new SubChapter("Subchapter 1");
        SubChapter subChapter_2 = new SubChapter("Subchapter 1");

        // Add images
        subChapter_1.createNewImage(image_1);
        subChapter_1.createNewImage(image_2);
        subChapter_1.createNewImage(image_3);

        subChapter_2.createNewImage("Image 3");
        subChapter_2.createNewImage("Image 2");
        subChapter_2.createNewImage("Image 1");

        // Add paragraphs
        subChapter_1.createNewParagraph(paragraph_1);
        subChapter_1.createNewParagraph(paragraph_2);
        subChapter_1.createNewParagraph(paragraph_3);

        subChapter_2.createNewParagraph("Paragraph 2");
        subChapter_2.createNewParagraph("Paragraph 1");
        subChapter_2.createNewParagraph("Paragraph 3");

        // Add Tables
        subChapter_1.createNewTable(table_1);
        subChapter_1.createNewTable(table_2);
        subChapter_1.createNewTable(table_3);

        subChapter_2.createNewTable("Table 1");
        subChapter_2.createNewTable("Table 3");
        subChapter_2.createNewTable("Table 2");

        Chapter chapter_1 = new Chapter("Chapater 1");
        Chapter chapter_2 = new Chapter("Chapater 1");

        chapter_1.addSubChapter(subChapter_1);
        chapter_1.addSubChapter(subChapter_2);

        chapter_2.addSubChapter(subChapter_1);
        chapter_2.addSubChapter(subChapter_1);

        Book book_1 = new Book("Disco Titanic");
        book_1.addChapter(chapter_1);
        book_1.addChapter(chapter_2);

        book_1.print();
    }

    public static void main(String[] args) {
        Book discoTitanic = new Book("Disco Titanic");
        Author rpGheo = new Author("Radu Pavel Gheo");
        discoTitanic.addAuthor(rpGheo);

        Collection<Author> a = discoTitanic.getAuthors();
        discoTitanic.addAuthor(new Author("Ion Marin"));

        int indexChapterOne = discoTitanic.createChapter("Capitolul 1");
        int indexChapterTwo = discoTitanic.createChapter("Capitolul 2");

        // System.out.println(discoTitanic);

        Chapter chp1 = discoTitanic.getChapter(indexChapterOne);
        //System.out.println(chp1);
        //testSubChapters();
        int indexSubChapterOneOne = chp1.createSubChapter("Subcapitolul 1.1");
        SubChapter scOneOne = chp1.getSubChapter(indexSubChapterOneOne);
        scOneOne.createNewParagraph("Paragraph 1");
        scOneOne.createNewParagraph("Paragraph 2");
        scOneOne.createNewParagraph("Paragraph 3");
        scOneOne.createNewImage("Image 1");
        scOneOne.createNewParagraph("Paragraph 4");
        scOneOne.createNewTable("Table 1");
        scOneOne.createNewParagraph("Paragraph 5");

        scOneOne.print();
    }
}
