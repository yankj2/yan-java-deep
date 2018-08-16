package designpattern_2.behavioral.patterns.chain;

public abstract class AbstractLogger {

	public static final int INFO = 1;
	
	public static final int DEBUG = 2;
	
	public static final int ERROR = 3;
	
	protected int level;
	
	// 责任链中下一个元素
	protected AbstractLogger nextLogger;

	public void setNextLogger(AbstractLogger nextLogger) {
		this.nextLogger = nextLogger;
	}
	
	public void logMessage(int level, String message){
		if(this.level <= level){
			this.write(message);
		}
		
		if(nextLogger != null){
			nextLogger.logMessage(level, message);
		}
	}
	
	public abstract void write(String message);
	
}
