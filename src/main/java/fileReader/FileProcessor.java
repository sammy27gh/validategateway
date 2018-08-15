package fileReader;


import java.io.FileNotFoundException;


import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;


public class FileProcessor<T> implements IFileProcessor<T>
{	
	public List<T> parseCSVToBeanList(String fileName, Map<String,String> headerColumnMap, Class<T> t)  
	{
		HeaderColumnNameTranslateMappingStrategy<T> beanStrategy = new HeaderColumnNameTranslateMappingStrategy<T>();
		beanStrategy.setType(t); 
		beanStrategy.setColumnMapping(headerColumnMap);
		CsvToBean<T> csvToBean = new CsvToBean<T>();// csv to bean variable holds the bean variable 
		CSVReader reader = null; // this variable holds the reading that is done.
		List<T> beanList = null; //Beanlist will hold parsing the reading to the java file. 
		try 
		{
			reader = new CSVReader(new FileReader(fileName));
			beanList = csvToBean.parse(beanStrategy, reader);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}	
		finally {
		    if (reader != null) {
		      safeClose(reader);
		    }
		  }	
		
		return beanList;
	}
	public static void safeClose(CSVReader reader) {
		  if (reader != null) {
		    try {
		      reader.close();
		    } catch (IOException e) {
		    	e.printStackTrace();
		    }
		  }
		}
}