package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ProfessorMenu {
    public static void ProfessorMenuRun(InputStream ois, OutputStream oos, Protocol protocol) throws IOException {

        int num = -1;

        while (true) {
            교수메뉴.교수메뉴();
            num = NecessaryFunction.getInput(num);

            if (num == 1) {
                ProfessorMainService.updateProfessor(ois, oos, protocol);
            } else if (num == 2) {
                ProfessorMainService.readOpenSubject(ois, oos, protocol);
            } else if (num == 3) {
                ProfessorMainService.insertAndUpdateSyllabus(ois, oos, protocol);
            } else if (num == 4) {
                ProfessorMainService.readOpenSubjectSyllabus(ois, oos, protocol);
            } else if (num == 5) {
                ProfessorMainService.readStudentListOnSubject(ois, oos, protocol);
            } else if (num == 6) {
                ProfessorMainService.readSubjectTimeTable(ois, oos, protocol);
            } else if (num == 0) {
                공통메뉴.로그아웃메뉴();
                return;
            } else if(num == -1) {
                continue;
            }
        }
    }
}
