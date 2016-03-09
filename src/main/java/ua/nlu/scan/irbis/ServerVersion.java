package ua.nlu.scan.irbis;

/**
 * Created by IntelliJ IDEA.
 * User: usr
 * Date: 04.01.2015
 * Time: 6:47:40
 * ��������� ������, ������������ ������ �������.
 */
public class ServerVersion {
    public String version;
    public int activeClientsCount;
    public int maxConnections;

    @Override
    public String toString() {
        return "ServerVersion{" +
                "version='" + version + '\'' +
                ", activeClientsCount=" + activeClientsCount +
                ", maxConnections=" + maxConnections +
                '}';
    }
}
