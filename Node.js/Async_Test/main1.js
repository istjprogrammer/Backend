//콜백을 이용한 함수
/*
const a = (callback) => {
    //1초 늦게 출력
    setTimeout(()=>{console.log(1);callback();}, 1000);
};

const b = () =>{
    setTimeout(()=>{console.log(2); callback();}, 1000);
};

const c = (callback) => {setTimeout(()=>{
    console.log(3);
    callback();
}, 1000)}

const d = () => {console.log(4)}
*/

//a가 호출 후 b가 호출되는 것(예전에 많이 썼다.)
//콜백지옥 예시

// a(()=>{
//     b(()=>{
//         c(()=>{
//             d()
//         })
//     })
// })

//promise로 콜백지옥을 해결하는 방법(위의 방법은 비동기처리에서 순서를 정할수는 있지만 너무 복잡하다.)
//promise를 사용하면 잘 처리가 되면 그 다음으로 넘겨준다.
const a = ()=>{
    return new Promise((resolve)=>{
        setTimeout(()=>{console.log(1);resolve();}, 1000);
    });
}

const b = ()=>{
    return new Promise((resolve)=>{
        setTimeout(()=>{console.log(2);resolve();}, 1000);
    });
}

const c = ()=>{
    return new Promise((resolve)=>{
        setTimeout(()=>{console.log(3);resolve();}, 1000);
    });
}

const d = ()=>{console.log(4);}

/*
a().then(()=>{
    b().then(()=>{
        c().then(()=>{
            d()
        })
    })
})
*/

//이렇게 다 생략해도 정상적으로 동작한다!
/*
a()
    .then(()=>b())
    .then(()=>c())
    .then(()=>d())
*/

//최대치로 이렇게까지 줄일 수 있다.
a()
    //then은 대기중(pending을 의미)
    .then(b)
    .then(c)
    .then(d)
    .then(()=>console.log('끝'))
