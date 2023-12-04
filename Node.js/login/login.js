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

app.use(cookieParser("1111"));
//session 사용설정
app.use(session({
    secret:"1111",
    resave: false, //새로운 요청 시 세션에 변동사항이 없어도 다시 저장할지를 설정
    saveUninitialized: true, //세션에 저장할 내용이 없어도 저장할지 설정
    //쿠키와 관련된 정보는 나중에 따로 지정해주면 된다.
    cookie:{
        httpOnly : true
    },
}))
//req -> 쿠키 -> 세션 -> res(쿠키/세션이라는 미들웨어를 거치면서 정보가 가공되어 넘어간다.)
//패스워드는 절대 쿠키에 저장하면 안된다.

app.use(express.json());

//메인페이지 설정
app.get("/", (req, res)=>{
    //세션이 비어있느냐 비어있지 않느냐를 확인
    //output을 변수로 함수 바깥에 지정
    let output;
    if(req.session.name){
        output = `<h2>로그인 한 사용자</h2>
        <p>${req.session.name}님 안녕하세요.</p>`
    }
    else{
    output = `<h2>로그인 하지 않은 사용자 입니다.</h2>
    <p>로그인 해주세요</p>`
    }
    res.send(output)
})

//로그인 라우팅 실행
app.get("/login", (req,res)=>{
    console.log("test")
    //세션 정보 확인
    console.log("session:",req.session);
    // res.cookie("name", "guswo");

    req.session.name = "이현재";
    res.end("login ok")
})

//로그아웃
app.get("/logout", (req, res)=>{
    res.clearCookie('connect.sid');
    res.end('Logout Ok')
})

//실행
app.listen(app.get('port'))
