package ca.jamiesinn.mcservicesapi;

/**
 *
 */
public class MCServicesAPI
{
    private static Service service = new Service();

    /**
     * Get the current status of a Minecraft/Mojang service
     * @param type ServiceType to check for
     * @return boolean of up/down
     */
    public static boolean getStatus(ServiceType type)
    {
        return service.getStatus(type);
    }
}
