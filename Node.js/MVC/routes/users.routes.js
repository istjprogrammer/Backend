const express = require("express");
const userControllers = require("./controllers/users.controller");
const usersRouter = express.Router()

usersRouter.get("/users", userControllers.getUsers);
usersRouter.get("/users/:userId", userControllers.getUser);
usersRouter.post("/users", userControllers.postUser);

module.exports = usersRouter;
