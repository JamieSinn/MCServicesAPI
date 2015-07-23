package ca.jamiesinn.mcservicesapi;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Service
{
    private List<String> status = new ArrayList<>();

    /**
     * New Service, parse JSON.
     */
    public Service()
    {
        parseJSON();
    }

    /**
     * Get an up/down of a given service
     * @param type ServiceType to check
     * @return boolean of up/down
     */
    public boolean getStatus(ServiceType type)
    {
        for(String s : status)
            if(s.startsWith(type.getUrl()))
                return true;
        return false;
    }

    private void parseJSON()
    {
        try
        {
            JSONArray arr = readJsonFromUrl("http://status.mojang.com/check");
            for (ServiceType s : ServiceType.values())
            {
                status.add(s.getUrl() + ":" + arr.getJSONObject(s.getOrder()).getString(s.getUrl()));
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

    private JSONArray readJsonFromUrl(String url) throws IOException, JSONException
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

    /**
     * Unused - But will return a List of all services and their status
     * @return List of all services and their status.
     */
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
