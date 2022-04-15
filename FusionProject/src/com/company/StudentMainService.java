package com.company;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
public class StudentMainService {

    public static void updateStudent(InputStream ois, OutputStream oos, Protocol protocol) throws IOException {
        공통메뉴.개인정보및비밀번호수정메뉴();
        StudentSubService.updateStudent(ois, oos, protocol);
    }

    public static void requestAndDeleteLecture(InputStream ois, OutputStream oos, Protocol protocol) throws IOException {
        int select = -1;

        학생메뉴.수강신청취소메뉴();
        select = NecessaryFunction.getInput(select);

        if(select == 1) {
            학생메뉴.수강신청메뉴();
            StudentSubService.requestLecture(ois, oos, protocol);
        }

        else if(select == 2) {
            학생메뉴.수강취소메뉴();
            StudentSubService.deleteLecture(ois, oos, protocol);
        }

        else if(select == -1) {
            return;
        }


    }

    public static void readOpenSubjectAll(InputStream ois, OutputStream oos, Protocol protocol) throws IOException {
        학생메뉴.개설교과목목록전학년조회();
        StudentSubService.readOpenSubjectAll(ois, oos, protocol);
    }

    public static void readSelectSyllabus(InputStream ois, OutputStream oos, Protocol protocol) throws IOException {
        학생메뉴.선택교과목강의계획서조회();
        StudentSubService.readSelectSyllabus(ois, oos, protocol);
    }

    public static void readStudentSubjectTimeTable(InputStream ois, OutputStream oos, Protocol protocol) throws IOException {
        학생메뉴.본인시간표조회();
        StudentSubService.readStudentSubjectTimeTable(ois, oos, protocol);
    }

}
