package chapter7;

import org.w3c.dom.xpath.XPathResult;

public class ch7_25 {
    public static void main(String[] args) {
        Parseable25 p=ParserManager25.getParser("XML");
        p.parse("document.xml");
        p=ParserManager25.getParser("HTML");
        p.parse("document.html`");

    }
}
interface Parseable25{
    public abstract void parse(String fileName);
}
class ParserManager25{
    public static  Parseable25 getParser(String type){
        if (type.equalsIgnoreCase("xml")){
            return new XMLParser25();
        }else{
            Parseable25 p=new HTMLParser25();
            return p;
        }
    }
}
class XMLParser25 implements Parseable25{

    public void parse(String fileName) {
        System.out.println(fileName+"---XML parsing completed");

    }
}
class HTMLParser25 implements Parseable25{

    public void parse(String fileName) {
        System.out.println(fileName+"---HTML parsing completed");

    }
}
