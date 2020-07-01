// Global class maintains the list of constants used across the system

public class Globals {

	// Primary menu options starts here
	public static final int _LOG_IN = 1;
	public static final int _QUIT = 2;
	
	public static final String LINE_SEPERATOR = "------------------------------------------------------------";

	// Menu Options Constants Starts Here
	public static final int _NEW_EVENT_POST = 1;
	public static final int _NEW_JOB_POST = 2;
	public static final int _NEW_SALE_POST = 3;
	public static final int _REPLY_TO_POST = 4;
	public static final int _DISPLAY_MY_POSTS = 5;
	public static final int _DISPLAY_ALL_POSTS = 6;
	public static final int _CLOSE_POST = 7;
	public static final int _DELETE_POST = 8;
	public static final int _LOGOUT = 9;

	// Other commands
	public static final String  unixClearCommand = "clear";
	public static final String  windowsClearCommand = "cls";
	
	// Default values of some attributes;
	public static final String _POST_STATUS_DEFAULT = "OPEN";
	
	// Prefixes
	public static final String _EVENT_ID_PREFX = "EVE";
	public static final String _JOB_ID_PREFX = "JOB";
	public static final String _SALE_ID_PREFX = "SAL";
}
