const path = require("path")

//이미지를 등록하기 위한 기능
function getPost(req, res){
    res.sendFile(path.join(__dirname, '..', 'public', 'images', 'running.gif'));
}

module.exports = {getPost}
