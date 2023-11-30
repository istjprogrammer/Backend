//먼저 express서버를 가져와준다
const express = require("express");
const userControllers = require("./users.controller");

//port번호 지정
const PORT = 4000;
const HOST = "0.0.0.0";

const app = express();

//MiddleWare(req와 res의 중간 다리 역할)
app.use((req, res, next)=>{
    //현재 시간을 저장
    const start = Date.now();
    console.log(`${req.method} ${req.url}`);
    next();

    const diffTime = Date.now() - start;
    console.log(`${req.method} ${req.url} ${diffTime}ms`);
    //요청을 계속 하다보면 처음에는 4ms이후에는 1ms밖에 안걸린다.
    //캐시 때문에 그렇다.
})

//middleware use를 확인할 수 있도록 설정
app.use(express.json())

//use를 활용해서 middleware가 만들어진다.

app.get("/", (req, res)=>{
    res.send("<h1>Hello World!</h1>")
});

//getuser함수호출
app.get("/users", userControllers.getUsers);


//restful 방식으로 요청하기(특정 사용자에게만 요청)
//id가 1인 사람에게 요청할때는?
//그러나 이렇게 하면 일관성이 떨어진다.

//get방식으로 /users라는 요청이 들어왔을 때 보여줄 정보
//전체 사용자가 아니라 특정 사용자만 조회하겠다는 요청
//userId라는 변수를 선언
//Users라는 배열에서 아이디를 꺼내오는 방식으로

//http://localhost:4000/users/1 이렇게 요청하면 users의 jeniffer가 잘 출력된다.

//getuser 함수호출
app.get("/users/:userId", userControllers.getUser);

//post방식 요청
//이 경우 middleware가 막혀서 undefined가 뜬다.
//middleware가 제대로 역할을 해줘야 데이터를 꺼내올 수 있다.
app.post("/users", userControllers.postUser);

app.listen(PORT, HOST);
console.log(`Run on http://${HOST}:${PORT}`)
