package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	public static String getDataFromPropertiesFile(String key) throws IOException {

		// 1> Get the Java Representation Object of Physical file
		FileInputStream fis = new FileInputStream("./src/test/resources/testdata/commondata.properties");
		Properties pObj = new Properties();

		// 2> use the load() and load all the keys
		pObj.load(fis);

		// 3> use getProperty() and pass key and get the value of key
		String value = pObj.getProperty(key);
		return value;

	}
}
