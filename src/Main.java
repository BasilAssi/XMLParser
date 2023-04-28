/**
 * Created By: Basil Assi
 * ID Number: 1192308
 * Date: 4/28/2023
 * Time: 4:21 PM
 * Project Name: XMLParser
 */


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static String bookId;


    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter book ID: ");
        bookId = scanner.next();
        Operations operations = new Operations();
        Document document = operations.loadDocument();
        Element bookElement = operations.findBook(document , bookId);
        Book book = operations.extrackInfo(bookElement);
        operations.printInfo(book);
    }


}