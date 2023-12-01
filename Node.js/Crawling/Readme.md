- 만약 서버에서 보내주는 데이터가 XML이나 Json이라면 그냥 아예 데이터를 주려고 마음을 먹은거다.
- HTML을 긁어와야 할 경우에는 강제로 긁어와야 하는 상황이다.
- 파싱 : 데이터를 골라오는 작업

## cheerio

- load() : html을 cheerio객체로 반환
- children() : 선택된 html문자열에 해당하는 모든 태그를 반환
- each() : 반복해서 콜백함수 실행
- find() : 내가 찾고자 하는 정보를 찾는 기능

## 모듈 설치

- npm i axios 
- npm i cheerio
