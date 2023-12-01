const oracledb = require("oracledb");
const dbConfig = require("./dbconfig.js");

oracledb.autoCommit = true;

function init(){
    //설치된 경로 지정
    oracledb.initOracleClient({libDir:"C:\\konny\\BackEnd\\instantclient_21_12"})
}

init();

//DB연결을 담당하는 함수
oracledb.getConnection({
    user:dbConfig.user,
    password:dbConfig.password,
    connectString: dbConfig.connectString
}, (err, conn)=>{
    // console.log("Oracle DB 연결 성공 : " + conn);
    let sql;

    /*
    //DB 조회
    sql = "select empno, ename, job, hiredate from emp";
    //execute라는 함수로 db에게 명령어를 전달해서 실행
    //명령어와 파라미터를 입력(현재 파라미터는 없으므로 빈 값으로 전달)
    //(명령어, 파라미터, 콜백함수)
    conn.execute(sql, [], (err, result)=>{
        if(err){
            throw err;
        }
        console.log(result.rows);
        doRelease(conn);
    });
    */
    //CREATE(생성)
    /*
    sql =  `create table nodeUser(
            id varchar2(10),
            password varchar2(10),
            name varchar2(10),
            age number)`;

    conn.execute(sql);
    console.log("테이블 생성 완료");
    */

    //INSERT(삽입)
    /*
    sql = "insert into nodeUser values(:id, :pw, :name, :age)";
    
    //값을 1개만 넣을 때
    //let binds = [["a1", "1111", "홍길동", 20]]

    let binds = [["b1", "1111", "Lee", 21],
                 ["c1", "1111", "Kim", 20],
                 ["d1", "1111", "Park", 19]]
    conn.executeMany(sql, binds, {});
    */

    //UPDATE(수정)
    sql = `update nodeUser set password=:pw, name=:name,
           age=:age where id=:id`;
    
    conn.executeMany(sql, [["2222", "Jeong", 31, "c1"]])

    //DELETE(삭제)
    /*
    sql = "delete nodeUser where id=:id";
    conn.execute(sql, ["b1"]);
    */
    sql = "select * from nodeUser";
    conn.execute(sql, [], (err, result)=>{
        console.log(result.rows);
        doRelease(conn);
    }) 
});

const doRelease = (conn)=>{
    conn.release((err)=>{
        if(err) throw err;
    });
}
