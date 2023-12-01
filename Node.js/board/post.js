//모듈 불러오기
const morgan = require('morgan')
const express = require('express')

//웹 서버 만들기
const app = express();
app.set('port', process.env.PORT || 9999);

app.use(morgan('dev'));
app.use(express.json());
app.use(express.urlencoded({extended:true}))

let boardList = [];
let board_id = 0;

//라우팅
app.get("/", (req, res)=>{
    res.send("<h1>게시판 연습</h1>")
})

app.get("/board", (req, res)=>{
    res.send(boardList);
})

app.post("/board", (req, res)=>{
    const board = {
        "id" : ++board_id,
        "user_id" : req.body.user_id,
        "date" : new Date(),
        "title" : req.body.title,
        "content" : req.body.content
    }
    boardList.push(board);

    res.redirect('/board');
})

//실행 코드
app.listen(app.get('port'), ()=>{
    console.log(app.get('port'), '번에서 서버 실행중')
});

//nodemon 설치 후 script에 run으로 실행 가능하도록 코드 짜준다.
//이후 post방식으로 postman에서 body테그에 json형식으로 자료를 보내주기
