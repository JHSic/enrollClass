package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class AdminMenu {
    public static void AdminMenuRun(InputStream ois, OutputStream oos, Protocol protocol) throws IOException {

        int num = -1;

        while(true) {
            관리자메뉴.관리자메뉴();
            num = NecessaryFunction.getInput(num);

            if(num == 1) {
                AdminMainService.createUser(ois, oos, protocol);
            }

            else if(num == 2) {
                AdminMainService.subjectCUD(ois, oos, protocol);
            }

            else if(num == 3) {
                AdminMainService.openSubjectCUD(ois, oos, protocol);
            }

            else if(num == 4) {
                AdminMainService.inputSyllabus(ois, oos, protocol);
            }

            else if(num == 5) {
                AdminMainService.inputCourse(ois, oos, protocol);
            }

            else if(num == 6) {
                AdminMainService.readUser(ois, oos, protocol);
            }

            else if(num == 7) {
                AdminMainService.readSubject(ois, oos, protocol);
            }

            else if(num == 0) {
                공통메뉴.로그아웃메뉴();
                return;
            }

            else if(num == -1) {
                continue;
            }
        }
    }
}