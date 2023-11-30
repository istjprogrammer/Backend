//먼저 express서버를 가져와준다
const express = require("express");
const usersRouter = require("./routes/users.routes");

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
})

app.use(express.json())

usersRouter.get("/", (req, res)=>{
    res.send("<h1>Hello World!</h1>")
});

//라우터 등록
app.use("/users", usersRouter)

app.listen(PORT, HOST);
console.log(`Run on http://${HOST}:${PORT}`)
