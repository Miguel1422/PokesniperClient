package com.mycompany.pokemonraros2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

public class Conexiones {


    public static void main(String[] args) throws ParseException {
        String time = "2016-08-19T00:49:21.000Z";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        format.setTimeZone(TimeZone.getTimeZone("America/Mexico_City"));
        Date date = format.parse(time);
        String nueva = format.format(date);
        System.out.println(date);
        System.out.println(nueva);

    }

    public ArrayList<Pokemon> getPokemon() throws MalformedURLException, IOException, ParseException {
        URLConnection connection = new URL("http://www.pokesnipers.com/api/v1/pokemon.json").openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        connection.connect();

        BufferedReader r = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));

        ArrayList<Pokemon> pokemon = new ArrayList<>();
        String l, texto = "";

        while ((l = r.readLine()) != null) {
            texto += l;
        }
        JSONObject js = new JSONObject(texto);

        JSONArray jsa = js.getJSONArray("results");

        for (int i = 0; i < jsa.length(); i++) {

            JSONObject actual = jsa.getJSONObject(i);
            String name = actual.getString("name");
            String coords = actual.getString("coords");

            StringTokenizer st = new StringTokenizer(coords, ",");
            double lat = Double.parseDouble(st.nextToken());
            double lon = Double.parseDouble(st.nextToken());

            String time = actual.getString("until");
            String icon = actual.getString("icon");
            int iv = actual.getInt("iv");

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date = format.parse(time);
            format.setTimeZone(TimeZone.getTimeZone("GTM"));
            date = format.parse(time);

            pokemon.add(new Pokemon(name, lat, lon, date, icon, iv != 0 ? true : false));

        }
        return pokemon;
    }
}
