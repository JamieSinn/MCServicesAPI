package ca.jamiesinn.mcservicesapi;

import ca.jamiesinn.mcservicesapi.services.Service;

public class MCServicesAPI
{
    public static void main(String[] args)
    {
        Service service = new Service();
        for(String s : service.getStatus())
        {
            System.out.println(s);
        }
    }
}
