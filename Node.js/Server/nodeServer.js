//JS는 단순히 HTML을 꾸며주는 기능으로만 쓰지 않는다.
//웹 서버 생성에도 JS가 쓰일 수 있다.
const http = require("http");

//createServer 함수 정의
http.createServer((req,res)=>{
    res.end("Hello")
});
