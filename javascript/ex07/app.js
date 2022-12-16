// express 라이브러리 로딩하기
const { response } = require('express');
const express = require('express');
// HTTP 요청을 다루는 라이브러리 로딩하기
const request = require('request');

const port = 3000; // 웹 서버 포트 번호

// express()를 호출하여 웹 서버를 준비
const app = express();

// 클라이언트 요청에 대해 호출될 매서드를 등록
app.get(                     // 클라이언트에서 get 요청이 들어왔을 때 호출될 매서드 지정
  '/exam01-1',               // 요청 url
  (req, res) => {                    // 요청 핸들러: 요청이 들어 왔을 때 호출되는 매서드
    res.set('access-control-allow-origin', '*'); // CORS 문제 해결
    res.set('content-Type', 'text/plain; charset=UTF-8');
    res.send("Hello! (서영훈)");
  } 
); 

// 클라이언트 요청을 다른 서버에게 보낸다.
app.get('/proxy', (req, res) => {
  console.log(req.query.url);

  request.get({
    url: req.query.url
  }, (error, response, body) => {
    console.log("네이버에서 응답 받았음!");
  });

  res.set('access-control-allow-origin', '*');
  res.set('content-Type', 'text/plain; charset=UTF-8');
  res.send("Hello! proxy!");
}); 

// 웹 서버 실행하기
app.listen(
  3000,                 // 포트번호 지정
  () => {               // 서버가 시작되었을 때 호출될 함수 = 리스너 = 이벤트 핸들러
    console.log(`${port}번 포트에서 서버 시작했음!`);
  } 
);



console.log("서버 시작했음!");

