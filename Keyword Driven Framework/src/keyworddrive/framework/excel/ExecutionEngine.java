package keyworddrive.framework.excel;

public class ExecutionEngine {	// Most important class, as it executes the actions based on the imported data from excel

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path  = "/Users/noheliaborjas/Documents/QA/KeywordDrivenTest.xlsx";
		ExecutionData.readExcel(path, 0);
		int rows = ExecutionData.getRowNum();
		int cols = 3;	//The keywords are saved on column no. 3 of the spreadsheet 
		for(int i=1; i<rows; i++) {
			String keyword = ExecutionData.getData(i, cols);
			System.out.println(keyword+"\n");
			switch(keyword) {
				case "open browser":
					Actions.invokeBrowser();
					break;
				case "enter URL":
					String url = ExecutionData.getData(i, cols+1);		//The url is saved on column no.4
					System.out.println(url + "\n");
					Actions.enterURL(url);//enters the url on actions
					break;
				case "sendKeys":
					String locatorSK = ExecutionData.getData(i, cols-1);		//The element locator is saved on column 2
					String keys = ExecutionData.getData(i, cols+1);			//The keys to send are saved on column 4
					Actions.sendKeys(keys, locatorSK);
					break;
				case "click":
					String locatorC = ExecutionData.getData(i, cols-1);		//The element locator is saved on column 2
					Actions.clickOn(locatorC);
				case "quit":
					Actions.quit();
				default:
					break;
			}
		}
	}

}

