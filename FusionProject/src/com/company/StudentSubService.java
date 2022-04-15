package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class StudentSubService {

    private static void choices(int num, int select, Protocol protocol, OutputStream oos) throws IOException {
        if(num == 2) {
            if(select == 1) {
                protocol = new Protocol(Protocol.타입_요청_학생, Protocol.코드_학생요청_수강신청및취소);
                oos.write(protocol.getPacket());
            }
            else if(select == 2) {
                protocol = new Protocol(Protocol.타입_요청_학생, Protocol.코드_학생요청_수강신청및취소);
                oos.write(protocol.getPacket());
            }
        }
        oos.flush();
    }

    private static void choice(int num, Protocol protocol, OutputStream oos) throws IOException {
        if(num == 1) {
            protocol = new Protocol(Protocol.타입_요청_공통, Protocol.코드_공통요청_개인정보수정);
            oos.write(protocol.getPacket());
        }
        else if(num == 3) {
            protocol = new Protocol(Protocol.타입_요청_교수학생공통, Protocol.코드_교수학생공통요청_개설교과목목록조회);
            oos.write(protocol.getPacket());
        }
        else if(num == 4) {
            protocol = new Protocol(Protocol.타입_요청_학생,  Protocol.코드_학생요청_특정개설교과목강의계획서조회);
            oos.write(protocol.getPacket());
        }
        else if(num == 5) {
            protocol = new Protocol(Protocol.타입_요청_교수학생공통, Protocol.코드_교수학생공통요청_교과목시간표조회_학생);
            oos.write(protocol.getPacket());
        }
        oos.flush();
    }

    public static void updateStudent(InputStream ois, OutputStream oos, Protocol protocol) throws IOException {
        choice(1, protocol, oos);

        protocol = new Protocol();

        NecessaryFunction.Read(ois, protocol);
        int packetType = protocol.getType();
        int packetCode = protocol.getCode();

        if(!NecessaryFunction.isType(packetType) || !NecessaryFunction.isCode(packetCode)) {
            return;
        }

        if(NecessaryFunction.check(packetType, packetCode) == 2) {
            String result = protocol.getData();
            System.out.println(result);
            return;
        }

        NecessaryFunction.singleInput(protocol, oos, Protocol.타입_정보전송_PW);

        NecessaryFunction.Read(ois, protocol);
        packetType = protocol.getType();
        packetCode = protocol.getCode();

        if(!NecessaryFunction.isType(packetType) || !NecessaryFunction.isCode(packetCode)) {
            return;
        }

        if(NecessaryFunction.check(packetType, packetCode) == 2) {
            String result = protocol.getData();
            System.out.println(result);
            return;
        }

        NecessaryFunction.updateInfo(protocol, oos, Protocol.타입_정보전송_계정정보, Protocol.코드_정보전송_계정정보_학생, DataSize_Const.학생수정정보);

        NecessaryFunction.Read(ois, protocol);
        packetType = protocol.getType();
        packetCode = protocol.getCode();

        if(!NecessaryFunction.isType(packetType) || !NecessaryFunction.isCode(packetCode)) {
            return;
        }

        if(NecessaryFunction.check(packetType, packetCode) == 2) {
            String result = protocol.getData();
            System.out.println(result);
            return;
        }

        메세지메뉴.개인정보수정성공();

    }

    public static void requestLecture(InputStream ois, OutputStream oos, Protocol protocol) throws IOException {
        choices(2, 1, protocol, oos);

        protocol = new Protocol();

        NecessaryFunction.Read(ois, protocol);
        int packetType = protocol.getType();
        int packetCode = protocol.getCode();

        if(!NecessaryFunction.isType(packetType) || !NecessaryFunction.isCode(packetCode)) {
            return;
        }

        if(NecessaryFunction.check(packetType, packetCode) == 2) {
            String result = protocol.getData();
            System.out.println(result);
            return;
        }

        NecessaryFunction.singleInput(protocol, oos, Protocol.타입_정보전송_교과목번호);

        NecessaryFunction.Read(ois, protocol);
        packetType = protocol.getType();
        packetCode = protocol.getCode();

        if(!NecessaryFunction.isType(packetType) || !NecessaryFunction.isCode(packetCode)) {
            return;
        }

        if(NecessaryFunction.check(packetType, packetCode) == 2) {
            String result = protocol.getData();
            System.out.println(result);
            return;
        }

        protocol= new Protocol(Protocol.타입_정보전송_수강신청및취소정보, Protocol.코드_정보전송_수강신청및취소정보_신청);
        oos.write(protocol.getPacket());

        NecessaryFunction.Read(ois, protocol);
        packetType = protocol.getType();
        packetCode = protocol.getCode();

        if(!NecessaryFunction.isType(packetType) || !NecessaryFunction.isCode(packetCode)) {
            return;
        }

        if(NecessaryFunction.check(packetType, packetCode) == 2) {
            String result = protocol.getData();
            System.out.println(result);
            return;
        }

        메세지메뉴.수강신청성공();

    }

    public static void deleteLecture(InputStream ois, OutputStream oos, Protocol protocol) throws IOException {
        choices(2, 2, protocol, oos);

        protocol = new Protocol();

        NecessaryFunction.Read(ois, protocol);
        int packetType = protocol.getType();
        int packetCode = protocol.getCode();

        if(!NecessaryFunction.isType(packetType) || !NecessaryFunction.isCode(packetCode)) {
            return;
        }

        if(NecessaryFunction.check(packetType, packetCode) == 2) {
            String result = protocol.getData();
            System.out.println(result);
            return;
        }

        NecessaryFunction.singleInput(protocol, oos, Protocol.타입_정보전송_교과목번호);

        NecessaryFunction.Read(ois, protocol);
        packetType = protocol.getType();
        packetCode = protocol.getCode();

        if(!NecessaryFunction.isType(packetType) || !NecessaryFunction.isCode(packetCode)) {
            return;
        }

        if(NecessaryFunction.check(packetType, packetCode) == 2) {
            String result = protocol.getData();
            System.out.println(result);
            return;
        }

        protocol= new Protocol(Protocol.타입_정보전송_수강신청및취소정보, Protocol.코드_정보전송_수강신청및취소정보_취소);
        oos.write(protocol.getPacket());

        NecessaryFunction.Read(ois, protocol);
        packetType = protocol.getType();
        packetCode = protocol.getCode();

        if(!NecessaryFunction.isType(packetType) || !NecessaryFunction.isCode(packetCode)) {
            return;
        }

        if(NecessaryFunction.check(packetType, packetCode) == 2) {
            String result = protocol.getData();
            System.out.println(result);
            return;
        }

        메세지메뉴.수강취소성공();

    }

    public static void readOpenSubjectAll(InputStream ois, OutputStream oos, Protocol protocol) throws IOException {
        choice(3, protocol, oos);

        protocol = new Protocol();

        NecessaryFunction.Read(ois, protocol);
        int packetType = protocol.getType();
        int packetCode = protocol.getCode();

        if(!NecessaryFunction.isType(packetType) || !NecessaryFunction.isCode(packetCode)) {
            return;
        }

        if(NecessaryFunction.check(packetType, packetCode) == 2) {
            String result = protocol.getData();
            System.out.println(result);
            return;
        } else if(NecessaryFunction.check(packetType, packetCode) == 3) {
            String result = protocol.getData();
            System.out.println(result);
            return;
        }
    }

    public static void readSelectSyllabus(InputStream ois, OutputStream oos, Protocol protocol) throws IOException {
        choice(4, protocol, oos);

        protocol = new Protocol();

        NecessaryFunction.Read(ois, protocol);
        int packetType = protocol.getType();
        int packetCode = protocol.getCode();

        if(!NecessaryFunction.isType(packetType) || !NecessaryFunction.isCode(packetCode)) {
            return;
        }

        if(NecessaryFunction.check(packetType, packetCode) == 2) {
            String result = protocol.getData();
            System.out.println(result);
            return;
        }

        NecessaryFunction.singleInput(protocol, oos, Protocol.타입_정보전송_교과목번호);

        NecessaryFunction.Read(ois, protocol);
        packetType = protocol.getType();
        packetCode = protocol.getCode();

        if(!NecessaryFunction.isType(packetType) || !NecessaryFunction.isCode(packetCode)) {
            return;
        }

        if(NecessaryFunction.check(packetType, packetCode) == 2) {
            String result = protocol.getData();
            System.out.println(result);
            return;
        } else if(NecessaryFunction.check(packetType, packetCode) == 3) {
            String result = protocol.getData();
            System.out.println(result);
            return;
        }
    }

    public static void readStudentSubjectTimeTable(InputStream ois, OutputStream oos, Protocol protocol) throws IOException {
        choice(5, protocol, oos);

        protocol = new Protocol();

        NecessaryFunction.Read(ois, protocol);
        int packetType = protocol.getType();
        int packetCode = protocol.getCode();

        if(!NecessaryFunction.isType(packetType) || !NecessaryFunction.isCode(packetCode)) {
            return;
        }

        if(NecessaryFunction.check(packetType, packetCode) == 2) {
            String result = protocol.getData();
            System.out.println(result);
            return;
        } else if(NecessaryFunction.check(packetType, packetCode) == 3) {
            String result = protocol.getData();
            System.out.println(result);
            return;
        }
    }
}
