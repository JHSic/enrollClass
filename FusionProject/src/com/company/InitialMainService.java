package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class InitialMainService {

    public static void choices(int num, Protocol protocol, OutputStream oos) throws IOException {
        switch(num){
            case 1:
                protocol = new Protocol(Protocol.타입_요청_공통, Protocol.코드_공통요청_로그인);
                oos.write(protocol.getPacket());
                break;
            case 2:
                protocol = new Protocol(Protocol.타입_요청_공통, Protocol.코드_공통요청_관리자계정생성);
                oos.write(protocol.getPacket());
                break;
        }
    }

    public static void login(InputStream ois, OutputStream oos, Protocol protocol, Socket socket) throws IOException{
        choices(1, protocol, oos);

        protocol = new Protocol();
        int userType = -1;

        NecessaryFunction.Read(ois, protocol);
        int packetType = protocol.getType();
        int packetCode = protocol.getCode();

        if(packetType == Protocol.타입_요청_공통 && packetCode == Protocol.코드_공통요청_로그인_ID) {
            int count = 0;
            while (count < 3) {
                count++;
                초기접속화면.로그인메뉴();
                NecessaryFunction.singleInput(protocol, oos, Protocol.타입_정보전송_ID, Protocol.코드_응답_데이터전송);

                NecessaryFunction.Read(ois, protocol);
                packetType = protocol.getType();
                packetCode = protocol.getCode();

                if (packetType == Protocol.타입_요청_공통 && packetCode == Protocol.코드_공통요청_로그인_PW) {
                    count--;
                    break;
                } else if(packetType == Protocol.타입_응답 && packetCode == Protocol.코드_응답_실패) {
                    String error = protocol.getData();
                    System.out.println(error);
                } else {
                    String error = protocol.getData();
                    System.out.println(error);
                    return;
                }
            }
            if(count >= 3){ //재전송 횟수 3회 초과 시
                return;
            }
            count = 0;

            if (packetType == Protocol.타입_요청_공통 && packetCode == Protocol.코드_공통요청_로그인_PW) {
                while (count < 3) {
                    count++;
                    초기접속화면.비밀번호메뉴();
                    NecessaryFunction.singleInput(protocol, oos, Protocol.타입_정보전송_PW, Protocol.코드_응답_데이터전송);
                    NecessaryFunction.Read(ois, protocol);
                    packetType = protocol.getType();
                    packetCode = protocol.getCode();

                    if (packetType == Protocol.타입_응답 && packetCode == Protocol.코드_응답_데이터전송) {
                        count--;
                        break;
                    } else if(packetType == Protocol.타입_응답 && packetCode == Protocol.코드_응답_실패) {
                        String error = protocol.getData();
                        System.out.println(error);
                    } else {
                        String error = protocol.getData();
                        System.out.println(error);
                        return;
                    }
                }
            }
            if(count >= 3){ //재전송 횟수 3회 초과 시

                return;
            }

            if (packetType == Protocol.타입_응답 && packetCode == Protocol.코드_응답_데이터전송) {
                userType = Integer.parseInt(protocol.getData());
                메세지메뉴.로그인성공();
            }
        }
        else{
            //아예 이상한 코드가 들어옴
            메세지메뉴.오류로인한종료();
            return;
        }
        while(true){
            if(userType == 1) {
                AdminMenu.AdminMenuRun(ois, oos, protocol); //관리자 메뉴 실행
                break;
            }
            else if(userType == 2){
                ProfessorMenu.ProfessorMenuRun(ois, oos, protocol); //교수 메뉴 실행
                break;
            }
            else if(userType == 3){
                StudentMenu.StudentMenuRun(ois, oos, protocol); //학생 메뉴 실행
                break;
            }
            else{
                break;
            }
        }

    }

    public static void createAdmin(InputStream ois, OutputStream oos, Protocol protocol) throws IOException{
        choices(2, protocol, oos);

        protocol = new Protocol();

        NecessaryFunction.Read(ois, protocol);
        int packetType = protocol.getType();
        int packetCode = protocol.getCode();

        if(!NecessaryFunction.isType(packetType) && !NecessaryFunction.isCode((packetCode))){
            return;
        }

        if(NecessaryFunction.check(packetType, packetCode) == 2) {
            String result = protocol.getData();
            System.out.println(result);
            return;
        }

        초기접속화면.관리자회원가입메뉴();
        NecessaryFunction.multyInput(protocol, oos, Protocol.타입_정보전송_계정정보, Protocol.코드_정보전송_계정정보_관리자, DataSize_Const.관리자정보);

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

        메세지메뉴.관리자계정생성성공();

    }
}
