package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StudentMenu {
    public static void StudentMenuRun(InputStream ois, OutputStream oos, Protocol protocol) throws IOException {

        int num = -1;

        while (true) {
            학생메뉴.학생메뉴();
            num = NecessaryFunction.getInput(num);

            if (num == 1) {
                StudentMainService.updateStudent(ois, oos, protocol);
            } else if (num == 2) {
                StudentMainService.requestAndDeleteLecture(ois, oos, protocol);
            } else if (num == 3) {
                StudentMainService.readOpenSubjectAll(ois, oos, protocol);
            } else if (num == 4) {
                StudentMainService.readSelectSyllabus(ois, oos, protocol);
            } else if (num == 5) {
                StudentMainService.readStudentSubjectTimeTable(ois, oos, protocol);
            } else if (num == 0) {
                공통메뉴.로그아웃메뉴();
                return;
            } else if(num == -1) {
                continue;
            }
        }
    }
}
