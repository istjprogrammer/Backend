const express = require('express')
const userControllers = require("../controllers/posts.controller");
const postsRouter = express.Router()

postsRouter.get("/", postsControllers.getPost);

module.exports = postsRouter;
