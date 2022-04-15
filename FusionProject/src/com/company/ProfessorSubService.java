package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ProfessorSubService {

    private static void choices(int num, int select, Protocol protocol, OutputStream oos) throws IOException {
        if (num == 3) {
            if (select == 1) {
                protocol = new Protocol(Protocol.타입_요청_교수, Protocol.코드_교수요청_강의계획서입력);
                oos.write(protocol.getPacket());
            } else if (select == 2) {
                protocol = new Protocol(Protocol.타입_요청_교수, Protocol.코드_교수요청_강의계획서수정);
                oos.write(protocol.getPacket());
            }
        }
        oos.flush();
    }

    private static void choice(int num, Protocol protocol, OutputStream oos) throws IOException {
        if (num == 1) {
            protocol = new Protocol(Protocol.타입_요청_공통, Protocol.코드_공통요청_개인정보수정);
            oos.write(protocol.getPacket());
        } else if (num == 2) {
            protocol = new Protocol(Protocol.타입_요청_교수학생공통, Protocol.코드_교수학생공통요청_개설교과목목록조회);
            oos.write(protocol.getPacket());
        } else if (num == 4) {
            protocol = new Protocol(Protocol.타입_요청_교수, Protocol.코드_교수요청_담당개설교과목강의계획서조회);
            oos.write(protocol.getPacket());
        } else if (num == 5) {
            protocol = new Protocol(Protocol.타입_요청_교수, Protocol.코드_교수요청_수강신청학생목록조회);
            oos.write(protocol.getPacket());
        } else if (num == 6) {
            protocol = new Protocol(Protocol.타입_요청_교수학생공통, Protocol.코드_교수학생공통요청_교과목시간표조회_교수);
            oos.write(protocol.getPacket());
        }
        oos.flush();
    }

    public static void updateProfessor(InputStream ois, OutputStream oos, Protocol protocol) throws IOException {
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

        NecessaryFunction.updateInfo(protocol, oos, Protocol.타입_정보전송_계정정보, Protocol.코드_정보전송_계정정보_교수, DataSize_Const.교수수정정보);

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

    public static void readOpenSubject(InputStream ois, OutputStream oos, Protocol protocol) throws IOException {
        choice(2, protocol, oos);

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

    public static void insertSyllabus(InputStream ois, OutputStream oos, Protocol protocol) throws IOException {
        choices(3,1, protocol, oos);

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

        교수메뉴.강의계획서정보입력메뉴();
        NecessaryFunction.singleInput(protocol, oos, Protocol.타입_정보전송_강의계획서입력정보);

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

        메세지메뉴.강의계획서입력성공();

    }

    public static void updateSyllabus(InputStream ois, OutputStream oos, Protocol protocol) throws IOException {
        choices(3, 2, protocol, oos);

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

        교수메뉴.강의계획서정보입력메뉴();
        NecessaryFunction.singleInput(protocol, oos, Protocol.타입_정보전송_강의계획서입력정보);

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

        메세지메뉴.강의계획서수정성공();

    }

    public static void readOpenSubjectSyllabus(InputStream ois, OutputStream oos, Protocol protocol) throws IOException {
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
        } else if(NecessaryFunction.check(packetType, packetCode) == 3) {
            String result = protocol.getData();
            System.out.println(result);
            return;
        }
    }

    public static void readStudentListOnSubject(InputStream ois, OutputStream oos, Protocol protocol) throws IOException {
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

    public static void readSubjectTimeTable(InputStream ois, OutputStream oos, Protocol protocol) throws IOException {
        choice(6, protocol, oos);

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