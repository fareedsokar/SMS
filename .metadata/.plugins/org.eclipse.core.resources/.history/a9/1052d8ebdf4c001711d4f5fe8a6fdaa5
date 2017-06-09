package OurSQL;

import java.util.ArrayList;

public class OurSQLBuild {

	OurSQL sql=new OurSQL();
	public OurSQLBuild()
	{
		//Building a record of our tables
		ArrayList<ColumnSQL> arr=new ArrayList<ColumnSQL>();
		arr.add(new ColumnSQL("id","Integer"));
		arr.add(new ColumnSQL("Name","String"));
		arr.add(new ColumnSQL("Password","String"));
		arr.add(new ColumnSQL("Email","String"));
		arr.add(new ColumnSQL("Status","Integer"));
		//arr.add(new ColumnSQL("Access","AccessProfiles"));
		sql.setIndex(0, "User", arr);
		//===============================
	}
	
}
