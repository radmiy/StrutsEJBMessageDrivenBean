package by.epamlab.ejbs.constants;
 
public final class Constants {
	public static final String NAME_PROJECT_ROOT = "/";
	public static final String KEY_USER = "user";
    public static final String KEY_ERROR_MESSAGE = "errorMessage";
    public static final String KEY_EMPTY = "";
    public static final String KEY_FILE_NAME = "fileName";
    public static final String KEY_FILE_DIR = "FILES_DIR_FILE";
    public static final String KEY_DELIMITER = "Content-Disposition: form-data; name=\"";
    
    public static final String CONTENT = "Content-Disposition";
    public static final String DELIMITER_FILE_NAME = "filename=\"";
    public static final String ATTACHMENT = "attachment; ";
    public static final String SEPARATOR = "\"";
    public static final String DELIMITER_SEPARETOR = "\\";
    public static final String SEPARATOR_FILE_NAME = "\\\\";
    public static final String DEFAULT_MIME_TYPE = "application/octet-stream";
    public static final String DATA_DIRECTORY = "data";
    
    public static final String ERROR_EMPTY = "Login is empty.";
    public static final String ERROR_LOGINS_MATCH = "Passwords do not match.";
    public static final String ERROR_NULL = "Login or password are absent.";
    public static final String ERROR_SOURCE = "Input source proccessing problems.";
    public static final String ERROR_USER = "The user is not registered in the system.";
    public static final String ERROR_USER_PASSWORD = "Incorect password.";
    public static final String ERROR_USER_EXIST = "This user is registered in the system.";
    public static final String ERROR_TASK_EXIST = "This task is exist in the system.";
    public static final String ERROR_TASK_NOT_FOUND = "Task not found exception.";
    public static final String ERROR_LOAD_USER = "Can't read user. ";
    public static final String ERROR_LOAD_TASKS = "Can't read tasks. ";
    public static final String ERROR_NOT_VALID_LINK = "Not a valid link. ";
    public static final String ERROR_NOT_VALID_SECTION = "Not a valid section. ";
    public static final String ERROR_VISITOR = "You do not have access privileges. Please login or register as a user.";
    public static final String ERROR_DATE = "The date is not correct.";
    public static final String ERROR_SMALL_DATE = "The date is less than the current.";
    public static final String ERROR_NO_SELECTED_TASKS = "No selected tasks. ";
    public static final String ERROR_NOT_MULTIPART_FORM_DATA = "Content type is not multipart/form-data";
    public static final String ERROR_FILE_UPLOADING = "Exception in uploading file.";
    public static final String ERROR_FILE_DELETING = "Exception in deleting file.";
    public static final String ERROR_FILE_NOT_FOUND = "File not found.";

    public static final String ERROR_FILE_EMPTY = "File Name can't be null or empty";
    public static final String ERROR_FILE_DOESNT_EXIST = "File doesn't exists on server.";
    public static final String WRONG_REQUEST = "Get method is forbidden here";
    
	public static final String OPERATION_ADD = "Add";
	public static final String OPERATION_EDIT = "Edit";
	public static final String OPERATION_FIX = "Fix";
	public static final String OPERATION_RECYCLE = "Recycle";
	public static final String OPERATION_UNFIX = "Unfix";
	public static final String OPERATION_UNRECYCLE = "Unrecycle";
	public static final String OPERATION_DELETE = "Delete";

    public static final String FILE_XML = "c:/0004257753-full.xml";
}
