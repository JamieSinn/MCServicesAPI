package ca.jamiesinn.mcservicesapi;

public enum ServiceType
{
    /**
     * minecraft.net - This is the website
     */
    MINECRAFT("minecraft.net", 0),
    /**
     * session.minecraft.net - This is the session server
     */
    MINECRAFT_SESSION("session.minecraft.net", 1),
    /**
     * account.mojang.com - This is the Mojang accounts server
     */
    MOJANG_ACCOUNT("account.mojang.com", 2),
    /**
     * auth.mojang.com - This is the Mojang auth server
     */
    MOJANG_AUTH("auth.mojang.com", 3),
    /**
     * skins.minecraft.net - This is the skins server
     */
    MINECRAFT_SKINS("skins.minecraft.net", 4),
    /**
     * authserver.mojang.com - This is the auth server
     */
    MOJANG_AUTHSERVER("authserver.mojang.com", 5),
    /**
     * sessionserver.mojang.com - Multiplayer sessions
     */
    MOJANG_SESSION("sessionserver.mojang.com", 6),
    /**
     * api.mojang.com - Mojang API
     */
    MOJANG_API("api.mojang.com", 7),
    /**
     * textures.minecraft.net - Textures server
     */
    MINECRAFT_TEXTURES("textures.minecraft.net", 8);

    private String url;
    private int order;

    /**
     * ServiceType
     * @param url The url/key in the JSONArray
     * @param order The order/index of the service in the JSONArray
     */
    ServiceType(String url, int order)
    {
        this.order = order;
        this.url = url;
    }

    /**
     * Get the url/key of the given service
     * @return key to JSONArray of given service
     */
    public String getUrl()
    {
        return url;
    }

    /**
     * Get the index of the given service
     * @return index
     */
    public int getOrder()
    {
        return order;
    }
}
