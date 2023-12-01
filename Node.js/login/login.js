/*
//설치
- npm i cookie-parser
- npm i session-parser
*/

//모듈 호출
const express = require('express');
const cookieParser = require("cookie-parser");
const session = require("express-session");

const app = express();

//포트번호 지정
app.set('port', process.env.PORT || 9999);

//메인페이지 설정
app.get("/", (req, res)=>{
    const output = `<h2>로그인 하지 않은 사용자 입니다.</h2>
    <p>로그인 해주세요</p>`
    
    res.send(output)
})

//실행
app.listen(app.get('port'))
