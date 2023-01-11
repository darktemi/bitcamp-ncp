package bitcamp.bootapp.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import bitcamp.bootapp.dao.MemberDao;
import bitcamp.bootapp.vo.Member;

@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://localhost:5500"})
@RestController
public class MemberController {

  MemberDao memberDao = new MemberDao();

  @PostMapping("/members")
  public Object addMember(
      // @RequestParam(required = false)
      String name, // ..&name=xx&..
      String tel, // ..&tel=xx&..
      String postNo, // ..&postNo=xx&..
      String basicAddress, // ..&basicAddress=xx&..
      String detailAddress, // ..&detailAddress=xx&..
      boolean working, // ..&working=xx&.. => "true"=true/"false"=false, 파라미터 없으면 false,
      // "on"=true/"off"=false, "1"=true/"0"=false, 그 밖에 문자열은 변환 오류 발생
      char gender, // ..&gender=M&.. => 문자 1개의 문자열 변환, null 또는 그 밖에 문자열은 변환 오류 발생
      byte level // ..&level=1&.. => Byte.parseByte("1") => byte의 허용 범위인 127을 넘어가거나 null은 변환 오류 발생
      ) {

    Member m = new Member();
    m.setName(name);
    m.setTel(tel);
    m.setPostNo(postNo);
    m.setBasicAddress(basicAddress);
    m.setDetailAddress(detailAddress);
    m.setWorking(working);
    m.setGender(gender);
    m.setLevel(level);
    m.setCreatedDate(new Date(System.currentTimeMillis()).toString());

    this.memberDao.insert(m);
    // 응답 결과를 담을 맵 객체 준비
    Map<String,Object> contentMap = new HashMap<>();
    contentMap.put("status", "success");

    return contentMap;
  }


  @GetMapping("/members")
  public Object getMembers() {

    Member[] members = this.memberDao.findAll();

    Map<String,Object> contentMap = new HashMap<>();
    contentMap.put("status", "success");
    contentMap.put("data", members);

    return contentMap;
  }

  @GetMapping("/members/{memberNo}")
  public Object getMember(@PathVariable int memberNo) {

    Member m = this.memberDao.findByNo(memberNo);

    // 응답 결과를 담을 맵 객체 준비
    Map<String,Object> contentMap = new HashMap<>();

    if (m == null) {
      contentMap.put("status", "failure");
      contentMap.put("data", "해당 번호의 게시글이 없습니다.");
    } else {
      contentMap.put("status", "success");
      contentMap.put("data", m);
    }

    return contentMap;
  }

  @PutMapping("/members/{no}")
  public Object updateMember(
      //@PathVariable int memberNo, // Member 인스턴스로 직접 받을 수 있다.
      Member m) {

    Map<String,Object> contentMap = new HashMap<>();

    Member old = this.memberDao.findByNo(m.getNo());
    if (old == null) {
      contentMap.put("status", "failure");
      contentMap.put("data", "회원이 없습니다.");
      return contentMap;
    }

    m.setCreatedDate(old.getCreatedDate());

    this.memberDao.update(m);

    contentMap.put("status", "success");

    return contentMap;
  }

  @DeleteMapping("/members/{memberNo}")
  public Object deleteMember(@PathVariable int memberNo) {
    // 낱개로 받을 때는 @PathVariable을 생략하면 안된다.

    Member m = this.memberDao.findByNo(memberNo);

    // 응답 결과를 담을 맵 객체 준비
    Map<String,Object> contentMap = new HashMap<>();

    if (m == null) {
      contentMap.put("status", "failure");
      contentMap.put("data", "회원이 없습니다.");
    } else {
      this.memberDao.delete(m);
      contentMap.put("status", "success");
    }

    return contentMap;
  }

}
