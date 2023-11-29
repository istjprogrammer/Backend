//JS는 단순히 HTML을 꾸며주는 기능으로만 쓰지 않는다.
//웹 서버 생성에도 JS가 쓰일 수 있다.
const http = require("http");
//port값은 자주 바뀔 수 있어서 상수로 지정하는게 낫다.
const PORT = 3007

const targetObject = {a: "a", b: "b"};


//createServer 함수 정의

//server라는 객체 생성
//http에서는 성공시 200을 출력한다!
//JSON.stringfy를 해줘야 문자열로 묶어줄 수 있고 정상적으로 출력할 수 있다.
//res.setHeader를 통해서 값을 지정해줄 수 있다.
const server = http.createServer((req,res)=>{
    //post방식은 if문으로 처리
    //post방식이면서 라우팅은 home으로 접속했을 때
    //post 방식은 url로 바로 접속이 안되서(get방식은 가능하다.) 웹브라우저에서 콘솔창을 열어서 실행해야 한다.
    //fetch('http://localhost:3007/home', {method:'POST'}, body:JSON.stringify({c:"c"})); 이렇게 콘솔창에 입력해주면 테스트 가능!
    if(req.method == "POST" && req.url==="/home"){
        //on은 사용자가 요청을 보냈을 때 활성화시키는 기능이다.
        req.on('data', (data)=> {
            console.log(data)
        })
    }

    //get방식은 eles문으로 처리
    else{
    if(req.url === "/home"){
    res.statusCode = 200;
    res.setHeader('Content-type', {"Content-Type": "application/json"})
    res.end(JSON.stringify(targetObject))}

    //write기능 수행
    else if(req.url === "/about"){
        res.setHeader("Content-type", "text/html");
        res.write("<html>")
        res.write("<body>")
        res.write("<h1>About Page</h1>")
        res.write("</body>")
        res.write("</html>")
        res.end()
    }
    //home과 about이 아닌 url입력시
    else{
        res.statusCode = 404;
        res.end()
    }
}
});

//네트워크 프로그램은 port가 있어야 동작이 가능하다.
//이렇게 만들면 localhost:3007을 입력하면 Hello라고 잘 출력되는 것을 볼 수 있다.
server.listen(PORT, ()=>{
    console.log(`Listening on port ${PORT}`)
});
