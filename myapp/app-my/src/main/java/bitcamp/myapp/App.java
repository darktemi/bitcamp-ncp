package bitcamp.myapp;

public class App {

  public static void main(String[] args) {
    App.mainMenu();
    System.out.println("안녕히 가세요!");
    Prompt.close();
  } // main()

  static void mainMenu() {
    while (true) {
      System.out.println("1. 일반 학생 관리");
      System.out.println("2. 국비 지원 학생 관리");
      System.out.println("3. 위탁 교육생 학생 관리");
      System.out.println("9. 종료");

      int menuNo = Prompt.inputInt("메뉴>");

      if (menuNo == 1) {
        MemberHandler.title = "일반 학생";
        MemberHandler.service();
      } else if (menuNo == 2) {
        Member2Handler.title = "국비 지원 학생";
        Member2Handler.service();
      } else if (menuNo == 3) {
        Member3Handler.title = "위탁 교육생";
        Member3Handler.service();
      } else if (menuNo == 9) {
        break;
      } else {
        System.out.println("잘못된 입력입니다.");
      }
    }
  }
} // class App









