package pl.lublin.wsei.java.cwiczenia;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Infografika {
    public String tytul;
    public String adresStrony;
    public String adresGrafiki;
    public String adresMiniaturki;
    public Integer szerokoscjpg;
    public Integer wysokoscjpg;

    public Infografika(String text){
        Pattern pat = Pattern.compile("<title><!\\[CDATA\\[(.*)\\]\\]");
        Matcher m = pat.matcher(text);
        if (m.find())
            tytul = m.group(1);
        else
            tytul = "";
        pat = Pattern.compile("<link>(.*)<\\/link>");
        m = pat.matcher(text);
        if(m.find())
            adresStrony = m.group(1);
            else
                adresStrony = "";


            pat = Pattern.compile("\" width=\"(.*)\" height=(.*)\">");
            m = pat.matcher(text);
            if(m.find()) {
                szerokoscjpg = Integer.parseInt(m.group(1));
            }
            else
                szerokoscjpg = 0;

        pat = Pattern.compile("height=\"(.*)\">");
        m = pat.matcher(text);
        if(m.find()) {
            wysokoscjpg = Integer.parseInt(m.group(1));
        }
        else
            wysokoscjpg = 0;

            pat = Pattern.compile("<media:content url=\"(.*)\" type");
            m = pat.matcher(text);
            if(m.find()) {
                adresGrafiki = m.group(1);
            }
            else
                adresGrafiki="";

        pat = Pattern.compile("<media:thumbnail url=\"(.*)\"");
        m = pat.matcher(text);
        if(m.find()) {
            adresMiniaturki = m.group(1);
        }
        else
            adresMiniaturki="";
    }

}

