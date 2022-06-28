package logs;

import authentication.UserSession;
import utils.Constants;
import utils.RemoteSession;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EventLog {
    public static void writeEventLog(String query) throws IOException {
        File log = new File(Constants.Log_Folder);
        RemoteSession host =new RemoteSession();
        if(!log.exists()) {
            log.mkdir();
        }
        FileWriter fw = new FileWriter(Constants.Query_Log_Path,true);
        java.util.Date date = new java.util.Date();
        fw.append(date+"||");
        String hostName = host.getHostName();
        fw.append(hostName+"||");
        UserSession user = new UserSession();
        fw.append(user.getUser()+"||");
        fw.append(query+"||");
        fw.append("\n");
        fw.close();
    }
}