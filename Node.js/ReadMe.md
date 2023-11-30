1. Node.js란?
- 자바스크립트 엔진 : 자바스크립트를 실행할 수 있는 핵심 엔진이다.
- 자바스크립트 런타임 
    (1) 엔진의 종류 (어떤 엔진을 쓰느냐에 따라서 성능 차이가 많이 난다.)
        - v8 : Chrome
        - SpiderMonkey : Firefox
        - JavascriptCore : Safari
        - Chakra : IE

    (2) 브라우저 API & Node.js API
        - 모두 사용할 수 있는 API 
            console.log(), ...
        - 브라우저 API
            window, ...
        - Node.js API
            Process, ...(브라우저에서는 사용 불가능)
        
        - convention 규칙에 따른 함수명
            url, settimeout
2. 모듈 시스템
    (1) 모듈의 종류
        1) Core Module
            - 기본적으로 내장되어 있는 모듈
            - https://nodejs.org/dist/latest-v20.x/docs/api/
        2) Local Module
            - 로컬로 생성된 모듈
        3) Third Party Module
            - NPM(Node Package Manager)을 사용하여 온라인에서도 사용할 수 있는 모듈
            - NPM이란 프로그램을 관리해주는 프로그램이다.
        
    (2) 모듈을 사용하는 방법
        const 변수 = require("모듈 이름");

        1) CommonJS module(전통적인 방식)
        2) ES module
            사용방법 : mjs 확장자를 사용하여 파일 단위로 적용하는 방법
                      Package.json에 명시하여 프로젝트 단위로 적용
        3) NPM 모듈
            - Node.js 오픈 소스의 생태계의 핵심
            - 개발에 필요로 하는 모든 기능이 이미 NPM에 있을 가능성이 99프로
            - 온라인 레포지토리(MVN 레포지토리 같은 느낌)
            - https://www.npmjs.com

3. 파일 모듈
    - https://nodejs.org/api/fs.html
    
    - 환경 변수
    Package.json에 간단하게 쓸 수 있는 방법이 있다.
    (npm install cross-env 로 명령을 실행해준다)
        posix를 통해서 환경변수를 똑같이 쓸 수 있다는 것이 장점이다.
4. 동기, 비동기

5. 패키지 관리 : npm(패키지 관리), npx(프로그램 실행)
    - node_modules
    - Package.json
    - Package-lock.json

    (1) Semantics Version
        - 버전 번호의 증가 : Major.Minor.patch
        - 호환되지 않는 API 변경시 major 버전(굉장히 큰 공사다.)
        - 이전 버전과 호환되는 방식으로 기능을 추가하는 minor 버전
        - 이전 버전과 호환되는 버그 수정시 patch 버전 증가

    (2) Semantics 
        - ~(필드)
            patch 버전까지만 설치 및 업데이트
            ~0.1.1 : >=0.1.1 < 0.2.0
        - ^(캐럿)
            minor 버전까지만 설치 및 업데이트
            ^1.0.5 : >=1.0.5 <2.0.0
    
    (3) package-lock.json
        1) package-lock.json이 생성되는 시점의 node_modules에 대한 정보를 가지고 있는 파일(최신정보)
        2) 소스 레포지토리(깃허브)에 커밋하기 위한 것이며 다양한 용도로 사용된다.
        3) 배포(CD) 및 지속적 통합(CI)이 동일한 종속성을 설치하도록 보장
        4) 디렉토리 자체를 커밋하지 않더라도 node_modules의 이전 상태로 시간여행
        5) 트리 변경 사항을 쉽게 볼 수 있게 한다.
    
    (4) npm audit(취약점 검사)
        - 취약성에 대한 보고서를 요청하고 취약점이 발견되면 영향과 적절한 교정이 계산된다.
        - npm audit fix --force

6. 웹 서버
    - 지금까지 했던 리엑트, 뷰는 node에 있는 서버를 이용(tomcat를 사용X)
    - node가 가지고 있는 모듈이 있고, 좀 더 전문적으로 쓰고 싶으면 기본 모듈 말고 express를 쓰면 된다.

    1) 기본적인 웹 서버 기능
        -postman 사용(post방식은 url로 접속을 할 수 없기에 fetch를 쓰거나 postman을 활용한다.)
7. express
    - 스프링에 타임리프가 있다면, node에는 익스프레스가 있다.
    - 교재 404페이지 참고
    - npm을 한번도 사용한적이 없으면 npm init로 초기화를 해준다.
    - npm install express 로 설치해준다.

    -Nodemon 설치(코드 변경이 있으면 자동으로 다시 실행해주는 역할)
        npm install -D nodemon 또는 npm install --save-dev nodemon
        (실행할때만 사용할 수 있다.)
    -package.json에 스크립트를 추가해주면
    "scripts": {
    "dev" : "nodemon express_server1.js"
    }
    이제 실행할 때 npm run dev만 입력해도 실행할 수 있게 된다.
    -그리고 nodemon이 설치되어서 이제 서버를 굳이 껐다 켤 필요가 없다.
    
    (1) MiddleWare
        node.js는 중간에 middleware를 지원한다.
        middleware는 중간에 연결을 해주는 프로그램인데,
        예를들면 java와 DB를 연결해주는 jdbc같은 역할이다.

        웹 서버에서 미들웨어는 request와 response 사이에서 기능을 수행한다.
        
    (2) MVC 패턴
        만약에 node.js를 MVC 패턴으로 만들려면?
        - router
        - static
        - template engine
            https://expressjs.com/en/resources/template-engines.html 
            (이 사이트에 들어가면 많은 template engines이 나온다.)
            npm i hbs (hbs 템플릿 엔진 추가)

        이렇게 3개를 꼭 써야 한다.
    
8. DataBase
    (1) Oracle
        1-1 모듈 설치 : npm i oracledb
        1-2 오라클 클라이언트 라이브러리 설치
    (2) MongoDB(추후에 할 예정)
