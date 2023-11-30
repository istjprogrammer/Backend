const Users = require("../models/users.model")

//모든 사용자 조회
function getUsers(req, res) {
    res.send(Users);
}

//특정 사용자 조회
function getUser(req, res) {
    const userId = req.params.userId
    const user = Users[userId]    
    if (user)
        res.json(user);
    //잘못된 아이디 전송시 404에러 출력
    else
        res.sendStatus(404).end();
}

//사용자 추가 기능
function postUser(req, res) {
    if (!req.body.name) {
        res.status(400).json({ error: "Missing user name" })
    }

    const newUser = {
        name: req.body.name,
        id: Users.length
    }

    Users.push(newUser);
    res.json(newUser);
}

module.exports = {
    getUser,
    getUsers,
    postUser   
}
