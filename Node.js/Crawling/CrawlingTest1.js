const axios = require("axios");
const cheerio = require("cheerio");

//axios를 활용해서 비동기로 크롤링을 하는 함수(async, await)
//promise를 리턴하면 await를 쓸 수 있다.
const getHtml = async ()=>{
    try{
    return await axios.get("https://roadbook.co.kr/category/%EC%8B%A0%EA%B0%84%EC%86%8C%EA%B0%9C")
    }
    catch(err){
        console.log(err);
    }
};

getHtml()
    .then((html)=>{
        const $ = cheerio.load(html.data);
        // console.log($);
        //$는 전체 값을 의미한다.
        //모든 자식들을 가져오는데 li테그만 가져오기
        $bodyList = ($("div#searchList ol").children("li"));

        $bodyList.each(function (i, elem){
            console.log($(this).find('a').text());
        });
    })
