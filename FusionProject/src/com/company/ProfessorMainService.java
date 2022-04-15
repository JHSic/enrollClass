package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ProfessorMainService {

    public static void updateProfessor(InputStream ois, OutputStream oos, Protocol protocol) throws IOException {
        공통메뉴.개인정보및비밀번호수정메뉴();
        ProfessorSubService.updateProfessor(ois, oos, protocol);

    }
    public static void readOpenSubject(InputStream ois, OutputStream oos, Protocol protocol) throws IOException {
        공통메뉴.개설교과목목록조회메뉴();
        ProfessorSubService.readOpenSubject(ois, oos, protocol);

    }
    public static void insertAndUpdateSyllabus(InputStream ois, OutputStream oos, Protocol protocol) throws IOException {
        int select = -1;

        교수메뉴.강의계획서입력수정메뉴();
        select = NecessaryFunction.getInput(select);

        if(select == 1) {
            교수메뉴.강의계획서입력메뉴();
            ProfessorSubService.insertSyllabus(ois, oos, protocol);
        }

        else if(select == 2) {
            교수메뉴.강의계획서수정메뉴();
            ProfessorSubService.updateSyllabus(ois, oos, protocol);
        }

        else if(select == 0 ){
            return;
        }

        else if(select == -1) {
            return;
        }


    }
    public static void readOpenSubjectSyllabus(InputStream ois, OutputStream oos, Protocol protocol) throws IOException {
        교수메뉴.개설교과목강의계획서조회메뉴();
        ProfessorSubService.readOpenSubjectSyllabus(ois, oos, protocol);

    }
    public static void readStudentListOnSubject(InputStream ois, OutputStream oos, Protocol protocol) throws IOException {
        교수메뉴.교과목수강신청학생목록조회메뉴();
        ProfessorSubService.readStudentListOnSubject(ois, oos, protocol);

    }

    public static void readSubjectTimeTable(InputStream ois, OutputStream oos, Protocol protocol) throws IOException {
        교수메뉴.교과목시간표조회();
        ProfessorSubService.readSubjectTimeTable(ois, oos, protocol);
    }
}