package by.epamlab.ejbs.constants;

public class ConstantsDB {
	public static final String USER_NAME = "epamlab";
    public static final String USER_PASSWORD = "111";
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL= "jdbc:mysql://localhost/";
	public static final String DB_NAME = "webProject";
	public static final String ERROR_CLOSE = "Can't close connection.";
	public static final String SELECT_SQL = "SELECT * FROM users WHERE login = ?";
	public static final String SELECT_TASKS = "SELECT *  FROM tasks WHERE name = ? and date = ?";
	public static final String SELECT_USER_SQL = "SELECT login FROM users WHERE login = ?";
	public static final String INSERT_USER_SQL = "INSERT INTO users (login, password, role) VALUES (?, ?, ?)";
	
	public static final String USER_COLUMN_ID = "idLogin";
	public static final String USER_COLUMN_LOGIN = "login";
	public static final String USER_COLUMN_PASS = "password";
	public static final String USER_COLUMN_ROLE = "role";
	
	public static final String TASK_COLUMN_ID = "idTask";
	public static final String TASK_COLUMN_TASK = "task";
	public static final String TASK_COLUMN_DESCRIPTION = "description";
	public static final String TASK_COLUMN_DAT = "dat";
	public static final String TASK_COLUMN_FILELINK = "fileLink";
	public static final String TASK_COLUMN_ISFIXED = "isFixed";
	public static final String TASK_COLUMN_ISRECYCLED = "isRecycled";
	
	public static final String COLUMN_TASK_NAME_ = "task";
	public static final String COLUMN_TASK_DATE = "dat";
	public static final String COLUMN_TASK_DSCRIPTION = "dscription";
	public static final String COLUMN_TASK_FIXED = "isFixed";
	public static final String COLUMN_TASK_DELETE = "isRecycled";
	
	public static final String QUERY_STRING = "Query: ";
	public static final String END_STRING = "\n";
	
	private static final String SQL_GET_ID_LOGIN = "(SELECT idLogin FROM users WHERE login = ? ) ";
	
	public static final String SELECT_TASK_SQL = "SELECT * FROM tasks, users WHERE loginId = idLogin and idTask = ? AND idLogin =" + SQL_GET_ID_LOGIN;

	private static final String SQL_SELECT_FIELDS_TASK = 
			"SELECT idTask, task, description, dat, isFixed, isRecycled, fileLink FROM tasks WHERE ";
	
	public static final String SQL_SELECT_TASK = SQL_SELECT_FIELDS_TASK + 
			"task = ? AND dat = ? AND " +
			"loginId = " + SQL_GET_ID_LOGIN + " ORDER BY dat";;
	
	public static final String SQL_GET_TODAY =  
			SQL_SELECT_FIELDS_TASK +
			"dat = date(current_date()) AND " + 
			"isFixed = false AND " +
			"isRecycled = false AND " +
			"loginId = " + SQL_GET_ID_LOGIN + " ORDER BY dat";
	
	public static final String SQL_GET_TOMORROW = 
			SQL_SELECT_FIELDS_TASK +
			"dat = adddate( current_date(), interval + 1 day ) AND " + 
			"isFixed = false AND " +
			"isRecycled = false AND " +
			"loginId = " + SQL_GET_ID_LOGIN + " ORDER BY dat";	
			
	public static final String SQL_GET_SOMEDAY = 
			SQL_SELECT_FIELDS_TASK +
			"(dat > adddate( current_date(), interval +1 day ) OR "
			+ "dat < date(current_date())) " + 
			"AND " +			
			"isFixed = false AND " +
			"isRecycled = false AND " +
			"loginId = " + SQL_GET_ID_LOGIN + " ORDER BY dat";
	public static final String SQL_GET_FIXED = 
			SQL_SELECT_FIELDS_TASK +
			"isFixed = true AND " +
			"isRecycled = false AND " +
			"loginId = " + SQL_GET_ID_LOGIN + " ORDER BY dat";
	public static final String SQL_GET_RECYCLE = 
			SQL_SELECT_FIELDS_TASK +
			"isRecycled = true AND " +
			"loginId = " + SQL_GET_ID_LOGIN + " ORDER BY dat";
	
	public static final String SQL_TASK_ADD = 
			"INSERT into tasks (loginId, task, description, dat, fileLink, isFixed, isRecycled) "
			+ "values (" + SQL_GET_ID_LOGIN + ", ?, ? , ?, null, false, false);";
	
	public static final int TASK_INDEX_LOGIN = 1;
	public static final int TASK_INDEX_TASK = 2;
	public static final int TASK_INDEX_DSCRIPTION = 3;
	public static final int TASK_INDEX_DATE = 4;
	
	public static final String SQL_TASK_EDIT = 
			"UPDATE tasks SET task = ?, description = ?, dat = ? WHERE "
			+ "loginId = " + SQL_GET_ID_LOGIN + " "
			+ "and idTask = ?;";
	public static final String SQL_TASK_FIX = 
			"UPDATE tasks SET isFixed = true WHERE "
			+ "loginId = " + SQL_GET_ID_LOGIN + " "
			+ "and idTask = ?;";
	public static final String SQL_TASK_RECYCLE = 
			"UPDATE tasks SET isRecycled = true WHERE "
			+ "loginId = " + SQL_GET_ID_LOGIN + " "
			+ "and idTask = ?;";
	public static final String SQL_TASK_UNFIX = 
			"UPDATE tasks SET isFixed = false WHERE "
			+ "loginId = " + SQL_GET_ID_LOGIN + " "
			+ "and idTask = ?;";
	public static final String SQL_TASK_UNRECYCLE = 
			"UPDATE tasks SET isRecycled = false WHERE "
			+ "loginId = " + SQL_GET_ID_LOGIN + " "
			+ "and idTask = ?;";
	public static final String SQL_TASK_DELETE = 
			"DELETE FROM tasks WHERE "
			+ "loginId = " + SQL_GET_ID_LOGIN + " "
			+ "and idTask = ?;";
	public static final String SQL_SET_FILEPATH = 
			"UPDATE tasks SET fileLink = ? WHERE "
			+ "loginId = " + SQL_GET_ID_LOGIN  
			+ "and idTask = ?;";

	public static final int OPERATION_USERNAME_INDEX_TASKS = 1;
	public static final int OPERATION_TASK_INDEX = 2;
}
