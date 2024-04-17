# OnionHotSayYo, 한국 생활 정보와 커뮤니티를 한눈에!
![image](https://github.com/beyond-sw-camp/be04-4th-OmokNoonE-OnionHotSayYo/assets/118791747/3080ca9c-37dc-4734-b13a-a168ca033705)

> "Discover Korea Together: Connect, Share, and Thrive!"

해외에서 살아가는 입장에서는 현지인에게는 당연한 것들이 외국인의 눈에는 새롭고 낯설게 느껴질 때가 많습니다. 이와 같이 한국을 방문한 많은 외국인들도 같은 경험을 하게 됩니다.

외국인에게 필요한 정보와 경험을 얻는 것은 생각보다 어려운 일입니다. OnionHotSayYo는 외국인으로서 한국에 거주하거나 방문하는 모든 이들이 자신의 경험을 공유하고 소통할 수 있는 공간을 제공하기 위해 만들어졌습니다.

또한 OnionHotSayYo를 통해 한국인들을 쉽게 외국인들에게 한국의 흥미로운 정보와 홍보를 할 수 기회를 얻을 수 있습니다.

## 기술 스택
### Frontend

![Vue 3](https://img.shields.io/badge/Vue_3-4FC08D.svg?&logo=vue.js&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E.svg?&logo=javascript&logoColor=black)


### Backend
  
![Java](https://img.shields.io/badge/Java-17-007396.svg?&logo=java&color=red)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3-6DB33F.svg?&logo=spring-boot&color=lightgreen)
![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-6DB33F.svg?&logo=spring-data-JPA)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C.svg?&logo=hibernate)
![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F.svg?&logo=spring-security&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-000000.svg?&logo=json-web-token&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?&logo=gradle)
![JUnit5](https://img.shields.io/badge/JUnit5-25A162.svg?&logo=junit5&logoColor=white&color=green)
![Ubuntu](https://img.shields.io/badge/Ubuntu-E95420.svg?&logo=ubuntu&logoColor=white)
![MariaDB](https://img.shields.io/badge/MariaDB-003545.svg?&logo=mariadb)
![Redis](https://img.shields.io/badge/Redis-DC382D.svg?&logo=redis&logoColor=white)


### DevOps

![Jenkins](https://img.shields.io/badge/Jenkins-D24939.svg?&logo=jenkins&color=lightgrey)
![Docker](https://img.shields.io/badge/Docker-2496ED.svg?&logo=docker&logoColor=white)
![Kubernetes](https://img.shields.io/badge/Kubernetes-326CE5.svg?&logo=kubernetes&logoColor=white)


<h3 align="center">
  
## 커뮤니티 관리자를 소개합니다

| <img src="https://github.com/beyond-sw-camp/be04-4th-OmokNoonE-OnionHotSayYo/assets/118791747/2422d185-a933-4468-a67f-aade75ec8c7f" height=150/> | <img src="https://github.com/beyond-sw-camp/be04-4th-OmokNoonE-OnionHotSayYo/blob/main/README_IMAGE/contributors/%EC%9D%B4%EC%9E%AC%EC%9B%90.png?raw=true" height=150/> | <img src="https://github.com/beyond-sw-camp/be04-4th-OmokNoonE-OnionHotSayYo/blob/main/README_IMAGE/contributors/%EC%9E%A5%EB%AF%BC%EC%84%9D.jpg?raw=true" height=150/> | <img src="https://github.com/beyond-sw-camp/be04-4th-OmokNoonE-OnionHotSayYo/blob/main/README_IMAGE/contributors/%EC%A1%B0%EC%98%88%EB%A6%B0.jpg?raw=true" height=150/> | <img src="https://github.com/beyond-sw-camp/be04-4th-OmokNoonE-OnionHotSayYo/blob/main/README_IMAGE/contributors/%EC%A7%80%ED%98%84%EA%B7%BC.png?raw=true" height=150/> |
| :----------------------------------------------------------: | :----------------------------------------------------------: | :----------------------------------------------------------: | :----------------------------------------------------------: | :----------------------------------------------------------: |
|                            최종찬                            |                            이재원                            |                            장민석                            |                            조예린                            |                            지현근                            |
| [<img src="https://img.shields.io/badge/Github-Link-181717?logo=Github">](https://github.com/CJC0512) | [<img src="https://img.shields.io/badge/Github-Link-181717?logo=Github">](https://github.com/jlee38266) | [<img src="https://img.shields.io/badge/Github-Link-181717?logo=Github">](https://github.com/ms1011) | [<img src="https://img.shields.io/badge/Github-Link-181717?logo=Github">](https://github.com/orlzlL) | [<img src="https://img.shields.io/badge/Github-Link-181717?logo=Github">](https://github.com/jihyeongeun) |


## 문서

### 시스템 아키텍처

![image](https://github.com/beyond-sw-camp/be04-4th-OmokNoonE-OnionHotSayYo/assets/118791747/33e0d533-42cb-4d4b-b32b-233da53c256c)

  1. 개발자가 로컬 환경에서 코드를 작성 및 테스트한 후 , 변경사항을 github로 push
  2. github는 변경 사항에 push 되면 webhook이 이벤트를 감지하고 해당 이벤트를 처리하기 위해서 HTTP 요청
  3. webhook에서 HTTP요청을 하게 되면 JENKINS를 통해 Gradle을 사용하여 소스코드를 빌드하고 실행이 가능한 jar 파일로 생성
  4. 빌드된 jar 파일은 dockerfile를 사용하여 Docker image로 pakaging.  
  5. Docker는 image를 DockerHub로 push 
  6. 쿠버네티스 클러스터는 Docker image를 가져와서 배포하고 백엔드와 프론트엔드는 각각의 파드로 배포됨
  7. ubuntu 서버에서 MariaDb를 관리하고 backend와 연동하여 데이터를 저장하고 관리함
  8. 사용자가 요청한 번역 작업은 DeepL API로 전송되어 처리되며, 번역된 결과가 반환됨

### 프로젝트 문서

  [프로젝트 문서](https://docs.google.com/spreadsheets/d/1Tz1QGNb5venJ7MRaIhWzXk0fvpHP7naOqcR9NRx-4H4/edit?usp=sharing)

### API 명세서

  [API 명세서](https://docs.google.com/spreadsheets/d/1t3bgnUeZIgcqyb5Rk_3qfDUV-yV0Xv4NktnJHBFlYrk/edit?usp=sharing)


## 🤔 회고

|&nbsp;&nbsp;팀&nbsp;원&nbsp;&nbsp;&nbsp;|회고록|
|:---:|---|
|최종찬| 내용 |
|이재원| 내용 |
|장민석| 내용 |
|조예린| 내용 |
|지현근| 내용 |
