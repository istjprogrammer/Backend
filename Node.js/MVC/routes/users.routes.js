const express = require('express')
const postsControllers = require("../controllers/posts.controller");
const postsRouter = express.Router()

postsRouter.get("/", postsControllers.getPost);

module.exports = postsRouter;
