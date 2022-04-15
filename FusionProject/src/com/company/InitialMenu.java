package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class InitialMenu {
    public static void main(String[] args) throws IOException {
        int input = -1;

        while(true){
            Socket socket = new Socket(args[0], Integer.parseInt(args[1]));
            OutputStream oos = socket.getOutputStream();
            InputStream ois = socket.getInputStream();

            Protocol protocol = new Protocol();
            byte[] buf = protocol.getPacket();


            초기접속화면.수강신청프로그램초기메뉴();
            input = NecessaryFunction.getInput(input);

            switch(input){
                case 1:
                    InitialMainService.login(ois, oos, protocol, socket);
                    NecessaryFunction.exit(oos, protocol);
                    break;
                case 2:
                    InitialMainService.createAdmin(ois, oos, protocol);
                    NecessaryFunction.exit(oos, protocol);
                    break;
                case 0:
                    메세지메뉴.연결종료();
                    NecessaryFunction.exit(oos, protocol);
                    return;
                default:
                    메세지메뉴.오류로인한종료();
                    NecessaryFunction.exit(oos, protocol);
                    return;
            }
        }
    }
}
