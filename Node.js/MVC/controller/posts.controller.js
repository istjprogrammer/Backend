const path = require("path")
//절대경로로 해줘야 잘 동작할 수 있다.

function getPost(req, res) {
    res.render('posts', {
    tempName: "post",
    title : "Post Page"
    })
}

module.exports = {getPost}
