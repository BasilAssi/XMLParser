/**
 * Created By: Basil Assi
 * ID Number: 1192308
 * Date: 4/28/2023
 * Time: 4:34 PM
 * Project Name: XMLParser
 */

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Operations {


    public  Document loadDocument() throws IOException, SAXException, ParserConfigurationException {

        String fileName = Constants.FILE_NAME;
        File inputFile = new File(fileName);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(inputFile);
        document.getDocumentElement().normalize();
        return document;
    }


    public  Element findBook(Document doc, String bookId) {
        NodeList books = doc.getElementsByTagName("book");

        Element book = null;



        for (int i = 0; i < books.getLength(); i++) {
            Element currentBook = (Element) books.item(i);

            if (currentBook.getAttribute("id").equals(bookId)) {
                System.out.println("The book: " + bookId + " Exist ");
                book = currentBook;
                break;
            }
        }
        return book;
    }


    public  Book extrackInfo(Element book) {

        Book myBook = null;
        if (book != null) {
            String author = book.getElementsByTagName("author").item(0).getTextContent();
            String title = book.getElementsByTagName("title").item(0).getTextContent();
            String genre = book.getElementsByTagName("genre").item(0).getTextContent();
            String price = book.getElementsByTagName("price").item(0).getTextContent();
            String publishDate = book.getElementsByTagName("publish_date").item(0).getTextContent();
            String description = book.getElementsByTagName("description").item(0).getTextContent();

            myBook = new Book(Main.bookId, author, title, genre, Double.valueOf(price), publishDate, description);
        }
        return myBook;


    }

    public  void printInfo(Book book) {
        if (book != null) {
            System.out.println(book.toString());
        } else {
            System.out.println("Book with ID " + Main.bookId + " not found.");
        }

    }
}