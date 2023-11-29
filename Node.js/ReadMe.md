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
