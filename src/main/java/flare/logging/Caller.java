package flare.logging;

public class Caller {
	
	public static String getCallerCallerClassName() { 
	    StackTraceElement[] stElements = Thread.currentThread().getStackTrace();
	    String callerClassName = null;
	    for (int i=1; i<stElements.length; i++) {
	        StackTraceElement ste = stElements[i];
	        if (!ste.getClassName().equals(Caller.class.getName())&& ste.getClassName().indexOf("java.lang.Thread")!=0) {
	            if (callerClassName==null) {
	                callerClassName = ste.getClassName();
	            } else if (!callerClassName.equals(ste.getClassName())) {
	                return ste.getClassName();
	            }
	        }
	    }
	    return null;
	 }
}
