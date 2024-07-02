package com.studentscheduleapp.microservicesapi.appapigateway.services;

import org.springframework.stereotype.Service;

@Service
public class VersionCheckService {

    public boolean isAfterOrEqualsVersion(String checkingVersion, String afterOfVersion) throws Exception {
        try {
            String[] accept = checkingVersion.split("[.-]");
            int accept1 = Integer.parseInt(accept[0]);
            int accept2 = Integer.parseInt(accept[1]);
            int accept3 = Integer.parseInt(accept[2]);
            String acceptHint = accept.length > 3 ? accept[3] : null;

            String[] main = afterOfVersion.split("[.-]");
            int main1 = Integer.parseInt(main[0]);
            int main2 = Integer.parseInt(main[1]);
            int main3 = Integer.parseInt(main[2]);
            String mainHint = main.length > 3 ? main[3] : null;
            System.out.println(accept1 + " " + accept2 + " " + accept3 + " " + acceptHint + "      " + main1 + " " + main2 + " " + main3 + " " + mainHint);

            if (accept1 > main1)
                return true;
            else if (accept1 == main1 && accept2 > main2)
                return true;
            else if (accept1 == main1 && accept2 == main2 && accept3 >= main3)
                return true;
            return false;
        } catch (Exception e) {
            throw new Exception("can't check version'");
        }

    }

}
