// //이건 동기 방식이다.
// //1->2->3이 출력되므로
// console.log(1);
// console.log(2);
// console.log(3);

// //비동기 방식
// console.log(1)
// setTimeout(()=>{console.log(2)}, 2000)
// console.log(3)

//즉 동기방식은 무조건 정해진 순서에 따라서 작업을 처리하는 것이고,
//비동기 방식은 순서 상관없이 실행되는 것이다.

//이것도 내가 클릭을 해야만 실행이 되는 것이므로 비동기 방식이다.

// const btnEl = document.querySelector("h1")
// btnEl.addEventListener("click", ()=>{
//     console.log("clicked!")
// })

// console.log("Hello world")

/*frozen이라는 영화의 정보를 받기 위한 동작*/
// fetch('https://www.omdbapi.com/?apikey=7035c60c&s=frozen')
//     //fetch로 데이터를 받아온 다음 then으로 함수 돌려주기  
//      .then(res => res.json())
//      .then(res => console.log(res))

// //1,2,3이 먼저 출력되고 fetch로 받아온 정보가 출력된다
// //비동기 방식이라 순서 없이 빨리 실행되는 순서대로 출력되는것!(운영체제 참고)
// //자바스크립트는 기본적으로 비동기로 처리가 된다.
// console.log(1);
// console.log(2);
// console.log(3);

//동기적으로 처리하려면?
/*
const getMovies = (movieName, cb) =>{
fetch(`https://www.omdbapi.com/?apikey=7035c60c&s=${movieName}`)
    //fetch로 데이터를 받아온 다음 then으로 함수 돌려주기  
     .then(res => res.json())
     .then(res => {console.log(res); cb();
    })
}*/
//비동기 방식도 콜백을 활용하면 내가 원하는대로 순서를 조정할 수 있다!
//이렇게 하면 겨울왕국->어벤저스->아바타 이렇게 나온다.
//하지만 이럴 경우 메모리 문제가 발생할 수 있는데 이는 promise로 해결이 가능하다.
// getMovies('frozen', ()=>{
//     console.log("겨울 왕국")
//     getMovies('avengers', ()=>{console.log("어밴저스")});
//     getMovies('avater', ()=>{console.log("아바타")})
// });     

//promise란?
// 대기(pending): 이행하지도, 거부하지도 않은 초기 상태.
// 이행(fulfilled): 연산이 성공적으로 완료됨.
// 거부(rejected): 연산이 실패함.

//getMovies를 promies 방식으로 수정

/*
const getMovies = (movieName, cb) =>{
    return new Promise(resolve =>{
    fetch(`https://www.omdbapi.com/?apikey=7035c60c&s=${movieName}`)
        //fetch로 데이터를 받아온 다음 then으로 함수 돌려주기  
         .then(res => res.json())
         .then(res => {console.log(res); resolve();
        })
    })
}
*/
/*
getMovies('frozen').then(()=>{
    console.log("겨울왕국")
    return getMovies('avengers');
}).then(()=>{
    console.log("어벤져스")
    return getMovies('avatar')
}).then(()=>{
    console.log("아바타");
});
*/

//async와 await 방식으로 바꿔본다면?

/*
const wrap = async()=>{
    await getMovies('frozen')
    console.log("겨울 왕국")

    await getMovies('avengers')
    console.log("어벤져스")

    await getMovies('avatar')
    console.log("아바타")
}

wrap();
*/

//promise를 활용한 error처리 방식
/*
const getMovies = (movieName) =>{
    return new Promise((resolve, reject) => {
    fetch(`https://www.omdbapi.com/?apikey=7035c60c&s=${movieName}`)
        //fetch로 데이터를 받아온 다음 then으로 함수 돌려주기  
        .then(res => res.json())
        .then(json => {console.log(json);
                        //Error 처리 방식
                        if(json.Response == "False"){
                            reject(json.Error)
                        }
                        //그렇지 않을 경우 resolve 출력
                        resolve(json)
        })
        .catch(err => {reject(err)})
    })
}
*/
/*
let loading = true;
getMovies('netsong')
    .then(movies => console.log("영화목록 : ", movies))
    .catch(error => {
            console.log("에러 발생: ", error)
            loading = false;    
        })
*/

/*
const wrap = async() => {
    try{
    const movies = await getMovies('avengers')
    console.log("영화 목록 : ", movies)
    }
    catch(err){
        console.log('에러 발생')
    }
}
wrap()
*/

//반복문에서 비동기 처리
const getMovies = (movieName) =>{
    return new Promise((resolve) => {
    fetch(`https://www.omdbapi.com/?apikey=7035c60c&s=${movieName}`)
        //fetch로 데이터를 받아온 다음 then으로 함수 돌려주기  
        .then(res => res.json())
        .then(json => resolve(json))
    })
}

const titles = ['frozen', 'avengers', 'avatar']

/*
titles.forEach(async title =>{
    const movies = await getMovies(title)
    console.log(title, movies)
})
*/

const wrap = async ()=>{
    for(const title of titles){
    const movies = await getMovies(title)
    console.log(title, movies)
    }
}
wrap()
