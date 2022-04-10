package flight.tracking.system;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Logger {
    private static Logger instance;
	private ArrayList<Log> logs;
	private final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm");

	private Logger() {
		logs = new ArrayList<>();
	}

	public static Logger getInstance() {
		if (instance == null)
			instance = new Logger();
		return instance;
	}

	public synchronized void log(String content) {
		if (Utils.emptyOrWhitespace(content))
			throw new IllegalArgumentException("Log content cannot be empty or whitespace.");
		logs.add(new Log(content));
		System.out.println(new Log(content).toString());
	}

	public String getLogs() {
		String contents = "";
		for (Log log : logs) {
			contents += log.toString() + '\n';
		}
		return contents;
	}

	private class Log {
		private LocalDateTime time;
		private String content;

		public Log(String content) {
			time = LocalDateTime.now();
			this.content = content;
		}

		@Override
		public String toString() {
			return time.format(format) + ": " + content;
		}
	}
}