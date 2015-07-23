package ca.jamiesinn.mcservicesapi.services;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Service
{
    //private String status;
    private List<String> status = new ArrayList<String>();

    public Service()
    {
        parseJSON();
    }

    private void parseJSON()
    {
        try
        {
            JSONArray arr = readJsonFromUrl("http://status.mojang.com/check");
            List<String> keys = new ArrayList<>();
            keys.add("minecraft.net");
            keys.add("session.minecraft.net");
            keys.add("account.mojang.com");
            keys.add("auth.mojang.com");
            keys.add("skins.minecraft.net");
            keys.add("authserver.mojang.com");
            keys.add("sessionserver.mojang.com");
            keys.add("api.mojang.com");
            keys.add("textures.minecraft.net");
            for (String s : keys)
            {
                status.add(s + ": " + arr.getJSONObject(keys.indexOf(s)).getString(s));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private String readAll(Reader rd) throws IOException
    {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1)
        {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public JSONArray readJsonFromUrl(String url) throws IOException, JSONException
    {
        InputStream is = new URL(url).openStream();
        try
        {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            return new JSONArray(jsonText);
        } finally
        {
            is.close();
        }
    }

    public List<String> getStatus()
    {
        List<String> result = new ArrayList<>();
        for (String s : status)
        {
            if (s.endsWith("green"))
                result.add(s.replace("green", "Up"));
            else
                result.add(s.replace("red", "Down"));
        }
        return result;
    }
}
