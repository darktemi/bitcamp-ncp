package bitcamp.myapp.test;

import bitcamp.myapp.BoardHandler;
import bitcamp.myapp.Prompt;

public class App {

  public static void main(String[] args) {
    mainMenu();
    System.out.println("종료합니다.");
    Prompt.close();
  }

  private static void mainMenu() {

    BoardHandler boardHandler = new BoardHandler("게시글 관리");

    while (true) {
      System.out.println("1. 게시글 관리");
      System.out.println("9. 종료");
      int menuNo = Prompt.inputInt("메뉴> ");

      if(menuNo == 1) {
        boardHandler.menu();
      } else if (menuNo == 9) {
        break;
      } else {
        System.out.println("잘못된 입력입니다.");
      }
    }
  }
} // class App









