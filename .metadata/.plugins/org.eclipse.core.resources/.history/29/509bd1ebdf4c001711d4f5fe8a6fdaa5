package OurSQL;

import java.util.ArrayList;
import java.util.HashMap;

public class OurSQL {
	private HashMap<Integer,String> tableNames;
	private HashMap<Integer,ArrayList<ColumnSQL>> tableTypes;
	
	public void setIndex(int index,String name,ArrayList<ColumnSQL> arr){
		tableNames.put(index, name);
		tableTypes.put(index, arr);
	}
	public String getIndexName(int index){
		return tableNames.get(index);
	}
	public ArrayList<ColumnSQL> getindexArrayList(int index){
		return tableTypes.get(index);
	}
	public HashMap<Integer,String> getTableNames() {
		return tableNames;
	}

	public void setTableNames(HashMap<Integer,String> tableNames) {
		this.tableNames = tableNames;
	}

	public HashMap<Integer,ArrayList<ColumnSQL>> getTableTypes() {
		return tableTypes;
	}

	public void setTableTypes(HashMap<Integer,ArrayList<ColumnSQL>> tableTypes) {
		this.tableTypes = tableTypes;
	}
}
