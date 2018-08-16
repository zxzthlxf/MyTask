import java.util.Iterator;
import java.util.Vector;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

public class FirstTask extends Task {

	String message;

	public void setMessage(String msg) {
		message = msg;
	}

	boolean fail = false;

	public void setFail(boolean b) {
		fail = b;
	}

	public void addText(String text) {
		message = text;
	}

	@Override
	public void execute() {
		if (fail)
			throw new BuildException("Fail requested.");
		if (message != null)
			log(message);
		for (@SuppressWarnings("rawtypes")
		Iterator it = messages.iterator(); it.hasNext();) {
			Message msg = (Message) it.next();
			log(msg.getMsg());
		}
	}

	@SuppressWarnings("rawtypes")
	Vector messages = new Vector();

	@SuppressWarnings("unchecked")
	public Message createMessage() {
		Message msg = new Message();
		messages.add(msg);
		return msg;
	}

	public class Message {
		public Message() {
		}

		String msg;

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public String getMsg() {
			return msg;
		}
	}
}
