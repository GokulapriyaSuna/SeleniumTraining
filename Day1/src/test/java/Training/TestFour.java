package Training;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class TestFour {

	
	static public Object[][] test()
	{
		File file = new File("src\\test\\resources\\Dataexcel\\Data.xlsx");
		Object[][] obj=null;
		try {
			InputStream is= new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(is);
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			obj=new Object[sheet.getLastRowNum()][];
			for(int i=1;i<=sheet.getLastRowNum();i++)
			{
				obj[i-1]=new Object[sheet.getRow(i).getPhysicalNumberOfCells()];
				for(int j=0; j<sheet.getRow(i).getPhysicalNumberOfCells();j++)
				{
					System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+ "\t");
					obj[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				}
				System.out.println();
			}
			workbook.close();		
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
	}
	
}
