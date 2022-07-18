package com.example.parsexmlandjson;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {
    Button json,xml;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        json = findViewById(R.id.json);
        xml = findViewById(R.id.xml);
        txt = findViewById(R.id.text);

        xml.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                try {
                    InputStream is = getAssets().open("city.xml");

                    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dc = documentBuilderFactory.newDocumentBuilder();
                    Document document = dc.parse(is);

                    txt.setText("XML data\n=================");
                    NodeList nodeList = document.getElementsByTagName("place");
                    Node node = nodeList.item(0);
                    if(node.getNodeType() == Node.ELEMENT_NODE){
                        Element element = (Element) node;
                        txt.setText(txt.getText()+"\n City Name : " + getValue("name",element));
                        txt.setText(txt.getText()+"\n Lat : " + getValue("lat",element));
                        txt.setText(txt.getText()+"\n Long : " + getValue("long",element));
                        txt.setText(txt.getText()+"\n Temperature : " + getValue("temp",element));
                        txt.setText(txt.getText()+"\n Humidity : " + getValue("humidity",element));
                        txt.setText(txt.getText() + "\n=================");
                    }

                } catch (IOException | ParserConfigurationException | SAXException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Error parsing XML "+e.getCause(), Toast.LENGTH_LONG).show();
                }
            }
        });

        json.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                try {
                    InputStream is = getAssets().open("city.json");
                    int size = is.available();
                    byte [] buff = new byte[size];
                    is.read(buff);
                    is.close();
                    String js = new String(buff, StandardCharsets.UTF_8);
                    txt.setText("JSON data\n=================");
                    JSONObject jsonObject = new JSONObject(js);
                    txt.setText(txt.getText()+"\nCity name : "+jsonObject.getString("name") + "\nLat : "+jsonObject.getString("lat") + "\nLat : "+jsonObject   .getString("lang") + "\nTemperature : "+jsonObject.getString("temp") + "\nHumidity : "+jsonObject.getString("humidity") + "\n=================");
                    
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    private String getValue(String tag, Element element)
    {
        return
                element.getElementsByTagName(tag).item(0).getChildNodes().item(0).getNodeValue();
    }
}
