package Generic_Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtils {

    /**
     * This method is used to read data from Property file
     *
     * @author Aswathi
     * @param key
     * @return
     * @throws IOException
     */
    public String readDataFromPropertyFile(String key) throws IOException {

        FileInputStream fis = new FileInputStream(IPathConstants.filePath);

        // create object for Properties
        Properties pObj = new Properties();
        pObj.load(fis);

        String value = pObj.getProperty(key);
        return value;
    }
}
