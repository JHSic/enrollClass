package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class AdminSubService {

    static Scanner sc = new Scanner(System.in);

    public static void choices(int num, int select, Protocol protocol, OutputStream oos) throws IOException {
        if (num == 1) {
            if (select == 1) {
                protocol = new Protocol(Protocol.타입_요청_관리자, Protocol.코드_관리자요청_계정생성_교수);
                oos.write(protocol.getPacket());
            } else if (select == 2) {
                protocol = new Protocol(Protocol.타입_요청_관리자, Protocol.코드_관리자요청_계정생성_학생);
                oos.write(protocol.getPacket());
            }
        } else if (num == 2) {
            if (select == 1) {
                protocol = new Protocol(Protocol.타입_요청_관리자, Protocol.코드_관리자요청_교과목생성);
                oos.write(protocol.getPacket());
            } else if (select == 2) {
                protocol = new Protocol(Protocol.타입_요청_관리자, Protocol.코드_관리자요청_교과목수정);
                oos.write(protocol.getPacket());
            } else if (select == 3) {
                protocol = new Protocol(Protocol.타입_요청_관리자, Protocol.코드_관리자요청_교과목삭제);
                oos.write(protocol.getPacket());
            }
        } else if (num == 3) {
            if (select == 1) {
                protocol = new Protocol(Protocol.타입_요청_관리자, Protocol.코드_관리자요청_개설교과목생성);
                oos.write(protocol.getPacket());
            } else if (select == 2) {
                protocol = new Protocol(Protocol.타입_요청_관리자, Protocol.코드_관리자요청_개설교과목수정);
                oos.write(protocol.getPacket());
            } else if (select == 3) {
                protocol = new Protocol(Protocol.타입_요청_관리자, Protocol.코드_관리자요청_개설교과목삭제);
                oos.write(protocol.getPacket());
            }
        } else if (num == 4) {
            if (select == 1) {
                protocol = new Protocol(Protocol.타입_요청_관리자, Protocol.코드_관리자요청_강의계획서시작및종료기간설정);
                oos.write(protocol.getPacket());
            } else if (select == 2) {
                protocol = new Protocol(Protocol.타입_요청_관리자, Protocol.코드_관리자요청_강의계획서시작기간설정);
                oos.write(protocol.getPacket());
            } else if (select == 3) {
                protocol = new Protocol(Protocol.타입_요청_관리자, Protocol.코드_관리자요청_강의계획서종료기간설정);
                oos.write(protocol.getPacket());
            }
        } else if(num == 5) {
            if(select == 1) {
                protocol = new Protocol(Protocol.타입_요청_관리자, Protocol.코드_관리자요청_학년별수강신청시작및종료기간설정);
                oos.write(protocol.getPacket());
            } else if(select == 2) {
                protocol = new Protocol(Protocol.타입_요청_관리자, Protocol.코드_관리자요청_학년별수강신청시작기간설정);
                oos.write(protocol.getPacket());
            } else if(select == 3) {
                protocol = new Protocol(Protocol.타입_요청_관리자, Protocol.코드_관리자요청_학년별수강신청종료기간설정);
                oos.write(protocol.getPacket());
            }
        } else if (num == 6) {
            if (select == 1) {
                protocol = new Protocol(Protocol.타입_요청_관리자, Protocol.코드_관리자요청_계정정보조회_교수);
                oos.write(protocol.getPacket());
            } else if (select == 2) {
                protocol = new Protocol(Protocol.타입_요청_관리자, Protocol.코드_관리자요청_계정정보조회_학생);
                oos.write(protocol.getPacket());
            }
        } else if (num == 7) {
            if (select == 1) {
                protocol = new Protocol(Protocol.타입_요청_관리자, Protocol.코드_관리자요청_개설교과목정보조회_전체);
                oos.write(protocol.getPacket());
            } else if (select == 2) {
                protocol = new Protocol(Protocol.타입_요청_관리자, Protocol.코드_관리자요청_개설교과목정보조회_교수별);
                String info = sc.nextLine();
                protocol.setData(info);
                oos.write(protocol.getPacket());
            } else if (select == 3) {
                protocol = new Protocol(Protocol.타입_요청_관리자, Protocol.코드_관리자요청_개설교과목정보조회_학년별);
                String info = sc.nextLine();
                protocol.setData(info);
                oos.write(protocol.getPacket());
            } else if (select == 4) {
                protocol = new Protocol(Protocol.타입_요청_관리자, Protocol.코드_관리자요청_개설교과목정보조회_교수학년별);
                String[] info = new String[DataSize_Const.교수이름및대상학년정보];
                for(int i = 0; i < info.length; i++) {
                    info[i] = sc.next();
                }
                protocol.setData(info);
                oos.write(protocol.getPacket());
            }
        }
        oos.flush();
    }

    public static void createProfessor(InputStream ois, OutputStream oos, Protocol protocol) throws IOException {
        choices(1, 1, protocol, oos);

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
        
        NecessaryFunction.multyInput(protocol, oos, Protocol.타입_정보전송_계정정보, Protocol.코드_정보전송_계정정보_교수, DataSize_Const.교수정보);

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

        메세지메뉴.교수계정생성성공();

    }

    public static void createStudent(InputStream ois, OutputStream oos, Protocol protocol) throws IOException  {
        choices(1, 2, protocol, oos);

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

        NecessaryFunction.multyInput(protocol, oos, Protocol.타입_정보전송_계정정보, Protocol.코드_정보전송_계정정보_학생, DataSize_Const.학생정보);

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

        메세지메뉴.학생계정생성성공();

    }

    public static void createSubject(InputStream ois, OutputStream oos, Protocol protocol) throws IOException  {
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

        NecessaryFunction.multyInput(protocol, oos, Protocol.타입_정보전송_교과목정보, DataSize_Const.교과목정보);

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

        메세지메뉴.교과목생성성공();

    }

    public static void updateSubject(InputStream ois, OutputStream oos, Protocol protocol) throws IOException  {
        choices(2, 2, protocol, oos);

        protocol = new Protocol();

        NecessaryFunction.Read(ois, protocol);
        int packetType = protocol.getType();
        int packetCode = protocol.getCode();

        if(!NecessaryFunction.isType(packetType) || !NecessaryFunction.isCode(packetCode)) {
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

        관리자메뉴.교과목전체정보수정메뉴();
        NecessaryFunction.updateSubjectInfo(protocol, oos, Protocol.타입_정보전송_교과목정보, DataSize_Const.교과목수정정보);

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

        메세지메뉴.교과목수정성공();

    }

    public static void deleteSubject(InputStream ois, OutputStream oos, Protocol protocol) throws IOException  {
        choices(2, 3, protocol, oos);

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

        메세지메뉴.교과목삭제성공();

    }

    public static void createOpenSubject(InputStream ois, OutputStream oos, Protocol protocol) throws IOException  {
        choices(3, 1, protocol, oos);

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

        NecessaryFunction.multyInput(protocol, oos, Protocol.타입_정보전송_개설교과목정보, DataSize_Const.개설교과목정보);

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

        메세지메뉴.개설교과목생성성공();

    }

    public static void updateOpenSubject(InputStream ois, OutputStream oos, Protocol protocol) throws IOException  {
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

        관리자메뉴.개설교과목전체정보수정메뉴();
        NecessaryFunction.updateSubjectInfo(protocol, oos, Protocol.타입_정보전송_개설교과목정보, DataSize_Const.개설교과목수정정보);

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

        메세지메뉴.개설교과목수정성공();

    }

    public static void deleteOpenSubject(InputStream ois, OutputStream oos, Protocol protocol) throws IOException  {
        choices(3, 3, protocol, oos);

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

        메세지메뉴.개설교과목삭제성공();

    }

    public static void inputStartAndEndSyllabus(InputStream ois, OutputStream oos, Protocol protocol) throws IOException  {
        choices(4, 1, protocol, oos);

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

        관리자메뉴.강의계획서입력시작종료기간설정메뉴();
        NecessaryFunction.multyInput(protocol, oos, Protocol.타입_정보전송_강의계획서기간정보, Protocol.코드_정보전송_강의계획서기간정보_시작및종료기간, DataSize_Const.강의계획서시작및종료시간정보);

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

        메세지메뉴.강의계획서기간설정성공();

    }

    public static void inputStartSyllabus(InputStream ois, OutputStream oos, Protocol protocol) throws IOException  {
        choices(4, 2, protocol, oos);

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

        관리자메뉴.강의계획서입력시작기간설정메뉴();
        NecessaryFunction.singleInput(protocol, oos, Protocol.타입_정보전송_강의계획서기간정보, Protocol.코드_정보전송_강의계획서기간정보_시작기간);

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

        메세지메뉴.강의계획서기간설정성공();

    }

    public static void inputEndSyllabus(InputStream ois, OutputStream oos, Protocol protocol) throws IOException  {
        choices(4, 3, protocol, oos);

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

        관리자메뉴.강의계획서입력종료기간설정메뉴();
        NecessaryFunction.singleInput(protocol, oos, Protocol.타입_정보전송_강의계획서기간정보, Protocol.코드_정보전송_강의계획서기간정보_종료기간);

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

        메세지메뉴.강의계획서기간설정성공();

    }

    public static void inputStartAndEndCourse(InputStream ois, OutputStream oos, Protocol protocol) throws IOException  {
        choices(5, 1, protocol, oos);

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
        
        관리자메뉴.학년별수강신청시작종료기간설정메뉴();
        NecessaryFunction.multyInput(protocol, oos, Protocol.타입_정보전송_수강신청기간정보, Protocol.코드_정보전송_수강신청기간정보_시작및종료기간, DataSize_Const.학년별수강신청시작및종료기간설정정보);

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

        메세지메뉴.수강신청기간설정성공();

    }

    public static void inputStartCourse(InputStream ois, OutputStream oos, Protocol protocol) throws IOException  {
        choices(5, 2, protocol, oos);

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

        관리자메뉴.학년별수강신청시작기간설정메뉴();
        NecessaryFunction.multyInput(protocol, oos, Protocol.타입_정보전송_수강신청기간정보, Protocol.코드_정보전송_수강신청기간정보_시작기간, DataSize_Const.학년별수강신청시작기간설정정보);

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

        메세지메뉴.수강신청기간설정성공();

    }
    public static void inputEndCourse(InputStream ois, OutputStream oos, Protocol protocol) throws IOException  {
        choices(5, 3, protocol, oos);

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

        관리자메뉴.학년별수강신청종료기간설정메뉴();
        NecessaryFunction.multyInput(protocol, oos, Protocol.타입_정보전송_수강신청기간정보, Protocol.코드_정보전송_수강신청기간정보_종료기간, DataSize_Const.학년별수강신청종료기간설정정보);

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

        메세지메뉴.수강신청기간설정성공();

    }

    public static void readProfessor(InputStream ois, OutputStream oos, Protocol protocol) throws IOException  {
        choices(6, 1, protocol, oos);

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

    public static void readStudent(InputStream ois, OutputStream oos, Protocol protocol) throws IOException  {
        choices(6, 2, protocol, oos);

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

    public static void readSubjectAll(InputStream ois, OutputStream oos, Protocol protocol) throws IOException  {
        choices(7, 1, protocol, oos);

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

    public static void readSubjectProfessor(InputStream ois, OutputStream oos, Protocol protocol) throws IOException  {
        choices(7, 2, protocol, oos);

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

    public static void readSubjectGrade(InputStream ois, OutputStream oos, Protocol protocol) throws IOException  {
        choices(7, 3, protocol, oos);

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

    public static void readSubjectProfessorAndGrade(InputStream ois, OutputStream oos, Protocol protocol) throws IOException  {
        choices(7, 4, protocol, oos);

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
