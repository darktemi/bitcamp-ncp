const express = require('express');
const app = express();
const port = 3000;

// app.get('/hello', function handleHello(req, res) {
  // res.send('Hello!');
//}); 클라이언트가 hello라는 요청을 보내면 두번 째 파라미터 함수를 호출
      // => 해당 함 수 자체를 파라미터로 집어넣어도 됨


app.get('/exam05_1', async (req, res) => {
  await new Promise(resolve => setTimeout(resolve,10000));
  res.send('console.log("exam05_1 ok!");');
})

app.get('/exam05_2', async (req, res) => {
  await new Promise(resolve => setTimeout(resolve,10000));
  res.send('console.log("exam05_2 ok!");');
})

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`);
})

