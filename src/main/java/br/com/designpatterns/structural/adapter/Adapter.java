package br.com.designpatterns.structural.adapter;

/**
 *
 *  Especifica que deve-se criar uma classe para converter a interface de uma classe em outra.
 *
 *  Specifies that a class must be created to convert the interface of one class to another.
 */

interface XML {                                             //Interface que irá receber a conversão
    void getXML();
}

class XMLFile implements XML {

    String xml;

    public XMLFile(String xml){
        this.xml = xml;
    }

    public void getXML(){
        System.out.println(xml);
    }
}

interface JSON {                                            //Interface a ser convertida
    void getJSON();
}

class JSONFile implements JSON {

    String json;

    public JSONFile(String json){
        this.json = json;
    }

    public void getJSON(){
        System.out.println(json);
    }

}

class JsonToXMLAdapter implements XML{                      //Classe que irá converter

    String json;

    public JsonToXMLAdapter(String json){
        this.json = json;
    }

    public void getXML(){
        String xml = json.concat(" converted to XML");  //Convertendo interface JSON para interface XML
        new XMLFile(xml);
    }

}

public class Adapter {

    public static void main(String[] args){

        new JsonToXMLAdapter("JSON").getXML();
    }

}
