package com.example.SpringServer.templateData;

import com.example.SpringServer.entity.Place;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.LinkedList;
import java.util.List;

public abstract class ParcerAbstractTemplate {
    static String url;
    static String docSelect;
    static String elemSelect;
    public abstract List<Place> getParse();
}
