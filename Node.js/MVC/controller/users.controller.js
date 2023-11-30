const Users = require("../models/users.model")

function getUsers(req, res){
    res.send(Users);
}

function getUser(req, res){
    const userId = req.params.userId;
    const user = Users[userId];
    if(user)
        res.json(user);
    else
        res.sendStatus(404).end();
}

function postUser(req, res){
    if(!req.body.name){
        return res.status(400).json({error: "Missing user name"});  
    }

    const newUser = {
        name : req.body.name,
        id : Users.length
    }

    Users.push(newUser);
    res.json(newUser);
}

module.exports = {
    getUser,
    getUsers,
    postUser
}
