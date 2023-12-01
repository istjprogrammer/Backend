/*모듈
-npm i express
-npm i morgan
*/

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

//등록
// app.post("/board", (req, res)=>{
//     const board = {
//         "id" : ++board_id,
//         "user_id" : req.body.user_id,
//         "date" : new Date(),
//         "title" : req.body.title,
//         "content" : req.body.content
//     }
//     boardList.push(board);

//     res.redirect('/board');
// })

//삭제
// app.delete('/board/:id', (req,res)=>{
//     const findItem = boardList.find((item)=>{
//         return item.id == +req.params.id
//     })

//     const idx = boardList.indexOf(findItem);
//     boardList.splice(idx, 1);

//     res.redirect('/board');
// });

//수정
//+를 하면, 공백을 띄워주는 역할
app.put("/board/:id", (req, res)=>{
    const findItem = boardList.find((item)=>{
        return item.id == req.params.id
    })

    const idx = boardList.indexOf(findItem)
    boardList.splice(idx, 1)

    const board = {
        "id" : req.params.id,
        "user_id" : req.body.user_id,
        "date" : new Date(),
        "title" : req.body.title,
        "content" : req.body.content
    }
    boardList.push(board);
});

//실행 코드
app.listen(app.get('port'), ()=>{
    console.log(app.get('port'), '번에서 서버 실행중')
});
