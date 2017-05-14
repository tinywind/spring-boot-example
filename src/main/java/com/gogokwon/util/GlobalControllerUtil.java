package com.gogokwon.util;

/**
 * Created by KJShin on 2017-05-07.
 */
public class GlobalControllerUtil {
    public String filename(String filepath)
    {
        if(filepath == null)
            return "";
        int lastIndex = filepath.lastIndexOf("/");
        return lastIndex < 0 ? filepath : filepath.substring(lastIndex + 1);
    }
}
