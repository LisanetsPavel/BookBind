package ua.nlu.scan.irbis;

/**
 * Created by IntelliJ IDEA.
 * User: usr
 * Date: 07.12.2014
 * Time: 10:15:52
 *
 * �����-������� ������ �������.
 */
public class ServerAnswerHeader {
    private char command;
    private String userId;
    private String commandNo;

    public ServerAnswerHeader() {
        // No-op.
    }

    public ServerAnswerHeader(char command, String userId, String commandNo) {
        this.command = command;
        this.userId = userId;
        this.commandNo = commandNo;
    }

    public char getCommand() {
        return command;
    }

    public String getUserId() {
        return userId;
    }

    public String getCommandNo() {
        return commandNo;
    }

    public void setCommand(char command) {
        this.command = command;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setCommandNo(String commandNo) {
        this.commandNo = commandNo;
    }
}
